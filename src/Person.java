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
	private int tempVY, tempVX;
	
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
	public void setVXandVY(int newVX, int newVY) {
		vx = newVX;
		vy = newVY;
		

	}
	public void dispose(Graphics g, boolean goingLeft) {
		if (goingLeft) {
			finalImage=imageOfPersonGoingLeft;
		} else {
			finalImage =imageOfPersonGoingRight; 

		}
	}
	public void paint(Graphics g) {
		
	
		if (posX >=90 && posX < 95 && posY == 125) {
			down(stageOfPerson);		//	System.out.println("hi");
		}	else if (posX >=90 && posX < 95 && posY >=410 && posY < 415 ) { 
			right(stageOfPerson);		//	System.out.println("no u");

		}	else if ( posY >=410 && posY < 415 && posX >= 660 && posX <665) {
			up(stageOfPerson);		//	System.out.println("bye");
		
		}else	 if (posX >= 660 && posX <665 && posY <= 250 && posY > 245) {
			right(stageOfPerson);				//System.out.println("yes");

		}	else  if (posY <= 250 && posY > 245 && posX >= 1080 && posX < 1805) {
			down(stageOfPerson);		//	System.out.println("no");

		}	else if (posX >= 1080 && posX < 1805 && posY >= 470 && posY < 475 ) {
			left(stageOfPerson);		//	System.out.println("maybe");

		}	else	if (posY >= 470 && posY < 475 && posX <= 130 && posX >125) {
				down(stageOfPerson);	//	System.out.println("so");

		}	else  if (posX <= 130 && posX >125 && posY >= 570 && posY < 575) { 
				right(stageOfPerson);	//	System.out.println("oof");

		}	else if (posY == 125) {
			left(stageOfPerson);

		}  else if (posX == 1180 && posY > 550) {
			stageOfPerson = 0;
		} else if (posX > 1240) {
		finalImage =imageOfPersonGoingLeft; 
		}
		   
		//System.out.println(posX + " " + posY);
		
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
			dispose(g,isDead);
		
	
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
