import java.util.Arrays;

public class SortAlg {
    

    public static void main(String[] args) {
        // int[] arr = {72, 57,8, 69};
        int []arr = {9,8,7,6,5,4,3,2,1};
        int len = arr.length;
        
        // quickSort(arr, 0, len - 1);
        // System.out.println(Arrays.toString(arr));

        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    static void quickSort(int arr[], int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        int x = arr[right];
        while (i < j) {
            while(i < j && arr[i] < x)
                i++;
            if (i < j) {
                arr[j--] = arr[i];
            }
            while(i < j && arr[j] > x) 
                j --;
            if (i < j) {
                arr[i++] = arr[j];
            }
        }
        arr[i] = x;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }


    static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    static void mergeSortHelper(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSortHelper(arr, left, mid);
        mergeSortHelper(arr, mid + 1, right);
        merge(arr, left, right);
    }


    static void merge(int[] arr, int left, int right) {
        int[] tmp = new int[right - left + 1];
        int mid = (right + left) >> 1;

        int i = left;
        int j = mid + 1;
        int tmpIndex = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                tmp[tmpIndex++] = arr[i++];
            } else {
                tmp[tmpIndex++] = arr[j++];
            }
        }

        while(i <= mid) {
            tmp[tmpIndex++] = arr[i++];
        }
        while(j <= right) {
            tmp[tmpIndex++] = arr[j++];
        }

        tmpIndex = 0;
        for (int k = left; k <= right; k++) {
            arr[k] = tmp[tmpIndex++];
        }
    }



}
