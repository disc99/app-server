package com.app.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpProcessor implements Runnable {
    Socket socket;

    public HttpProcessor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream()) {

            HttpServletRequest req = new Request(in);
            HttpServletResponse res = new Response(out);

            String uri = req.getRequestURI();
            HttpServlet servlet = Context.INSTANCE
                    .getRouting()
                    .getServlet(uri)
                    .orElseThrow(() -> new RoutingNotFoundException())
                    .newInstance();

            servlet.service(req, res);

        } catch (IOException | ServletException | InstantiationException | IllegalAccessException
                | RoutingNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}