package com.avoxstudio.badmintonpointcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var leftCounter = 0
    private var rightCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("leftCounter", leftCounter)
        outState.putInt("rightCounter", rightCounter)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        leftCounter = savedInstanceState.getInt("leftCounter")
        rightCounter = savedInstanceState.getInt("rightCounter")
        setPointValueToUI()
        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun initListener(){
        btnReset.setOnClickListener {
            leftCounter = 0
            rightCounter = 0
            setPointValueToUI()
        }

        btnMinusLeft.setOnClickListener {
            if (leftCounter>0){
                leftCounter--
                setPointValueToUI()
            }
        }

        btnMinusRight.setOnClickListener {
            if (rightCounter>0){
                rightCounter--
                setPointValueToUI()
            }
        }

        btnPlusLeft.setOnClickListener {
            leftCounter++
            setPointValueToUI()
        }

        btnPlusRight.setOnClickListener {
            rightCounter++
            setPointValueToUI()
        }
    }

    private fun setPointValueToUI(){
        tvCounterLeft.setText(leftCounter.toString())
        tvCounterRight.setText(rightCounter.toString())
    }
}