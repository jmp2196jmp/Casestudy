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

public class Product {

	public void product() {
       JFrame f=new JFrame(" PRODUCT"); 
		
		final JTextField us=new JTextField();  
	    us.setBounds(150,55, 150,20);
	    final JTextField ps=new JTextField();  
	    ps.setBounds(150,75, 150,20);
	    final JTextField ms=new JTextField();  
	    ms.setBounds(150,95, 150,20);
	    final JTextField pc=new JTextField();  
	    pc.setBounds(150,115, 150,20);
	    final JTextField q=new JTextField();  
	    q.setBounds(150,135, 150,20);
		    
	      JLabel ul,pl,min,pe,qa;  
	      ul=new JLabel("Product id :");  
	      ul.setBounds(50,50, 100,30);  
	      pl=new JLabel("Product name:");
	      pl.setBounds(50, 70, 100, 30);
	      min=new JLabel("MinSellQuantity:");
	      min.setBounds(50, 90, 100, 30);
	      pe=new JLabel("Price:");
	      pe.setBounds(50, 110, 100, 30);
	      qa=new JLabel("Quantity:");
	      qa.setBounds(50, 130, 100, 30);
	      
	      
	      
	      JButton b=new JButton("Submit");  
	      b.setBounds(150,170,95,20);
	      
	      JButton b2=new JButton("Inventory");  
	      b2.setBounds(150,200,95,20);
	      
	      
	      JButton b1=new JButton("Logout");  
		    b1.setBounds(150,250,95,20);
	      
	      ConnectionManager c=new ConnectionManager();
	      b2.addActionListener(new ActionListener(){  
		    	public void actionPerformed(ActionEvent e){
	      
		    		
		    		// f5.setVisible(false);
                     
                     JFrame f5 = new JFrame ("INVENTORY");
                     
                     JLabel pid,pne,sqy,ppe,tct;
                     
                     pid= new JLabel ("Product_ID");
                     pid.setBounds(10,25,150,30);
                     f5.add(pid);
                     pne= new JLabel ("Product_Name");
                     pne.setBounds(120,25,150,30);
                     f5.add(pne);
                     sqy= new JLabel ("Quantity");
                     sqy.setBounds(240,25,150,30);
                     f5.add(sqy);
                     ppe= new JLabel ("Price");
                     ppe.setBounds(350,25,150,30);
                     f5.add(ppe);
                     tct= new JLabel ("Total_Cost");
                     tct.setBounds(460,25,150,30);
                     f5.add(tct);
                       
                     Statement st;
                    
                       
                     String sql="SELECT * FROM product";
                     ResultSet rs1=null;
                     try {
                    	 st = c.condata().createStatement();
                     rs1 = st.executeQuery(sql);
                     } catch (SQLException | ClassNotFoundException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                     }
                     try {
                         int a=0;
                     while(rs1.next())
                     {
                        String id = rs1.getString("id");
                        String pn = rs1.getString("pname");
                       // String sq = rs1.getString("msellqnty");
                        String qr=rs1.getString("quantity");
                        String pp = rs1.getString("price");
                       
                       int isq= Integer.parseInt(qr) ;
                        int ipp= Integer.parseInt(pp);
                        int ttc=isq*ipp;
                        String total=String.valueOf(ttc);
                       
                     JLabel lid,lpn,lsq,lpp,ltc;
                     
                     
                     lid= new JLabel (id);
                     lid.setBounds(10,50+a,150,30);
                     f5.add(lid);
                       
                     lpn= new JLabel (pn);
                     lpn.setBounds(120,50+a,150,30);
                     f5.add(lpn);
                     
                     lsq= new JLabel (qr);
                     lsq.setBounds(240,50+a,150,30);
                     f5.add(lsq);
                     
                     lpp= new JLabel (pp);
                     lpp.setBounds(350,50+a,150,30);
                     f5.add(lpp);
                     
                     ltc= new JLabel (total);
                     ltc.setBounds(460,50+a,150,30);
                     f5.add(ltc);
                     
                     a=a+30;
                       
                     }
                     } catch (SQLException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                     }
                     
                     
                     
                     f5.setSize(600,400);
                     f5.setLayout(null);
                     f5.setVisible(true);
                     
		    	}
	      });
	      
	      
	      
	      
	      
	      b.addActionListener(new ActionListener(){  
		    	public void actionPerformed(ActionEvent e){
		    		String pnam;
		    		int pd,mn,pi,qt;
		    		 pnam=ps.getText();
		    		 pd=Integer.parseInt(us.getText());
		    		 mn=Integer.parseInt(ms.getText());
		    		 pi=Integer.parseInt(pc.getText());
		    		 qt=Integer.parseInt(q.getText());

		    		Statement st;
					try {
						st = c.condata().createStatement();
						st.execute("insert into product(id,pname,msellqnty,price,quantity) values("+pd+",'"+pnam+"',"+mn+","+pi+","+qt+")" );
					    } 
					catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
			            }
					
					}
	             });
	    f.add(b1);  
	    f.add(b2); 
		f.add(q);
		f.add(qa);
	    f.add(b);
	    f.add(ul);
	    f.add(pl);
	    f.add(ps);
	    f.add(us);
	    f.add(min);
	    f.add(ms);
	    f.add(pe);
	    f.add(pc);
	    f.setSize(500,500);  
	    f.setLayout(null);  
	    f.setVisible(true);  
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
