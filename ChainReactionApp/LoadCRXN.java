//LoadCRXN Class
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.image.*;
class LoadCRXN implements ActionListener
{
    JFrame jf;
    JTextField filename;
    JButton banner,jb_load;
    JLabel textlabel;
    JPanel err1,err2;
    Board obj;
    static int mat1[][]=new int[9][15];
    static int m=0;
    LoadCRXN(Board ob)
    {
        jf=new JFrame("Chain Reaction PVP - Load Game");
        jf.getContentPane().setBackground(new Color(2,2,2));
        jf.pack();
        jf.setBackground(new Color(2,2,2));
        jf.setSize(990,728);
        jf.setResizable(true);
        jf.setVisible(true);
        
        //err1
        err1=new JPanel();
        
        //filename
        filename=new JTextField(30);
        filename.setOpaque(true);
        filename.setBounds(215,530,400,50);
        filename.setBackground(new Color(180,180,180));
        filename.setForeground(new Color(2,2,2));
        filename.setText("");
        filename.setFont(new Font("Consolas",Font.ITALIC,24));
        filename.setMargin(new Insets(4,10,4,10));
        filename.setBorder(BorderFactory.createEmptyBorder());
        filename.setHorizontalAlignment(SwingConstants.CENTER);
        jf.add(filename);
        
        //jb_load
        jb_load=new JButton("");
        jb_load.setOpaque(true);
        jb_load.setBounds(635,530,120,50);
        jb_load.setBackground(new Color(60,60,60));
        jb_load.setForeground(new Color(250,250,250));
        jb_load.setText("Load");
        jb_load.setFont(new Font("Arial",Font.BOLD,24));
        jb_load.setMargin(new Insets(2,2,2,2));
        jb_load.setBorder(BorderFactory.createEmptyBorder());
        jb_load.setHorizontalAlignment(SwingConstants.CENTER);
        jb_load.setBorderPainted(false);
        jb_load.setFocusPainted(false);
        jb_load.addActionListener(this);
        jf.add(jb_load);
        
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
        obj=ob;
        
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
        int m=load(filename.getText());
        for(int i=0;i<9;i++)
            for(int j=0;j<15;j++)
                obj.mat[i][j]=mat1[i][j];
        obj.whoseMoveNow=m;
        obj.refreshMatrix();
        obj.setStatus(m);
        obj.jf.setVisible(true);
        jf.setVisible(false);
    }
    public static int load(String filename)
    {
        String fullname="";
        if(!(filename.trim()).endsWith(".crxn"))
        fullname=filename.trim()+".crxn";
        else
        fullname=filename.trim();
        int m=0;
        try
        {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fullname));
            mat1=(int[][])ois.readObject();
            m=ois.readInt();
            ois.close();
        }
        catch(Exception e)
        {
        }
        return m;
    }
}