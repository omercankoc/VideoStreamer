package com.carvio.videostream

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import java.io.IOException
import java.net.Socket
import java.util.*

class VideoStreamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_stream)

        CoroutineScope(IO).async { videoStream() }
    }

    private suspend fun videoStream(){

        try {
            val socket = Socket("172.24.1.1",8080)
            val writer = socket.getOutputStream()
            val scanner = Scanner(socket.getInputStream())
            println(scanner.nextLine())
            scanner.close()
            writer.close()
            socket.close()
        } catch (e : IOException){
            e.printStackTrace()
            println("CONNECTION LOST!")
        }
    }
}