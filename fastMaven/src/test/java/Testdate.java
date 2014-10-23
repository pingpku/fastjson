import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: guoping
 * Date: 14-9-2
 * Time: 上午10:44
 * To change this template use File | Settings | File Templates.
 */
public class Testdate {
    public static void main(String args[]) throws Exception {
        String pc = "201408";
        String ksyf = "8";
        int ys= 6;
        // 根据开始月份和月数获取该批次的所有月份
        // 获取年份
        String year = pc.substring(0, 4);
        if (ksyf.length() == 1) {
            ksyf = "0" + ksyf;
        }
        String startDate = year + ksyf;
        // 获取月份的数组，用来存月份
        HashMap[] arr = new HashMap[ys];
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date date = sdf.parse(startDate);
        cal.setTime(date);
        for (int i = 0; i < ys; i++) {
            arr[i] = new HashMap();
            arr[i].put("dis",sdf.format(cal.getTime()));
            arr[i].put("val",sdf.format(cal.getTime()));
            System.out.println(arr[i].toString());
            cal.add(Calendar.MONTH, 1);
        }
    }
}
