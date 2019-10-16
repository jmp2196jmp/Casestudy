package ecart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Show {

	public void show() {
		JFrame f5 = new JFrame ("Show History");
        
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
       ConnectionManager c=new  ConnectionManager();
          
        String sql="SELECT * FROM showitem";
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
           String id = rs1.getString("pname");
           String pn = rs1.getString("buy/sell");
          String sq = rs1.getString("quantity");
           String qr=rs1.getString("totalcost");
           String pp = rs1.getString("itemprice");
          
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

}
