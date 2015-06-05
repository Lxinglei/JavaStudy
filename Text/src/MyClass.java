/**
 * Created by meteor on 15/6/1.
 */
public class MyClass {
    private int f1;

    public MyClass(int f1) {
        this.f1 = f1;
    }

    public MyClass() {
    }

    public int getF1() {
        return f1;
    }

    public void setF1(int f1) {
        this.f1 = f1;
    }
    public static void main(String[] args){
        MyClass m1 = new MyClass(1);
        MyClass m2 = new MyClass();
        m2.setF1(m1.getF1());
        m2.setF1(2);
        System.out.println(m1.getF1());
    }
}

