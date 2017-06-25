package webServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleServer {

    private static final String URL_REGEXP = "GET\\s(/.*)\\sHTTP.*";

    public static void main(String[] args) throws IOException {
        final int port = 8080;
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server is working. Listening to port: " + port);
        while (true) {
            Socket s = ss.accept();
            SocketProcessor sp = new SocketProcessor(s);
            new Thread(sp).start();
        }
    }

    private static class SocketProcessor implements Runnable {
        private Socket s;
        private InputStream is;
        private OutputStream os;

        public SocketProcessor(Socket s) throws IOException {
            this.s = s;
            this.is = s.getInputStream();
            this.os = s.getOutputStream();
        }

        @Override
        public void run() {
            try {
                List<String> headersLines = readHeaders();
                String path = getRequestURL(headersLines);
                System.out.println(path);
                //writeResponse("<html><body><h1>Hello from Epam!</h1></body></html>");
                //String s = giveHTMLPage();
                //String s = dispatch(path);
                writeResponse(path);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                quietClose(s);
            }
            System.err.println("Client processing finished");
        }

        private void writeResponse(String path) throws IOException {
            String contentType = "text/html";
            String s = "";
            switch (path) {
                case "/": {
                    s = "index.html";
                    break;
                }
                case "/index.html": {
                    s = "index.html";
                    break;
                }
                case "/style.css": {
                    s = "style.css";
                    contentType = "text/css";
                    break;
                }
                case "/img/cat.jpg": {
                    s = "img/cat.jpg";
                    break;
                }
                case "/guess.html": {
                    s = "guess.html";
                    break;
                }
                case "/cats.html": {
                    s = "cats.html";
                    break;
                }
                default: {
                    s = "404.html";
                    break;
                }
            }

            String response = "HTTP 1.1 200 OK\r\n" +
                    "Server: my own server 18.06.2017\r\n" +
                    "Content-Type: " + contentType + "\r\n" +
                    // "Content-Length: " + s.length() + "\r\n" +
                    "Connection: close\r\n\r\n";


            String res = response + new String(Files.readAllBytes(Paths.get(".\\site\\" + s)));

            byte[] b = res.getBytes();
            os.write(b);
            os.flush();

        }

        private String giveHTMLPage() throws IOException {
            return new String(Files.readAllBytes(Paths.get(".\\site\\index.html")));

        }

        private List<String> readHeaders() throws IOException {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bufRead = new BufferedReader(isr);
            System.out.println("Request headers: ");
            List<String> headersLines = new ArrayList<>();
            while (true) {
                String s = bufRead.readLine();
                headersLines.add(s);
                System.out.println(s);
                if (s == null || s.trim().length() == 0) {
                    break;
                }
            }
            return headersLines;
        }

        private String dispatch(String path) {
            String s = "";
            switch (path) {
                case "/": {
                    s = "index.html";
                    break;
                }
                case "/index.html": {
                    s = "index.html";
                    break;
                }
                case "/style.css": {
                    s = "style.css";
                    break;
                }
                case "/img/cat.jpg": {
                    s = "img/cat.jpg";
                    break;
                }
                case "/guess.html": {
                    s = "guess.html";
                    break;
                }
                case "/cats.html": {
                    s = "cats.html";
                    break;
                }
                default: {
                    s = "404.html";
                    break;
                }
            }

            try {
                return new String(Files.readAllBytes(Paths.get(".\\site\\" + s)));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }

        private String getRequestURL(List<String> request) {

            return request.stream().filter(line -> line != null && line.matches(URL_REGEXP)).map(url -> {
                Pattern p = Pattern.compile(URL_REGEXP);
                Matcher m = p.matcher(url);
                m.find();
                return m.group(1);
            }).findFirst().orElse(null);
        }

        private void quietClose(Closeable s) {
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
