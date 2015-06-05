package cn.meteor.homework.ch04;

import java.util.Scanner;

/**
 * Created by meteor on 15/5/31.
 */
public class Ch04_03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] array = new int[4];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length -1 - i];
            array[array.length - 1 -i] = temp;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}