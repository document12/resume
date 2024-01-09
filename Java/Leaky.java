import java.util.ArrayList;
import java.util.Scanner;

class Leaky{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Frames");
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        int val = 0;
        System.out.println("Enter the Bucket Size");
        int b = sc.nextInt();
        System.out.println("Enter the Data For Each Packet");
        for(int i =0;i<n;i++){
            val = sc.nextInt();
            if(val <= b)
                arr.add(val);
        }   
        System.out.println("Enter the Out Rate");
        int out = sc.nextInt();
        sc.close();
        System.out.println("The Order of Output are");
        for(int i =0;i<arr.size();){
            val = arr.get(i);
            if(val <= out){
                System.out.println(val);
                i++;
            }else{
                val -= out;
                System.out.println(out);
                arr.set(i,val);
            }
        }
    }
}