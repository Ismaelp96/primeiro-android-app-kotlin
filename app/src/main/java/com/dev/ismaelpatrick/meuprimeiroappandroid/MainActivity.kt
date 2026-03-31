package com.dev.ismaelpatrick.meuprimeiroappandroid

import android.content.Context
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dev.ismaelpatrick.meuprimeiroappandroid.broadcastreceiver.LowBatteryBroadcastReceiver
import com.dev.ismaelpatrick.meuprimeiroappandroid.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding

   private val lowBatteryBroadcastReceiver = LowBatteryBroadcastReceiver()
    private val lowBatteryintentFilter = IntentFilter("android.intent.action.BATTERY_LOW")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val myClass = MyClass(context = applicationContext)

        showToast(context = this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        with(binding.tvMyFirstAndroidApp) {
            this?.text = "Meu Primeiro App Android!"
            this?.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
        }

        supportFragmentManager.beginTransaction().add(R.id.flMainContainer, BlankFragment.newInstance(
            name = "Ismael Patrick",
            age = 29,
            isMale = true
        )).commit()

        registerReceiver(lowBatteryBroadcastReceiver, lowBatteryintentFilter)

    }

    fun showToast(context: Context) {
        Toast.makeText(context, "hello world!", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(lowBatteryBroadcastReceiver)
        Log.d("MainActivity", "onDestroy")
    }
}