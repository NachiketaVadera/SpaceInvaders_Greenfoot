import greenfoot.*;
import java.util.List;

/**
 * This is a class that setups the background for the game.
 * 
 * @author Nachiketa Vadera 
 * @version 0.1
 */
public class PlayCanvas extends World
{
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private static final int SHOOT_INTERVAL = 30;
    public static final int UP = 270;
    public static final int DOWN = 90;
    
    private int actCount = 0;
    
    public PlayCanvas() {    
        super(WIDTH, HEIGHT, 1);
        GreenfootImage background = new GreenfootImage(WIDTH, HEIGHT);
        background.setColor(Color.BLACK);
        background.fill();
        setBackground(background);

        prepare();
    }

    private void prepare() {
        PlayerShip playerShip = new PlayerShip();
        addObject(playerShip, WIDTH/2, HEIGHT-100);
        
        // add targets
        for (int i = 2;i < 10;i++) {
            addObject(new Target(), i*100, 50);
        }
    }
    
    public void act() {
        actCount++;
        if (actCount > SHOOT_INTERVAL) {
            List listOfTargets = getObjects(Target.class);
            if (!listOfTargets.isEmpty()) {
                            Target randomTarget = (Target) listOfTargets.get(Greenfoot.getRandomNumber(listOfTargets.size()));
                            randomTarget.shoot();
            }
            actCount = 0;
        }
    }
}
