import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: guoping
 * Date: 14-7-24
 * Time: 上午11:26
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String args[]) throws  Exception{
        System.out.println("test git");
        Test t = new Test();
       int a = t.checkDsz("20140908");
    }

    /**
     * 根据传入的日期判断单双周
     * @param dateStr
     * @return
     * @throws Exception
     */
    public  int checkDsz(String dateStr) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //获取第一周的周一
        String firstWeek = "20140901";
        Date firstWd = sdf.parse(firstWeek);

        Calendar cal = Calendar.getInstance();
        cal.setTime(firstWd);
        cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        System.out.println("当周周一为：" + sdf.format(cal.getTime()));

        //判断传入的日期的单双周
        Date paramDate = sdf.parse(dateStr);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(paramDate);
        int xq = 0;
        if(cal2.get(Calendar.DAY_OF_WEEK) == 1){
            xq = 7;
        }else{
            xq = cal2.get(Calendar.DAY_OF_WEEK) - 1;
        }
        System.out.println("当前为星期：" + xq);

        long diffDay = (cal2.getTimeInMillis() - cal.getTimeInMillis())/(24 * 60 * 60 * 1000);
        System.out.println("相差天数："+diffDay);
        int diffWeek = (int)diffDay / 7;
        System.out.println("相差的星期数:" + diffWeek + ",为第" + (diffWeek + 1) + "周");
        if((diffDay / 7) % 2 ==0){//单周
            System.out.println("单周");
        } else {
            System.out.println("双周");
        }
        return 0;
    }

}
