package com.ankur.datingaccountsetup

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import com.ankur.datingaccountsetup.databinding.ActivityIdealMatchBinding
import com.ankur.datingaccountsetup.databinding.DialogBoxBinding
import com.google.android.material.card.MaterialCardView

class IdealMatch : AppCompatActivity() {
    private lateinit var binding: ActivityIdealMatchBinding
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityIdealMatchBinding.inflate(layoutInflater)
        setContentView(binding.root)





        binding.nextBtn.setOnClickListener {
            val dialog =Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_box)
            dialog.setCancelable(false)
            dialog.show()
            dialog.findViewById<Button>(R.id.homeBtn).setOnClickListener {
                Intent(this,MainActivity::class.java).also {
                    startActivity(it)
                }



            }
        }



            binding.backBtn.setOnClickListener{
                Intent(this,selectYourInterest::class.java).also {
                    startActivity(it)
                }
            }
        }


}


