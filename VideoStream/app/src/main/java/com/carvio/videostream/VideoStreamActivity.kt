package com.carvio.videostream

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.ktor.network.selector.*
import io.ktor.network.sockets.*
import io.ktor.utils.io.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import java.io.IOException
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.util.*

class VideoStreamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_stream)

        GlobalScope.async {
            try {
                val socket = aSocket(ActorSelectorManager(Dispatchers.IO)).tcp().connect(InetSocketAddress("172.24.1.1", 554))
                val input = socket.openReadChannel()

                val response = input.readByte()
                println("Server said: '$response'")
            } catch (e : IOException){
                e.printStackTrace()
            }
        }
    }
}