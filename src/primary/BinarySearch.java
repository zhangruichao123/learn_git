package primary;

import java.util.Arrays;

/**
 * @author zrc
 * @create 2023/1/10
 */
//二分法
public class BinarySearch {
    public static void main(String[] args) {
        int maxLen = 200;
        int maxVal = 1000;
        int testTime = 500000;
        Boolean flag = true;
        for (int i = 0; i < testTime; i++) {
//            int[] arr = Comp.randomArr(maxLen, maxVal);
//            Arrays.sort(arr);
            int[] arr = Comp.randomArrUnq(maxLen, maxVal);
            int indexMid = findIndexMid(arr);

//            int value = (int) (Math.random() * maxVal);
//            if (test(arr, value) != findIndex(arr, value)) {
//            if (testR(arr, value) != findIndexR(arr, value)) {
            if (!testM(arr,indexMid)) {
//                System.out.println(testR(arr, value));
//                System.out.println(findIndexR(arr, value));
//                System.out.println(value);
                System.out.println(indexMid);
                System.out.println("sss");
                for (int val : arr) {
                    System.out.print(val+" ");
                }
                System.out.println("二分查找出错了");
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "Nice" : "Fuck");
    }

    //    对数器
    public static boolean test(int[] arr, int num) {
        for (int val : arr) {
            if (val == num) {
                return true;
            }
        }
        return false;
    }

    //    最右对数器
    public static int testR(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > num) {
                return i - 1;
            }
        }
        return arr.length-1;
    }

    //    局部最小对数器
    public static boolean testM(int[] arr, int minIndex) {
        if (arr.length==0||arr==null){
            return minIndex==-1;
        }
        int left=minIndex-1;
        int right=minIndex+1;
        boolean leftFlag= left >=0 ? arr[left]>arr[minIndex]:true;
        boolean rightFlag= right < arr.length ? arr[right]>arr[minIndex]:true;
        return leftFlag&&rightFlag;
    }


    //    有序数组中找到num
    public static boolean findIndex(int[] arr, int num) {
        if (arr.length == 0 || arr == null) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }


//    有序数组中找到<=num最右的位置
    public static int findIndexR(int[] arr, int num) {
        if (arr.length == 0 || arr == null) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int flag=-1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] <= num) {
                flag=mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return flag;
    }

//    局部最小值问题
public static int findIndexMid(int[] arr) {
    if (arr.length == 0 || arr == null) {
        return -1;
    }
    if (arr.length==1) {
        return 0;
    }
    if (arr[0]<arr[1]) {
        return 0;
    }
    if (arr[arr.length - 1]<arr[arr.length - 2]) {
        return arr.length - 1;
    }
    int L = 0;
    int R = arr.length - 1;
    while (L < R-1) {
        int mid = (L + R) / 2;
        if (arr[mid] < arr[mid-1]&&arr[mid] < arr[mid+1]) {
            return mid;
        } else{
            if(arr[mid]> arr[mid-1]) {
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
    }
    return arr[L]<arr[R]?L:R;
}
}
