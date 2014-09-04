package oschina.arithmetic;

/**
 * 螺旋矩阵
 * Created with IntelliJ IDEA.
 * User: guoping
 * Date: 14-9-4
 * Time: 上午9:58
 * To change this template use File | Settings | File Templates.
 */
public class TestRect {



    public static void main(String[] args) {
        int n = 5;
        int[][] a = new int[n][n];

        f(a);
        print(a);
    }

    public static void print(int[][] a) {
        for(int i=0; i<a.length; i++) {
            for(int j=0; j<a[i].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static void f(int[][] ret) {
        int n = ret.length;

        if(n % 2 == 0) {
            int x = n;
            for(int i=1; i<=n/2; i++) {

                ret[n-i][i-1] = (x)*(x);

                int min = 1;
                for(int a=i; a<=n-i; a++) {
                    ret[n-i][a] = ret[n-i][i-1] - min++;
                }

                min = 1;
                for(int b=n-i-1; b>=i-1; b--) {
                    ret[b][n-i] = ret[n-i][n-i] - min++;
                }

                min = 1;
                for(int c=n-i-1; c>=i-1; c--) {
                    ret[i-1][c] = ret[i-1][n-i] - min++;
                }

                min = 1;
                for(int d=i; d<=n-i-1; d++) {
                    ret[d][i-1] = ret[i-1][i-1] - min++;
                }

                x = x-2;
            }
        } else {
            int x = n;
            for(int i=1; i<=n/2 + 1; i++) {
                ret[i-1][n-i] = x*x;

                int min = 1;
                for(int c=n-i-1; c>=i-1; c--) {
                    ret[i-1][c] = ret[i-1][n-i] - min++;
                }

                min = 1;
                for(int d=i; d<=n-i; d++) {
                    ret[d][i-1] = ret[i-1][i-1] - min++;
                }

                min = 1;
                for(int a=i; a<=n-i; a++) {
                    ret[n-i][a] = ret[n-i][i-1] - min++;
                }

                min = 1;
                for(int b=n-i-1; b>=i; b--) {
                    ret[b][n-i] = ret[n-i][n-i] - min++;
                }


                x = x-2;
            }
        }
    }
}
