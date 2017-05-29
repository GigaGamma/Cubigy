package com.cubigy.audio;

import java.util.ArrayList;

import javax.sound.sampled.Clip;

public class Jukebox extends Thread {
	
	public static ArrayList<Clip> songs = new ArrayList<Clip>();
	
	@Override
	public void run() {
		int i = 0;
		while (true) {
			if (!songs.get(i).isActive()) {
				if (i != 0) {i++;}
				songs.get(i).start();
			}
		}
	}
	
	public static void initSongs() {
		songs.add(SoundPlayer.playSound("audio/music/feelingsremix.wav"));
	}
	
}
