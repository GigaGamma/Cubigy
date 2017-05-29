package com.cubigy.launcher;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.cubigy.game.Window;

public class Launcher extends Frame {

	private static final long serialVersionUID = 5836022044139812787L;
	
	private Button play;
	
	public Launcher() {
		setTitle("Cubigy Launcher");
		setSize(1200, 1000);
		setLayout(new GridLayout(3, 1));
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		});
		
		setVisible(true);
		
		play = new Button("Play");
		play.setActionCommand("play");
		play.addActionListener(new ButtonListener());
		add(play);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("play")) {
				setVisible(false);
				setEnabled(false);
				Window a = new Window();
				try {
					a.init();
					System.exit(0);
				} catch (IOException e1) {e1.printStackTrace();}
			}
		}
		
	}
	
}
