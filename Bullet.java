import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor {
    
    public Bullet() {
        this(PlayCanvas.UP);
    }
    
    public Bullet(int direction) {
        setRotation(direction);
    }
    
    public void act() {
        move(5);
        if (getY() < 5 || getY() > 595) {
            getWorld().removeObject(this);
        }
    }
}
