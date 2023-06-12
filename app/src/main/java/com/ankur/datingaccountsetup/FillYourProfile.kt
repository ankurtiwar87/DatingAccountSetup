package com.ankur.datingaccountsetup

import android.content.Intent
import android.content.pm.ActivityInfo
import com.ankur.datingaccountsetup.adapters.CustomSpinnerAdapter
import android.graphics.PorterDuff
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import com.ankur.datingaccountsetup.databinding.ActivityFillYourProfileBinding


class FillYourProfile : AppCompatActivity() {

    private lateinit var binding: ActivityFillYourProfileBinding

    companion object {
        private const val PICK_IMAGE_REQUEST = 1
    }

    private var galleryLauncher: ActivityResultLauncher<String>? = null
    private var selectedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFillYourProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Intent(this, AddBestPhoto::class.java).also {
                startActivity(it)
            }

        }

        //making status bar invisible
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val windowInsetsController = ViewCompat.getWindowInsetsController(window.decorView)

        windowInsetsController?.isAppearanceLightStatusBars = true

        //setting vector icons of floating action button
        val myIcon = resources.getDrawable(R.drawable.ic_baseline_arrow_back_24)
        binding.floatingActionButton2.setImageDrawable(myIcon)

        val myIcon2 = resources.getDrawable(R.drawable.ic_baseline_edit_24)
        binding.floatingActionButton.setImageDrawable(myIcon2)

        //customizing borders of edittext
        setUpEditText(binding.et2)
        setUpEditText(binding.et3)
        setUpEditText(binding.et4)
        setUpEditText(binding.et6)

        //implementing fab to set profile picture
        binding.floatingActionButton.setOnClickListener {
            galleryLauncher?.launch("image/*")
        }

        // Create the gallery launcher
        galleryLauncher =
            registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
                if (uri != null) {
                    selectedImageUri = uri
                    binding.profileImage.setImageURI(selectedImageUri)
                }
            }

        //Spinner Items
        val items = listOf("Gender", "Male", "Female", "Other")

        // Defining the adapter for the Spinner
        val adapter = CustomSpinnerAdapter(this, items)

        // Set the adapter for the Spinner
        binding.spinner.adapter = adapter

        //to change color of border of Spinner
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Change the border color
                binding.spinner.background.setColorFilter(
                    ContextCompat.getColor(
                        this@FillYourProfile,
                        R.color.cherry
                    ), PorterDuff.Mode.SRC_ATOP
                )
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
    }

    private fun setUpEditText(editText: EditText) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrEmpty()) {
                    editText.setBackgroundResource(R.drawable.edit_text_border)
                } else {
                    editText.setBackgroundResource(R.drawable.edit_text_border_pink)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}

