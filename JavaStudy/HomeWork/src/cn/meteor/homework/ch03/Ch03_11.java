package cn.meteor.homework.ch03;

import java.util.DoubleSummaryStatistics;

/**    //求和

 * Created by meteor on 15/5/31.
 */
public class Ch03_11 {
    public static void main(String[] args){
        double n = 1;
        double e = 0;
        double e1 = 1;
        String eStr = "";
        while (Math.abs(e - e1) > 0.000001){
            System.out.println(Math.abs(e - e1));
            e1 = e;
            e += (double)n / Ch03_11.factorial(n);
            n ++;
        }
        System.out.println(e);
    }
    public static int factorial(double n){
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
