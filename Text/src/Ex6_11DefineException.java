/**
 * Created by meteor on 15/5/30.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Ex6_11DefineException {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        while(true){
            String len;
            System.out.println("请输入字符串（输入DONE结束）：");
            BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
            StringToolLongException problem=new StringToolLongException();

            //System.out.println("请输入字符串（输入DONE结束）：");

            try{
                len=buf.readLine();
                if(len.length()>20)
                    throw problem;
            }catch(StringToolLongException e){
                System.out.print(e.toString());
            }//System.out.println("程序运行结束。");
        }
    }

}
class StringToolLongException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    StringToolLongException(){
        super("输入字符串长度超出范围！");
    }

}