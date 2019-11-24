package com.web_dev.blog.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author xxq
 * @ClassName ImageUtil
 * @Description TODO
 * @Date 2019/11/20
 * @Version 1.0
 **/
public class ImageUtil {
    /**
     * 将字符串绘制成指定大小的矩形图片
     * @param content
     * @param width
     * @param height
     * @return
     */
    public static BufferedImage getImage(String content,int width,int height) {
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) img.getGraphics();
        //设置画笔颜色
        g.setColor(new Color(255, 255, 255));
        //填充背景色
        g.fillRect(0,0,width,height);
        //画一个矩形
        g.drawRect(0,0,200,100);
        //设置字的颜色
        g.setPaint(new Color(255, 18, 210));
        //设置字体
        Font font = new Font("楷体",Font.BOLD,40);
        g.setFont(font);
        g.drawString(content,40,60);
        g.setColor(new Color(76, 134, 236));
        g.drawLine(20,30,130,50);
        return img;
    }

    public static void main(String[] args) throws IOException {

        String code = StringUtil.createRandomCharData(6);

        BufferedImage img = ImageUtil.getImage(code,200,100);

        File file = new File("D:/code.jpg");

        ImageIO.write(img,"jpg",file);
    }
}
