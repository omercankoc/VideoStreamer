package com.carvio.videostream

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.ktor.network.selector.*
import io.ktor.network.sockets.*
import io.ktor.util.*
import io.ktor.util.Identity.decode
import io.ktor.util.cio.*
import io.ktor.utils.io.*
import kotlinx.coroutines.*
import java.io.*
import java.net.Socket
import java.util.*


class VideoStreamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_stream)

        var frame = ByteArray(5000000)

        GlobalScope.async {
            try {
                var socket : Socket = Socket("172.24.1.1", 8080)
                while (true){
                    var inputStreamReader : InputStreamReader = InputStreamReader(socket.getInputStream())
                    var bufferedReader : BufferedReader = BufferedReader(inputStreamReader)
                    var stream = bufferedReader.read()
                    stream = stream.decode()
                    print(stream)

                }

            } catch (e: IOException){
                e.printStackTrace()
            }
        }
    }
}
