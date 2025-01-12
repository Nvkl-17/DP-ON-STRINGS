import java.lang.reflect.Array;
import java.util.Arrays;

public class  Lc {
    
    static   int rec(String s1 , String s2 , int m , int n)
    {
        if(m==0 || n==0)
            return 0;
        if(s1.charAt(m-1)==s2.charAt(n-1))
            return 1 + rec(s1, s2, m-1, n-1);
        else
            return Math.max(rec(s1, s2, m-1, n), rec(s1, s2, m, n-1));

    }

    static int mem(String s1,String s2,int m,int n,int[][] mm)
    {
        if(m==0 || n==0)
            return 0;
        if(mm[m][n]!=-1)
            return mm[m][n];
        if(s1.charAt(m-1) == s2.charAt(n-1))
        {
            return mm[m][n] = 1 + mem(s1, s2, m-1, n-1, mm);
        }

        return mm[m][n] = Math.max(mem(s1, s2, m-1, n, mm), mem(s1, s2, m, n-1, mm));
    }


    static int dy(String s1,String s2 , int m,int n)
    {
        int[] dp = new int[n+1];

        for(int i=1;i<=m;++i)
        {
            int pr = dp[0];
            for(int j =1;j<=n;++j)
            {
                int temp = dp[j];
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[j] = 1 + pr;
                else
                    dp[j] = Math.max(dp[j-1],dp[j]);
                pr = temp;
            }
        }
        return dp[n];
    }

    public static void main(String[] args)
    {
        String s1 = "ABC";
        String s2 = "CBA";

        //RECURSION
        System.out.println(rec(s1,s2,s1.length(),s2.length()));

        //MEMOIZATION 
        int m=s1.length();int n = s2.length();
        int[][] mm = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            Arrays.fill(mm[i],-1);
        System.out.println(mem(s1,s2,s1.length(),s2.length(),mm));

        //DP
        System.out.println(dy(s1,s2,m,n));

    }
}
