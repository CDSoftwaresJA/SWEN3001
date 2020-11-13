package com.webot.swen3001

import com.orhanobut.hawk.Hawk

class Utils {
    fun updateStatus(number:String){
        Hawk.put("status",number)
    }
    fun getStatus(number:String){
        return Hawk.get("status")
    }
    fun getNotification(number:Int){
        return Hawk.get("notification")
    }
    fun updateNotification(number:Int){
        Hawk.put("notification",number)
    }

}