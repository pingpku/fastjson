import java.util.HashMap;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: guoping
 * Date: 14-10-13
 * Time: 下午5:01
 * To change this template use File | Settings | File Templates.
 */
public class PercentFive {
    public static  void main(String[] args) throws Exception{
        Random ran = new Random();
        int i=0;
        HashMap hm = new HashMap();
        while (i < 3){
            int d = ran.nextInt(5);
            System.out.println(d);
            hm.put(d,d);
            i++;
        }
        System.out.println(hm.toString());
    }
}
