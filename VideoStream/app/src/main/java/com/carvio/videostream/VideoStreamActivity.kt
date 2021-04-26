package com.carvio.videostream

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.ktor.network.selector.*
import io.ktor.network.sockets.*
import io.ktor.util.Identity.decode
import io.ktor.utils.io.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import java.io.*
import java.net.Socket
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.util.*


class VideoStreamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_stream)

        // UTF8
        // SETTER FRAME ARRAY
        // FIND
        // CREATE FRAME
        // IMDECODE

        var frame = String()

        GlobalScope.async {
            try {

                val socket = Socket("172.24.1.1", 8080)
                var inputStreamReader : InputStreamReader = InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8)
                var bufferedReader : BufferedReader = BufferedReader(inputStreamReader,)

                while (true){

                    var stream = bufferedReader.readLine()
                }

            } catch (e: IOException){
                e.printStackTrace()
            }
        }
    }
    companion object {
        val TAG = VideoStreamActivity::class.simpleName
    }
}