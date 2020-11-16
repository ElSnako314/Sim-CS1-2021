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
    private Blob[] blobs = new Blob[5000];

    public World() {
        for (int i = 0; i < 5000; i++) {
            blobs[i] = new Blob();
        }
    }
    
    public void draw(Graphics g) {
        g.setColor(background);
        //"for each" loop OR "enhanced" for loop
        for (Blob blob : blobs) {
            blob.draw(g);
        }
    }
}
