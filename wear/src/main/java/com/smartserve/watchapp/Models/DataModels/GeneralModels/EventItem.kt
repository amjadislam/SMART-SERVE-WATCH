package com.smartserve.watchapp.Models.DataModels.GeneralModels

import android.content.Intent
import java.io.Serializable

class EventItem(
        var type  : String = "",
        var order_uuid  : String = ""
): Serializable