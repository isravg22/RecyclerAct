package com.example.recycleract

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class AmpliarImagen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ampliar_imagen)

        val imageUrl = intent.getStringExtra("imagenUrl")
        if (imageUrl != null) {
            val imageView: ImageView = findViewById(R.id.ampliarImageView)
            Picasso.with(this).load(imageUrl).into(imageView)

        }

        findViewById<View>(R.id.relativeLayoutAmpliarImagen).setOnClickListener {
            val intent = Intent(this, imagenRecyclerView::class.java)
            startActivity(intent)
            finish()
        }
    }
}