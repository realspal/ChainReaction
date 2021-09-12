//InfoCRXN Class
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.image.*;
public class InfoCRXN
{
    JFrame jfinfo;
    JLabel text[]=new JLabel[71];
    JPanel jp1;
    JPanel err1,err2;
    JScrollPane jsp;
    JButton banner;
    InfoCRXN()
    {
        jfinfo=new JFrame("Chain Reaction PVP - Info");
        jfinfo.getContentPane().setBackground(new Color(50,50,50));
        jfinfo.pack();
        jfinfo.setBackground(new Color(50,50,50));
        jfinfo.setSize(990,728);
        jfinfo.setResizable(true);
        jfinfo.setVisible(true);
        
        //err1
        err1=new JPanel();
        
        //jp1 and jsp
        jp1=new JPanel();
        jsp=new JScrollPane(jp1);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setBounds(20,90,935,570);
        jsp.setBackground(new Color(245,245,245));
        GridBagLayout layout=new GridBagLayout();
        jp1.setLayout(layout);
        GridBagConstraints gbc=new GridBagConstraints();
        jsp.setBorder(BorderFactory.createEmptyBorder());
        jfinfo.add(jsp);
        
        for(int i=0;i<71;i++)
        {
            text[i]=new JLabel("");
            text[i].setOpaque(true);
            text[i].setBounds(20,90+24*i,940,24);
            text[i].setBackground(new Color(220,220,220));
            text[i].setForeground(new Color(40,40,40));
            text[i].setText(" --");
            text[i].setFont(new Font("Consolas",Font.PLAIN,16));
            text[i].setBorder(BorderFactory.createEmptyBorder());
            text[i].setHorizontalAlignment(SwingConstants.LEFT);
        }
        for(int i=0;i<71;i++)
        {
            gbc.fill=GridBagConstraints.HORIZONTAL;
            text[i].setPreferredSize(new Dimension(950,24));
            gbc.gridx=0;
            gbc.gridy=i;
            jp1.add(text[i],gbc);
        }
        
        //banner
        banner=new JButton("");
        banner.setOpaque(true);
        banner.setBounds(20,20,853,60);
        banner.setBackground(new Color(80,80,80));
        banner.setForeground(new Color(240,240,240));
        banner.setText("");
        banner.setFont(new Font("Arial", Font.PLAIN, 32));
        banner.setMargin(new Insets(0,0,0,0));
        banner.setBorder(BorderFactory.createEmptyBorder());
        banner.setHorizontalAlignment(SwingConstants.LEFT);
        try
        {
            banner.setIcon(new ImageIcon(ImageIO.read(new File("CRXN-Banner-Info.png"))));
        }
        catch (IOException e)
        {
            //e.printStackTrace();
        }
        jfinfo.add(banner);
        
        text[0].setText("  ------------------------------------------------------------------------------------------------");
        text[1].setText("  CHAIN REACTION PVP - Java Application for Windows PC");
        text[2].setText("  ------------------------------------------------------------------------------------------------");
        text[3].setText("  ");
        text[4].setText("  Game Application: Developed by Soumyadeep Pal");
        text[5].setText("  Developer Link: https://www.github.com/realspal");
        text[6].setText("  Game Rules: Based on the original Chain Reaction Android Game");
        text[7].setText("  ------------------------------------------------------------------------------------------------");
        text[8].setText("  ");
        text[9].setText("  Copyright © 2021 Developer. All rights reserved. No part of this project may be reproduced,");
        text[10].setText("  stored in a retrieval system, distributed or transmitted in any form or by any means,");
        text[11].setText("  electronic, mechanical, photocopying, recording or otherwise, without the prior written");
        text[12].setText("  permission of the developer, except in the case of personal non-commercial uses permitted");
        text[13].setText("  by copyright law. For permission requests, write to the developer, addressed “Permission");
        text[14].setText("  Request”, via LinkedIn at https://www.linkedin.com/in/realspal. Even in such uses, the");
        text[15].setText("  information contained in this document, the name of the developer and the project link");
        text[16].setText("  shall not be modified, and must be retained as it is.");
        text[17].setText("  ------------------------------------------------------------------------------------------------");
        text[18].setText("  ");
        text[19].setText("  About This Project:");
        text[20].setText("  This project contains a Windows application for playing the Chain Reaction game in 2 player");
        text[21].setText("  (player vs player or PvP) mode, created in Java using Swing and AWT. The colored orbs seen");
        text[22].setText("  in the game play were created separately using Microsoft Paint. This version features a 9x16");
        text[23].setText("  grid for 2 players (Red and Blue) and is capable of invalidating illegal moves and declaring");
        text[24].setText("  winner automatically. It also features options for saving an incomplete game and loading a");
        text[25].setText("  saved game. The game data files are stored in CRXN file (.crxn) format.");
        text[26].setText("  ------------------------------------------------------------------------------------------------");
        text[27].setText("  ");
        text[28].setText("  About The Game Chain Reaction (Source - https://brilliant.org/wiki/chain-reaction-game):");
        text[29].setText("  ");
        text[30].setText("  Chain reaction is a turn-based deterministic combinatorial strategy game of perfect");
        text[31].setText("  information for 2 (to 8) players, played on a rectangular grid. It was originally developed");
        text[32].setText("  by Buddy-Matt Entertainment for Android.");
        text[33].setText("  ");
        text[34].setText("  Original Play Store Application Link:");
        text[35].setText("  https://play.google.com/store/apps/details?id=com.BuddyMattEnt.ChainReaction&hl=en_IN&gl=US");
        text[36].setText("  ");
        text[37].setText("  The most interesting thing is how unpredictable the game seems to be in the end, at least");
        text[38].setText("  when you play it with your human friends. The obvious heuristic that tells us you're better");
        text[39].setText("  off at the moment by having as many orbs as possible turns out to be very wrong. While it so");
        text[40].setText("  seems to everyone, that say, red will win, blue suddenly takes over.");
        text[41].setText("  ");
        text[42].setText("  Rules Of The Game:");
        text[43].setText("  1. The gameplay takes place in an mxn board. The most commonly used size of the board is");
        text[44].setText("     9x6. However, in this project, the size of the board is 9x15 to suit the landscape view.");
        text[45].setText("  2. For each cell in the board, we define a critical mass. The critical mass is equal to the");
        text[46].setText("     number of orthogonally adjacent cells. That would be 4 for usual cells, 3 for cells in");
        text[47].setText("     the edge and 2 for cells in the corner.");
        text[48].setText("  3. All cells are initially empty. The Red and the Blue players take turns to place “orbs” of");
        text[49].setText("     their corresponding colors. The Red player can only place a red orb in an empty cell or a");
        text[50].setText("     cell which already contains one or more red orbs. When two or more orbs are placed in the");
        text[51].setText("     same cell, they stack up.");
        text[52].setText("  4. When a cell is loaded with a number of orbs equal to its critical mass, the stack");
        text[53].setText("     immediately explodes. As a result of the explosion, to each of the orthogonally adjacent");
        text[54].setText("     cells, an orb is added and the initial cell looses as many orbs as its critical mass. The");
        text[55].setText("     explosions might result in overloading of an adjacent cell and the chain reaction of");
        text[56].setText("     explosions continues until every cell is stable.");
        text[57].setText("  5. When a red cell explodes and there are blue cells around, the blue cells are converted to");
        text[58].setText("     red and the other rules of explosions still follow. The same rule is applicable for the");
        text[59].setText("     reverse scenario.");
        text[60].setText("  6. The winner is the one who eliminates all orbs of the other player.");
        text[61].setText("  ------------------------------------------------------------------------------------------------");
        text[62].setText("  ");
        text[63].setText("  Message From Developer (Date: 12th September, 2021):");
        text[64].setText("  ");
        text[65].setText("  I really enjoyed coding the Windows version of the Chain Reaction game. I hope you will have");
        text[66].setText("  fun playing this game and devising your own strategies. For more information, you can contact");
        text[67].setText("  me via LinkedIn (https://www.linkedin.com/in/realspal). Thanks for reading. With regards,");
        text[68].setText("  ");
        text[69].setText("  Soumyadeep Pal.");
        text[70].setText("  ------------------------------------------------------------------------------------------------");
        //err3
        JLabel err3=new JLabel();
        err3.setBounds(1850,1050,20,20);
        jfinfo.add(err3);
    }
}