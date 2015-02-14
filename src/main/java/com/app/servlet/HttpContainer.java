package com.app.servlet;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class HttpContainer implements Runnable {

    private static final Logger LOGGER = Logger.getGlobal();

    private boolean running = true;

    public void run() {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(Context.INSTANCE.getPort(), 5, InetAddress.getByName(Context.INSTANCE
                    .getIp()));
            LOGGER.info("Server started");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        Socket socket = null;

        while (running) {
            try {
                socket = serverSocket.accept();
                LOGGER.info("Request accepted");

                HttpProcessor processor = new HttpProcessor(socket);

                new Thread(processor).start();

            } catch (Exception e) {
                e.printStackTrace();

                continue;
            }
        }

        try {
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}