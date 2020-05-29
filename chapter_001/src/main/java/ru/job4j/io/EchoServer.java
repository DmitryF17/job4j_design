package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(9000)) {

            boolean order = true;
            while (order) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    while (in.ready()) {
                        String str = in.readLine();
                        String answer = str;
                        System.out.println(str);
                        if (str.contains("Exit")) {
                            order = false;
                        }
                        if (str.contains("Hello")) {
                            answer = "Hello";
                        }
                        out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                        out.write(answer.getBytes());
                        break;
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}



