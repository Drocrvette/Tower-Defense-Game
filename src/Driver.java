import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class Driver extends JPanel implements ActionListener, MouseListener{

	Background b = new Background(1);
	Person oldPerson1 = new Person(1240,125,1);
	Person normalPerson1 = new Person (1240, 125, 2);
	Person fastest1 = new Person (1240, 125, 5);
	Person fast1 = new Person(1240, 125, 3);
	Person faster1 = new Person(1240, 125, 4);
	int counter = 0;
	Background title = new Background(0);
	buttons exit = new buttons(0, 600,4);
	buttons start = new buttons(1200, 600,3);
	Bat basic = new Bat(300, 300);
	String screen = "main menu";
	ArrayList<Person> people = new ArrayList<Person>();
	int deathCounter = 300;
	Bat buyBat = new Bat(1300,115);
	Bat buyCatapult = new Bat(1300,185);

	
	Thread music = new Thread() {
		public void run() {
			Clip clip;
			try {
				AudioInputStream input = AudioSystem.getAudioInputStream(new File("other music.wav"));
				clip = AudioSystem.getClip();
				clip.open(input);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				clip.start();
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}
		}
	};
		
	public void paint(Graphics g) {
		super.paintComponent(g);
		title.paint(g);
		exit.paint(g);
		start.paint(g);
		

		
		if (screen.equals("play")) {
		b.paint(g);
		buyBat.paint(g);
		buyCatapult.paint(g);
		oldPerson1.paint(g);
		people.add(fastest1);
	


	
		if (counter >= 50) {
		normalPerson1.paint(g);

		

		}
		if (counter >= 100) {
			fast1.paint(g);


			
			}if (counter >= 150) {
			faster1.paint(g);
				
			}if (counter >= 200) {
			fastest1.paint(g);
							}
			if (counter >= 250) {

			}
			counter++;
		}
		if (screen.equals("exit") ) {
		   System.exit(0);
		}
		if (isRoundOver()) {
			counter = 0;
		}
	
	}
	
	public boolean isRoundOver() {

		for (int i = 0; i < people.size();i++) {
			if (people.get(i).getStage() != 0) {
				return false;
			}
			else {
				deathCounter = 1000;
				while (deathCounter >0) {
					deathCounter--;
					System.out.println(deathCounter);
				}
			}
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver d = new Driver();
	}
	
	
	public Driver() {
		JFrame f = new JFrame("Tower-defense-game");
		f.setSize(new Dimension(1440, 900));
		f.add(this);
		f.addMouseListener(this);
		f.setResizable(false);
		
		Timer t = new Timer(16, this);
	
		music.run();
		
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		
	}
	
	



	
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int mouseX = arg0.getX();
		int mouseY = arg0.getY();
		if ((1210 < mouseX && mouseX < 1400) && (690 < mouseY  && mouseY < 750)) {
			screen = "play";
		}else if ((10 < mouseX && mouseX < 200) && (690 < mouseY  && mouseY < 750)) {
			screen = "exit";
		}
		System.out.println(screen);

	}
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

}
