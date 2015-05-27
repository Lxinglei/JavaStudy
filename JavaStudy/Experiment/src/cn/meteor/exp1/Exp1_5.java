package cn.meteor.exp1;

/**
 * Created by meteor on 15/5/24.
 */
public class Exp1_5 {
    private int[][] starRec = new int[7][7];

    private void fillRec() {
        int spaceCount = 8;
        int spaceLeftCount;
        for (int i = 0; i < 7; i++) {
            if (i < 4)
                spaceCount -= 2;
            else spaceCount += 2;
            spaceLeftCount = spaceCount / 2;
            for (int j = 0; j < 7; j++) {

                if (j < spaceLeftCount)
                    starRec[i][j] = -1;
                else if (7 - j <= spaceLeftCount)
                    starRec[i][j] = -1;
                else starRec[i][j] = 0;
            }
        }
    }

    public void printStars() {
        fillRec();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (starRec[i][j] == -1)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }

    public void printRec() {
        fillRec();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (-1 == starRec[i][j])
                    System.out.print(starRec[i][j] + " ");
                else
                    System.out.print(" " + starRec[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setStarRec(int[][] starRec) {
        this.starRec = starRec;
    }

    public static void main(String[] args) {
        Exp1_5 exp1_5 = new Exp1_5();
        System.out.println("========");
        exp1_5.printRec();
        exp1_5.printStars();
    }
}