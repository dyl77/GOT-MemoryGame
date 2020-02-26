import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class GameBoard extends JFrame {


    private List<Cards> cards;
    private Cards selectedCard;
    private Cards card1;
    private Cards card2;
    private Timer timer1;

    public GameBoard(){

        int cardPairs = 8;
        List<Cards> cardsList = new ArrayList<Cards>();
        List<Integer> cardValues = new ArrayList<Integer>();

        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource("Game-Assets/StarkBackground.jpg"));
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
        
        Image background = image.getScaledInstance(800, 1050, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(background);
        setContentPane(new JLabel(imageIcon));
        
        for (int i = 0; i < cardPairs; i++){
            cardValues.add(i);
            cardValues.add(i);
        }
        Collections.shuffle(cardValues);

        for (int val : cardValues){
            Cards card = new Cards();
            card.setPreferredSize(new Dimension(190,216));
            card.setHouse(val);
            card.setBacking();
            card.setBorder(BorderFactory.createEmptyBorder());
            card.setMargin(new Insets(0,0,0,0));
            card.setHorizontalAlignment(SwingConstants.CENTER);
            
            card.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    selectedCard = card;
                    doTurn();
                }
            });
            
            cardsList.add(card);
        }
        
        this.cards = cardsList;
        
        timer1 = new Timer(900, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                checkCards();
            }
        });

        timer1.setRepeats(false);

        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());
        for (Cards c : cards){
            pane.add(c);
        }
        setTitle("Match the Great Houses of Westeros");
        
    }

    public void doTurn(){
        if (card1 == null && card2 == null){
            card1 = selectedCard;
            card1.setSelected(true);
        }

        if (card1 != null && card1 != selectedCard && card2 == null){
            card2 = selectedCard;
            card2.setSelected(true);
            timer1.start();

        }
    }

    public void checkCards(){
        if (card1.getHouse() == card2.getHouse()){
            card1.setEnabled(false);
            card2.setEnabled(false);
            card1.setMatched(true); 
            card2.setMatched(true);
            
            JOptionPane.showMessageDialog(this, "You Matched House " + card1.getHouseName());
            if (this.isGameWon()){
                JOptionPane.showMessageDialog(this, "You Win The Iron Throne!");
                System.exit(0);
            }
        }

        else{
            card1.setSelected(false);
            card2.setSelected(false);
        }
        card1 = null;
        card2 = null;
    }

    public boolean isGameWon(){
        for(Cards c: this.cards){
            if (c.getMatched() == false){
                return false;
            }
        }
        return true;
    }
}

