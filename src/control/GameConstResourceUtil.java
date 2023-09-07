package control;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameConstResourceUtil {
    private static String path = "img";


    public static final Image HERO_UP = new ImageIcon(path + "/heroUp.png").getImage();
    public static final Image HERO_DOWN = new ImageIcon(path + "/heroDown.png").getImage();
    public static final Image COMMON_ENEMY_PLANE_1 = new ImageIcon(path + "/enemyPlane1_1_0.png").getImage();
    public static final Image COMMON_ENEMY_PLANE_2 = new ImageIcon(path + "/enemyPlane1_2_0.png").getImage();
    public static final Image COMMON_ENEMY_DEAD_1 = new ImageIcon(path + "/enemyPlane1_1_1.png").getImage();
    public static final Image COMMON_ENEMY_DEAD_2 = new ImageIcon(path + "/enemyPlane1_2_1.png").getImage();
    public static final Image PROMOTE_ENEMY_PLANE = new ImageIcon(path + "/enemyPlane2_1_0.png").getImage();
    public static final Image PROMOTE_ENEMY_DEAD = new ImageIcon("img/enemyPlane2_1_1.png").getImage();
    public static final Image BOSS_1 = new ImageIcon(path + "/boss1_0.png").getImage();
    public static final Image BOSS_2 = new ImageIcon(path + "/boss1_1.png").getImage();
    public static final Image BOSS_3 = new ImageIcon(path + "/boss1_2.png").getImage();
    public static final Image BOSS_4 = new ImageIcon(path + "/boss1_3.png").getImage();
    public static final Image BOSS_5 = new ImageIcon(path + "/boss1_4.png").getImage();




    public static final Image BG1 = new ImageIcon("img/BG1.jpg").getImage();
    public static final Image BG2 = new ImageIcon("img/BG2.jpg").getImage();
    public static final Image BG3 = new ImageIcon("img/BG3.jpg").getImage();
    public static final Image FRIEND_BULLET_LIGHT = new ImageIcon("img/friendBulletL.png").getImage();
    public static final Image BEE = new ImageIcon("img/bee.png").getImage();
    public static final Image DOUBLE_FIRE = new ImageIcon("img/doubleFire.png").getImage();
    public static final Image NUCLEAR_BOMB = new ImageIcon("img/atomBomb.png").getImage();
    public static final Image ENEMY_DEAD_IMAGE_1 = new ImageIcon("img/blast_0_1.png").getImage();
    public static final Image ENEMY_DEAD_IMAGE_2 = new ImageIcon("img/blast_0_2.png").getImage();
    public static final Image ENEMY_DEAD_IMAGE_3 = new ImageIcon("img/blast_0_3.png").getImage();
    public static final Image ENEMY_DEAD_IMAGE_4 = new ImageIcon("img/blast_0_4.png").getImage();
    public static final Image ENEMY_DEAD_IMAGE_5 = new ImageIcon("img/blast_0_5.png").getImage();
    public static final Image PROMOTE_ENEMY_BULLET = new ImageIcon("img/promoteBullet.png").getImage();
    public static final Image BIG_BOMB_1 = new ImageIcon("img/boss_9.png").getImage();
    public static final Image BIG_BOMB_2 = new ImageIcon("img/boss_10.png").getImage();
    public static final Image BIG_BOMB_3 = new ImageIcon("img/boss_11.png").getImage();
    public static final Image BIG_BOMB_4 = new ImageIcon("img/boss_12.png").getImage();
    public static final Image START_SCREEN = new ImageIcon("img/start.png").getImage();
    public static final Image PAUSE_SCREEN = new ImageIcon("img/pause.png").getImage();
    public static final Image OVER_SCREEN = new ImageIcon("img/gameOver.png").getImage();
    public static final Image PASS_SCREEN = new ImageIcon("img/gamePass.png").getImage();
    public static final Image POINT = new ImageIcon("img/point.png").getImage();
    public static final Image LIFE_BAR_BLACK = new ImageIcon("img/lifeBarBlack.png").getImage();
    public static final Image LIFE_BAR_RED = new ImageIcon("img/lifeBarRed.png").getImage();


    public static void setPath(int color){
        if (color == 1){
            path = "img2";
        }else if (color == 0){
            path = "img";
        }
    }
}
