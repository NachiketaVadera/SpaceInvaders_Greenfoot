import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class setups the player's spaceship
 * 
 * @author Nachiketa Vadera
 * @version 0.1
 */
public class PlayerShip extends Actor {
    
    private static final int MOVE_STEP_SIZE = 5;
    private static int actCallsAfterShot = Integer.MAX_VALUE;
    
    public PlayerShip() {
        setRotation(270);
    }
    
    public void act() {

        if (isHit()) {
            World world = getWorld();
               world.removeObjects(world.getObjects(null));
               world.addObject(new GameOver(), world.getWidth()/2, world.getHeight()/2);
               Greenfoot.stop();
        }
        
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - MOVE_STEP_SIZE, getY());
        } 
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + MOVE_STEP_SIZE, getY());
        }
        if (Greenfoot.isKeyDown("space")) {
            if (actCallsAfterShot > 20) {
                getWorld().addObject(new PlayerBullet(), getX(), getY());
                actCallsAfterShot = 0;
            }
            actCallsAfterShot++;
        } else {
            actCallsAfterShot = Integer.MAX_VALUE;
        }
    }
    
    public boolean isHit() {
        Actor enemyBullet = getOneIntersectingObject(TargetBullet.class);
        if (enemyBullet != null) {
            enemyBullet.setImage(new GreenfootImage("boom.gif"));
            return true;
        }
        return false;
    }
}
