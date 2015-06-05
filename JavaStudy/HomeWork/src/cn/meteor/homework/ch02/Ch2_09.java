package cn.meteor.homework.ch02;

import java.text.DecimalFormat;

/**
 * Created by meteor on 15/5/31.
 */
public class Ch2_09 {
    public static void main(String[] args){
        Rectangle rec1 = new Rectangle(new Point(0, 0), new Point(2, -2));
        Rectangle rec2 = new Rectangle(new Point(0, 0), 2, 1, 2, -1);

        System.out.println(rec1);
        System.out.println("Circumfrence: " + rec1.getCircumfrence());
        System.out.println("Area " + rec1.getArea());
        System.out.println("Diagonal: " + rec1.getDiagonal());
        System.out.println("========================");
        System.out.println(rec2);
        System.out.println("Circumfrence: " + rec2.getCircumfrence());
        System.out.println("Area " + rec2.getArea());
        System.out.println("Diagonal: " + rec2.getDiagonal());
    }

}

/**
 * 二维点类
 */
class Point{
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

/**
 * 矩形类
 */
class Rectangle{
    private Point p1;
    private Point p2;

    /**
     * 用两个Point初始化矩形的构造函数
     * @param p1
     * @param p2
     */
    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * 用一个点和长宽以及长宽方向初始化矩形的构造函数
     * @param p1
     * @param width
     * @param widthDirect
     * @param height
     * @param heightDirect
     */
    public Rectangle(Point p1, double width, int widthDirect, double height, int heightDirect){
        this.p1 = p1;
        p2 = new Point();

        double x2, y2;
        if (widthDirect == 1)
            x2 = p1.getX() + width;
        else
            x2 = p1.getX() - width;

        if (widthDirect == -1)
            y2 = p1.getY() + width;
        else
            y2 = p1.getY() - width;

        p2.setX(x2);
        p2.setY(y2);
    }

    public double getCircumfrence(){
        return 2 * (Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY()));
    }

    public double getArea(){
        return Math.abs(p1.getX() - p2.getX()) * Math.abs(p1.getY() - p2.getY());
    }

    public double getWidth(){
        return Math.abs(p1.getX() - p2.getX());
    }
    public double getHeight(){
        return Math.abs(p1.getY() - p2.getY());
    }


    public double getDiagonal(){
        DecimalFormat decimalFormat = new DecimalFormat(".0");
        return Double.parseDouble(decimalFormat.format(Math.sqrt( getWidth() * getWidth() + getHeight() * getHeight() )));
    }
    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "[" + p1 + "," + p2 +"]";
    }
}