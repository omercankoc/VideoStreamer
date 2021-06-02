package com.omercankoc.streamer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.io.IOException
import java.io.InputStreamReader
import java.net.Socket
import java.nio.charset.StandardCharsets

class StreamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stream)

        GlobalScope.async {
            try {
                val socket = Socket("172.24.1.1",8080)
                var inputStreamReader : InputStreamReader = InputStreamReader(socket.getInputStream(),
                    StandardCharsets.UTF_8)
                print(inputStreamReader)
                //var bufferedReader : BufferedReader = BufferedReader(inputStreamReader)
            } catch (e: IOException){
                e.printStackTrace()
            }
        }
    }
}