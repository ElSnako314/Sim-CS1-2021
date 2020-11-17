package sim;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ElSnako
 */
public class World {
    private int population;
    private final int SIZE = 600;
    private final Color background = Color.GRAY;
    private Blob[] blobs = new Blob[300];

    public World() {
        for (int i = 0; i < 300; i++) {
            blobs[i] = new Blob();
        }
    }
    
    public void draw(Graphics g) {
        g.setColor(background);
        //"for each" loop OR "enhanced" for loop
        for (Blob blob : blobs) {
            blob.draw(g);
            blob.move();
            blob.collideWorldBound(this);
            for (Blob b1 : blobs) {
                blob.blobsCollide(b1);
            }         
        }
    }

    public int getSIZE() {
        return SIZE;
    }
}
