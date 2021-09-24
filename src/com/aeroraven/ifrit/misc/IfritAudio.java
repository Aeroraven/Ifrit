package com.aeroraven.ifrit.misc;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.AudioSystem;

public class IfritAudio {
	//From web
	public static void playMusic(String e) throws Exception {
		File file = new File(e);
		AudioInputStream am;
		am = AudioSystem.getAudioInputStream(file);
		AudioFormat af = am.getFormat();
		SourceDataLine sd ;
		sd = AudioSystem.getSourceDataLine(af);
		sd.open();
		sd.start();
		int sumByteRead = 0; 
		byte [] b = new byte[320];
		while (sumByteRead != -1) {
			sumByteRead = am.read(b, 0, b.length);
			if(sumByteRead >= 0 ) {
				sd.write(b, 0, b.length);
			}
		}
		sd.drain();
		sd.close();
	}
}
