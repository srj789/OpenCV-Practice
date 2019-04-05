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
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;

import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
  
public class FaceDetect {
   public static void main (String[] args) throws IOException {
      // Loading the OpenCV core library
      System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

      // Reading the Image from the file and storing it in to a Matrix object
      String file ="H:/eclipse mars.2/OpenCVJava/Sample/1.jpg";
      Mat src = Imgcodecs.imread(file);
      BufferedImage img=ImageIO.read(new File("H:/eclipse mars.2/OpenCVJava/Sample/1.jpg"));
      GaussianBlur obj=new GaussianBlur();
      obj.displayImage(img);

      // Instantiating the CascadeClassifier
      String xmlFile = "H:/opencv/sources/samples/winrt/FaceDetection/FaceDetection/Assets/haarcascade_frontalface_alt.xml";
      CascadeClassifier classifier = new CascadeClassifier(xmlFile);

      // Detecting the face in the snap
      MatOfRect faceDetections = new MatOfRect();
      classifier.detectMultiScale(src, faceDetections);
      System.out.println(String.format("Detected %s faces", 
         faceDetections.toArray().length));

      // Drawing boxes
      for (Rect rect : faceDetections.toArray()) {
         Imgproc.rectangle(
            src,                                               // where to draw the box
            new Point(rect.x, rect.y),                            // bottom left
            new Point(rect.x + rect.width, rect.y + rect.height), // top right
            new Scalar(0, 0, 255),
            3                                                     // RGB colour
         );
      }

      // Writing the image
      Imgcodecs.imwrite("H:/eclipse mars.2/OpenCVJava/Sample/facedetect_output3.jpg", src);
      BufferedImage img3=ImageIO.read(new File("H:/eclipse mars.2/OpenCVJava/Sample/facedetect_output3.jpg"));
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