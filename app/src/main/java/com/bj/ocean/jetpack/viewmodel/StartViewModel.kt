package com.bj.ocean.jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
@Deprecated("测试类，废弃")
class StartViewModel : ViewModel() {
    private var liveData=MutableLiveData<String>()
    val data:LiveData<String>
    get()=liveData
    init {
        liveData.value="hello jetpack"
    }
}
