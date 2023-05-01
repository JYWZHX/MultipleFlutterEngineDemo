package com.wzhx.multipleflutterenginedemo

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.wzhx.multipleflutterenginedemo.fragment.Tab1Fragment
import com.wzhx.multipleflutterenginedemo.fragment.Tab2Fragment
import com.wzhx.multipleflutterenginedemo.fragment.Tab3Fragment
import com.wzhx.multipleflutterenginedemo.fragment.Tab4Fragment

class MainActivity : AppCompatActivity() {

    private var current: Fragment? = null

    private lateinit var mTab1Btn: TextView
    private lateinit var mTab2Btn: TextView
    private lateinit var mTab3Btn: TextView
    private lateinit var mTab4Btn: TextView

    private val tab1Fragment by lazy {
        Tab1Fragment()
    }
    private val tab2Fragment by lazy {
        Tab2Fragment()
    }
    private val tab3Fragment by lazy {
        Tab3Fragment()
    }
    private val tab4Fragment by lazy {
        Tab4Fragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        current = tab1Fragment

        mTab1Btn = findViewById(R.id.tab1_btn)
        mTab2Btn = findViewById(R.id.tab2_btn)
        mTab3Btn = findViewById(R.id.tab3_btn)
        mTab4Btn = findViewById(R.id.tab4_btn)

        supportFragmentManager.beginTransaction().replace(R.id.empty_view, current as Fragment)
            .commitAllowingStateLoss()
        supportFragmentManager.executePendingTransactions()
    }

    fun tabClick(view: View) {
        resetMenuState()

        when (view.id) {
            R.id.tab1_btn -> {
                current = tab1Fragment
                mTab1Btn.setTextColor(resources.getColor(R.color.tab_text_selected_color, null))
            }
            R.id.tab2_btn -> {
                current = tab2Fragment
                mTab2Btn.setTextColor(resources.getColor(R.color.tab_text_selected_color, null))
            }
            R.id.tab3_btn -> {
                current = tab3Fragment
                mTab3Btn.setTextColor(resources.getColor(R.color.tab_text_selected_color, null))
            }
            R.id.tab4_btn -> {
                current = tab4Fragment
                mTab4Btn.setTextColor(resources.getColor(R.color.tab_text_selected_color, null))
            }
        }

        if (current != null && !(current as Fragment).isAdded) {
            supportFragmentManager.beginTransaction().replace(R.id.empty_view, current as Fragment)
                .commitAllowingStateLoss()
            supportFragmentManager.executePendingTransactions()
        }
    }

    private fun resetMenuState() {
        mTab1Btn.setTextColor(resources.getColor(R.color.tab_text_normal_color, null))
        mTab2Btn.setTextColor(resources.getColor(R.color.tab_text_normal_color, null))
        mTab3Btn.setTextColor(resources.getColor(R.color.tab_text_normal_color, null))
        mTab4Btn.setTextColor(resources.getColor(R.color.tab_text_normal_color, null))
    }
}