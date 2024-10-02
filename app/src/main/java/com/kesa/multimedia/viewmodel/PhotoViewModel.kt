package com.kesa.multimedia.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PhotoViewModel: ViewModel() {
    fun postPhoto(uri: Uri, caption:String){
        viewModelScope.launch {

        }
    }
}