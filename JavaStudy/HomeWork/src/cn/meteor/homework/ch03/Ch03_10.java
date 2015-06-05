package cn.meteor.homework.ch03;

/**
 * Created by meteor on 15/5/31.
 */
public class Ch03_10 {
    public static void main(String[] args){
        Fractions fractions = new Fractions(12, 16);
        System.out.println(fractions);
        System.out.println(fractions.redution());

    }
}

class Fractions{
    private int molecular;  //分子
    private int denominator;    //分母

    public Fractions(int molecular, int denominator) {
        this.molecular = molecular;
        this.denominator = denominator;
    }

    public Fractions redution(){
        int molecular = this.molecular;
        int denominator = this.denominator;
        int greatestCommonDivisor = MyUtil.getGreatestCommonDivisor(molecular, denominator);
        return new Fractions(molecular / greatestCommonDivisor, denominator / greatestCommonDivisor);
    }

    @Override
    public String toString() {
        return molecular + "/" + denominator;
    }
}
class MyUtil{
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