import java.io.*;
import java.net.*;
import java.util.Scanner;

class TCPC{
    public static void main(String[] args) throws Exception {
        Socket ss = new Socket("127.0.0.1",4000);
        // BufferedReader namReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        System.out.println("Connection Established Waiting for File Name");
        String fname = sc.nextLine();
        OutputStream os = ss.getOutputStream();
        PrintWriter pw = new PrintWriter(os , true);
        pw.println(fname);
        ss.close();
        sc.close();
    }
}

