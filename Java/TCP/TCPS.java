import java.net.*;
import java.io.*;

class TCPS {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(4000);
        System.out.println("Waithin For Connection");
        Socket s = ss.accept();
        
        InputStream is = s.getInputStream();
        BufferedReader namReader = new BufferedReader(new InputStreamReader(is));
        String fname = namReader.readLine();
        System.out.println(fname);
        try{
            BufferedReader contread = new BufferedReader(new FileReader(fname));
            String str;
            while (( str = contread.readLine() )!= null) {
                System.out.println(str);
            }
            contread.close();
        }catch (FileNotFoundException exp){
            System.out.println("Invalid File Name");
        }finally{
            ss.close();   
        }
    
    }
}