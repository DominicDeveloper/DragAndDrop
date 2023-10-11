package com.asadbek.draganddrop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.asadbek.draganddrop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    // x,y,dx,dy - telefon ekranining 4 taraflari koordinalarini saqlovchi o`zgaruvchilar
    var x:Float? = null
    var y:Float? = null
    var dx:Float? = null
    var dy:Float? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    // sensor bosilishini eshituvchi override funktsiya
    override fun onTouchEvent(event: MotionEvent?): Boolean {

        // agar sensor pastga qarab bosilib harakatlantirilsa x va y uning o`rni koordinatasiga tenglashadi
        if (event!!.action == MotionEvent.ACTION_DOWN){
            x = event.x
            y = event.y
        }

        // agar sensor harakatlantirilsa uning o`rniga dx,dy o`zgaruvchilariga tenglashadi
        if (event.action == MotionEvent.ACTION_MOVE){
            dx = event.x - x!!
            dy = event.y - y!!

            binding.imageView.x = binding.imageView.x + dx!!
            binding.imageView.y = binding.imageView.y + dy!!

            x = event.x
            y = event.y
        }

        return super.onTouchEvent(event)
    }
}