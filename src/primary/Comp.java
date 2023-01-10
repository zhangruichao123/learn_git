package primary;

/**
 * @author zrc
 * @create 2023/1/10
 */
//对数器测试，大样本随机测试
public class Comp {
    //大样本随机测试数组
    public static int[] randomArr(int maxLen,int maxVal) {
        int len =(int)(Math.random() * maxLen);
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random() * maxVal);
        }
        return arr;
    }
    //判断数组是否有序
    public static boolean isSort(int[] arr) {
        if (arr.length < 2){
            return true;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max > arr[i]){
                return false;
            }
            Math.max(max,arr[i]);
        }
        return true;
    }

}
