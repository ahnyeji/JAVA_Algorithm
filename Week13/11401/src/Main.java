import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static long[] fact;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K == 0 || N == K) {
            System.out.println(1);
            return;
        }
        fact = new long[N + 1];
        fact[1] = 1;
        for(int i = 2; i <= N; i++) fact[i] = (fact[i - 1] * i) % 1000000007;

        long bottom = (fact[N - K] * fact[K]) % 1000000007;
        System.out.println((fact[N] * fermat(bottom, 1000000007 - 2)) % 1000000007);
    }

    // {R!(N-R)!}^(1000000007-2) = {R!(N-R)!}^(-1) (mod 1000000007) => (Fermat's Little Theorem)

    static long fermat(long a, long p) {
        if(p == 0) return 1;
        long halfP = fermat(a, p/2) % 1000000007;
        if(p % 2 == 1) return (((halfP * halfP) % 1000000007) * a) % 1000000007;
        return (halfP * halfP) % 1000000007;
    }
}
