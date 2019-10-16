package ecart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Sell {

	

	public void agent() {
        JFrame f=new JFrame("Customer"); 
		
         JButton b=new JButton("Buy/Sell");  
	      b.setBounds(150,150,95,20);
	      
	      JButton b1h=new JButton("History");  
	      b1h.setBounds(150,190,95,20);
	      
	      Show sw=new Show();
	      
	      b1h.addActionListener(new ActionListener(){  
		    	public void actionPerformed(ActionEvent e){
		    		//System.out.println("hai");
		    		sw.show();
		    	}
	      });
		    	
		    		
	      
	      
	      JButton b2=new JButton("Logout");  
	      b2.setBounds(150,230,95,20);
	      
	      
	      b.addActionListener(new ActionListener(){  
		    	public void actionPerformed(ActionEvent e){
		    		
		    		 JFrame f=new JFrame(" Buy/Sell"); 
		    			
		    			final JTextField us=new JTextField();  
		    		    us.setBounds(150,55, 150,20);
		    		
		    		    JLabel ul;
		    		    ul=new JLabel("Product id :");  
		    		    ul.setBounds(50,50, 100,30); 
		    		      
		    		    JButton b=new JButton("Buy");  
		    		      b.setBounds(150,100,95,20);
		    		      
		    		      JButton b1=new JButton("Sell");  
		    		      b1.setBounds(150,150,95,20);
		    		      Seller sl=new Seller();
		    		      
		    		      b1.addActionListener(new ActionListener(){  
		    			    	public void actionPerformed(ActionEvent e){
		    			    		sl.seller();
		    			    	}
		    			    	});
		    		      
		    		           b.addActionListener(new ActionListener(){  
		    			    	public void actionPerformed(ActionEvent e){
		    			    		
		    			    		JFrame m=new JFrame(" Buy"); 
		    			    		
		    			    		
		    			    		

		    		    			final JTextField us=new JTextField();  
		    		    		    us.setBounds(150,55, 150,20);
		    		    		
		    		    		    JLabel ul;
		    		    		    ul=new JLabel("Product id :");  
		    		    		    ul.setBounds(50,50, 100,30); 
		    		    		      
		    			    		
		    		    		    final JTextField qn=new JTextField();  
		    		    		    qn.setBounds(150,85, 150,20);
		    		    		
		    		    		    JLabel ql;
		    		    		    ql=new JLabel("Quantity :");  
		    		    		    ql.setBounds(50,80, 100,30); 
		    		    		      
		    		    		    JButton b1=new JButton("submit");  
		  		    		        b1.setBounds(150,150,95,20);
		  		    		      
		  		    		      b1.addActionListener(new ActionListener(){  
				    			    	public void actionPerformed(ActionEvent e){
				    			    		ConnectionManager c=new ConnectionManager();
				    			    		  int id=Integer.parseInt(us.getText());
			                                     int q=Integer.parseInt(qn.getText());
			                                     //System.out.println(id);
			                                     Statement st;
			                          		   
			                                    try {
			                                        st = c.condata().createStatement();
			                                    
			                                    
			                                        ResultSet rs= st.executeQuery("select pname,price,msellqnty,quantity from product where id='"+id+"'") ;
			                                         if(rs.next())
			                                         {
			                                              
			                                            
			                                              String nam= rs.getString("pname");
			                                              int price= rs.getInt("price");
			                                              int qtyavl= rs.getInt("quantity");
			                                              int minqty= rs.getInt("msellqnty");
			                                              int s=minqty;
			                                              int s1=qtyavl;
			                                             // System.out.println(nam);
			                                             // System.out.println(price);
			                                              JLabel namee,pricee,qtyy,minqtyy;
			                                              String price1 = Integer.toString(price);
			                                              String qty1 = Integer.toString(qtyavl);
			                                              String minqty1 = Integer.toString(minqty);
			                                                 namee = new JLabel(nam);
			                                                 pricee= new JLabel(price1);
			                                                 qtyy= new JLabel(qty1);
			                                                 minqtyy=new JLabel(minqty1);
			                                                 m.add(namee);
			                                                 m.add(pricee);
			                                                 m.add(minqtyy);
			                                                 m.add(qtyy);
			                                                 namee.setBounds(200, 600, 100, 30);
			                                                 pricee.setBounds(400, 600, 100, 30);
			                                                 minqtyy.setBounds(600, 600, 100, 30);
			                                                 qtyy.setBounds(800, 600, 100, 30);
			                                                 if((q>=s)&&(q<=s1))
			                                                 {
			                                                     int updateQ=qtyavl-q;
			                                                     System.out.println(updateQ);
			                                                    st.executeUpdate("update product set quantity="+updateQ+" where id='"+id+"'");
			                                                 }
			                                               
			                                         }
			                                    
			                                    } catch (ClassNotFoundException | SQLException e1) {
			                                        // TODO Auto-generated catch block
			                                        e1.printStackTrace();
			                                    }
			                                    		
				    			    		
				    			    		
				    			    	}
				    			    	});
				    			    		
		  		    		      
		  		    		            m.add(b1);
		    			    		    m.add(us);
		    			    		    m.add(ul);
		    			    		    m.add(ql);
		    			    		    m.add(qn);
		    			    		    m.setSize(1000,1000);  
		    			    		    m.setLayout(null);  
		    			    		    m.setVisible(true);  
		    			    		    m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    			    		     
		    			    		      
		    			    		
		    			    		
		    			    	       }
		    			    	    });
		    			    	
		    		      
		    		    
		    		      
		    		      f.add(b);
		    		      f.add(b1);
		    		      f.add(b2);
		    		      f.add(us);
		    		      f.add(ul);
		    		    
		    		    f.setSize(500,500);  
		    		    f.setLayout(null);  
		    		    f.setVisible(true);  
		    		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    		     
		    		      
		    	}
	      });
	      
	      
	      
		
	      f.add(b);
	      f.add(b1h);
	      f.add(b2);
	     
	      f.setSize(500,500);  
		    f.setLayout(null);  
		    f.setVisible(true);  
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
