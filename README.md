# app-server
app-server is minimal embedded web server and servlet engine.

## How to use

1.Create AppServer start class.

```java
public class Bootstrap {
    public static void main(String[] args) {
        AppServer.builder()
                .routing(uri -> Optional.of(HelloServlet.class))
                .port(9999)
                .start();
    }
}

```

2.Access the url you set.

## Requirements

* JDK 8 +
