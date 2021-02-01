import java.io.*;
// 메모리 305868KB & 시간 1036ms
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        arr = mergeSort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static int[] merge(int[] left, int[] right){
        int llen = left.length;
        int rlen = right.length;
        int[] arr = new int[llen + rlen];
        int l = 0;
        int r = 0;
        int idx = 0;
        while(l < llen && r < rlen){
            arr[idx++] = left[l] <= right[r] ? left[l++] : right[r++];
        }
        if(l < llen){
            System.arraycopy(left, l, arr, idx, llen - l);
        } else{
            System.arraycopy(right, r, arr, idx, rlen - r);
        }
        return arr;
    }

    public static int[] mergeSort(int[] arr){
        int len = arr.length;
        if(len < 2) return arr;
        int mid = len / 2;
        int[] left = new int[mid];
        int[] right = new int[len - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, len - mid);
        arr = merge(mergeSort(left), mergeSort(right));
        return arr;
    }
}
