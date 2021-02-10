/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_management_system;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Himanshu Agarwal
 */
public class Venue extends JFrame {
    JLabel l1[] = new JLabel[]{new JLabel("Name"),new JLabel("price"),new JLabel("capacity"),new JLabel("facilities"),new JLabel("description")};
    private String name,image_url,facilities,description,capacity,price;
    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c1;
    private void is_available(){
        Date_Time dt = new Date_Time();
        String current_date = dt.getdate();
        System.out.print(current_date);
        
    }
    
        
       Venue(String name){
        
        getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("Venues");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(4366,900);
            getContentPane().setLayout(null);
            conn c = new conn();
            JScrollPane sb = new JScrollPane();
            
        String q = "select * from venue where Name ='"+name+"'";
        try {
            ResultSet rs = c.s.executeQuery(q);
            while(rs.next())
            {
                    name = rs.getString(2);
                    image_url = rs.getString(3);
                    capacity = rs.getString(4);
                    price = rs.getString(5);
                    facilities = rs.getString(6);
                    description = rs.getString(7);
//                    System.out.print(description);
                    JLabel l2[] = new JLabel[]{new JLabel(name),new JLabel(price),new JLabel(capacity),new JLabel(facilities),new JLabel(description)};
                    
                    
                    
                    int j = 0;
                    for(int i=0;i<5;i++){
                        if (i>2){
                                j+= 50;
                                l1[i].setBounds(40,20+j,100,30);
                            }
                        else {
                            l1[i].setBounds(40,20+j,100,30);
                        }
                            add(l1[i]);
                            
                            j+= 50;
                            
            
                       }
                    j =0;
                    for(int i=0;i<5;i++){
                        if (i>2){
                                j+= 50;
                                l2[i].setBounds(150,20+j,500,500);
                            }
                        else {
                        
                            l2[i].setBounds(150,20+j,100,30);
                        }
                            add(l2[i]);
                            j+= 50;
            
                       }
//                    System.out.print(image_url);
                
                    
                try {
                    URL url = new URL(image_url);
                    Image img;
                    img = ImageIO.read(url);
                    ImageIcon i2 = new ImageIcon(img);
                    Image q1 = i2.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
                    ImageIcon q2 = new ImageIcon(q1);
                    JLabel l3 = new JLabel(q2);
                    l3.setBounds(450,50,300,300);
                    add(l3);
                } catch (IOException ex) {
                    Logger.getLogger(Venue.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                   
//                    JLabel l1 = new JLabel(name);
//                    l1.setFont(new Font("Tahoma", Font.PLAIN, 17));
//                    l1.setBounds(60, 170, 150, 27);
//                    add(l1);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(Venue.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            
            
            
            
            
            add(sb);
             setSize(4366,900);
            setVisible(true);
            setLocation(0,0);
        
    }
    
    
    void getVenue(int id){
        conn c = new conn();
        String q = "select * from venue where id ='"+id+"'";
        try {
            ResultSet rs = c.s.executeQuery(q);
            rs.next();
            name = rs.getString(2);
            image_url = rs.getString(3);
                    capacity = rs.getString(4);
                    price = rs.getString(5);
                    facilities = rs.getString(6);
                    description = rs.getString(7);
                    
        } catch (SQLException ex) {
            Logger.getLogger(Venue.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    void addvenue(String name,String image_url,String capacity,String price,String facilities,String description){
        conn c =new conn();
        String q = "insert into venue values('"+name+"', '"+image_url+"', "+capacity+", "+price+", '"+facilities+"', '"+description+"' )";
        System.out.print(q);
        
        try{
            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Room Successfully Added");
                this.setVisible(false);
            
        }catch (SQLException ex) {
            Logger.getLogger(Venue.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
//    public static void main(String args[]){
//        Venue v = new Venue(); 
//        
//        
//        
////        v.is_available();
//    }

    
    
    
    
    
}
