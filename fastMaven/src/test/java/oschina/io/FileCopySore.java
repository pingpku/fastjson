package oschina.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 功能：将自己写的代码复制一份保存到指定文件夹
 * 只要输入所在工程的包名即可完成复制移动到F:\javaDaiMa\目录下
 *
 *
 * @author xiao
 *
 */
public class FileCopySore {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的包名:");
        String packageName = scanner.nextLine().trim();

        File file = new File("./src/"+packageName+"/");//目标文件

        File[] subs = file.listFiles();//获得文件列表

        for(File sub:subs){
            String str = sub.getName();
            System.out.println("所要复制的文件名："+str);
            if(str.endsWith("txt") || str.endsWith("java")){//只复制后缀为java和txt的文件
                System.out.println(str);
                try {
                    moveCopy(sub);
                    explainWord(sub,packageName);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     *
     */
    public static void explainWord(File file,String pathName)throws IOException{

        FileOutputStream fos =
                new FileOutputStream("F:\\javaDaiMa\\explain"+
                        file.getName().replace("java", "txt"));//复制的文件的目录

        BufferedOutputStream bos =
                new BufferedOutputStream(fos);

        long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH点mm分ss秒 E a");
        String strDate = sdf.format(date);
        bos.write(strDate.getBytes());
        bos.write("\n原文件所在工程jsd07的包名为:".getBytes());
        bos.write(pathName.getBytes());
//          bos.write();


//      bis.close();
        bos.close();
        System.out.println("写explain文件成功");
    }

    /**
     * 将文件从工程目录复制移动到指定目录下
     * @param file
     * @throws IOException
     */
    public static void moveCopy(File file) throws IOException{

        FileInputStream fis =
                new FileInputStream(file);//字节流

        BufferedInputStream bis =
                new BufferedInputStream(fis);//加快复制效率


        FileOutputStream fos =
                new FileOutputStream("F:\\javaDaiMa\\"+file.getName());//复制的文件的目录

        BufferedOutputStream bos =
                new BufferedOutputStream(fos);


        int d = -1;
        while((d =bis.read())!= -1){
            bos.write(d);
        }

        bis.close();
        bos.close();
        System.out.println("复制成功");

    }
}
