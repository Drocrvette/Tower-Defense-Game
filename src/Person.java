import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Person {

	private int vx, vy;
	private int posX, posY;
	private int stageOfPerson;
	private boolean isDead = false;
	private Image imageOfPersonGoingLeft, imageOfPersonGoingRight, finalImage;
	private AffineTransform tx = AffineTransform.getTranslateInstance(posX, posY);
	private int counter;
	private int position = vx + vy;
	
	public Person(int newX, int newY, int currentStage) {
		
		posX = newX;
		posY = newY;
		stageOfPerson = currentStage;
		init(posX, posY);
	
	}
	

	public void up(int stage) {
		vx = 0;
		vy = -stage;
	}public void down(int stage) {
		vx = 0;
		vy = stage;
	}public void left(int stage) {
		vx = -stage;
		vy = 0;
		finalImage=imageOfPersonGoingLeft;
	}public void right(int stage) {
		vx = stage;
		vy = 0;
		finalImage =imageOfPersonGoingRight; 
	}
	public void setStage(int newStage) {
		stageOfPerson = newStage;
	}
	public int getStage() {
		return stageOfPerson;
	}
	public int getX() {
		return posX;
	}
	public int getY() {
		return posY;
	}
	public int getVX() {
		return vx;
	}
	public int getVY() {
		return vy;
	}
	
	public void paint(Graphics g) {
		
		
		
		if (posX  > 50 && posY == 100) {
			left(stageOfPerson);
		  if (posX == 680 && posY > 0 && posY < 280) { 
			down(stageOfPerson);
		 if (posX == 680 && posY > 270 && posY < 500 ) {
			right(stageOfPerson);
		 if (posX == 150 && posY < 500 && posY > 270) {
			up(stageOfPerson);
		  if (posX < 680 && posY == 500) {
			right(stageOfPerson);
		  if (posX == 680 && posY >=500) {
			down(stageOfPerson);
			if (posX  > 50 && posY == 100) {
				left(stageOfPerson);
			  if (posX == 680 && posY > 0 && posY < 280) { 
				down(stageOfPerson);
			 if (posX == 680 && posY > 270 && posY < 500 ) {
				right(stageOfPerson);

		}
		   }}}}}}}}
		
		
		if (stageOfPerson == 1) {
			imageOfPersonGoingLeft = getImage("OldPerson Going Left.gif");
			imageOfPersonGoingRight = getImage("OldPerson Going Right.gif");
			} 
		if (stageOfPerson == 2) {
			imageOfPersonGoingLeft = getImage("normalPerson walking.gif");
			imageOfPersonGoingRight = getImage("normalPerson walking reversed.gif");
		}
		if (stageOfPerson == 3) {
			imageOfPersonGoingLeft = getImage("fastman Going Left.gif");
			imageOfPersonGoingRight = getImage("fastman Going Right.gif");
			} 
		if (stageOfPerson == 4) {
			imageOfPersonGoingLeft = getImage("fasterman going left.gif");
			imageOfPersonGoingRight = getImage("fasterman going right.gif");
		}
		if (stageOfPerson == 5) {
			imageOfPersonGoingLeft = getImage("Fastestman going left.gif");
			imageOfPersonGoingRight = getImage("Fastestman going right.gif");
		}
		if (stageOfPerson == 0) {
			imageOfPersonGoingLeft = getImage("better death.gif");
			imageOfPersonGoingRight = getImage("better death.gif");
			isDead = true;
			vx = 0;
			vy = 0;

		}
			
		
		
		posX+=vx;
		posY+=vy;
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(finalImage, tx, null);
		tx.setToTranslation(posX, posY);
		tx.scale(2, 2);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(2, 2);
	}
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Person.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
