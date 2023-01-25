package primary;

import java.util.HashMap;

/**
 * @author zrc
 * @create 2023/1/16
 */
public class Solution {
    //    两数之和
    public static int[] twoSum(int[] nums, int target) {
        int indexVal=0;
        int i=1;
        while(nums[indexVal]+nums[i]!=target){
            if(i<nums.length-1){
                i++;
            }else{
                indexVal++;
                i=1+indexVal;
            }
        }
        int[] ans={indexVal,i};
        return ans;
    }

    //    两数之和优化
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> table = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (table.containsKey(target-nums[i])){
                return new int[]{table.get(target-nums[i]),i};
            }else{
                table.put(nums[i], i);
            }
        }
        return null;
    }

/*    public static void main(String[] args) {
        int[] nums ={3,2,4};
        int target=6;
        int[] ans = twoSum2(nums, target);
        for (int an : ans) {
            System.out.println(an);
        }
    }*/


    public static int removeElement(int[] nums, int val) {
        int flag=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[flag]=nums[i];
                flag++;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] nums ={0,1,2,2,3,0,4,2};
        int target=2;
        int ans = removeElement(nums, target);
        System.out.println(ans);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }

}
