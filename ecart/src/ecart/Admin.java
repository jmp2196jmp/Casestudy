package ecart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Admin {

	public void login()  {
		JFrame f=new JFrame(" ADMIN LOGIN"); 
		
		final JTextField us=new JTextField();  
	    us.setBounds(120,55, 150,20);  
	    final JTextField ps=new JTextField();  
	    ps.setBounds(120,95, 150,20);
		    
	    JLabel ul,pl,ms1,ms2;  
	    ul=new JLabel("UserName :");  
	    ul.setBounds(50,50, 100,30);  
	     pl=new JLabel("Password :");
	      pl.setBounds(50, 90, 100, 30);
	      
	      
	    ms1=new JLabel();
	    ms1.setBounds(120, 215, 300, 30);
	    ms2=new JLabel();
	    ms2.setBounds(120, 200, 300, 30);  
	    
	    JButton b=new JButton("Submit");  
	    b.setBounds(150,150,95,20);
          Product pr=new Product();
		   b.addActionListener(new ActionListener(){  
		    	public void actionPerformed(ActionEvent e){
		    		
		    	ConnectionManager c=new ConnectionManager();
		    		 String mut=us.getText();
		   		    String spt=ps.getText();
		    		 int t=0;
					try {
						
					    Statement st= c.condata().createStatement();
					   ResultSet rt=st.executeQuery("select name,password from admin ");
					  
		    	  while(rt.next())
		    	  {
		    		  if(((rt.getString(1).equals(mut))&&(rt.getString(2).equals(spt))))
		    		  {
		    			  ms1.setText("Login Success");
		    			  pr.product();
		    			  t++;
		    			  break;
		    		  }
		    	  }
		    	  if(t==0)
		    	  {
		    		  ms2.setText("invalid");
		    	  }
		    	}
					catch(ClassNotFoundException | SQLException e1)
					{
						e1.printStackTrace();
					}
		    	}
		   });
	    
	    f.add(ul);
	    f.add(pl);
	    f.add(b);
	    f.add(us);
	    f.add(ps);
		 f.add(ms1);
		 f.add(ms2);
		    f.setSize(500,500);  
		    f.setLayout(null);  
		    f.setVisible(true);  
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
