import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: guoping
 * Date: 14-9-5
 * Time: 下午2:21
 * To change this template use File | Settings | File Templates.
 */
public class NameTest {
    public static void main(String[] args) {
        char[] str = "alert('123')".toCharArray();
        String[] octArr = new String[str.length];
        String[] hexArr = new String[str.length];

        //字符转八进制
        System.out.println("---------------------二进制--------------------------");
        for(int i=0;i<str.length;i++){
            String a = Integer.toBinaryString(str[i]);
            System.out.println(a);
        }

        //字符转八进制
        System.out.println("---------------------八进制--------------------------");
        for(int i=0;i<str.length;i++){
            String a = Integer.toOctalString(str[i]);
            System.out.print("\\" + a);
            octArr[i] = a;
        }

        //字符转十六进制
        System.out.println("---------------------十六进制--------------------------");
        for(int i=0;i<str.length;i++){
            String a = Integer.toHexString(str[i]);
            System.out.print("\\u" + a);
            hexArr[i] = a;
        }

        System.out.println("---------------------翻转--------------------------");

        System.out.println("---------------------十六进制为数字前 + 0x--------------------------");
        char oxs = (char)0x61;
        System.out.println(oxs);

        System.out.println("---------------------八进制为数字前 + 0--------------------------");
        char os = (char)0141;
        System.out.println(os);

        System.out.println("---------------------十六进制方法2--------------------------");
        for(int i=0;i<hexArr.length;i++){
            int oi1 = Integer.parseInt(hexArr[i],16);
            char o1s = (char)oi1;
            System.out.print(o1s);
        }
        System.out.println();

        System.out.println("---------------------八进制方法2--------------------------");
        for(int i=0;i<octArr.length;i++){
            int a = Integer.parseInt(octArr[i],8);
            char as = (char)a;
            System.out.print(as);
        }
    }
}
