package com.carvio.videostream

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.ktor.network.selector.*
import io.ktor.network.sockets.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.io.IOException
import java.net.InetSocketAddress
import java.util.*

class VideoStreamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_stream)

        try {
            val socket = aSocket(ActorSelectorManager(Dispatchers.IO)).tcp().connect(InetSocketAddress("172.24.1.1", 554))
            val input = socket.openReadChannel()

            val response = input.readByte()
            println("Server said: '$response'")
        } catch (e : IOException){
            e.printStackTrace()
            println("CONNECTION LOST!")
        }

    }
}