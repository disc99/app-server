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

public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter out = res.getWriter();
        out.println("<HTML>");
        out.println("<BODY>");
        out.println("<H3>Hello World!</H3>");
        out.println("</BODY>");
        out.println("</HTML>");

    }
}
```

2.Access the url you set.

## Requirements

* JDK 8 +
