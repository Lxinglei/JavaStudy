package cn.meteor.io.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by metror on 15/5/20.
 */

public class IOTest {
    public static void main(String[] args) {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            str = br.readLine();
            System.out.println(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
