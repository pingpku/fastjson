import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: guoping
 * Date: 14-9-2
 * Time: 上午10:44
 * To change this template use File | Settings | File Templates.
 */
public class Testdate {
    public static void main(String args[]){
        Date tdate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(tdate);
        cal.add(Calendar.DATE,1);
        System.out.println(cal.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println(sdf.format(cal.getTime()));
    }
}
