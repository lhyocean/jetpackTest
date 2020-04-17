package com.bj.ocean.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bj.ocean.jetpack.databinding.StartActivityBinding
import androidx.databinding.DataBindingUtil.setContentView



class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<StartActivityBinding>(this,R.layout.start_activity)




//        if (savedInstanceState == null) {
////            supportFragmentManager.beginTransaction()
////                .replace(R.id.container, StartFragment.newInstance())
////                .commitNow()
////        }





    }

}
