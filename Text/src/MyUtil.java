/**
 * Created by metror on 15/5/10.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class MyUtil {
    //调试模式开关
    public static boolean DEV_MODE = false;
    //文件路径
    private String filePath;
    //矩阵行数
    private int num;

    //构造函数

    /**
     *
     * @param filePath
     * @param num
     */
    public MyUtil(String filePath, int num) {
        this.filePath = filePath;
        this.num = num;
    }

    public String getFilePath() {
        return filePath;
    }

    //获取矩阵行数
    public int getNum() {
        return num;
    }

    /**
     *
     * @return intArray
     */
    public int[][] FileToIntegerArray() {
        StringBuilder sb = new StringBuilder();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(new File(getFilePath())));
            String tmp;
            while ((tmp = br.readLine()) != null) {
                sb.append(tmp.trim());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int intArray[][] = new int[getNum()][getNum()];

        /**
         * 调试输出,通过DEV_MODE开关控制
         */
        if (DEV_MODE)
            System.out.println("======================================\n从文件读入的字符串:\n" + sb.toString().trim() + "\nlength:" + sb.toString().trim().split(",").length +
                    "\n======================================");

        intArray = getMap(sb.toString(), getNum());

        if (DEV_MODE){
            System.out.println("转换成的矩阵:\n====================================== ");
            for (int i = 0; i < getNum(); i++) {
                for (int j = 0; j < getNum(); j++) {
                    System.out.print(intArray[i][j] + ",");
                }
                System.out.println();
            }
        System.out.println("======================================");
        }
        return intArray;
    }

    public int[][] getMap(String str, int num) {
        int count = 0;
        String[] strArr = str.split(",");
        int[][] a = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                a[i][j] = Integer.parseInt(strArr[count]);
                count++;
            }
        }
        return a;
    }

}
