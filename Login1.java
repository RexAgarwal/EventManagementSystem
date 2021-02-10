/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Himanshu Agarwal
 */
public class Login1 extends JFrame{
    JLabel l1,l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2;
    String type;
    Login1(String s1){
        this.type = s1;
        ImageIcon i1 = new ImageIcon("C:/Users/Himanshu Agarwal/Documents/NetBeansProjects/Event_Management_System/src/event_management_system/images/man_logo.jpg");
        Image q1 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(q1);
        JLabel l3 = new JLabel(i2);
        l3.setBounds(350,10,200,200);
        add(l3);
        getContentPane().setBackground(Color.WHITE);
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        l1.setBounds(40,20,100,30);
        l2.setBounds(40,70,100,30);
        add(l1);
        add(l2);
        t1 = new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);
        
        p1 = new JPasswordField();
        p1.setBounds(150,70,150,30);
        add(p1);
        
        b1 = new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,120,100,30);
        add(b1);
        b1.addActionListener( new ActionListener(){
                
              public void actionPerformed(ActionEvent ae){
        try{
            conn c1 = new conn();
            String u = t1.getText();
            String v = p1.getText();
            ResultSet rs = null;
            
            if (type == "admin")
            {
            
            String q = "select * from user where name='"+u+"' and password='"+v+"' and type ='"+"admin"+"'";
             rs = c1.s.executeQuery(q); 
//            String q2 = "select type from user where name ='"+u+"' and password='"+v+"' ";
            System.out.print(q);
            }
            else if (type == "customer")
            {
                String q = "select * from user where name='"+u+"' and password='"+v+"' and type ='"+"customer"+"'";
                rs = c1.s.executeQuery(q); 
//            String q2 = "select type from user where name ='"+u+"' and password='"+v+"' ";
                System.out.print(q);
            }
            
            
//            ResultSet rs2 = c1.s.executeQuery(q2); 
            if(rs.next()){ 
                if (type == "admin")
                new Dashboard().setVisible(true);
                else if (type == "customer")
                    new Dashboard2().setVisible(true);
                
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                new Event_Management_System().setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
        });
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(150,120,100,30);
        add(b2);
        b2.addActionListener(new ActionListener(){
                
              public void actionPerformed(ActionEvent ae){
                  System.exit(0);
              }
        
        } );
        
        
        setLayout(null);
        setBounds(500,300,600,400);
        setVisible(true);
//        if (type == "Admin"){
//            Admin();
//            
//            
//        }
//else        
        if (type == "customer"){
            Customer();
            
        }
        
    }
//    void Admin(){
//        
//        
//    }
    void Customer(){
        JButton b3 = new JButton("Register");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(260,120,100,30);
        add(b3);
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new Register().setVisible(true);
                
                
        }
        
        
        });
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
        try{
            conn c1 = new conn();
            String u = t1.getText();
            String v = p1.getText();
            
            String q = "select * from users where username='"+u+"' and password='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){ 
                
                new Dashboard().setVisible(true);
                setVisible(false);
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
                new Event_Management_System().setVisible(true);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }else if(ae.getSource()==b2){
            System.exit(0);
        }
    }
//    public static void main(String args[]){
//        Login1 l = new Login1("a");
//    }
//    
    
    
}
