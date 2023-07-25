package conversor.gui;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class Teste {

	public static void main(String[] args) {
		
//		JFrame f = new JFrame("frame");
//		
//		ConversorPainel c = new ConversorPainel();
//		f.setSize(400,400);
//		f.add(c);
//		f.show();
		
		
		 JFrame f = new JFrame("frame");
         
	   
	        //create a panel
	        JPanel p =new JPanel();
	         
	        //create a new label
	        JLabel l= new JLabel("select the day of the week");
	 
	        //String array to store weekdays
	        String week[]= { "Monday","Tuesday","Wednesday",
	                         "Thursday","Friday","Saturday","Sunday"};
	         
	        //create list
	        JComboBox b= new JComboBox(week);
	         
	        //set a selected index
	        b.setSelectedIndex(2);
	         
	        //add list to panel
	        p.add(b);
	  
	        f.add(p);
	         
	        //set the size of frame
	        f.setSize(400,400);
	          
	        f.show();
		
	}

}
