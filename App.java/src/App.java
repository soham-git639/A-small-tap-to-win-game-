import javax.swing.*;
//import java.util.*;
//import java.awt.*;
public class App {
    public static void main(String[] args) throws Exception {
        int bordWidth = 600;
        int bordHight = 300;

        JFrame frame = new JFrame("Battle");
        
        frame.setSize(bordWidth,bordHight);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        Game game = new Game();
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
    }
}
