package com.app.servlet;

import java.util.Optional;

public class AppServerTest {

    public static void main(String... args) {
        AppServer.builder()
                .routing(uri -> Optional.of(HelloServlet.class))
                .port(9999)
                .start();
    }
}
