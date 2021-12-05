import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener, ActionListener{
    private boolean play = false;
    private int score =0;
    private int totalbricks = 28;
    private Timer time;
    private int delay = 1;
    private int player1= 280;
    private int ballposx = 290;
    private int ballposy = 290;
    private int ballxdir = -1;
    private int ballydir = -2;

    private mapbrick map;

    public Gameplay() {
        map = new mapbrick (4,7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time = new Timer(delay, this);
        time.start();
    }

    public void paint(Graphics g) {
        //bg
        g.setColor(Color.darkGray);
        g.fillRect(1,1, 692, 592);

        //draw
        map.draw((Graphics2D)g);

        //borders
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0,0 , 692, 3);
        g.fillRect(683,0,3, 592);

        //scores
        g.setColor(Color.white);
        g.setFont(new Font("Verdana", Font.BOLD, 25));
        g.drawString(""+score, 599, 28);
        //paddle
        g.setColor(Color.green);
        g.fillRect(player1, 550, 110,10);

        //ball 
        g.setColor(Color.yellow);
        g.fillOval(ballposx,ballposy, 20, 20);

        if(totalbricks <=0) {
            play = false;
            ballxdir = 0;
            ballydir = 0;
            g.setColor(Color.orange);
            g.setFont(new Font("Verdana", Font.BOLD, 35));
            g.drawString("YOU WON!", 190, 300);

            g.setFont(new Font("Verdana", Font.BOLD, 30));
            g.drawString("Press SPACE to restart",230, 350);
        }

        if (ballposy > 570) {
            play = false;
            ballxdir = 0;
            ballydir = 0;
            g.setColor(Color.red);
            g.setFont(new Font("Verdana", Font.BOLD, 35));
            g.drawString("GAME OVER!", 190, 300);

            g.setFont(new Font("Verdana", Font.BOLD, 30));
            g.drawString("Press SPACE to restart",230, 350);

        }
        g.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        time.start();
        if(play) {
            //detecting interstion of 2 objs
            if (new Rectangle(ballposx,ballposy, 20, 20).intersects(new Rectangle(player1, 550, 100, 8))) {
                ballydir = -ballydir;
            }
// to destroy brick
            B: for (int i=0; i< map.map.length; i++) {
                for (int j=0; j<map.map[0].length; j++) {
                    if (map.map[i][j]>0) {
                        int brickx = j*map.brickwidth + 70;
                        int bricky = i* map.brickheight + 50;
                        int brickwidth = map.brickwidth;
                        int brickheight = map.brickheight;

                        Rectangle rect = new Rectangle(brickx, bricky, brickwidth, brickheight);
                        Rectangle ballrect = new Rectangle(ballposx, ballposy, 20, 20);
                        Rectangle brickrect = rect;

                        if(ballrect.intersects(brickrect)) {
                            map.setBrickval(0,i,j);
                            totalbricks--;
                            score += 10;

                            if(ballposx + 19 <= brickrect.x || ballposx + 1 >= brickrect.x + brickrect.width) {
                                ballxdir = - ballxdir;
                            } else {
                                ballydir = -ballydir;
                            }

                            break B;
                        }
                    }
                }
            }
            ballposx += ballxdir;
            ballposy += ballydir;
            if (ballposx < 0) {
                ballxdir = - ballxdir;
            }
            if (ballposy < 0) {
                ballydir = - ballydir;
            }
            if (ballposx > 670) {
                ballxdir = - ballxdir;
            }

        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D) {
            if(player1 >= 600) {
                player1 = 600;
            } else {
                play = true;
                player1+=40;;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_A) {
            if(player1 <10) {
                player1 = 10;
            } else {
                play = true;
                player1 -=40;
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (!play) {
                play = true;
                ballposx = 290;
                ballposy = 290;
                ballxdir = -1;
                ballydir = -2;
                player1 = 280;
                score = 0;
                totalbricks = 28;
                map = new mapbrick(4,7);

                repaint();
            };

        }
    }


}

