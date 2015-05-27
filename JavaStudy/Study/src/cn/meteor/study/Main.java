package cn.meteor.study;

import java.util.Scanner;

/**
 * Created by metror on 15/5/22.
 */
public class Main {
    private Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int[] array1 = new int[Final.MAX_NUM];
        int[] array2 = new int[Final.MAX_NUM];
        int[] arraySum = new int[Final.MAX_NUM];
        for (int i = 0; i < Final.MAX_NUM; i++) {
            array1[i] = (int) (Math.random()*10);
            array2[i] = (int) (Math.random()*10);
        }

        for (int i = 0; i <Final.MAX_NUM; i++) {
            arraySum[i] = array1[i] + array2[i];
            System.out.println("A[" + i + "] = " + array1[i]);
            System.out.println("B[" + i + "] = " + array2[i]);
            System.out.println("A[" + i + "] + B[" + i + "] = " + arraySum[i]);
        }

    }
}
