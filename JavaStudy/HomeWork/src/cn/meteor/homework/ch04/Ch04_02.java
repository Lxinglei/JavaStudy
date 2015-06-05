package cn.meteor.homework.ch04;

import java.util.Scanner;

/**
 * Created by meteor on 15/5/31.
 */
public class Ch04_02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double[] scores = new double[50];

        for (int i = 0; i <scores.length; i++) {
            scores[i] = sc.nextDouble();
        }

        int level1, level2, level3, level4, level5, level6;
        level1 = level2 = level3 = level4 = level5 = level6 = 0;

        for (int i = 0; i < scores.length; i++) {
            switch ((int)(scores[i] / 10)){
                case 10:
                    level1++;
                    break;
                case 9:
                    level2 ++;
                    break;
                case 8:
                    level3++;
                    break;
                case 7:
                    level4++;
                    break;
                case 6:
                    level5++;
                    break;
                default:
                    level6++;
                    break;
            }
        }
        System.out.println("100分 :" + level1);
        System.out.println("90~99 :" + level2);
        System.out.println("80~88 :" + level3);
        System.out.println("70~79 :" + level4);
        System.out.println("60~69 :" + level5);
        System.out.println("不及格 :" + level6);
    }
}
