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
        g.setBackground(new Color(255, 205, 66));
        g.drawRect(0,0,200,100);
        g.setPaint(new Color(255, 18, 210));
        Font font = new Font("楷体",Font.BOLD,30);
        g.setFont(font);
        g.drawString(content,80,50);
        return img;
    }

    public static void main(String[] args) throws IOException {

        String code = StringUtil.createRandomCharData(6);

        BufferedImage img = ImageUtil.getImage(code,200,100);

        File file = new File("D:/code.jpg");

        ImageIO.write(img,"jpg",file);
    }
}
