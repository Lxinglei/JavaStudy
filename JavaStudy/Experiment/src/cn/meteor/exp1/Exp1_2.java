package cn.meteor.exp1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meteor on 15/5/24.
 */
public class Exp1_2 {
    private int min = 100;
    private int max = 999;
    private List<Integer> list;
    private List<Integer> intList = new ArrayList<Integer>();

    public Exp1_2() {
        list = new ArrayList<Integer>();
    }

    public List<Integer> getResult(){
        for (int i = getMin(); i <= getMax(); i++) {
            String iStr = Integer.toString(i);
            String[] iStrs = iStr.split("");
            if (isMyNum(iStrs, i)){
                list.add(i);
                isMyNum(iStrs, i);
            }else {
                intList.clear();
            }
        }


        return list;
    }

    public boolean isMyNum(String[] iStrs, int num ){
        System.out.println(iStrs[0]+iStrs[1]+iStrs[2] + "\n" + num);
        int sum = 0;
        System.out.println(intList);
        for (int j = 0; j < iStrs.length; j++) {
            intList.add(Integer.parseInt(iStrs[j]));
        }
        System.out.println(intList);
        for (int k = 0; k < intList.size(); k++) {
            sum += intList.get(k).intValue()*intList.get(k).intValue()*intList.get(k).intValue();
        }
        System.out.println("="+sum);
        System.out.println("="+num);
        if (sum == num)
            return true;
        else return false;

    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public static void main(String[] args){
        Exp1_2 exp1_1 = new Exp1_2();
        List<Integer> list = exp1_1.getResult();

        System.out.println("共有"+list.size()+"水仙花数");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).intValue());
        }

    }
}
