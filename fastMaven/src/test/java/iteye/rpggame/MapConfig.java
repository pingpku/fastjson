package iteye.rpggame;

import javax.swing.ImageIcon;

public interface MapConfig {
    //素材的大小
    int eleWidth = 50;
    int eleHeight = 50;
    //地图的大小
    int MapWidth = 2000;
    int MapHeight= 2000;
    //地图保存的位置
    String path = "bodytxt.map";

    //用到的图片素材
    ImageIcon icon0 = new ImageIcon("000草地.png");
    ImageIcon icon100 = new ImageIcon("100红树.png");
    ImageIcon icon101 = new ImageIcon("101绿树.png");
    ImageIcon icon102 = new ImageIcon("102绿竹.png");
    //将所有的图片素材对象放入一个数组中，便于窗体上的下拉列表添加所有的图片素材
    ImageIcon[] allicons = {icon0,icon100,icon101,icon102};
}