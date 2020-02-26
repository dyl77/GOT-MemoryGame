
import java.awt.Dimension;
import javax.swing.JFrame;



public class GamePanel{
    public static void main(String[] args){
        GameBoard GOT = new GameBoard();
        
        GOT.setPreferredSize(new Dimension(800,1050)); 
        GOT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GOT.pack();
        GOT.setVisible(true);
        
    }   
}
