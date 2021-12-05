import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class mapbrick {
    public int map[][];
    public int brickwidth;
    public int brickheight;
    public mapbrick (int row, int col) {
        map = new int [row][col];
        for (int i=0; i< map.length; i++) {
            for (int j=0; j<map[0].length ; j++) {
                map[i][j] = 1;
            }
        }
// brick position
        brickwidth = 540/col;
        brickheight = 150/row;
    }
//draw brick
    public void draw(Graphics2D g) {
        for (int i=0; i< map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                if (map[i][j]> 0) {
                    g.setColor(Color.PINK);
                    g.fillRect(j*brickwidth + 70,  i*brickheight + 50,  brickwidth,  brickheight);

                    //map border of bricks
                    g.setStroke(new BasicStroke(8));
                    g.setColor(Color.darkGray);
                    g.drawRect(j*brickwidth +70, i*brickheight + 50, brickwidth, brickheight);

                }
            }
        }
    }
// to pass value for destroy brick
    public void setBrickval(int val, int row, int col) {
        map[row][col] = val;
    }
}

