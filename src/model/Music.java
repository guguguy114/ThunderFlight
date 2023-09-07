package model;

import control.GameConstStr;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Music {
    public static String START_GAME = "file:./music/start.wav";
    public static String ADD_LIFE = "file:./music/addLife.wav";
    public static String GET_DOUBLE_FIRE = "file:./music/useDouble.wav";
    public static String ENEMY_DOWN = "file:./music/enemyBoom.wav";
    public static String GAME_OVER = "file:./music/gameOver.wav";
    public static String FIRE = "file:./music/fire.wav";
    public static String MAIN_GAME_BGM_1 = "file:./music/test.wav";
    public static String GET_BOMB = "file:./music/getBomb.wav";
    public static String REBORN = "file:./music/reborn.wav";
    public static String USE_BOMB = "file:./music/useBomb.wav";
    private final Clip clip;
    private final String playMode;

    public Music(String filePath, String playMode) {
        try {
            this.playMode = playMode;
            URL url = new URL(filePath);
            AudioInputStream io = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(io);
            clip.setFramePosition(0);
            if (playMode.equals(GameConstStr.MUSIC_BGM)){
                clip.setLoopPoints(0, -1);
            }
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
            }
    }

    public void startMusic(){
        if (playMode.equals(GameConstStr.MUSIC_BGM)){
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }else {
            if (clip.getFramePosition() >= clip.getFrameLength()) {
                clip.setFramePosition(0);
            }
        }
        clip.start();
        //System.out.println(clip.getFrameLength());
    }

    public void stopMusic(){
        clip.stop();
    }

    public void resetMusic(){
        clip.setFramePosition(0);
    }
}
