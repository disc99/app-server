package com.app.sample;

import java.util.Optional;

import com.app.servlet.AppServer;

/**
 * This class is used to launch application
 * 
 */
public class Bootstrap {
    public static void main(String[] args) {
        AppServer.builder()
                .routing(uri -> Optional.of(HelloServlet.class))
                .port(9999)
                .start();
    }
}