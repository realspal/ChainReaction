//NewCRXN Class
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.image.*;
public class NewCRXN implements ActionListener
{
    JFrame jf;
    JPanel err1,err2;
    JButton banner,jb_new,jb_load;
    NewCRXN()
    {
        jf=new JFrame("Chain Reaction PVP - Choose Game");
        jf.getContentPane().setBackground(new Color(2,2,2));
        jf.pack();
        jf.setBackground(new Color(2,2,2));
        jf.setSize(990,728);
        jf.setResizable(true);
        jf.setVisible(true);
        
        //err1
        err1=new JPanel();
        
        //jb_new
        jb_new=new JButton("");
        jb_new.setOpaque(true);
        jb_new.setBounds(265,480,200,50);
        jb_new.setBackground(new Color(60,60,60));
        jb_new.setForeground(new Color(250,250,250));
        jb_new.setText("New Game");
        jb_new.setFont(new Font("Arial",Font.BOLD,24));
        jb_new.setMargin(new Insets(2,2,2,2));
        jb_new.setBorder(BorderFactory.createEmptyBorder());
        jb_new.setHorizontalAlignment(SwingConstants.CENTER);
        jb_new.setBorderPainted(false);
        jb_new.setFocusPainted(false);
        jb_new.addActionListener(this);
        jf.add(jb_new);
        
        //jb_load
        jb_load=new JButton("");
        jb_load.setOpaque(true);
        jb_load.setBounds(515,480,200,50);
        jb_load.setBackground(new Color(60,60,60));
        jb_load.setForeground(new Color(250,250,250));
        jb_load.setText("Load Game");
        jb_load.setFont(new Font("Arial",Font.BOLD,24));
        jb_load.setMargin(new Insets(2,2,2,2));
        jb_load.setBorder(BorderFactory.createEmptyBorder());
        jb_load.setHorizontalAlignment(SwingConstants.CENTER);
        jb_load.setBorderPainted(false);
        jb_load.setFocusPainted(false);
        jb_load.addActionListener(this);
        jf.add(jb_load);
        
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
        jf.setVisible(false);
        if(e.getSource()==jb_new)
        {
            new Board(0);
        }
        else
        {
            Board obj=new Board(1);
            obj.jf.setVisible(false);
            new LoadCRXN(obj);
        }
    }
}