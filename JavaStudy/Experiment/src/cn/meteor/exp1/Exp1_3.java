package cn.meteor.exp1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meteor on 15/5/24.
 */
public class Exp1_3 {
    private int max = 100;



    private List<Integer> primes = new ArrayList<Integer>();
    public List<Integer> getPrimes(){
        for (int i = 1; i <= max; i++) {
            if (isPrime(i))
                primes.add(i);
        }
        return primes;
    }
    private boolean isPrime(int num){
        boolean flag = true;
        for (int j = 1; j < num-1; j++) {
            if (j==1) continue;
            if ((num % j) == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }
    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    public static void main(String[] args){
        Exp1_3 exp1_3 = new Exp1_3();
        exp1_3.setMax(1000);
        System.out.println(exp1_3.getPrimes());
    }
}
