
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class buttons {
	private int x = 0,y = 0;
	private Image img; // image of the frog
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	public buttons(int initX, int initY, int buttonType) {
		x = initX;
		y = initY;

		if (buttonType == 4) {
		img = getImage("pixil-frame-0 (4).png");
		initMainMenu(x,y);

		} 
			if (buttonType == 3) {
			img = getImage("pixil-frame-0 (3).png");
			initMainMenu(x,y);

			} if (buttonType == 1) {
				img = getImage("pause button.png");
				initMap(x,y);

			}
			if (buttonType == 2) {
				img = getImage("play button.png");
				initMap(x,y);

			}
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		
	}
	
	
	private void initMainMenu(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1.11, 1.1);
	}
	
	private void initMap(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(4, 3.5);
	}
	



	// converts image to make it drawable in paint
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = buttons.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
