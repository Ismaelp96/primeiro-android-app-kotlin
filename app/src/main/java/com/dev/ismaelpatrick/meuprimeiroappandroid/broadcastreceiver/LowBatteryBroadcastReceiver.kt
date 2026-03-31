package com.dev.ismaelpatrick.meuprimeiroappandroid.broadcastreceiver

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class LowBatteryBroadcastReceiver: BroadcastReceiver() {
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context?, p1: Intent?) {
        Toast.makeText(context, "Evento de bateria baixa recebido!", Toast.LENGTH_LONG).show()
    }
}