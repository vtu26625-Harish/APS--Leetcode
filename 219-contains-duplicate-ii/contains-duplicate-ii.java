class Solution {
    public boolean containsNearbyDuplicate(int[] arr, int k) {
      HashMap<Integer,Integer> list = new HashMap<>();
      for(int i=0;i<arr.length;i++){
         if(list.containsKey(arr[i])){
            if(i-list.get(arr[i]) <= k){
               return true;
            }
         }
         list.put(arr[i],i);
     } 
     return false;
    }
}