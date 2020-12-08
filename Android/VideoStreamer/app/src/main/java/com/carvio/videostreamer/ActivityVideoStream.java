package com.carvio.videostreamer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ActivityVideoStream extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_stream);

        Socket socket;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;

        String line;
        byte[] lineArray = new byte[100];

        try{
            socket = new Socket("172.24.1.1",8080);
            while(true){

                inputStreamReader = new InputStreamReader(socket.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                line = bufferedReader.readLine();
                System.out.println(line);

            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public class VideoStream extends Thread{
        Socket socket;
        String sysHostAddress;
        public VideoStream(InetAddress hostAddress){
            sysHostAddress = hostAddress.getHostAddress();
            socket = new Socket();
        }

        @Override
        public void run() {
            try {
                socket.connect(new InetSocketAddress(sysHostAddress,8080));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
