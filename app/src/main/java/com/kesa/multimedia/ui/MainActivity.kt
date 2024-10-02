package com.kesa.multimedia.ui

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModel
import com.kesa.multimedia.R
import com.kesa.multimedia.databinding.ActivityMainBinding
import com.kesa.multimedia.viewmodel.PhotoViewModel

class MainActivity : AppCompatActivity() {
    val photoViewModel: PhotoViewModel by ViewModel()
    lateinit var binding: ActivityMainBinding
    lateinit var pickMedia: ActivityResultLauncher<PickVisualMediaRequest>
    var photoUri: Uri?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            if (uri != null) {
                photoUri=uri
                //do uploud
            }
        }

        binding.button.setOnClickListener{
            validateForm()
        }

    }

    override fun onResume() {
        super.onResume()
        binding.ivPhoto.setOnClickListener {
            val mimeType = "image/*"
            pickMedia.launch(
                PickVisualMediaRequest(
                ActivityResultContracts.PickVisualMedia.SingleMimeType(
                    mimeType
                )
            )
            )

        }
    }


    private fun validateForm(){
        var err = false
        if(photoUri==null){
            err = true
            Toast.makeText(this,"Please select a photo", Toast.LENGTH_LONG).show()
        }

        val caption = binding.etCaption.text.toString()
        if(caption.isBlank()){
            err=true
            binding.etCaption.error="Caption required"
        }
        if(!err){
            photoViewModel.postPhoto(photoUri!!, caption)
        }
    }
}