package array;

public class FindMinimumInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,1};
        System.out.println(findMinimum(arr));
    }

    public static int findMinimum(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[left]) {
                right = mid;
            } else if (arr[mid] > arr[right]) {
                left = mid;
            }
        }
        return arr[right];
    }
}
