package com.kesa.multimedia.viewmodel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kesa.multimedia.model.PhotoResponse
import com.kesa.multimedia.repository.PhotoRepository
import kotlinx.coroutines.launch

class PhotoViewModel: ViewModel() {

    val photoRepo = PhotoRepository()
    val errorLiveData = MutableLiveData<String>()
    val photoResponseLiveData = MutableLiveData<PhotoResponse>()

    fun postPhoto(uri: Uri, caption:String){
        viewModelScope.launch {
            val response = photoRepo.uploadPhoto(uri,caption)
             if (response.isSuccessful){
                 photoResponseLiveData.postValue(response.body())

                 }else{
                     errorLiveData.postValue(response.errorBody()?.string())
             }

        }
    }
}