import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

	public class Cards extends JButton{
	    private int id;
	    private boolean matched = false;
	    private String houseName;
	    
	   public void setBacking() {
	    	
	    try {
	    	
	        Image backing = ImageIO.read(getClass().getResource("/Game-Assets/CardBacking2.jpg"));
	        this.setIcon(new ImageIcon(backing));
	      } catch (Exception ex) {
	        System.out.println(ex);
	      }
	    }
	    
	    public void getBacking() {
	    	this.getIcon();
	    }

	    public void setHouse(int id){
	    	this.id = id;
	    	
	    	try {
	    	Image Lannister = ImageIO.read(getClass().getResource("/Game-Assets/LannisterSigil.png"));
	    	Image Stark = ImageIO.read(getClass().getResource("/Game-Assets/StarkSigil.png"));
	    	Image Tully = ImageIO.read(getClass().getResource("/Game-Assets/TullySigil.png"));
	    	Image Frey = ImageIO.read(getClass().getResource("/Game-Assets/FreySigil.png"));
	    	Image GreyJoy = ImageIO.read(getClass().getResource("/Game-Assets/GreyJoySigil.png"));
	    	Image Baratheon = ImageIO.read(getClass().getResource("/Game-Assets/BaratheonSigil.png"));
	    	Image Targaryan = ImageIO.read(getClass().getResource("/Game-Assets/TargaryanSigil.png"));
	    	Image Arryn = ImageIO.read(getClass().getResource("/Game-Assets/ArrynSigil.png"));
	    	
	    	 switch(id) {
		        case 0:
		        	this.setSelectedIcon(new ImageIcon(Lannister));
		        	this.houseName = "Lannister";
		        	break;
		        case 1:
		        	this.setSelectedIcon(new ImageIcon(Stark));
		        	this.houseName = "Stark";
		        	break;
		        case 2:
		        	this.setSelectedIcon(new ImageIcon(Tully));
		        	this.houseName = "Tully";
		        	break;
		        case 3:
		        	this.setSelectedIcon(new ImageIcon(Frey));
		        	this.houseName = "Frey";
		        	break;
		        case 4:
		        	this.setSelectedIcon(new ImageIcon(GreyJoy));
		        	this.houseName = "GreyJoy";
		        	break;
		        case 5:
		        	this.setSelectedIcon(new ImageIcon(Baratheon));
		        	this.houseName = "Baratheon";
		        	break;
		        case 6:
		        	this.setSelectedIcon(new ImageIcon(Targaryan));
		        	this.houseName = "Targaryan";
		        	break;
		        case 7:
		        	this.setSelectedIcon(new ImageIcon(Arryn));
		        	this.houseName = "Arryn";
		        	break;
		        }
	    	}catch (Exception ex) {
	    		System.out.println(ex);
	    	}
	    }

	    
	    public int getHouse(){
	        return this.id;
	    }

	    public void setHouseName(int id) {
	    	switch(id) {
	        case 0:
	        	this.houseName = "Lannister";
	        	break;
	        case 1:
	        	this.houseName = "Stark";
	        	break;
	        case 2:
	        	this.houseName = "Tully";
	        	break;
	        case 3:
	        	this.houseName = "Frey";
	        	break;
	        case 4:
	        	this.houseName = "GreyJoy";
	        	break;
	        case 5:
	        	this.houseName = "Baratheon";
	        	break;
	        case 6:
	        	this.houseName = "Targaryan";
	        	break;
	        case 7:
	        	this.houseName = "Arryn";
	        	break;
	    }
	   }
	    
	    public String getHouseName() {
	    	return this.houseName;
	    }

	    public void setMatched(boolean matched){
	        this.matched = matched;
	    }

	    public boolean getMatched(){
	        return this.matched;
	    }
	}
