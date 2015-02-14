package com.app.servlet;

public final class AppServer {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Builder() {
        }

        public Builder routing(UriRouting routing) {
            Context.INSTANCE.setRouting(routing);
            return this;
        }

        public Builder port(int port) {
            Context.INSTANCE.setPort(port);
            return this;
        }

        public void start() {
            new AppServer().start();
        }
    }

    public void start() {
        HttpContainer container = new HttpContainer();
        new Thread(container).start();

    }
}