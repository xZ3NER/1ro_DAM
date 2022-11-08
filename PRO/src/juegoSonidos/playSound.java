package juegoSonidos;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class playSound {

    private File audio;
    private Clip clip;
    private AudioInputStream audioInputStream;

    public playSound(String url) {
        audio = new File(url);
        Play();
    }

    private void Play() {

        try {
            audioInputStream = AudioSystem.getAudioInputStream(this.audio.getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (UnsupportedAudioFileException | IOException
                | LineUnavailableException ex) {
            System.out.println(ex);
        }
    }

}
