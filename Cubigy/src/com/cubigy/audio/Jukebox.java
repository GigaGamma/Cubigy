package com.cubigy.audio;

import java.util.ArrayList;

import javax.sound.sampled.Clip;

public class Jukebox extends Thread {
	
	public static ArrayList<Clip> songs = new ArrayList<Clip>();
	
	@Override
	public void run() {
		int i = 0;
		while (true) {
			if (songs.get(i) != null && !songs.get(i).isOpen()) {
				if (i != 0) {i++;}
				songs.get(i).start();
			}
			else if (songs.get(i) == null) {
				i = 0;
			}
		}
	}
	
	public static void initSongs() {
		//songs.add(SoundPlayer.playSound("audio/music/feelings.wav"));
	}
	
}
