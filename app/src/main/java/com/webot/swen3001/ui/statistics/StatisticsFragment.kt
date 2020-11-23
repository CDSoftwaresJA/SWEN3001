package com.webot.swen3001.ui.statistics


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.webot.swen3001.R
import com.webot.swen3001.models.MyAdapter
import com.webot.swen3001.models.RequestDataItem


import kotlinx.android.synthetic.main.recycler_view_fragment.*
import okhttp3.*
import java.io.IOException

class StatisticsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recycler_view_fragment, container, false)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //my_recycler.setBackgroundColor(Color.BLUE)
        my_recycler.layoutManager = LinearLayoutManager(activity)




        fetchJson()
    }


    fun fetchJson(){

        val url2="https://api.covid19api.com/dayone/country/jamaica"
        val request = Request.Builder().url(url2).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback{

            override fun onResponse(call: Call, response: Response) {

                val body = response.body?.string()
                println(body)

                val gson= GsonBuilder().create()
                val data = gson.fromJson(body,Array<RequestDataItem>::class.java)

                requireActivity().runOnUiThread {
                    my_recycler.adapter= MyAdapter(data)
                }


            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed")
            }


        })
    }

}




