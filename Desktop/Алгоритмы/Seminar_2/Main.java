import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[15];
        int[] arr = new int[15];
        int[] array1 = new int[15];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(10);
            arr[i] = array[i];
            array1[i] = array[i];
        }

        // long current = System.currentTimeMillis();
        // System.out.println(Arrays.toString(array));
        // bubleSort(array);
        // System.out.println(Arrays.toString(array));
        // System.out.println(System.currentTimeMillis() - current);

        // current = System.currentTimeMillis();
        // System.out.println(Arrays.toString(arr));
        // quickSort(arr, 0, arr.length-1);
        // System.out.println(Arrays.toString(arr));
        // System.out.println(System.currentTimeMillis() - current);
        System.out.println(Arrays.toString(array1));
        quickSort(array1, 0, array1.length - 1);
        System.out.println(Arrays.toString(array1));
        System.out.println(binarySearch(array1, 5, 0, array1.length - 1));
    }

    public static void bubleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        int p = arr[start + (end - start) / 2];
        while (left <= right) {
            while (arr[left] < p) {
                left++;
            }
            while (arr[right] > p) {
                right--;
            }
            if (left <= right) {
                if (left < right) {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
                left++;
                right--;
            }
        }

        if (left < end) {
            quickSort(arr, left, end);
        }
        if (start < right) {
            quickSort(arr, start, right);
        }
    }

    public static int binarySearch(int[] array1, int value, int start, int end) {
        if (start <= end) {
            int midpoint = start + (end - start) / 2;
            if (array1[midpoint] == value) {
                return midpoint; 
            } else if (array1[midpoint] < value) {
                return binarySearch(array1, value, midpoint + 1, end);
            } else {
                return binarySearch(array1, value, start, midpoint - 1);
            }
        }

        return -1;
    }
}
