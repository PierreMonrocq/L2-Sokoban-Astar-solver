package ressources;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Music extends Thread {
	static Clip clip;

	public Music(String Sound) {
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(loadMusic(Sound)));
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-25.0F);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void run() {
		clip.start();
	}

	public static void stopMusic() {
		clip.stop();
	}

	public static void mute() {
		BooleanControl choixSon = (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);

		if (choixSon != null) {
			choixSon.setValue(true);
		}
	}

	public static void demute() {
		BooleanControl choixSon = (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);
		if (choixSon != null) {
			choixSon.setValue(false);
		}
	}

	private static InputStream loadMusic(String file) {
		InputStream in = Music.class.getResourceAsStream(file);
		InputStream bufferedIn = new BufferedInputStream(in);
		return bufferedIn;
	}
}