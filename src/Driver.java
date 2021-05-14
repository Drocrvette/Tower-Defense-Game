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
	Person oldPerson1 = new Person(-100,50,1);
	Person normalPerson1 = new Person (-100, 50, 2);
	Person fastest1 = new Person (-100, 50, 5);
	Person fast1 = new Person(-100, 50, 3);
	Person faster1 = new Person(-100, 50, 4);
	int counter = 0;
	Background title = new Background(0);
	buttons exit = new buttons(0, 600,4);
	buttons options = new buttons(300, 600,5);
	buttons start = new buttons(600, 600,3);
	Bat basic = new Bat(300, 300);

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
		options.paint(g);
		start.paint(g);
		
		if (counter >= 1) {
		b.paint(g);
		oldPerson1.paint(g);
		basic.paint(g);

		
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
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver d = new Driver();
	}
	
	
	public Driver() {
		JFrame f = new JFrame("Tower-defense-game");
		f.setSize(new Dimension(850, 850));
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
			counter = 1;

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
