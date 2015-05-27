package cn.meteor.exp1;

import java.util.Scanner;

/**
 * Created by meteor on 15/5/24.
 */
public class Exp1_4 {
    private double x=0;
    public double getResult(){
        if (getX() < 1)
            return getX();
        else if(x >= 1 && x <10)
            return 3 * x - 2;
        else
            return 4 * x;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Exp1_4 exp1_4 = new Exp1_4();
        System.out.println("输入x: ");
        exp1_4.setX(sc.nextInt());
        System.out.println(exp1_4.getResult());
    }
}
