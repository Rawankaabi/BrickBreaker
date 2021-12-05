import javax.swing.JFrame;
public class start{

    public static void main(String[] args) {
        JFrame obj = new JFrame();// object for JFrame
        Gameplay game = new Gameplay();// object for class gameplay
        obj.setBounds(10,10,700,600);
        obj.setTitle("BRICK BREAKER");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(game);


    }

}
