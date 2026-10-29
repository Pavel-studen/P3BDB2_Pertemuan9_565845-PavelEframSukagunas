package com.example.disasterapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disasterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisiasi adapter
        val adapterDisaster = DisasterAdapter(generateDummy()) { disaster ->
            Toast.makeText(this@MainActivity, "You clicked on ${disaster.nameDisaster}", Toast.LENGTH_SHORT).show()
        }

        with(binding){
            // Linear Layout Manager
//            rvDisaster.apply{
//                adapter = adapterDisaster
//                layoutManager = LinearLayoutManager(this@MainActivity)
//            }
            // Grid Layout Manager
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }
    fun generateDummy(): List<Disaster>{
        return listOf(
            Disaster(imageDisaster = R.drawable.tsunami, nameDisaster = "Tsunami", disasterType = "Natural"),
            Disaster(imageDisaster = R.drawable.volcanic_eruption, nameDisaster = "Volcanic Eruption", disasterType = "Natural"),
            Disaster(imageDisaster = R.drawable.earthquake, nameDisaster = "Earthquake", disasterType = "Natural"),
            Disaster(imageDisaster = R.drawable.flood, nameDisaster = "Flood", disasterType = "Natural"),
            Disaster(imageDisaster = R.drawable.fire, nameDisaster = "Fire", disasterType = "Natural"),
            Disaster(imageDisaster = R.drawable.nuclear_accident, nameDisaster = "Nuclear Accident", disasterType = "Man-made"),
            Disaster(imageDisaster = R.drawable.terrorist_attack, nameDisaster = "Terrorist Attack", disasterType = "Man-made"),
            Disaster(imageDisaster = R.drawable.war, nameDisaster = "War", disasterType = "Man-made")
        )
    }
}