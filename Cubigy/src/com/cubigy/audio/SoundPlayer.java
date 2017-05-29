package com.cubigy.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer {
	
	public static synchronized Clip playSound(final String url) {
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource(url));
			clip.open(inputStream);
			return clip;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
