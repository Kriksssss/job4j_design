package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EchoServer {
    private static final Logger LOGGER = Logger.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try {
            runServer();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error in the server", e);
        }
    }

    private static void runServer() throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                    String response = "HTTP/1.1 200 OK\r\n";
                    out.write(response.getBytes());

                    String requestLine = in.readLine();
                    System.out.println(requestLine);

                    if (requestLine.contains("msg=Exit")) {
                        server.close();
                    } else if (requestLine.contains("msg=Hello")) {
                        response += "Hello.";
                    } else {
                        response += "What.";
                    }

                    out.write(response.getBytes());
                    out.flush();
                }
            }
        }
    }
}
