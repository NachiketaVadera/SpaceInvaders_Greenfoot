import greenfoot.*;

public class TargetBullet extends Bullet {
        public TargetBullet() {
        this(PlayCanvas.DOWN);
    }
    
    public TargetBullet(int direction) {
        setRotation(direction);
    }
}
