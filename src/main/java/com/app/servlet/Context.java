package com.app.servlet;

import java.util.Optional;

public enum Context {
    INSTANCE;

    private UriRouting routing = uri -> Optional.empty();
    private int port = 8080;
    private String ip = "localhost";

    public UriRouting getRouting() {
        return routing;
    }

    public void setRouting(UriRouting routing) {
        this.routing = routing;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}