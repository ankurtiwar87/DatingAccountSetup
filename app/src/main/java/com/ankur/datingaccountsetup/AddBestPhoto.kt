package com.ankur.datingaccountsetup

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import com.ankur.datingaccountsetup.databinding.ActivityAddBestPhotoBinding

class AddBestPhoto : AppCompatActivity() {

    private  lateinit var binding: ActivityAddBestPhotoBinding

    companion object {
        private const val PICK_IMAGE_REQUEST = 1
    }

    private lateinit var galleryLauncher: ActivityResultLauncher<String>
    private lateinit var selectedImageUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddBestPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)




            //implementing border color
            //val borderColor = ContextCompat.getColor(this, R.color.cherry)
            //val borderDrawable = imageView.background as GradientDrawable
            //borderDrawable.setStroke(4.dpToPx(this), borderColor)

            //implementing back floating action button
            binding.floatingActionButton3.setOnClickListener{
                val i = Intent(this,FillYourProfile::class.java)
                startActivity(i)
            }

            //implementing fabs
            binding.floatingActionButton7.setOnClickListener {
                implementingFab(binding.imageView3)
            }
            binding.floatingActionButton8.setOnClickListener {
                implementingFab(binding.imageView4)
            }
            binding.floatingActionButton6.setOnClickListener {
                implementingFab(binding.imageView2)
            }
            binding.floatingActionButton4.setOnClickListener {
                implementingFab(binding.imageView)
            }

            //implementing next button
            binding.button2.setOnClickListener{
                val i1 = Intent(this,selectYourInterest::class.java)
                startActivity(i1)
            }

        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK) {
                if(data!=null) {
                    val imageUri: Uri?=data.data
                    binding.imageView.setImageURI(imageUri)
                }
            }
        }

        //fun Int.dpToPx(context: Context): Int {
        //val scale = context.resources.displayMetrics.density
        //return (this * scale + 0.5f).toInt()
        //}

        //function to implement fab

        private fun implementingFab(imageView: ImageView) {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }
}