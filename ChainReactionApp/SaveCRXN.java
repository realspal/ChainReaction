//SaveCRXN Class
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.image.*;
class SaveCRXN implements ActionListener
{
    JFrame jf;
    JTextField filenm;
    JButton banner,jb_save;
    JLabel textlabel;
    JPanel err1,err2;
    BoardData bd1;
    SaveCRXN(BoardData bd)
    {
        jf=new JFrame("Chain Reaction PVP - Save Game");
        jf.getContentPane().setBackground(new Color(2,2,2));
        jf.pack();
        jf.setBackground(new Color(2,2,2));
        jf.setSize(990,728);
        jf.setResizable(true);
        jf.setVisible(true);
        
        //err1
        err1=new JPanel();
        
        //filenm
        filenm=new JTextField(30);
        filenm.setOpaque(true);
        filenm.setBounds(215,530,400,50);
        filenm.setBackground(new Color(180,180,180));
        filenm.setForeground(new Color(2,2,2));
        filenm.setText("");
        filenm.setFont(new Font("Consolas",Font.ITALIC,24));
        filenm.setMargin(new Insets(4,10,4,10));
        filenm.setBorder(BorderFactory.createEmptyBorder());
        filenm.setHorizontalAlignment(SwingConstants.CENTER);
        jf.add(filenm);
        
        //jb_save
        jb_save=new JButton("");
        jb_save.setOpaque(true);
        jb_save.setBounds(635,530,120,50);
        jb_save.setBackground(new Color(60,60,60));
        jb_save.setForeground(new Color(250,250,250));
        jb_save.setText("Save");
        jb_save.setFont(new Font("Arial",Font.BOLD,24));
        jb_save.setMargin(new Insets(2,2,2,2));
        jb_save.setBorder(BorderFactory.createEmptyBorder());
        jb_save.setHorizontalAlignment(SwingConstants.CENTER);
        jb_save.setBorderPainted(false);
        jb_save.setFocusPainted(false);
        jb_save.addActionListener(this);
        jf.add(jb_save);
        
        //textlabel
        textlabel=new JLabel("");
        textlabel.setOpaque(true);
        textlabel.setBounds(215,480,400,40);
        textlabel.setBackground(new Color(2,2,2));
        textlabel.setForeground(new Color(220,220,220));
        textlabel.setText("Enter File Name");
        textlabel.setFont(new Font("Arial",Font.BOLD,20));
        textlabel.setBorder(BorderFactory.createEmptyBorder());
        textlabel.setHorizontalAlignment(SwingConstants.CENTER);
        jf.add(textlabel);
        
        //object
        bd1=bd;
        
        //banner
        banner=new JButton("");
        banner.setOpaque(true);
        banner.setBounds(95,150,800,300);
        banner.setBackground(new Color(80,80,80));
        banner.setForeground(new Color(240,240,240));
        banner.setText("");
        banner.setFont(new Font("Arial", Font.PLAIN, 32));
        banner.setMargin(new Insets(0,0,0,0));
        banner.setBorder(BorderFactory.createEmptyBorder());
        banner.setHorizontalAlignment(SwingConstants.CENTER);
        try
        {
            banner.setIcon(new ImageIcon(ImageIO.read(new File("CRXN-Banner-Cover.png"))));
        }
        catch (IOException e)
        {
            //e.printStackTrace();
        }
        jf.add(banner);
        
        //err3
        JLabel err3=new JLabel();
        err3.setBounds(1850,1050,20,20);
        jf.add(err3);
    }
    public void actionPerformed(ActionEvent e)
    {
        String str=(filenm.getText()).trim();
        if(str.endsWith(".crxn"))
        str=str.substring(0,str.length()-5);
        GameFile.save(str,bd1);
        jf.setVisible(false);
    }
}