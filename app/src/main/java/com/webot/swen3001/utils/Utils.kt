package com.webot.swen3001.utils

import com.orhanobut.hawk.Hawk

object Utils {
     fun updateStatus(boolean: Boolean){
        Hawk.put("status",boolean)
    }
    fun getStatus():Boolean{
        return Hawk.get("status",true)
    }
    fun getNotification():Boolean{
        return Hawk.get("notification",true)
    }
    fun updateNotification(boolean: Boolean){
        Hawk.put("notification",boolean)
    }

}