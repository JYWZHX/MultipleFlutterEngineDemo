package com.wzhx.multipleflutterenginedemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.wzhx.multipleflutterenginedemo.R

class Tab2Fragment: Fragment() {

    private lateinit var mDemoText: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }
    
    private fun initView(view: View) {
        mDemoText = view.findViewById(R.id.demo_text)
        mDemoText.text = "Tab2Fragment"
    }
}