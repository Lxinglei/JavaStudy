package cn.meteor.homework.ticket;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created by meteor on 15/6/4.
 */
public class Ticket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketSystem ts = new TicketSystem();
        while (true) {
            TicketView.drawMainMenu();
            switch (sc.nextInt()) {
                case 1:
                    System.out.print("请输入位置的x y坐标, 中间以空格隔开: ");
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    if (ts.getTicket(new Site(x, y)))
                        System.out.println("message: 购票成功!");
                    else System.out.println("message； 购票失败");
                    break;
                case 2:
                    System.out.print("请输入位置的x y坐标, 中间以空格隔开: ");
                    int x1 = sc.nextInt();
                    int y1 = sc.nextInt();
                    if (ts.returnTicket(new Site(x1, y1)))
                        System.out.println("message: 退票成功!");
                    else System.out.println("message: 退票失败");
                    break;
                case 3:
                    ts.check();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("非法操作!");
                    break;
            }
            System.out.println("\n\n\n");
        }
    }
}

class TicketSystem {
    private int[][] sites = new int[8][8];

    public TicketSystem() {
        for (int i = 0; i < sites.length; i++) {
            for (int j = 0; j < sites[i].length; j++) {
                sites[i][j] = 0;
            }
        }
    }

    public boolean getTicket(Site site) {
        if (site.getX() > sites.length - 1 || site.getY() > sites[0].length) {
            System.out.println("[fatal error]: 不存在此座位!");
            return false;
        }

        if (sites[site.getX()][site.getY()] == 0) {
            sites[site.getX()][site.getY()] = 1;
            return true;
        } else {
            System.out.println("[fatal error]: 此座位已经被预定!");
            return false;
        }
    }

    public boolean returnTicket(Site site) {
        if (site.getX() > sites.length - 1 || site.getY() > sites[0].length) {
            System.out.println("[fatal error]: 不存在此座位!");
            return false;
        }

        if (sites[site.getX()][site.getY()] == 0) {
            System.out.println("[fatal error]: 此座位暂未被预定!");
            return false;
        } else {
            sites[site.getX()][site.getY()] = 0;
            return true;
        }
    }

    public void check() {
        System.out.println("==========================================");
        for (int i = 0; i < sites.length; i++) {
            for (int j = 0; j < sites[i].length; j++) {
                String status = sites[i][j] == 0 ? "空闲位" : "已售出";
                System.out.print("【" + status + "】\t|");
            }
            System.out.println("");
            for (int j = 0; j <sites[i].length; j++) {
                System.out.print("【" + new Site(i, j) + "】\t|");
            }
            System.out.println("\n—————————————————————————————————————————————————————————————————————————————————————————");
        }
        System.out.println("==========================================");
    }
}

class TicketView {
    public static void drawMainMenu() {
        System.out.println("输入数字进行选择: ");
        System.out.println("=================");
        System.out.println("1. 订票");
        System.out.println("2. 退票");
        System.out.println("3. 查询");
        System.out.println("4. 退出");
        System.out.println("=================");
        System.out.print("请输入数字: ");
    }
}

class Site {
    private int x;
    private int y;

    public Site(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Site() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + " " + y + ")";
    }
}
