import java.util.*;

class Solution{
    int solve(int num1,int num2){
        //code here
        int isPrime[] = new int[10000];
        Arrays.fill(isPrime,1);
        
        for(int i =2 ;i*i<10000;i++){
            for(int j = i*i;j<10000;j=j+i){
                if(isPrime[j]==1){
                    isPrime[j]=0;
                }
            }
        }
        
        int vis[] = new int[10000];
        int dp[] = new int[10000];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(num1);
        
        while(!q.isEmpty()){
            int currNode = q.poll();
            vis[currNode]=1;
            String str = currNode+"";
            for(int i =0 ;i<4;i++){
                for(char c ='0';c<='9';c++){
                    if((c=='0'&& i==0) || str.charAt(i)==c){
                        continue;
                    }
                    
                    String nextNode = str.substring(0,i)+c+str.substring(i+1);
                   
                    int nxtNode = Integer.parseInt(nextNode);
                    if(isPrime[nxtNode]==1 && dp[nxtNode]==0) {
                        dp[nxtNode] = 1+ dp[currNode];
                        q.add(nxtNode);
                    }
                }
            }
        }
        
        return dp[num2];
    }
}