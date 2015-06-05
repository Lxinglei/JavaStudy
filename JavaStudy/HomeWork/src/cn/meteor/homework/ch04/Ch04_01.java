package cn.meteor.homework.ch04;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by meteor on 15/5/31.
 */
public class Ch04_01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double[] scores = new double[5];
        double sum = 0;
        double average;

        System.out.println("请输入成绩: ");
        for (int i = 0; i < scores.length; i++) {
            scores[i] = sc.nextDouble();
            sum += scores[i];
        }

        average = Double.parseDouble(new DecimalFormat("0.0").format(sum / scores.length));

        System.out.println(average);
    }
}
