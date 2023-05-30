package com.example.aswitch

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.aswitch.R

class MapInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_detailed_info)

        var intent = intent
        var placeInfo = intent.getStringArrayExtra("markerInfo")

        var nameTextView = findViewById<TextView>(R.id.placeName)
        var menuTextView = findViewById<TextView>(R.id.mainMenu)
        var addressTextView = findViewById<TextView>(R.id.location)
        var phoneTextView = findViewById<TextView>(R.id.phoneNumber)
        var amenityTextView = findViewById<TextView>(R.id.amenity)
        var imageView = findViewById<ImageView>(R.id.placeImage)
        var imageUri: Uri

        nameTextView.setText(placeInfo!!.get(0))
        addressTextView.setText(placeInfo!!.get(1))
        menuTextView.setText(placeInfo!!.get(2))
        phoneTextView.setText(placeInfo!!.get(3))
        amenityTextView.setText(placeInfo!!.get(4))
        imageUri = placeInfo!!.get(5).toUri()
        Glide.with(applicationContext).load(imageUri).diskCacheStrategy(
            DiskCacheStrategy.ALL).centerCrop().placeholder(R.drawable.ic_image_placeholder).into(imageView)
    }
}