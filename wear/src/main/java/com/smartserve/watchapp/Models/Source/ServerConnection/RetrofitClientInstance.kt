package com.smartserve.watchapp.Models.Source.ServerConnection

import android.content.Context
import android.content.Intent
import androidx.multidex.BuildConfig
import com.smartserve.watchapp.Utils.GeneralUtils.SessionManager
import com.smartserve.watchapp.Views.activities.SplashActivity
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class RetrofitClientInstance(ctx : Context) {
    private var retrofit: Retrofit? = null
    private val httpClient = OkHttpClient.Builder()
    var context: Context

    val BASE_URL = "http://mashghol.com/smartseve-api/public/api/v1/"

    init {
        context = ctx
        if (retrofit == null) {
            initRetrofit()
        }
    }



    fun initRetrofit(){
        var retrofitBuilder = retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            httpClient.callTimeout(120,TimeUnit.SECONDS).connectTimeout(30,TimeUnit.SECONDS).readTimeout(120,TimeUnit.SECONDS)

        val authToken = SessionManager(context).getAuthToken()
        if (!authToken.isNullOrEmpty()) {
            val interceptor = AuthenticationInterceptor(
                authToken,
                context
            )
            httpClient.addInterceptor(interceptor)
        }
        if (BuildConfig.DEBUG) {
            val loggingIntercepter = getLoggingInterceptor()
            loggingIntercepter.setLevel(HttpLoggingInterceptor.Level.BODY)
            httpClient.addInterceptor(loggingIntercepter)
        }
        retrofitBuilder.client(httpClient.build())
        retrofit = retrofitBuilder.build()
    }



    fun getService(): ApiService {
        return retrofit!!.create<ApiService>(ApiService::class.java)
    }


    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingIntercepter = HttpLoggingInterceptor()
        loggingIntercepter.level=HttpLoggingInterceptor.Level.BODY
        return loggingIntercepter
    }









    inner class AuthenticationInterceptor internal constructor(
        private val authToken: String,
        private val context: Context
    ) : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            var original: Request = chain.request()
            val builder = original.newBuilder()
                .header("Authorization", "Bearer ${authToken}")
            var request = builder.build()
            val response = chain.proceed(request)
            if (response.code() != 401) {
                return response
            } else {
                context.applicationContext.startActivity(
                    Intent(
                        context,
                        SplashActivity::class.java
                    )
                )
                return response
            }
            /* else {
                val currentToken = SessionManager(context).getAuthToken()
                synchronized(httpClient) {
                    var code = refreshToken()
                    if (code != 200) {
                        return response;
                    }

                    if (SessionManager(context).getAuthToken() != currentToken) { //retry requires new auth token,
                        builder.header(
                            "Authorization",
                            "Bearer ${SessionManager(context).getAuthToken()}"
                        )
                        request = builder.build()
                        this@RetrofitClientInstance.initRetrofit()
                        return chain.proceed(request) //repeat request with new token
                    }
                }
                return response
            }*/
        }



    }



    private fun refreshToken(): Int {


        var retrofitBuilder2 = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        val clientBuilder = OkHttpClient.Builder()

        var retrofit2 = retrofitBuilder2.client(clientBuilder.build()).build()
        var apiService = retrofit2.create<ApiService>(ApiService::class.java)
        val body = RequestBody.create(MediaType.parse("text/plain"), "refresh_token")

        var userEmail=SessionManager(context).getEmail()
        return 200
    /*    var userPass=SessionManager(context).getPassword()
        var updateToken = apiService.userLogin(userEmail,userPass,"password").execute().body()
        if (updateToken != null) {
            SessionManager(context).setAuthenticationToken(updateToken!!.access_token);
            return 200;
        } else {
            return 400
        }*/
    }




















    companion object {
        var singleInstance: RetrofitClientInstance? = null

        fun getInstance(context: Context): RetrofitClientInstance? {
            if (singleInstance == null)
                singleInstance =
                    RetrofitClientInstance(
                        context
                    )

            return singleInstance
        }
    }


}