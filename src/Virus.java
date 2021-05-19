import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Virus{

	private int posX,posY;
	private int vx,vy;
	
	
	
	public Virus(int startingX, int startingY, int speed) {
		
		posX = startingX;
		posY = startingY;
		vx = speed;
		vy = speed;
		
	}
}
