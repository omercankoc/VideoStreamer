package com.carvio.videostream

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.ktor.network.selector.*
import io.ktor.network.sockets.*
import io.ktor.util.*
import io.ktor.util.cio.*
import io.ktor.utils.io.*
import kotlinx.coroutines.*
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStreamReader
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
                var input = BufferedReader(InputStreamReader(socket.getInputStream()))
                //val socket = aSocket(ActorSelectorManager(Dispatchers.IO)).tcp().connect(InetSocketAddress("172.24.1.1", 8080))

                while (true){

                    var response = input.readLine()
                    print(response)


                    //val input = socket.ByteReadChannel()
                    //val response = input.readUTF8Line()
                    //frame += response
                    //println("Server said: '$response'")
                    // ---
                    //var input = ByteArrayInputStream(frame)
                    //var response = input.read()

                    //frame += response

                    //print(frame)


                    //val input = socket.openReadChannel()
                    //val response = input.readByte()
                    //print("RESPONSE : $response")
                }

            } catch (e: IOException){
                e.printStackTrace()
            }
        }
    }
}
