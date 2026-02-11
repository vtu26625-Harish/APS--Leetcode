class Solution {
    public int[] sortedSquares(int[] nums) {
        int[]res=new int[nums.length];
        int start=0;
        int end=nums.length-1;
        int index=res.length-1;
        while(index>=0){
            if(nums[start]*nums[start]<=nums[end]*nums[end]){
                res[index]=nums[end]*nums[end];
                index--;
                end--;
            }
            else{
                res[index]=nums[start]*nums[start];
                index--;
                start++;
            }
        }
        return res;
    }
}