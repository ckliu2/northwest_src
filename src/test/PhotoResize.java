package test;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class PhotoResize {

    public static void main(String[] args) {
	try{
	    String srcImageFile="D://IIS//bill//photo//20110530031//3.jpg";
	    BufferedImage src = ImageIO.read(new File(srcImageFile)); 
            int width = src.getWidth(); 
            int height = src.getHeight();
            System.out.println("width="+width+"--height="+height);
            
           
            java.text.DecimalFormat df = new java.text.DecimalFormat("#0.####");
            int reWidth,reHeight;  
            double scaleRate;    
            int limitWidth=456;
            int limitHeight=304;
            
            //¾î¦¡
            if(width >= height){
               scaleRate=Double.parseDouble(String.valueOf(limitWidth))/Double.parseDouble(String.valueOf(width));      
             }else{
             	//ª½¦¡
           	   scaleRate=Double.parseDouble(String.valueOf(limitHeight))/Double.parseDouble(String.valueOf(height));      
             }
          
            System.out.println("scaleRate="+scaleRate);
            
            
            reWidth=(int)Math.round(Double.parseDouble(String.valueOf(width)) * scaleRate);
            System.out.println("reWidth="+reWidth);
            
            reHeight=(int)Math.round(Double.parseDouble(String.valueOf(height)) * scaleRate);
            System.out.println("reHeight"+reHeight);
            /*
            reHeight=Integer.parseInt( df.format( Double.parseDouble(String.valueOf(height)) * scaleRate) );
            
            Math.round(scaleRate);
            */
            /*
      	    System.out.println(reWidth+"--"+reHeight);
      	    */
            
      	      /*
            String result="d://tmp//family-1.jpg";
            Image image = src.getScaledInstance(width, height, Image.SCALE_DEFAULT);  
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
            Graphics g = tag.getGraphics();  
            g.drawImage(image, 0, 0, null); 
            g.dispose();  
            ImageIO.write(tag, "JPEG", new File(result));
            */
            //Double.parseDouble();
            
      
	}catch(Exception e){
	    System.out.println(e.toString());
	}

    }

}
