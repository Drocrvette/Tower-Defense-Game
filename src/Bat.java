
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Bat {

	private int posX, posY;
	private int upgradesOfBat;
	private Image imageOfBatLookingLeft, imageOfBatLookingRight, finalImage;
	private AffineTransform tx = AffineTransform.getTranslateInstance(posX, posY);
	private int counter;
	private int speedOfVirus;
	private int yellow = 3;
	
	public Bat(int newX, int newY) {
		posX = newX;
		posY = newY;
		init(posX, posY);
		imageOfBatLookingLeft = getImage("normal bat looking left.gif");
		imageOfBatLookingRight = getImage("normal bat looking right.gif");

	}
	

	public void visualTargeting(int humanPosX) {
		if (humanPosX > posX) {
			finalImage = imageOfBatLookingRight;

		} else {
			finalImage = imageOfBatLookingLeft;

		}
	}
	public void paint(Graphics g) {
			
		imageOfBatLookingRight = getImage("normal bat looking right.gif");
		imageOfBatLookingLeft = getImage("normal bat looking left.gif");
		
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(finalImage, tx, null);
		tx.setToTranslation(posX, posY);
		tx.scale(1, 1);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(2, 1.5);
	}
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Bat.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
