package array;

public class FindMinimumInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 1, 1, 1, 2};
        System.out.println(findMinimumWithDuplicates(arr));
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

    public static int findMinimumWithDuplicates(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[left]) {
                while (mid - 1 >= 0 && arr[mid - 1] == arr[mid]) {
                    mid--;
                }
                right = mid;
            } else if (arr[mid] > arr[right]) {
                while (mid + 1 < arr.length && arr[mid] == arr[mid + 1]) {
                    mid++;
                }
                left = mid;
            } else { // 最左值、最右值与中值相等的情形,直接排除两个边界元素
                left++;
                right--;
            }
        }
        //为什么是right,因为每次二分选择的区间都是一个异常区间，最左值比最右值大，所以最小值是在right下标上
        return arr[right];
    }
}
