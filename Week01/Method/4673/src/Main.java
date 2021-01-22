public class Main {

    static int[] notSelf = new int[10001];

    public static void main(String[] args) {
        for(int i = 1; i < 10001; i++){
            if(notSelf[i] == 0){
                System.out.println(i);
                d(i);
            }
        }
    }

    public static void d(int n) {
        if(n > 10000){
            return;
        }
        int check = n;
        while(n > 0){
            check += n % 10;
            n /= 10;
        }
        if(check < 10001){
            notSelf[check]++;
            d(check);
        }
    }
}
