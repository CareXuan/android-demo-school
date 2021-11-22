package com.example.mouseandroid

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
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
            transFragmentMain(HomepageFragment())
        }
        btnGround.setOnClickListener {
            transFragmentMain(GroundFragment())
        }
        btnMsg.setOnClickListener {
            transFragmentMain(MessageFragment())
        }
        btnPersonal.setOnClickListener {
            transFragmentMain(PersonalFragment())
        }
        transFragmentMain(HomepageFragment())
    }

    fun transFragmentMain(fragment:Fragment){
        val activity = activity
        val fragmentManager = activity?.supportFragmentManager
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.mainFragment, fragment)
        transaction?.commit()
    }
}