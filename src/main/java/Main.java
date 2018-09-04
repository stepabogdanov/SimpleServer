import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        run();
    }

    static void run () throws Exception {

        Server server = new Server(8080);
        server.setHandler(new HelloWorld());
        server.start();
        server.join();


    }
}

class HelloWorld extends AbstractHandler {


    public void handle(String s, Request request, HttpServletRequest httpServletRequest,
                       HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html; charset=utf-8");

        response.setStatus(HttpServletResponse.SC_OK);
        String ipAddress = request.getRemoteAddr();

        response.getWriter().println("<p>Hello Wolrd </br>" + ipAddress + "</p>");


        request.setHandled(true);

    }
}