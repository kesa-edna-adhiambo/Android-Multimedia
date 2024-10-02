package com.kesa.multimedia.repository

import android.content.ContentResolver
import android.net.Uri
import android.provider.OpenableColumns
import com.kesa.multimedia.MyApp
import com.kesa.multimedia.api.ApiClient
import com.kesa.multimedia.api.ApiInterface
import com.kesa.multimedia.model.PhotoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream

class PhotoRepository {
    val apiInterface = ApiClient.buildClient(ApiInterface::class.java)


    suspend fun uploadPhoto(uri: Uri, caption:String): Response<PhotoResponse> {
        return withContext(Dispatchers.IO){

        }
    }
    fun getFileFromUri(uri: Uri):File{
        val context = MyApp.appContext
        val inputStream = context.contentResolver.openInputStream(uri)
        val file = File(context.filesDir, getFileNameFromUri(context.contentResolver, uri))
        val outputStream= FileOutputStream(file)
        inputStream !!.copyTo(outputStream)
        inputStream.close()
        inputStream.close()
        return file
    }

    fun getFileNameFromUri(resolver: ContentResolver, uri: Uri):String{
        val cursor = resolver.query(uri, null,null,null,null)!!
        val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        cursor.moveToFirst()
        val name = cursor.getString(nameIndex)
        cursor.close()
        return name
    }
}