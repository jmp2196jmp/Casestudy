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

public class Seller {

	public void seller() {
		JFrame m=new JFrame("Sell"); 
		
		
		

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
	      
	    JButton b4=new JButton("submit");  
	        b4.setBounds(150,150,95,20);
	      
	      b4.addActionListener(new ActionListener(){  
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
                              int pce=q*price;
                              String  bu="buy";
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
                                 
                                     int updateQ=qtyavl+q;
                                     System.out.println(updateQ);
                                    st.executeUpdate("update product set quantity="+updateQ+" where id='"+id+"'");
                                    st.execute("insert into showitem values('"+nam+"','"+bu+"',"+s1+","+pce+","+price+")" );
                               
                         }
                    
                    } catch (ClassNotFoundException | SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    		
	    		
	    		
	    	}
	    	});
	    		
	      
	            m.add(b4);
		    m.add(us);
		    m.add(ul);
		    m.add(ql);
		    m.add(qn);
		    m.setSize(1000,1000);  
		    m.setLayout(null);  
		    m.setVisible(true);  
		    m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     
		      
		
	}

}
