package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {

                    StringBuilder request = new StringBuilder();
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        request.append(str).append(System.lineSeparator());
                        System.out.println(str);
                    }

                    String response = "HTTP/1.1 200 OK\r\n\r\n";

                    if (request.toString().contains("msg=Exit")) {
                        server.close();
                    } else if (request.toString().contains("msg=Hello")) {
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
