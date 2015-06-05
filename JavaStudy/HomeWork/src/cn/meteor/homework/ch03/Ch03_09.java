package cn.meteor.homework.ch03;

/**
 * Created by meteor on 15/5/31.
 */
public class Ch03_09 {
    public static void main(String[] args){
        System.out.println(Util.getGreatestCommonDivisor(23, 11));
        System.out.println(Util.getGreatestCommonDivisor(22, 11));
        System.out.println(Util.getGreatestCommonDivisor(120, 12));
        System.out.println(Util.getGreatestCommonDivisor(3388, 1102));
        System.out.println(Util.getGreatestCommonDivisor(21, 11));
    }
}

class Util{
    public static int getGreatestCommonDivisor(int num1, int num2){
        int m, n;
        n = num1 <= num2 ? num1 : num2;
        m = num1 > num2 ? num1 : num2;
        while (n != 0){
            int temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }
}