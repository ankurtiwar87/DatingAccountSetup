package com.ankur.datingaccountsetup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.ankur.datingaccountsetup.databinding.ActivitySelectYourInterestBinding
import com.google.android.material.chip.Chip

class selectYourInterest : AppCompatActivity() {
    private lateinit var binding: ActivitySelectYourInterestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySelectYourInterestBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //implementing chip selection
        binding.chip1.setOnClickListener { changeChipColor(binding.chip1) }
        binding.chip2.setOnClickListener { changeChipColor(binding.chip2) }
        binding.chip3.setOnClickListener { changeChipColor(binding.chip3) }
        binding.chip4.setOnClickListener { changeChipColor(binding.chip4) }
        binding.chip5.setOnClickListener { changeChipColor(binding.chip5) }
        binding.chip6.setOnClickListener { changeChipColor(binding.chip6) }
        binding.chip7.setOnClickListener { changeChipColor(binding.chip7) }
        binding.chip8.setOnClickListener { changeChipColor(binding.chip8) }
        binding.chip9.setOnClickListener { changeChipColor(binding.chip9) }
        binding.chip10.setOnClickListener { changeChipColor(binding.chip10) }
        binding.chip11.setOnClickListener { changeChipColor(binding.chip11) }
        binding.chip12.setOnClickListener { changeChipColor(binding.chip12) }
        binding.chip13.setOnClickListener { changeChipColor(binding.chip13) }
        binding.chip14.setOnClickListener { changeChipColor(binding.chip14) }
        binding.chip15.setOnClickListener { changeChipColor(binding.chip15) }
        binding.chip16.setOnClickListener { changeChipColor(binding.chip16) }
        binding.chip17.setOnClickListener { changeChipColor(binding.chip17) }
        binding.chip18.setOnClickListener { changeChipColor(binding.chip18) }

        //implementing back button
        binding.floatingActionButton5.setOnClickListener{
            val i2 = Intent(this,AddBestPhoto::class.java)
            startActivity(i2)


        }

        binding.button3.setOnClickListener {
            Intent(applicationContext,IdealMatch::class.java).also {
                startActivity(it)
            }
        }

    }

    private fun changeChipColor(chip: Chip) {
        chip.setChipBackgroundColorResource(R.color.cherry)
        chip.setTextColor(ContextCompat.getColor(this, android.R.color.white))
    }
}