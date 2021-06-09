
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Money {
	private int bank = 0;
	private int x,y;
	private Image img; // image of the frog
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	private boolean roundOver;
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Money(int bank) {
		this.bank = bank;

		
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
			URL imageURL = Money.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public void setIsRoundOver(boolean newIsRoundOver) {
		roundOver = newIsRoundOver;
	}
}
