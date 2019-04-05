import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class GaussianBlur {
   public static void main(String args[]) throws IOException {
      // Loading the OpenCV core library
      System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

      // Reading the Image from the file and storing it in to a Matrix object
      String file ="H:/eclipse mars.2/OpenCVJava/Sample/2.jpg";
      Mat src = Imgcodecs.imread(file);
      
      BufferedImage img=ImageIO.read(new File("H:/eclipse mars.2/OpenCVJava/Sample/2.jpg"));
      GaussianBlur obj=new GaussianBlur();
      obj.displayImage(img);
    

      // Creating an empty matrix to store the result
      Mat dst = new Mat();
    
      // Applying GaussianBlur on the Image
      Imgproc.GaussianBlur(src, dst, new Size(45, 45), 0);

      // Writing the image
      Imgcodecs.imwrite("H:/eclipse mars.2/OpenCVJava/Sample/Gaussian.jpg", dst);
      BufferedImage img3=ImageIO.read(new File("H:/eclipse mars.2/OpenCVJava/Sample/Gaussian.jpg"));
      obj.displayImage(img3);
      System.out.println("Image Processed");
   }
   public void displayImage(Image img2) {
	    ImageIcon icon=new ImageIcon(img2);
	    JFrame frame=new JFrame();
	    frame.setLayout(new FlowLayout());        
	    frame.setSize(img2.getWidth(null)+50, img2.getHeight(null)+50);     
	    JLabel lbl=new JLabel();
	    lbl.setIcon(icon);
	    frame.add(lbl);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}