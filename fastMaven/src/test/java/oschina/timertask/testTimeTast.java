package oschina.timertask;

/**
 * Created with IntelliJ IDEA.
 * User: guoping
 * Date: 14-10-23
 * Time: 上午11:09
 * To change this template use File | Settings | File Templates.
 */

import util.TxtFileUtil;

import java.io.File;
import java.util.Timer;

public class testTimeTast {

    public static void main(String[] args) {

        // 新建一个文件
        File file = new File(
                "14.txt"/**
         *
         * 文件路径名
         **/
        );
        try {
            TxtFileUtil.createFile(file);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /**
         * 新建一个时间调度任务
         */
        RunTimerTask run = new RunTimerTask();

        Timer timer = new Timer();
        // 每隔一秒钟执行任务一次,但是如果RunTimerTask执行时间超过一秒了，则会出现延迟的状况
        timer.schedule(run, 0, 1000);

    }

}
