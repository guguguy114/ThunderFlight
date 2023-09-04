package model;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Music {
    public static String START_GAME = "file:./music/start.wav";
    public static String ADD_LIFE = "file:./music/addLife.wav";
    public static String GET_DOUBLE_FIRE = "file:./music/useDouble.wav";
    public static String ENEMY_DOWN = "file:./music/enemyBoom.wav";
    public static String GAME_OVER = "file:./music/start.wav";
    public static String FIRE = "file:./music/fire.wav";
    public static String MAIN_GAME_BGM_1 = "file:./music/game.wav";
    public static String GET_BOMB = "file:./music/getBomb.wav";
    public static String REBORN = "file:./music/reborn.wav";
    public static String USE_BOMB = "file:./music/useBomb.wav";

    private final Clip clip;

    public Music(String filePath) {
        try {
            URL url = new URL(filePath);
            AudioInputStream io = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(io);
            clip.setFramePosition(0);
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
            }
    }

    public void startMusic(){
        if (clip.getFramePosition() >= clip.getFrameLength()){
            clip.setFramePosition(0);
        }
        clip.start();
        System.out.println(clip.getFrameLength());
    }
}
