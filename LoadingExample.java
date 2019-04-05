import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage; 
import java.io.File; 
import java.io.IOException; 
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
  
public class LoadingExample {
   public static void main( String[] args ) throws IOException {
      //Input File 
      File input = new File("I:/trip to chulgiri/2017-08-06-10-25-06-638.jpg");
          
      //Reading the image 
      BufferedImage image = ImageIO.read(input);
      LoadingExample obj=new LoadingExample();
      obj.displayImage(image);
      
      //Saving the image with a different name
      File ouptut = new File("H:/eclipse mars.2/OpenCVJava/Sample/2.jpg");
      ImageIO.write(image, "jpg", ouptut);
         
      System.out.println("image Saved");
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