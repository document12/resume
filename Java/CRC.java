import java.util.Scanner;

class CRC {
    static String crc(String data ,String poly, boolean check){
        int n = data.length() , m = poly.length();
        if(!check){
            for(int i = 0;i<n-m+1;i++)
                data += "0";
        }
        String zeros = "";
        for(int i = 0;i<m;i++)
            zeros += "0";
        String rem = "" , currData = "" , currPoly = "";
        try{
            for(int i =0;i<n;i++){
                if(i == 0)
                    currData = data.substring(0, m);
                else   
                    currData = rem.substring(1) + String.valueOf(data.charAt(m + i-1));
                
                if(currData.charAt(0) == '0')
                    currPoly = zeros;
                else
                    currPoly = poly;
                rem = "";
                for(int j = 0;j<m;j++)
                    rem += (currData.charAt(j) == currPoly.charAt(j)) ? "0" : "1";
                
            }  
        }catch(StringIndexOutOfBoundsException e){
            
        }
        return rem.substring(1); 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Data Word");
        String data = sc.nextLine();
        System.out.println("Enter the Generating Polynomial");
        String poly = sc.nextLine();
        
        sc.close();
        data += crc(data , poly , false);
        System.out.println("Crc Data is "+data);
        data = crc(data, poly, true);
        if(data.contains("1"))
            System.out.println("Data Changed");
        else
            System.out.println("Data Unchanged");
    }    
}
