import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Virus {

	private double posX,posY;
	private double vx,vy;
	private double x;
	private double y;
	private int targetX, targetY;
	private double  angleInR;
	private Image finalImage;
	private boolean hit = false;
	private AffineTransform tx = AffineTransform.getTranslateInstance(posX, posY);	
	private int speed;
	
	
	public Virus(int startingX, int startingY, int newSpeed) {
		speed = newSpeed;
		posX = startingX;
		posY = startingY;
		init(posX,posY);
		hit = false;		
	}
	
	public void setTargetPos(int newTargetX, int newTargetY, int vOfTargetX, int vOfTargetY) {
		targetX = newTargetX+vOfTargetX;
		targetY = newTargetY+vOfTargetY;
	
		 x = targetX-posX;
		 y = targetY-posY;
		if (Math.sqrt((double)(x * x)+(y*y)) <500) {
			newMath();
		}
		if (Math.abs(x) < 50 && Math.abs(y) < 50) {
			hit = true;
			vx =0;
			vy = 0;
		}
	}

	
	public void newMath() {
		if (x < 0 && y < 0) {
		angleInR = Math.atan((double)(y/x));
		vx = -Math.cos(angleInR)*speed;
		vy = -Math.sin(angleInR)*speed;
		} else if (x > 0 && y < 0) {
			angleInR = Math.atan((double)(y/x));
			vx = Math.cos(angleInR)*speed;
			vy = Math.sin(angleInR)*speed;
			} else if (x < 0 && y > 0) {
				angleInR = Math.atan((double)(y/x));
				vx = -Math.cos(angleInR)*speed;
				vy = -Math.sin(angleInR)*speed;
				} else if (x > 0 && y > 0) {
					angleInR = Math.atan((double)(y/x));
					vx = Math.cos(angleInR)*speed;
					vy = Math.sin(angleInR)*speed;
					}  

		
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
