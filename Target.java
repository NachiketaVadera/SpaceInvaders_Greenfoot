import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Ammo Class
 * 
 * @author Nachiketa Vadera
 * @version 0.1
 */
public class Target extends Actor {
    
    Random random = new Random();
    private static final int MAX = 950;
    private static final int MIN = 50;
    
    public Target() {
        setRotation(PlayCanvas.DOWN);
    }
    
    public void act() {
        Actor bullet = getOneIntersectingObject(PlayerBullet.class);
        if (bullet != null) {
            getWorld().removeObject(this);
        }
    }
    
    public void shoot() {
        getWorld().addObject(new TargetBullet(), getX(), getY());
    }
}
