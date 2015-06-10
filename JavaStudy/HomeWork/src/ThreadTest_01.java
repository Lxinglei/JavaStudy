/**
 * Created by meteor on 15/6/5.
 */
public class ThreadTest_01 {
    public static void main(String[] args){
        System.out.println("程序开始");
        MyThread myThread = new MyThread();
        System.out.println("MyThread: " + myThread.getState());
        myThread.start();
        System.out.println("MyThread: " + myThread.getState());
        System.out.println("我在这");
        System.out.println("MyThread: " + myThread.getState());
    }
}

class MyThread extends Thread{
    private int count;
    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(2000);
                System.out.println(count);
                count ++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
