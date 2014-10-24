package oschina.timertask;

/**
 * Created with IntelliJ IDEA.
 * User: guoping
 * Date: 14-10-23
 * Time: 上午11:09
 * To change this template use File | Settings | File Templates.
 */

import java.io.File;

import util.TxtFileUtil;

public class EventRunnable implements Runnable {
    private String name;
    File file = new File(
            "14.txt"/** 文件路径名 **/
    );

    public EventRunnable(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        double startTime = System.currentTimeMillis();
        String x = "nihao";
        for (int i = 0; i < 80000; i++) {
            x += "!";
        }
        double endTime = System.currentTimeMillis();

        System.out.println(name + ":" + (endTime - startTime) + "毫秒");
        TxtFileUtil.appendToFile(name + ":" + (endTime - startTime) + "毫秒"
                + "\r\n", file);
    }

}
