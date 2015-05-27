package cn.meteor.exp1;

/**
 * Created by meteor on 15/5/24.
 */
public class Exp1_1 {
    public static void main(String[] args){
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0)
                sum += i;
        }
        System.out.println(sum);
    }

}
