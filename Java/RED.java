import java.util.Random;

class Red{
    public static void main(String[] args) {
        double max_prob = 0.7;
        double min_prob = 0.3;
        int max_pack = 20;
        int queue_lim = 10;
        Random rd = new Random();
        int accept = 0;
        int thresh = 5;
        for(int i = 0;i<max_pack;i++){
            if(i < thresh){
                System.out.println("Packet Accept");
                accept++;
            }
            if (accept == queue_lim) {
                System.out.println("Packet Dropped (Queue Full)");
            }
            else if (rd.nextDouble() < min_prob){
                System.out.println("Packet Dropped ");
                min_prob += (max_prob - min_prob) / (max_pack -1);
            }
            else{
                System.out.println("Packet Accept");
                accept++;
            }
        }
    }
}
