package util;

/**
 * 两个包：commons-net-3.3.jar、log4j-1.2.16.ja
 *
 * Created with IntelliJ IDEA.
 * User: guoping
 * Date: 14-10-23
 * Time: 下午1:58
 * To change this template use File | Settings | File Templates.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

public class FtpUtil {
    // 日志
    public static Logger logger = Logger.getLogger(FtpUtil.class);

    /**
     * Description: 向FTP服务器上传文件
     *
     * @param url      FTP服务器hostname
     * @param port     FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param path     FTP服务器保存目录
     * @param filename 上传到FTP服务器上的文件名
     * @param input    输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(String url, int port, String username,
                                     String password, String path, String filename, InputStream input) {
        boolean returnValue = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;

            ftp.connect(url, port);// 连接FTP服务器
            ftp.login(username, password);// 登录
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.setControlEncoding("gbk");
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                logger.info("FTP SERVER REFUSED CONNECTION.");
                return returnValue;
            }
            String home_path = ftp.printWorkingDirectory();
            ftp.changeWorkingDirectory(home_path + path);

            ftp.storeFile(filename, input);

            input.close();

            ftp.logout();
            returnValue = true;
        } catch (IOException e) {
            logger.info("FTPUPLOADUTIL UPLOD FILE ERROR :" + e);
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return returnValue;
    }

    /**
     * Description: 向FTP服务器上传文件
     *
     * @param filename 上传到FTP服务器上的文件名
     * @param input    输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(String filename, InputStream input) {
        boolean returnValue = false;
        returnValue = uploadFile(InitProperties.ftpIp, InitProperties.ftpPort,
                InitProperties.ftpUser, InitProperties.ftpPwd,
                InitProperties.upload_ftp_path, filename, input);
        return returnValue;
    }

    /**
     * Description: 向FTP服务器下载文件
     *
     * @param url       FTP服务器hostname
     * @param port      FTP服务器端口
     * @param username  FTP登录账号
     * @param password  FTP登录密码
     * @param path      FTP服务器保存目录
     * @param filename  上传到FTP服务器上的文件名
     * @param localPath 输出路径
     * @return 成功返回true，否则返回false
     */
    public static boolean downloadFile(String url, int port, String username,
                                       String password, String path, String filename, String localPath) {
        boolean returnValue = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;

            ftp.connect(url, port);// 连接FTP服务器
            ftp.login(username, password);// 登录
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.setControlEncoding("gbk");
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                logger.info("FTP SERVER REFUSED CONNECTION.");
                return returnValue;
            }
            String home_path = ftp.printWorkingDirectory();
            ftp.changeWorkingDirectory(home_path + path);

            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(filename)) {
                    File localFile = new File(localPath);
                    OutputStream os = new FileOutputStream(localFile);
                    ftp.retrieveFile(ff.getName(), os);
                    returnValue = true;
                }
            }

            ftp.logout();
        } catch (IOException e) {
            logger.info("FTPDOWNLOADUTIL DOWNLOAD FILE ERROR :" + e);
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return returnValue;
    }

    /**
     * Description: 向FTP服务器下载文件
     *
     * @param filename  上传到FTP服务器上的文件名
     * @param localPath 输出路径
     * @return 成功返回true，否则返回false
     */
    public static boolean downloadFile(String filename, String localPath) {
        boolean returnValue = false;
        downloadFile(InitProperties.ftpIp, InitProperties.ftpPort,
                InitProperties.ftpUser, InitProperties.ftpPwd,
                InitProperties.upload_ftp_path, filename, localPath);
        return returnValue;
    }

}

class InitProperties {
    public static String uploadLocalPath;
    public static String upload_ftp_path;
    public static String ftpIp;
    public static int ftpPort;
    public static String ftpUser;
    public static String ftpPwd;
}
