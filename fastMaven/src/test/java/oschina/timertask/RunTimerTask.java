package oschina.timertask;

/**
 * Created with IntelliJ IDEA.
 * User: guoping
 * Date: 14-10-23
 * Time: 上午11:07
 * To change this template use File | Settings | File Templates.
 */

import util.TxtFileUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class RunTimerTask extends TimerTask {
    // 标记第几次调度
    public static int num = 1;
    File file = new File("14.txt"/** 文件路径名 **/
    );

    @Override
    public void run() {
        // TODO Auto-generated method stub
        // 标记开始时间
        double startTime = System.currentTimeMillis();
        System.out.println("start");

        /**
         * 每次调用将日期存入文件中
         */
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        String stringDate = simpleDateFormat.format(date);

        TxtFileUtil.appendToFile(stringDate + "\r\n", file);// \r\n实现换行，不能对换位置

        /**
         * 每次执行一个时间调度任务时都开辟一个线程去执行，这样可以减少时间开销避免任务执行时间过长导致定时调度的延迟
         */
        EventRunnable eventRunnable = new EventRunnable("event" + num);
        Thread thread = new Thread(eventRunnable);
        thread.start();


        /**
         * 算出执行完run方法后消耗的总时间，如果超过一秒则定时器将延迟
         */
        double endTime = System.currentTimeMillis();
        System.out.println("RunTimerTask" + num + ":" + (endTime - startTime) + "毫秒");
        TxtFileUtil.appendToFile("RunTimerTask" + num + ":" + (endTime - startTime)
                + "毫秒" + "\r\n", file);


        // 运行十次后结束
        num++;
        while (RunTimerTask.num == 11) {
            this.cancel();

        }

    }

}
