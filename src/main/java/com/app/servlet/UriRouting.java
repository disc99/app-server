package com.app.servlet;

import java.util.Optional;

import javax.servlet.http.HttpServlet;

public interface UriRouting {
    public Optional<Class<? extends HttpServlet>> getServlet(String uri);
}