package com.example.mouseandroid

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_bottom.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BottomFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnHomepage.setOnClickListener {
            val appService = ServiceCreator.create(AppService::class.java)
            appService.getAppData().enqueue(object : Callback<ResponseArray<User>> {
                override fun onResponse(call: Call<ResponseArray<User>>, response: Response<ResponseArray<User>>) {
                    val list = response.body()
                    Log.d("success",list!!.msg)
                }

                override fun onFailure(call: Call<ResponseArray<User>>, t: Throwable) {
                    Log.d("fail",t.message.toString())
                    t.printStackTrace()
                }
            })
        }
    }
}