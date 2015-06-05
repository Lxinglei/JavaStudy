package cn.meteor.homework.ch04;

/**
 * Created by meteor on 15/5/31.
 */
public class Ch04_06 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int [][] array = new int[10][10];
        for(int i=0; i< 10; i++){
            for(int j=0; j<i+1; j++){
                if(j == 0)
                    array[i][j] = 1;
                else if(i == 0) break;
                else
                    array[i][j]=array[i-1][j-1]+array[i-1][j];
            }
        }
        for(int i=0; i< 10; i++){
            for(int k=10 -i; k>0; k--)
                System.out.print("  ");
            for(int j=0; j<i+1; j++){
                if(array[i][j] < 10)
                    System.out.print("  " + array[i][j] + " ");
                else if(array[i][j] < 100 && array[i][j] >= 10 )
                    System.out.print(" " + array[i][j] + " ");
                else
                    System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}