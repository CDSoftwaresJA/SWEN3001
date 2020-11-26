package com.webot.swen3001.utils

import com.orhanobut.hawk.Hawk

object Utils {
     fun updateStatus(string: String){
        Hawk.put("status",string)
    }
    fun getStatus():String{
        return Hawk.get("status","Negative")
    }
    fun getNotification():Boolean{
        return Hawk.get("notification",true)
    }
    fun updateNotification(boolean: Boolean){
        Hawk.put("notification",boolean)
    }

}