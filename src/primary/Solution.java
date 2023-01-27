package primary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

//    移除元素
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

/*    public static void main(String[] args) {
        int[] nums ={0,1,2,2,3,0,4,2};
        int target=2;
        int ans = removeElement(nums, target);
        System.out.println(ans);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }*/
//    兼具大小写的最好英文字母
    public static String greatestLetter(String s) {
        Set<Character> hs=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            hs.add(ch);
        }
        for(int i=25;i>=0;i--){
            if(hs.contains((char)('a'+i))&&hs.contains((char)('A'+i))){
                return String.valueOf((char)('A'+i));
            }
        }
        return "";
    }

    public static String greatestLetter2(String s) {
        Set<Character> hs=new HashSet<>();
        for (char c : s.toCharArray()) {
            hs.add(c);
        }
        for(char i='Z';i>='A';i--){
            if(hs.contains(i)&&hs.contains((char) (i+32))){
                return String.valueOf(i);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "lEeTcOdE";

//        String ans = greatestLetter(s);
        String ans = greatestLetter2(s);
        System.out.println(ans);

    }

}
