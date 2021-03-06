package test;
import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO;  
import java.awt.image.Raster;
import java.util.Arrays;

public class GetPixels {
	static String direct_path;

	public GetPixels( String direc_path ) {
	     direct_path = direc_path;     
	}

	public static int[] get_pixels() {
//		System.out.println(direct_path);	
		
		
		BufferedImage img = null; 
	    File f = null; 
	     try
	     { 
	         f = new File(direct_path); 
	         img = ImageIO.read(f); 
//	         System.out.println(img.getClass().getName());
	     } 
	     catch(IOException e) 
	     { 
	         System.out.println(e); 
	     } 
	     int width = img.getWidth(); 
	     int height = img.getHeight(); 	     
	     int[] imgArr = new int[width*height];
	     Raster raster = img.getData();
	     for (int i = 0; i < width; i++) {
	         for (int j = 0; j < height; j++) {
	             imgArr[i*width+j] = raster.getSample(i, j, 0);	             
	         }
	     }	     
	     return imgArr;
	}

}
