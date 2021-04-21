package com.carvio.videostream

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.ktor.network.selector.*
import io.ktor.network.sockets.*
import io.ktor.util.Identity.decode
import io.ktor.utils.io.*
import kotlinx.coroutines.*
import java.io.*
import java.net.Socket


class VideoStreamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_stream)

        var frame = ByteArray(5000000)

        GlobalScope.async {
            try {

                var socket = Socket("172.24.1.1", 8080)
                var inputStreamReader : InputStreamReader = InputStreamReader(socket.getInputStream())
                var bufferedReader : BufferedReader = BufferedReader(inputStreamReader)

                while (true){
                    var stream : String = bufferedReader.readLine()
                    println(stream)
                }
                
            } catch (e: IOException){
                e.printStackTrace()
            }
        }
    }
}
