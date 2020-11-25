package com.webot.swen3001.utils

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothAdapter.LeScanCallback
import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.room.Room
import com.webot.swen3001.models.Exposures
import com.webot.swen3001.models.SymptomsLog
import es.dmoral.toasty.Toasty
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

// Java platform code that powers Love is Blue
class ExposureBluetooth(private val context: Context) {
    private val mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
    private var uuid: String? = null
    lateinit var mTTS: TextToSpeech
    lateinit var db : AppDatabase

    private val mLeScanCallback =
        LeScanCallback { device, rssi, scanRecord ->
            val found =
                (IntToHex2(scanRecord[6].toInt()) + IntToHex2(scanRecord[7].toInt()) + IntToHex2(
                    scanRecord[8].toInt()
                ) + IntToHex2(scanRecord[9].toInt())
                        + "-" + IntToHex2(scanRecord[10].toInt()) + IntToHex2(scanRecord[11].toInt())
                        + "-" + IntToHex2(scanRecord[12].toInt()) + IntToHex2(scanRecord[13].toInt())
                        + "-" + IntToHex2(scanRecord[14].toInt()) + IntToHex2(scanRecord[15].toInt())
                        + "-" + IntToHex2(scanRecord[16].toInt()) + IntToHex2(scanRecord[17].toInt())
                        + IntToHex2(scanRecord[18].toInt()) + IntToHex2(scanRecord[19].toInt())
                        + IntToHex2(scanRecord[20].toInt()) + IntToHex2(scanRecord[21].toInt()))
            val HashMap = HashMap<String, Any>()
            HashMap["uuid"] = found
            HashMap["rssi"] = rssi
            val result = "Device ID: $found\nSignal Strength: $rssi"
            Log.d("Result : ", result)
            if (uuid != found) {
                uuid = found

                Toasty.warning(context, result).show()
                mTTS.speak("You are too close, please maintain social distancing ", TextToSpeech.QUEUE_FLUSH, null)

                thread {
                    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
                    val currentDate = sdf.format(Date())
                    db.queriesExposure().insertExposureLogs(Exposures(0,"$currentDate","$rssi"))
                }

            }
        }

    fun startScan() {
        db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "tracer"
        ).build()


        mTTS = TextToSpeech(context, TextToSpeech.OnInitListener { status ->
            if (status != TextToSpeech.ERROR){
                //if there is no error then set language
                mTTS.language = Locale.UK
            }
        })

        mBluetoothAdapter.startLeScan(mLeScanCallback)
    }

    fun stopScan() {
        mBluetoothAdapter.stopLeScan(mLeScanCallback)
    }

    fun IntToHex2(i: Int): String {
        val hex_2 = charArrayOf(
            Character.forDigit(i shr 4 and 0x0f, 16),
            Character.forDigit(i and 0x0f, 16)
        )
        val hex_2_str = String(hex_2)
        return hex_2_str.toUpperCase()
    }
}