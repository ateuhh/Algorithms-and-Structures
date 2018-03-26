import java.util.Scanner;

public class QuickSort {
    private static int partition(int[] array, int left, int right){
        int temp = array[(left + right)/2];
        int i = left;
        int j = right;
        while (i <= j){
            while (array[i] < temp)
                i++;
            while (array[j] > temp)
                j--;
            if (i >= j)
                break;
            int swap = array[i];
            array[i] = array[j];
            array[j] = swap;
        }
        return j;
    }

    private static void quickSort(int[] array, int left, int right){
        if (left < right){
            int temp = partition(array, left, right);
            quickSort(array, left, temp);
            quickSort(array, temp + 1, right);
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Give me length your array");
        int n = in.nextInt();
        System.out.println("Give me items");
        int[] items = new int[n];
        for (int i = 0; i < n ; i++){
            items[i] = in.nextInt();
        }
        System.out.println("Thank you!");
        quickSort(items,0,n - 1);
        for (int i = 0; i<n; i++){
            System.out.print(items[i] + " ");
        }
    }

}
