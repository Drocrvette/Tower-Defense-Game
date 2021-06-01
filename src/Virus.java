import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Virus {

	private int posX,posY;
	private double vx,vy;
	private int x,y;
	private int targetX, targetY;
	private int speedOfTargetX, speedOfTargetY;
	private Image finalImage;
	private boolean hit = false;
	private AffineTransform tx = AffineTransform.getTranslateInstance(posX, posY);
	private double a;
	private int speed;
	
	
	public Virus(int startingX, int startingY, int newSpeed) {
		speed = newSpeed;
		posX = startingX;
		posY = startingY;
		init(posX,posY);
		hit = false;		
	}
	
	public void setTargetPos(int newTargetX, int newTargetY, int vOfTargetX, int vOfTargetY) {
		targetX = newTargetX;
		targetY = newTargetY;
		speedOfTargetX = vOfTargetX;
		speedOfTargetY = vOfTargetY;
		 x = Math.abs(targetX-posX);
		 y = Math.abs(targetY-posY);
		if (Math.sqrt((double)(x * x)+(y*y)) <5000) {
			newMath();
		}
		if (Math.abs(x) < 50 && Math.abs(y) < 50) {
			hit = true;
		}
	}

	
	public void newMath() {
		targetX +=speedOfTargetX;
		targetY +=speedOfTargetY;
		vx = speed * Math.sin(a);
		vy = speed * Math.cos(a);
		
		
		System.out.println(vx + "  " + vy + "  " + a);
	}
	public void paint(Graphics g) {
		
		finalImage = getImage("pixil-frame-0 (15).png");
		posX+=vx;
		posY+=vy;
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(finalImage, tx, null);
		tx.setToTranslation(posX, posY);
		tx.scale(2, 2);
	}
	public boolean isHit() {
		return hit;
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(2, 1.5);
	}
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Virus.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	
	
	}
}
