package ecart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		
		JFrame f=new JFrame("LOGIN");  
	    
		
	    JButton b=new JButton("ADMIN");  
	    b.setBounds(50,50,95,30);
	    Admin ad=new Admin();
		
	    
		   b.addActionListener(new ActionListener(){  
		    	public void actionPerformed(ActionEvent e){
		    		
		    	ad.login();	
		    		
		    	}
		   });
	    
	    JButton b1=new JButton("AGENT");  
	    b1.setBounds(50,100,95,30);
	    Agent ag=new Agent();
	    b1.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){
	    		
	    	ag.login();	
	    	
	    		
	    	}
	   });
    
	    
	    JButton b2=new JButton("EXIT");  
	    b2.setBounds(50,150,95,30);
       
	    f.add(b);
	    f.add(b1);
	    f.add(b2);
	    
	    f.setSize(500,500);  
	    f.setLayout(null);  
	    f.setVisible(true);  
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
