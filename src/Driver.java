import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class Driver extends JPanel implements ActionListener, MouseListener{

	Background b = new Background(1);
	int counter = 0;
	Background title = new Background(0);
	buttons exit = new buttons(0, 600,4);
	buttons start = new buttons(600, 600,3);
	buttons pause = new buttons(1035,717,2);
	buttons resume = new buttons(1028,717,1);
	String screen = "main menu";
	String gameButton = "pause";
	String select = "nothing";
	ArrayList<Person> people = new ArrayList<Person>();
	ArrayList<Bat> towers = new ArrayList<Bat>();
	int deathCounter = 300;
	Bat buyBat = new Bat(1300,115,1);
	Bat buyCatapult = new Bat(1300,185,3);
	int tempvx, tempvy;
	Virus v = new Virus(1000, 100, 5);
	int round = 0;
	int mouseX, mouseY;
	int[][] rounds = {
			{1,15,0,0,0,0},
			{2,10,10,0,0,0},
			{3,0,20,0,0,0,0},
			{4,0,10,10,0,0},
			{5,10,10,20,0,0},
			{6,0,0,10,10,0},
			{7,0,0,0,10,10},
			{8,0,0,0,0,20},
			{9,0,0,0,0,30},
			{10,10,10,10,10}
	};
	Music2 MainMenuMusic = new Music2("Menu_Music.wav", true);
	Music2 GameMusic = new Music2("Game_Music_(1).wav", true);
	Music2 loseSound = new Music2("loseSound.wav", false);
	Music2 winSound = new Music2("winSound.wav", false);
	Music2 upgradeSound = new Music2("upgradeSound.wav", false);
	Music2 spawnSound = new Music2("spawn.wav", false);
	Music2 startSound = new Music2("startSound.wav", false);
	

		
	public void paint(Graphics g) {
		super.paintComponent(g);
		title.paint(g);
		exit.paint(g);
		start.paint(g);
		
		if (screen.equals("play")) {
		
			
		b.paint(g);
		buyBat.paint(g);
		buyCatapult.paint(g);
		
		for (Bat placeTowers : towers) {
			placeTowers.paint(g);
		}
	
		if (gameButton.equals("resume")) {
			resume.paint(g);
			for (int i = 0; i < people.size(); i++) {
				people.get(i).setVXandVY(tempvx,tempvy);
			}
			for (Person enemies : people) {
				enemies.paint(g);
				int newTimer = 0;
				while (newTimer > 200) {
					newTimer++;
				}
				if (isRoundOver())  {
					
					gameButton = "pause";
					round++;
					

				}
			}
		} else if (gameButton.equals("pause")) {
			pause.paint(g);
			for (int i = 0; i < people.size(); i++) {
				tempvx = people.get(i).getVX();
				tempvy = people.get(i).getVY();

				people.get(i).setVXandVY(0,0);
			}
			
		}
	
		
		 if (!gameButton.equals("pause")) {
			counter++;
			}
		}
		if (screen.equals("exit") ) {
		   System.exit(0);
		}
		if (isRoundOver()) {
			counter = 0;
		}
	
	}
	
	public void displayNumber(int number, Graphics g, int x, int y) {
		int display;
		for (int i = 0; i < number; i++) {
			display = number % 10;
			switch(display)
			{
			   case 0 :
				   getImage("number 0.png");
				   
				   break; 
			   case 1 :
				   getImage("number 1.png");
			      break; 
			   case 2 :
				   getImage("number 2.png");
			      break; 
			   case 3 :
				   getImage("number 3.png");
			      break; 
			   case 4 :
				   getImage("number 4.png");
			      break; 
			   case 5 :
				   getImage("number 5.png");
			      break; 
			   case 6 :
				   getImage("number 6.png");
			      break; 
			   case 7 :
				   getImage("number 7.png");
			      break; 
			   case 8 :
				   getImage("number 8.png");
			      break; 
			   case 9 :
				   getImage("number 9.png");
			      break; 
		}
	}
	}
	
	

	public boolean isRoundOver() {

		for (int i = 0; i < people.size();i++) {
			if (people.get(i).getStage() != 0) {
				return false;
			}
			else {
				round++;
				deathCounter = 1000;
				while (deathCounter >0) {
					deathCounter--;
				}
			}
			
		}
		return true;
	}
	
	public int roundMoney () {
		
		if (isRoundOver() == true) {
			return 300 + (round * 100);
		}else {
			return 0;
		}
		
		
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
	if (screen.equals("main menu")) {
	MainMenuMusic.play();
		} else if (screen.equals("play")) {
			MainMenuMusic.stop();
			GameMusic.play();
		}
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		
	}
	Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Person.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	



	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		 mouseX = arg0.getX();
		 mouseY = arg0.getY();
		
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
		mouseX = arg0.getX();
		mouseY = arg0.getY();
		if (mouseX >= 1290 && mouseX < 1370 && mouseY >= 120 && mouseY <  190) {
			select = "bat";
		}if (mouseX >= 1290 && mouseX < 1370 && mouseY >= 190 && mouseY <  260) {
			select = "catapult";
		}
		
		
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int counter;
		mouseX = arg0.getX();
		mouseY = arg0.getY();
		if (!select.equals("nothing")) {
			if (select.equals("bat")) {
				Bat batty = new Bat(mouseX-50,mouseY-50,1);
				towers.add(batty);
				select = "nothing";
				System.out.println("yes");
			} else if (select.equals("catapult")) {
				Bat catty = new Bat(mouseX-50,mouseY-50,5);
				towers.add(catty);				select = "nothing";

				System.out.println("yes");
			}  
		}
		if ((610 < mouseX && mouseX < 800) && (690 < mouseY  && mouseY < 750)) {
			screen = "play";
		}else if ((10 < mouseX && mouseX < 200) && (690 < mouseY  && mouseY < 750)) {
			screen = "exit";
		} else if (mouseX < 1200 && mouseX > 1010 && mouseY < 780 && mouseY > 705 && (gameButton.equals("pause"))) {
			gameButton = "resume";
			for (int i = 1; i < rounds[round].length; i++) {
				for (int l = 0; l < rounds[round][i]; l++) {
						people.add(new Person(1240,125,i));
						System.out.println("yes");
				}
			}
			
		}else if (mouseX < 1200 && mouseX > 1010 && mouseY < 780 && mouseY > 705 && (gameButton.equals("resume")|| screen.equals("play"))) {
			gameButton = "pause";
			

		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

}
