import java.lang.reflect.Array;
import java.util.Arrays;

public class Thrlc {
    static int rec(String s1,String s2 , String s3,int m,int l,int n)
    {
        if(m==0 || n==0||l==0)
            return 0;

        if(s1.charAt(l-1) == s2.charAt(m-1) && s2.charAt(m-1) == s3.charAt(n-1))
            return 1 + rec(s1,s2,s3,l-1,m-1,n-1);

        return Math.max(Math.max(rec(s1, s2, s3, l-1, m, n), rec(s1, s2, s3, l, m-1, n)), rec(s1, s2, s3, l, m, n-1));
    }

    static int mem(String s1,String s2 , String s3,int m,int l,int n,int[][][] mm)
    {
        if(m==0 || n==0||l==0)
            return 0;

        if(mm[l][m][n]!=-1)
            return mm[l][m][n];

        if(s1.charAt(l-1) == s2.charAt(m-1) && s2.charAt(m-1) == s3.charAt(n-1))
            return mm[l][m][n] = 1 + rec(s1,s2,s3,l-1,m-1,n-1);

        return mm[l][m][n] = Math.max(Math.max(rec(s1, s2, s3, l-1, m, n), rec(s1, s2, s3, l, m-1, n)), rec(s1, s2, s3, l, m, n-1));

    }

    static int dy(String s1,String s2 , String s3,int m,int l,int n)
    {
        int[][][] dp = new int [l+1][m+1][n+1];

        for(int i=0;i<=l;i++)
        {
            for(int j=0;j<=m;j++)
            {
                for(int k=0;k<=m;k++)
                {
                    if(i==0 || j==0||k==0)
                        dp[i][j][k] = 0;
                    else if(s1.charAt(i-1) == s2.charAt(j-1) && s1.charAt(i-1) == s3.charAt(k-1))
                        dp[i][j][k] = 1 + dp[i-1][j-1][k-1];
                    else
                        dp[i][j][k] = Math.max(Math.max(dp[i-1][j][k],dp[i][j-1][k]),dp[i][j][k-1] );
                }
            }
        }
        return dp[l][m][n];
    }

    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "BCA";
        String s3 = "CAB";

        int l = s1.length();
        int m = s2.length();
        int n = s3.length();
        
        //REC
        System.out.println(rec(s1,s2,s3,l,m,n));

        //MEM
        int[][][] mm = new int[l+1][m+1][n+1];

        for(int i=0;i<=l;i++)
        {
            for(int j=0;j<=m;j++)
            {
                for(int k=0;k<=n;k++)
                    mm[i][j][k] = -1;

            }
        }
        System.out.println(mem(s1,s2,s3,l,m,n,mm));

        //DP
        System.out.println(dy(s1,s2,s3,l,m,n));
    }
}
