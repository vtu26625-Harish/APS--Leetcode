class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] ans = new int [26];
        for(int i=0;i<tasks.length;i++){
            ans[tasks[i]-'A']++;
        }
        Arrays.sort(ans);
        int fre = ans[25];
        int idle = (fre-1)*n;
        for(int i=24;i>=0;i--){
            idle -= Math.min(fre-1,ans[i]);
        }
        idle = Math.max(0,idle);

        return tasks.length+idle;

    }
}