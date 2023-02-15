import java.util.Scanner;

class fibonacci
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fiboRecur(n));
        System.out.println(fiboMemo(n, new int[n + 1]));
        System.out.println(fiboTab(n, new int[n + 1]));
        System.out.println(fiboMostOptimised(n));
        sc.close();
    }

    public static int fiboRecur(int n)
    {
        if (n <= 1)
            return n;
        return fiboRecur(n - 1) + fiboRecur(n - 2);
    }

    public static int  fiboMemo(int n,int dp[])
    {
        if (n <= 1)
            return n;
        if (dp[n] != 0)
            return dp[n];
        return dp[n] = fiboMemo(n - 1, dp) + fiboMemo(n - 2, dp);
    }

    public static int fiboTab(int n,int dp[])
    {
        for (int i = 0; i <= n; i++) {
            if (i <= 1) {
                dp[i] = i;
                continue;
            }
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int fiboMostOptimised(int n)
    {
        if (n <= 1)
            return n;
        int last = 1, lastSecond = 0;
        for(int i=2;i<=n;i++)
        {
            int curr = last + lastSecond;
            lastSecond = last;
            last = curr;
        }
        return last;
    }
}