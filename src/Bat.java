
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Bat {


	private int posX, posY;
	private boolean batupgrade;
	private Image imageOfBatLookingLeft, imageOfBatLookingRight, finalImage;
	private AffineTransform tx = AffineTransform.getTranslateInstance(posX, posY);
	private int counter;
	private int version;
	
	public Bat(int newX, int newY, int newVersion) {
		version = newVersion;
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
			if (version == 1) {
		imageOfBatLookingRight = getImage("bat.png");
		imageOfBatLookingLeft = getImage("bat.png");
		tx.scale(1, 1);

			} else if (version == 2) {
				imageOfBatLookingRight = getImage("normal bat looking right.gif");
				imageOfBatLookingLeft = getImage("normal bat looking left.gif");
				tx.scale(1, 1);
			} else if (version == 3) {
				imageOfBatLookingRight = getImage("bat2right.gif");
				imageOfBatLookingLeft = getImage("bat2left.gif");
				tx.scale(1, 1);
			} else if (version == 4) {
				imageOfBatLookingRight = getImage("catapult.png");
				imageOfBatLookingLeft = getImage("catapult.png");
				tx.scale(2, 2);
			} else if (version == 5) {
				imageOfBatLookingRight = getImage("catapult looking right.gif");
				imageOfBatLookingLeft = getImage("catapult looking left.gif");
				tx.scale(2, 2);
			} else if (version == 6) {
				imageOfBatLookingRight = getImage("catapult2right.gif");
				imageOfBatLookingLeft = getImage("catapult2left.gif");
				tx.scale(2, 2);
			}
		finalImage = imageOfBatLookingLeft;
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(finalImage, tx, null);
		tx.setToTranslation(posX, posY);
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
