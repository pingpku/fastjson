import java.util.Random;

/**
 * 每五个产生一个随机数
 * Created with IntelliJ IDEA.
 * User: guoping
 * Date: 14-9-2
 * Time: 上午9:35
 * To change this template use File | Settings | File Templates.
 */
public class RanTest {
    public static void main(String[] args) {

        RanTest test = new RanTest();
        test.rand5();
    }

    public void rand5(){
        int[] a = new int[50];
        for(int i=0;i<50;i++){
            a[i] = i+1;
        }
        int b[] = new int[10];
        Random random = new Random();
        int j = 0;
        for(int i=0;i<a.length;i = i + 5){
            int ran = random.nextInt(5) + (i+1);
            b[j] = ran;
            j++;
        }
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }

    /**
     * 每10个产生两个随机数
     */
    public void rand10(){
        int[] a = new int[50];
        for(int i=0;i<50;i++){
            a[i] = i+1;
        }
        int b[] = new int[10];
        Random random = new Random();
        int j = 0;
        for(int i=0;i<a.length;i = i + 10){
            int ran = random.nextInt(10) + (i+1);
            b[j] = ran;
            j++;
            while(true){
                int ran1 = random.nextInt(10) + (i+1);
                if(ran1 != ran){
                    b[j] = ran1;
                    j++;
                    break;
                }
            }
        }
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }
}
