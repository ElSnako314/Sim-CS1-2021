package sim;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ElSnako
 */
public class Blob {
    private int x, y, vx, vy, hp;
    private int holdVelocityX = 0, holdVelocityY = 0;
    private final static int SIZE = 10, MAX_SPEED = 10;
    private final static Color color = new Color (240,128,128);
    
    public Blob(int x, int y) {
       this.x = x;
       this.y = y;
       this.vx = (int) (Math.random() * 2 * MAX_SPEED) - MAX_SPEED;
       this.vy = (int) (Math.random() * 2 * MAX_SPEED) - MAX_SPEED;
    }
    
    //no-args constructor
    public Blob() {
       this.x = (int) (Math.random() * 600);
       this.y = (int) (Math.random() * 600);
       this.vx = (int) (Math.random() * 2 * MAX_SPEED) - MAX_SPEED;
       this.vy = (int) (Math.random() * 2 * MAX_SPEED) - MAX_SPEED;
    }
    
    public void move() {
        x += vx;
        y += vy;
    }
    
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, SIZE, SIZE);
    }
    
    public void collideWorldBound(World w) {
        if (this.x >= w.getSIZE()) {
            vx *= -1;
        }
        if (this.x <= 0) {
            vx *= -1;
        }
        if (this.y >= w.getSIZE()) {
            vy *= -1;
        }
        if (this.y <= 0) {
            vy *= -1;
        }
    }
    public void generateHP() {
        hp = 0;
    }
    
    public void blobsCollide(Blob other) {
        //ovalVSoval already returns a boolean
        if (ovalVSoval(this, other)) {
            holdVelocityX = other.vx;
            holdVelocityY = other.vy;
            other.vx = this.vx;
            other.vy = this.vy;
            this.vx = holdVelocityX;
            this.vy = holdVelocityY;
        }
        
    }
    
    private boolean ovalVSoval(Blob b1, Blob b2) {
        if (distance(b1, b2) < Blob.SIZE) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private double distance(Blob b1, Blob b2) {
        return Math.sqrt(Math.pow(b2.x - b1.x, 2) + Math.pow(b2.y - b1.y, 2));
    }
}
