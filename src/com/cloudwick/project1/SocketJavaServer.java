package com.cloudwick.project1;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 * Created by ahuja on 3/31/15.
 */

public class SocketJavaServer implements Runnable {

    private static Socket connection;
    private String Timestamp;
    private int ID;

        int port = 19999;
        int count = 0;
public void Init() {
    try {
        ServerSocket socket1 = new ServerSocket(port);

        while (true) {

            Socket connection = socket1.accept();

            Runnable runnable = new SocketJavaServer(connection, ++count);
            Thread thread = new Thread(runnable);
            thread.start();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

}
SocketJavaServer(Socket s, int i){
    this.connection = s;
    this.ID = i;
}
    public void run() {

        try {
            BufferedInputStream is = new BufferedInputStream(connection.getInputStream());
            InputStreamReader isr = new InputStreamReader(is);
            int character;
            StringBuffer process = new StringBuffer();
            while((character = isr.read()) != 13) {
                process.append((char)character);
            }
            System.out.println(process);
            //need to wait 10 seconds to pretend that we're processing something
            try {
                Thread.sleep(10000);
            }
            catch (Exception e){}
            Timestamp = new java.util.Date().toString();
            String returnCode = "MultipleSocketServer repsonded at "+ Timestamp + (char) 13;
            BufferedOutputStream os = new BufferedOutputStream(connection.getOutputStream());
            OutputStreamWriter osw = new OutputStreamWriter(os, "US-ASCII");
            osw.write(returnCode);
            osw.flush();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                connection.close();
            }
            catch (IOException e){}
        }
    }
    public static void main(String[] args) {

        SocketJavaServer Server= new SocketJavaServer(connection,1);
        Server.Init();


    }



    }








