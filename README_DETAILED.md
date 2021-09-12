# ChainReaction
Chain Reaction PvP (2-Player) Game Application with options for saving and loading an incomplete game. This repository contains a Windows application, created in Java using Swing and AWT, for playing the Chain Reaction game, a turn-based deterministic combinatorial strategy game of perfect information for 2 (to 8) players, played on a rectangular grid, originally developed by Buddy-Matt Entertainment for Android. This version of the game features a 9x16 grid for 2 players (Red and Blue).

-----------------------------------------------------------------------------------------------

CHAIN REACTION PVP - Java Application for Windows PC
-----------------------------------------------------------------------------------------------

Game Application: Developed by Soumyadeep Pal

Developer Link: https://www.github.com/realspal

Game Rules: Based on the original Chain Reaction Android Game

-----------------------------------------------------------------------------------------------

Copyright © 2021 Developer. All rights reserved. No part of this project may be reproduced, stored in a retrieval system, distributed or transmitted in any form or by any means,  electronic, mechanical, photocopying, recording or otherwise, without the prior written permission of the developer, except in the case of personal non-commercial uses permitted by copyright law. For permission requests, write to the developer, addressed “Permission Request”, via LinkedIn at https://www.linkedin.com/in/realspal. Even in such uses, the information contained in this document, the name of the developer and the project link shall not be modified, and must be retained as it is.

-----------------------------------------------------------------------------------------------

About This Repository:
-----------------------------------------------------------------------------------------------

This repository contains a Windows application for playing the Chain Reaction game in 2 player
(player vs player or PvP) mode, created in Java using Swing and AWT. The colored orbs seen
in the game play were created separately using Microsoft Paint. This version features a 9x16
grid for 2 players (Red and Blue) and is capable of invalidating illegal moves and declaring
winner automatically. It also features options for saving an incomplete game and loading a
saved game. The game data files are stored in CRXN file (.crxn) format.

-----------------------------------------------------------------------------------------------

About The Game Chain Reaction (Source - https://brilliant.org/wiki/chain-reaction-game):
-----------------------------------------------------------------------------------------------

Chain reaction is a turn-based deterministic combinatorial strategy game of perfect
information for 2 (to 8) players, played on a rectangular grid. It was originally developed
by Buddy-Matt Entertainment for Android.

Original Play Store Application Link:
https://play.google.com/store/apps/details?id=com.BuddyMattEnt.ChainReaction&hl=en_IN&gl=US

The most interesting thing is how unpredictable the game seems to be in the end, at least
when you play it with your human friends. The obvious heuristic that tells us you're better
off at the moment by having as many orbs as possible turns out to be very wrong. While it so
seems to everyone, that say, red will win, blue suddenly takes over.

-----------------------------------------------------------------------------------------------

Rules Of The Game:
-----------------------------------------------------------------------------------------------

1. The gameplay takes place in an mxn board. The most commonly used size of the board is
   9x6. However, in this project, the size of the board is 9x15 to suit the landscape view.
2. For each cell in the board, we define a critical mass. The critical mass is equal to the
   number of orthogonally adjacent cells. That would be 4 for usual cells, 3 for cells in
   the edge and 2 for cells in the corner.
3. All cells are initially empty. The Red and the Blue players take turns to place “orbs” of
   their corresponding colors. The Red player can only place a red orb in an empty cell or a
   cell which already contains one or more red orbs. When two or more orbs are placed in the
   same cell, they stack up.
4. When a cell is loaded with a number of orbs equal to its critical mass, the stack
   immediately explodes. As a result of the explosion, to each of the orthogonally adjacent
   cells, an orb is added and the initial cell looses as many orbs as its critical mass. The
   explosions might result in overloading of an adjacent cell and the chain reaction of
   explosions continues until every cell is stable.
5. When a red cell explodes and there are blue cells around, the blue cells are converted to
   red and the other rules of explosions still follow. The same rule is applicable for the
   reverse scenario.
6. The winner is the one who eliminates all orbs of the other player.

-----------------------------------------------------------------------------------------------

Message From Developer (Date: 12th September, 2021):
-----------------------------------------------------------------------------------------------

I really enjoyed coding the Windows version of the Chain Reaction game. I hope you will have
fun playing this game and devising your own strategies. For more information, you can contact
me via LinkedIn (https://www.linkedin.com/in/realspal). Thanks for reading. With regards,

Soumyadeep Pal.

-----------------------------------------------------------------------------------------------
