package com.cloudwick.project1;

import java.io.*;
import java.net.*;

/**
 * Created by ahuja on 3/31/15.
 */
public class SocketJavaClient {

    public void Connection() {

        String host = "localhost";
        int port = 19999;

        StringBuffer instr = new StringBuffer();
        String Timestamp;

        try {


            InetAddress address = InetAddress.getByName(host);

            Socket connection = new Socket(address, port);


            BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());

            OutputStreamWriter osw = new OutputStreamWriter(bos);

            Timestamp = new java.util.Date().toString();

            String process = "Calling the Socket Server on " + host + " port " + port +
                    " at " + Timestamp + (char) 13;

            osw.write(process);
            osw.flush();

            BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());

            InputStreamReader isr = new InputStreamReader(bis);

            int c;

            while ((c = isr.read()) != 13) {
                instr.append((char) c);
            }
            connection.close();
            System.out.print(instr);


        } catch (IOException f) {
            System.out.print("IOException" + f);
        } catch (Exception e) {
            System.out.print("Exception " + e);
        }

    }


    public static void main(String[] args) {

        SocketJavaClient Client= new SocketJavaClient();

        Client.Connection();


    }
}