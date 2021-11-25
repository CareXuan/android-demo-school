package com.example.mouseandroid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_homepage.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

/**
 * A simple [Fragment] subclass.
 * Use the [HomepageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomepageFragment : Fragment() {
    private val goodList = ArrayList<Good>()
    private var page = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homepage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initGood(page)

    }

    private fun initGood(page: Int) {
        val appService = ServiceCreator.create(AppService::class.java)
        appService.getGoodData().enqueue(object : Callback<ResponseArray<Good>> {
            override fun onResponse(
                call: Call<ResponseArray<Good>>,
                response: Response<ResponseArray<Good>>
            ) {
                val list = response.body()?.data
                for (good in list!!.iterator()) {
                    goodList.add(good)
                }
                val layoutManager =
                    StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                homepage_good.layoutManager = layoutManager
                val adapter = context?.let { HomepageGoodAdapter(it, goodList) }
                homepage_good.adapter = adapter
            }

            override fun onFailure(call: Call<ResponseArray<Good>>, t: Throwable) {
                Log.d("failure", t.message.toString())
            }
        })
    }
}