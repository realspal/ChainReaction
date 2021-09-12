//Board Class
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.image.*;
public class Board implements ActionListener
{
    JFrame jf;
    public int mat[][]=new int[9][15];
    public int whoseMoveNow;
    JButton b[][]=new JButton[9][15];
    JPanel jp1;
    JPanel err1,err2;
    JScrollPane jsp;
    JButton banner,status,save,info;
    boolean isGameActive=false;
    boolean isFirstMoveDone=false;
    Board(int flag)
    {
        //flag=0 for new game and flag=1 for loaded game
        
        jf=new JFrame("Chain Reaction PVP - Play Game");
        jf.getContentPane().setBackground(new Color(2,2,2));
        jf.pack();
        jf.setBackground(new Color(2,2,2));
        jf.setSize(990,728);
        jf.setResizable(true);
        jf.setVisible(true);
                
        //err1
        err1=new JPanel();
        
        //jp1 and jsp
        jp1=new JPanel();
        jsp=new JScrollPane(jp1);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        jsp.setBounds(20,100,930,558);
        jsp.setBackground(new Color(245,245,245));
        GridBagLayout layout=new GridBagLayout();
        jp1.setLayout(layout);
        GridBagConstraints gbc=new GridBagConstraints();
        jsp.setBorder(BorderFactory.createEmptyBorder());
        jf.add(jsp);
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<15;j++)
            {
                b[i][j]=new JButton("");
                b[i][j].setOpaque(true);
                b[i][j].setBounds(20+62*j,100+62*i,62,62);
                b[i][j].setBackground(new Color(50,50,50));
                b[i][j].setForeground(new Color(240,240,240));
                b[i][j].setText("");
                b[i][j].setFont(new Font("Arial",Font.PLAIN,20));
                b[i][j].setMargin(new Insets(1,1,1,1));
                b[i][j].setBorder(BorderFactory.createEmptyBorder());
                b[i][j].setHorizontalAlignment(SwingConstants.CENTER);
            }
        }
        for(int i=0;i<9;i++)
        {
            gbc.fill = GridBagConstraints.HORIZONTAL;
            for(int j=0;j<15;j++)
            {
                b[i][j].setPreferredSize(new Dimension(62,62));
                //b[i][j].setOpaque(true);
                b[i][j].setBorderPainted(false);
                b[i][j].setFocusPainted(false);
                b[i][j].addActionListener(this);
                gbc.gridx = j;
                gbc.gridy = i;
                jp1.add(b[i][j],gbc);
            }
        }
        
        //banner
        banner=new JButton("");
        banner.setOpaque(true);
        banner.setBounds(20,20,275,60);
        banner.setBackground(new Color(80,80,80));
        banner.setForeground(new Color(240,240,240));
        banner.setText("");
        banner.setFont(new Font("Arial", Font.PLAIN, 32));
        banner.setMargin(new Insets(0,0,0,0));
        banner.setBorder(BorderFactory.createEmptyBorder());
        banner.setHorizontalAlignment(SwingConstants.CENTER);
        try
        {
            banner.setIcon(new ImageIcon(ImageIO.read(new File("CRXN-Banner.png"))));
        }
        catch (IOException e)
        {
            //e.printStackTrace();
        }
        jf.add(banner);
        
        //status
        status=new JButton("");
        status.setOpaque(true);
        status.setBounds(315,20,475,60);
        status.setBackground(new Color(40,40,40));
        status.setForeground(new Color(80,80,80));
        status.setText("Welcome");
        status.setFont(new Font("Arial",Font.BOLD,24));
        status.setMargin(new Insets(0,0,0,0));
        status.setBorder(BorderFactory.createEmptyBorder());
        status.setHorizontalAlignment(SwingConstants.CENTER);
        jf.add(status);
        
        //save
        save=new JButton("");
        save.setOpaque(true);
        save.setBounds(810,20,60,60);
        save.setBackground(new Color(80,80,80));
        save.setForeground(new Color(240,240,240));
        save.setText("");
        save.setFont(new Font("Arial", Font.PLAIN, 32));
        save.setMargin(new Insets(0,0,0,0));
        save.setBorder(BorderFactory.createEmptyBorder());
        save.setHorizontalAlignment(SwingConstants.CENTER);
        save.setBorderPainted(false);
        save.setFocusPainted(false);
        save.addActionListener(this);
        try
        {
            save.setIcon(new ImageIcon(ImageIO.read(new File("CRXN-Save.png"))));
        }
        catch (IOException e)
        {
            //e.printStackTrace();
        }
        jf.add(save);
        
        //info
        info=new JButton("");
        info.setOpaque(true);
        info.setBounds(890,20,60,60);
        info.setBackground(new Color(80,80,80));
        info.setForeground(new Color(240,240,240));
        info.setText("");
        info.setFont(new Font("Arial", Font.PLAIN, 32));
        info.setMargin(new Insets(0,0,0,0));
        info.setBorder(BorderFactory.createEmptyBorder());
        info.setHorizontalAlignment(SwingConstants.CENTER);
        info.setBorderPainted(false);
        info.setFocusPainted(false);
        info.addActionListener(this);
        try
        {
            info.setIcon(new ImageIcon(ImageIO.read(new File("CRXN-Info.png"))));
        }
        catch (IOException e)
        {
            //e.printStackTrace();
        }
        jf.add(info);
        
        //initialise matrix
        if(flag==0)
        {
            for(int i=0;i<9;i++)
            for(int j=0;j<15;j++)
            mat[i][j]=0;
            
            whoseMoveNow=1;
        }
        //refresh matrix
        refreshMatrix();
        
        //err3
        JLabel err3=new JLabel();
        err3.setBounds(1850,1050,20,20);
        jf.add(err3);
        
        //err2=new JPanel();
        //jf.add(err2);
        
        //set status
        setStatus(whoseMoveNow);
        isGameActive=true;
    }
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<15;j++)
            {
                if(e.getSource()==b[i][j])
                {
                    if(isGameActive)
                    clicked(i,j);
                }
            }
        }
        if(e.getSource()==save)
        {
            jf.setVisible(false);
            new SaveCRXN(new BoardData(mat,whoseMoveNow));
        }
        if(e.getSource()==info)
        {
            new InfoCRXN();
        }
    }
    void clicked(int x,int y)
    {
        if((whoseMoveNow==1 && mat[x][y]>0)||(whoseMoveNow==2 && mat[x][y]<0))
        {
            setStatus(whoseMoveNow+4);
        }
        else
        {
            add(x,y);
            refreshMatrix();
            if(checkForWin()==0)
            {
                whoseMoveNow=(whoseMoveNow==1)?2:1;
                setStatus(whoseMoveNow);
            }
            else
            {
                isGameActive=false;
                setStatus(whoseMoveNow+2);
            }
        }
    }
    void add(int x,int y)
    {
        int w=whoseMoveNow;
        if(w==1) //player 1
        {
            if(x==0 && y==0) //corners
            { 
                if(mat[x][y]==0) { mat[x][y]=-1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=0; add(0,1); add(1,0); return; }
            }
            if(x==0 && y==14) //corners
            {
                if(mat[x][y]==0) { mat[x][y]=-1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=0; add(0,13); add(1,14); return; }
            }
            if(x==8 && y==0) //corners
            {
                if(mat[x][y]==0) { mat[x][y]=-1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=0; add(8,1); add(7,0); return; }
            }
            if(x==8 && y==14) //corners
            {
                if(mat[x][y]==0) { mat[x][y]=-1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=0; add(8,13); add(7,14); return; }
            }
            if(x==0 && y>0 && y<14) //edges
            {
                if(mat[x][y]==0) { mat[x][y]=-1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=-2; return; }
                if(mat[x][y]==2 || mat[x][y]==-2) { mat[x][y]=0; add(0,y-1); add(0,y+1); add(1,y); return; }
            }
            if(x==8 && y>0 && y<14) //edges
            {
                if(mat[x][y]==0) { mat[x][y]=-1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=-2; return; }
                if(mat[x][y]==2 || mat[x][y]==-2) { mat[x][y]=0; add(8,y-1); add(8,y+1); add(7,y); return; }
            }
            if(y==0 && x>0 && x<8) //edges
            {
                if(mat[x][y]==0) { mat[x][y]=-1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=-2; return; }
                if(mat[x][y]==2 || mat[x][y]==-2) { mat[x][y]=0; add(x-1,0); add(x+1,0); add(x,1); return; }
            }
            if(y==14 && x>0 && x<8) //edges
            {
                if(mat[x][y]==0) { mat[x][y]=-1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=-2; return; }
                if(mat[x][y]==2 || mat[x][y]==-2) { mat[x][y]=0; add(x-1,14); add(x+1,14); add(x,13); return; }
            }
            if(x>0 && x<8 && y>0 && y<14) //body
            {
                if(mat[x][y]==0) { mat[x][y]=-1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=-2; return; }
                if(mat[x][y]==2 || mat[x][y]==-2) { mat[x][y]=-3; return; }
                if(mat[x][y]==3 || mat[x][y]==-3) { mat[x][y]=0; add(x,y-1); add(x,y+1); add(x-1,y); add(x+1,y); return; }
            }
        }
        else //player 2
        {
            if(x==0 && y==0) //corners
            { 
                if(mat[x][y]==0) { mat[x][y]=1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=0; add(0,1); add(1,0); return; }
            }
            if(x==0 && y==14) //corners
            {
                if(mat[x][y]==0) { mat[x][y]=1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=0; add(0,13); add(1,14); return; }
            }
            if(x==8 && y==0) //corners
            {
                if(mat[x][y]==0) { mat[x][y]=1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=0; add(8,1); add(7,0); return; }
            }
            if(x==8 && y==14) //corners
            {
                if(mat[x][y]==0) { mat[x][y]=1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=0; add(8,13); add(7,14); return; }
            }
            if(x==0 && y>0 && y<14) //edges
            {
                if(mat[x][y]==0) { mat[x][y]=1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=2; return; }
                if(mat[x][y]==2 || mat[x][y]==-2) { mat[x][y]=0; add(0,y-1); add(0,y+1); add(1,y); return; }
            }
            if(x==8 && y>0 && y<14) //edges
            {
                if(mat[x][y]==0) { mat[x][y]=1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=2; return; }
                if(mat[x][y]==2 || mat[x][y]==-2) { mat[x][y]=0; add(8,y-1); add(8,y+1); add(7,y); return; }
            }
            if(y==0 && x>0 && x<8) //edges
            {
                if(mat[x][y]==0) { mat[x][y]=1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=2; return; }
                if(mat[x][y]==2 || mat[x][y]==-2) { mat[x][y]=0; add(x-1,0); add(x+1,0); add(x,1); return; }
            }
            if(y==14 && x>0 && x<8) //edges
            {
                if(mat[x][y]==0) { mat[x][y]=1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=2; return; }
                if(mat[x][y]==2 || mat[x][y]==-2) { mat[x][y]=0; add(x-1,14); add(x+1,14); add(x,13); return; }
            }
            if(x>0 && x<8 && y>0 && y<14) //body
            {
                if(mat[x][y]==0) { mat[x][y]=1; return; }
                if(mat[x][y]==1 || mat[x][y]==-1) { mat[x][y]=2; return; }
                if(mat[x][y]==2 || mat[x][y]==-2) { mat[x][y]=3; return; }
                if(mat[x][y]==3 || mat[x][y]==-3) { mat[x][y]=0; add(x,y-1); add(x,y+1); add(x-1,y); add(x+1,y); return; }
            }
        }
        
    }
    void refreshMatrix()
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<15;j++)
            {
                try
                {
                    if(mat[i][j]==0) //empty
                    b[i][j].setIcon(new ImageIcon(ImageIO.read(new File("orb-p0-n0.png"))));
                    else if(mat[i][j]<0) //player 1
                    b[i][j].setIcon(new ImageIcon(ImageIO.read(new File("orb-p1-n"+(0-mat[i][j])+".png"))));
                    else //player 2
                    b[i][j].setIcon(new ImageIcon(ImageIO.read(new File("orb-p2-n"+mat[i][j]+".png"))));
                }
                catch (IOException e)
                {
                    //e.printStackTrace();
                }
            }
        }
    }
    void setStatus(int x)
    {
        if(x==0)
        {
            status.setText("--");
            status.setForeground(new Color(80,80,80));
        }
        if(x==1)
        {
            status.setText("Red Player's Move...");
            status.setForeground(new Color(237,28,36));
        }
        if(x==2)
        {
            status.setText("Blue Player's Move...");
            status.setForeground(new Color(0,162,232));
        }
        if(x==3)
        {
            status.setText("Red Player Won!");
            status.setForeground(new Color(237,28,36));
        }
        if(x==4)
        {
            status.setText("Blue Player Won!");
            status.setForeground(new Color(0,162,232));
        }
        if(x==5)
        {
            status.setText("#INVALID! Red Player's Move...");
            status.setForeground(new Color(237,28,36));
        }
        if(x==6)
        {
            status.setText("#INVALID! Blue Player's Move...");
            status.setForeground(new Color(0,162,232));
        }
    }
    int checkForWin()
    {
        if(!isFirstMoveDone)
        {
            isFirstMoveDone=true;
            return 0;
        }
        int p1=0,p2=0;
        for(int i=0;i<9;i++)
        for(int j=0;j<15;j++)
        if(mat[i][j]<0)
        p1++;
        else if(mat[i][j]>0)
        p2++;
        if(p1>0 && p2==0)
        return 1;
        if(p1==0 && p2>0)
        return 2;
        return 0;
    }
}