/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_management_system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Himanshu Agarwal
 */
public class viewdetails extends JFrame{
    String v1 = "SELECT Name FROM venue LIMIT 100";
      String v2 = "SELECT name FROM photographer LIMIT 100";
      String v3 = "SELECT caterer FROM catering LIMIT 100";
      private JPanel contentPane;
    viewdetails(String it){
    setBounds(450, 200, 1000, 450);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
            conn c = new conn();
            try{
                 ArrayList<String> ob = new ArrayList<String>();
            ResultSet rs = c.s.executeQuery(v1);
            int j=0;
            while(rs.next())
            {
            String name = rs.getString(1);
            System.out.print(name);
            JButton b2 = new JButton(name);
            b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(10, 10+j, 100, 30);
	contentPane.add(b2);
	b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    setVisible(false);
                    Venue v = new Venue(name);  
                }catch(Exception e ){}}});
        j = j+40;
        
            
            
            }
            }
            catch (SQLException ex) {
            Logger.getLogger(Venue.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    
      
      contentPane.setBackground(Color.WHITE);
                setVisible(true);
      setSize(4366,900);
            
    }
    public static void main(String args[]){
        viewdetails v = new viewdetails("venue");
    }
        
    
}
