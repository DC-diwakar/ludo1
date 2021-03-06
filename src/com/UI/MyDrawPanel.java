package com.UI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class MyDrawPanel extends JPanel {
    public static final int OFFSET = 0;
    public static final int SPACE = 50;

    public static final int WIDTH = 650;
    public static final int HEIGHT = 650;
    public  int redI[]={-1,-1,-1,-1};
    public  int blueI[]={-1,-1,-1,-1};
    public  int greenI[]={-1,-1,-1,-1};
    public  int yellowI[]={-1,-1,-1,-1};
    public  String chanceToPlay="red";
    public String attacker="";
    public int index = 1;
    public boolean isRedInPlay[]={false,false,false,false};
    public boolean isBlueInPlay[]={false,false,false,false};
    public boolean isYellowInPlay[]={false,false,false,false};
    public boolean isGreenInPlay[]={false,false,false,false};
    public boolean redRoundDone[]={false,false,false,false};
    public boolean blueRoundDone[]={false,false,false,false};
    public boolean yellowRoundDone[]={false,false,false,false};
    public boolean greenRoundDone[]={false,false,false,false};

    private ArrayList<Pieces> allPieces = new ArrayList<Pieces>();
    private ArrayList<MovePiece> movePieces = new ArrayList<MovePiece>();
    private ArrayList<BasePiece> basePieces = new ArrayList<BasePiece>();
    private ArrayList<RedMovePiece> redMovePieces=new ArrayList<RedMovePiece>();
    private ArrayList<BlueMovePiece> blueMovePieces=new ArrayList<BlueMovePiece>();
    private ArrayList<YellowMovePiece> yellowMovePieces=new ArrayList<YellowMovePiece>();
    private ArrayList<GreenMovePiece> greenMovePieces=new ArrayList<GreenMovePiece>();
    public int x = 250;
    public int y = 0;

    private String level =
            "#####&&&#####\n"
                    + "#$$##&B&##$$#\n"
                    + "#$$##&B&##$$#\n"
                    + "#####&B&#####\n"
                    + "#####&B&#####\n"
                    + "&&&&&&B&&&&&&\n"
                    + "&RRRRR#YYYYY&\n"
                    + "&&&&&&G&&&&&&\n"
                    + "#####&G&#####\n"
                    + "#####&G&#####\n"
                    + "#$$##&G&##$$#\n"
                    + "#$$##&G&##$$#\n"
                    + "#####&&&#####\n";

      int[] piecesOrder = {1, 2, 3, 48, 4, 47, 5, 46, 6, 45, 7, 39, 40, 41, 42, 43, 44,
              8, 9, 10, 11, 12, 13, 38, 14, 37, 36, 35, 34, 33, 32, 20,
              19, 18, 17, 16, 15, 31, 21, 30, 22, 29, 23, 28, 24, 27, 26, 25};
      
//      int[] redPath=  {10,11,12,9,13,8,14,7,15,6,16,1,2,3,4,5,17,18,19,20,21,22,47,48,49,50,51,52,53,23,46,45,44,43,42,41,29,28,27,26,25,24,40,30,39,31,38,32,37,33,36,35,34};



    public int diceNumber;

    public int baseIndex=0;
    public MyDrawPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initWorld();
    }

    public final void initWorld() {
        System.out.println("MyDrawing:initWorld");
        int x = OFFSET;
        int y = OFFSET;

        BoardPiece boardPiece;
        MovePiece movePiece;
        BasePiece basePiece;
        RedMovePiece redMovePiece;
        BlueMovePiece blueMovePiece;
        YellowMovePiece yellowMovePiece;
        GreenMovePiece greenMovePiece;
        int ii = 0; 
        int rii=0;
        int bii=0;
        int yii=0;
        int gii=0;
        for (int i = 0; i < level.length(); i++) {

            char item = level.charAt(i);

            if (item == '\n') {
                y += SPACE;
                x = OFFSET;
            } else if (item == '#') {
                boardPiece = new BoardPiece(x, y);
                allPieces.add(boardPiece);
                x += SPACE;
            } else if (item == '&') {
                movePiece = new MovePiece(x, y);
                movePiece.setIndex(piecesOrder[ii]);
                ii++;
                allPieces.add(movePiece);
                movePieces.add(movePiece);

                x += SPACE;
            } else if (item == '$') {
                basePiece = new BasePiece(x, y);
                basePiece.setIndex(baseIndex);
                baseIndex++;
                allPieces.add(basePiece);
                basePieces.add(basePiece);
                x += SPACE;
            }  else if (item == 'R') {
                redMovePiece = new RedMovePiece(x, y);
                redMovePiece.setIndex(rii);
                rii++;
                allPieces.add(redMovePiece);
                redMovePieces.add(redMovePiece);
                x += SPACE;
            }  else if (item == 'B') {
                blueMovePiece = new BlueMovePiece(x, y);
                blueMovePiece.setIndex(bii);
                bii++; 
                allPieces.add(blueMovePiece);
                blueMovePieces.add(blueMovePiece);
                x += SPACE;
            }  else if (item == 'Y') {
                yellowMovePiece = new YellowMovePiece(x, y);
                yellowMovePiece.setIndex(yii);
                yii++;
                allPieces.add(yellowMovePiece);
                yellowMovePieces.add(yellowMovePiece);
                x += SPACE;
            }
               else if (item == 'G') {
                greenMovePiece = new GreenMovePiece(x, y);
                greenMovePiece.setIndex(gii);
                gii++;
                allPieces.add(greenMovePiece);
                greenMovePieces.add(greenMovePiece);
                x += SPACE;
            }




        }
        Collections.sort(movePieces);
       // chanceToPlay="red";
    }


public void attackByRed(int iii)
{
System.out.println("attack by red chali");
for(int x=0;x<4;x++)
{
if(blueI[x]==iii && blueRoundDone[x]==false)
{
blueI[x]=-1;
isBlueInPlay[x]=false;
}
if(yellowI[x]==iii && yellowRoundDone[x]==false)
{
yellowI[x]=-1;
isYellowInPlay[x]=false;
}
if(greenI[x]==iii && greenRoundDone[x]==false)
{
greenI[x]=-1;
isGreenInPlay[x]=false;
}
}
}

public void attackByBlue(int iii)
{
System.out.println("attack by blue chali");
for(int x=0;x<4;x++)
{
if(redI[x]==iii && redRoundDone[x]==false)
{
redI[x]=-1;
isRedInPlay[x]=false;
}
if(yellowI[x]==iii && yellowRoundDone[x]==false) 
{
yellowI[x]=-1;
isYellowInPlay[x]=false;
}
if(greenI[x]==iii && greenRoundDone[x]==false)
{
greenI[x]=-1;
isGreenInPlay[x]=false;
}
}
}

public void attackByYellow(int iii)
{
System.out.println("attack by yellow chali");
for(int x=0;x<4;x++)
{
if(redI[x]==iii && redRoundDone[x]==false)
{
redI[x]=-1;
isRedInPlay[x]=false;
}
if(blueI[x]==iii && blueRoundDone[x]==false)
{
blueI[x]=-1;
isBlueInPlay[x]=false;
}
if(greenI[x]==iii && greenRoundDone[x]==false)
{
greenI[x]=-1;
isGreenInPlay[x]=false;
}
}
}


public void attackByGreen(int iii)
{
System.out.println("attack by green chali");
for(int x=0;x<4;x++)
{
if(redI[x]==iii && redRoundDone[x]==false)
{
redI[x]=-1;
isRedInPlay[x]=false;
}
if(blueI[x]==iii && blueRoundDone[x]==false)
{
blueI[x]=-1;
isBlueInPlay[x]=false;
}
if(yellowI[x]==iii && yellowRoundDone[x]==false)
{
yellowI[x]=-1;
isYellowInPlay[x]=false;
}
}
}

    public void evaluateBasePieces(){

      if(redI[0]!=-1) basePieces.get(0).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage()); 
      else basePieces.get(0).setImage(new ImageIcon(this.getClass().getResource("images/red.png64")).getImage());
      if(redI[1]!=-1) basePieces.get(1).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage()); 
      else basePieces.get(1).setImage(new ImageIcon(this.getClass().getResource("images/red.png64")).getImage());
      if(redI[2]!=-1) basePieces.get(4).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage()); 
      else basePieces.get(4).setImage(new ImageIcon(this.getClass().getResource("images/red.png64")).getImage());
      if(redI[3]!=-1) basePieces.get(5).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage()); 
      else basePieces.get(5).setImage(new ImageIcon(this.getClass().getResource("images/red.png64")).getImage());
                  

      if(blueI[0]!=-1) basePieces.get(2).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage()); 
      else basePieces.get(2).setImage(new ImageIcon(this.getClass().getResource("images/blue.png64")).getImage());
      if(blueI[1]!=-1) basePieces.get(3).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());  
      else basePieces.get(3).setImage(new ImageIcon(this.getClass().getResource("images/blue.png64")).getImage());
      if(blueI[2]!=-1) basePieces.get(6).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
      else basePieces.get(6).setImage(new ImageIcon(this.getClass().getResource("images/blue.png64")).getImage());
      if(blueI[3]!=-1) basePieces.get(7).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
      else basePieces.get(7).setImage(new ImageIcon(this.getClass().getResource("images/blue.png64")).getImage());

      if(greenI[0]!=-1) basePieces.get(8).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
      else basePieces.get(8).setImage(new ImageIcon(this.getClass().getResource("images/green.png64")).getImage());
      if(greenI[1]!=-1) basePieces.get(9).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
      else basePieces.get(9).setImage(new ImageIcon(this.getClass().getResource("images/green.png64")).getImage());
      if(greenI[2]!=-1) basePieces.get(12).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
      else basePieces.get(12).setImage(new ImageIcon(this.getClass().getResource("images/green.png64")).getImage());
      if(greenI[3]!=-1) basePieces.get(13).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
      else basePieces.get(13).setImage(new ImageIcon(this.getClass().getResource("images/green.png64")).getImage());

      if(yellowI[0]!=-1) basePieces.get(10).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
      else basePieces.get(10).setImage(new ImageIcon(this.getClass().getResource("images/yellow.png64")).getImage());
      if(yellowI[1]!=-1) basePieces.get(11).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
      else basePieces.get(11).setImage(new ImageIcon(this.getClass().getResource("images/yellow.png64")).getImage());
      if(yellowI[2]!=-1) basePieces.get(14).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
      else basePieces.get(14).setImage(new ImageIcon(this.getClass().getResource("images/yellow.png64")).getImage());
      if(yellowI[3]!=-1) basePieces.get(15).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
      else basePieces.get(15).setImage(new ImageIcon(this.getClass().getResource("images/yellow.png64")).getImage());

     }





    public void buildWorld(Graphics g) {
        System.out.println("MyDrawPanel:buildWorld\n");
        evaluateBasePieces();
        for (int i = 0; i < allPieces.size(); i++) {
            Pieces item = (Pieces) allPieces.get(i);
            g.drawImage(item.getImage(), item.x(), item.y(), this);
        }
        g.fillRect(300,300,50,50);
        g.setColor(Color.orange);
        g.setFont(new Font("Verdana",Font.BOLD, 18));
              g.drawString(String.valueOf(diceNumber), 318,330);
        Image image=null;
        for(int i=0;i<4;i++)
        {
        if(redI[i]!=-1 && redI[i]!=-10)
         {        
         image = new ImageIcon(this.getClass().getResource("images/red"+i+".png64")).getImage();
         if(!redRoundDone[i])
         { 
         g.drawImage(image,movePieces.get(redI[i]).x(),movePieces.get(redI[i]).y(),this);
         if(attacker=="red") attackByRed(redI[i]);
         }
         else g.drawImage(image,redMovePieces.get(redI[i]).x(),redMovePieces.get(redI[i]).y(),this);
         } 
        if(blueI[i]!=-1 && blueI[i]!=-10)
         {
         image = new ImageIcon(this.getClass().getResource("images/blue"+i+".png64")).getImage();
         if(!blueRoundDone[i])
         { 
         g.drawImage(image,movePieces.get(blueI[i]).x(),movePieces.get(blueI[i]).y(),this);
         if(attacker=="blue") attackByBlue(blueI[i]);
         }      
         else g.drawImage(image,blueMovePieces.get(blueI[i]).x(),blueMovePieces.get(blueI[i]).y(),this);
         }
        if(yellowI[i]!=-1 && yellowI[i]!=-10)
         {
         image = new ImageIcon(this.getClass().getResource("images/yellow"+i+".png64")).getImage();
         if(!yellowRoundDone[i])
         {
         g.drawImage(image,movePieces.get(yellowI[i]).x(),movePieces.get(yellowI[i]).y(),this);
         if(attacker=="yellow") attackByYellow(yellowI[i]);
         } 
         else g.drawImage(image,yellowMovePieces.get(yellowI[i]).x(),yellowMovePieces.get(yellowI[i]).y(),this);   
         }
         if(greenI[i]!=-1 && greenI[i]!=-10)
         {
         image = new ImageIcon(this.getClass().getResource("images/green"+i+".png64")).getImage();
         if(!greenRoundDone[i])
         { 
          g.drawImage(image,movePieces.get(greenI[i]).x(),movePieces.get(greenI[i]).y(),this);
          if(attacker=="green") attackByGreen(greenI[i]);
         } 
         else g.drawImage(image,greenMovePieces.get(greenI[i]).x(),greenMovePieces.get(greenI[i]).y(),this);
         }
        }         
    }
   
public void updateChanceToPlay()
{
System.out.println(chanceToPlay);
if(chanceToPlay.equals("red"))
{
attacker="red";
if(this.diceNumber==6) return;
chanceToPlay="blue";
}
else
{
if(chanceToPlay.equals("blue"))
{
attacker="blue";
if(this.diceNumber==6) return;
chanceToPlay="yellow";
}
else
{
if(chanceToPlay.equals("yellow"))
{
attacker="yellow";
if(this.diceNumber==6) return;
chanceToPlay="green";
}
else
{
if(chanceToPlay.equals("green"))
{
attacker="green";
if(this.diceNumber==6) return;
chanceToPlay="red";
}
else if(chanceToPlay.equals("")) chanceToPlay="red";
}
}
}
}



    public void move(int diceNumber,int pieceId) {
           System.out.println("PieceID:"+pieceId); 
          int temp=0;
       if(chanceToPlay.equals("red"))
        {     
            if(redI[pieceId]==-10)
             {
              updateChanceToPlay();
              return;
             }
             System.out.println(redI[pieceId]);
            if(isRedInPlay[pieceId]==false && diceNumber==6)
             {
              diceNumber=1;
              redI[pieceId]=39-1;
              isRedInPlay[pieceId]=true;
             }
             if(isRedInPlay[pieceId]==false && diceNumber!=6)
             {
              repaint();
              updateChanceToPlay();
              return;
             }
               temp=redI[pieceId];
           while (diceNumber > 0) {
            // x = movePieces.get(redI[0]).x();
           // y = movePieces.get(redI[0]).y();
            redI[pieceId]=redI[pieceId]+1;
            if(redI[pieceId]>47)
           {
            redI[pieceId]=0;
           }
            if(redRoundDone[pieceId]==true && redI[pieceId]>4)
            { 
              if(redI[pieceId]==5) {
                 redI[pieceId]=-10;
                 updateChanceToPlay();
                } 
               else redI[pieceId]=temp;
              repaint();
              updateChanceToPlay();
              return;
            }
            if (redI[pieceId]==38) {
                 redRoundDone[pieceId]=true;
                 redI[pieceId]=0;               
            }
            diceNumber--;
       //     diceNumber=0;
           repaint();
        }
         // repaint();     
    }
         else
         {
          if(chanceToPlay.equals("blue"))
          {   System.out.println(blueI[pieceId]);
             if(blueI[pieceId]==-10) {
               updateChanceToPlay();
               return;
              }
             if(isBlueInPlay[pieceId]==false && diceNumber==6)
             {
              diceNumber=1;
              blueI[pieceId]=3-1;
              isBlueInPlay[pieceId]=true;
             }
             if(isBlueInPlay[pieceId]==false && diceNumber!=6)
             {
              repaint();
              updateChanceToPlay();
              return;
             }
              temp=blueI[pieceId];
            while (diceNumber > 0) {
            // x = movePieces.get(blueI[0]).x();
           // y = movePieces.get(blueI[0]).y();

           blueI[pieceId]=blueI[pieceId]+1;
            if (blueI[pieceId] > 47) {
                 blueI[pieceId]= 0;
            }
              if(blueRoundDone[pieceId]==true && blueI[pieceId]>4)
              {  
               if(blueI[pieceId]==5)
               { 
               blueI[pieceId]=-10;
               isBlueInPlay[pieceId]=false;
               } 
              else blueI[pieceId]=temp;
              repaint();
              updateChanceToPlay();
              return;
             }
            if (blueI[pieceId]==2 && blueRoundDone[pieceId]==false) {
                 blueRoundDone[pieceId]=true;
                 blueI[pieceId]=0;
            }

           diceNumber--;
//            diceNumber=0;
          repaint();
        }
          } 
          else
          {
           if(chanceToPlay.equals("yellow"))
            { System.out.println(yellowI[pieceId]);
              if(yellowI[pieceId]==-10) 
              { 
              updateChanceToPlay();
              return; 
              }
             if(isYellowInPlay[pieceId]==false && diceNumber==6)
             {
              diceNumber=1;
              yellowI[pieceId]=15-1;
              isYellowInPlay[pieceId]=true;
             }
             if(isYellowInPlay[pieceId]==false && diceNumber!=6)
             {
              repaint();
               updateChanceToPlay();
              return;
             }
               temp=yellowI[pieceId];
                 while (diceNumber > 0) {
    //        x = movePieces.get(yellowI[0]+diceNumber).x();
      //      y = movePieces.get(yellowI[0]+diceNumber).y();


            if(yellowRoundDone[pieceId])
             {
              yellowI[pieceId]=yellowI[pieceId]-1;
              }
            else
             { 
            yellowI[pieceId]=yellowI[pieceId]+1;
             }


            if (yellowI[pieceId] > 47) {
                 yellowI[pieceId]= 0;
            }

              if(yellowRoundDone[pieceId]==true && yellowI[pieceId]<0)
             {  
              if(yellowI[pieceId]==-1)
                { 
                yellowI[pieceId]=-10;
                isYellowInPlay[pieceId]=false; 
               }
              else yellowI[pieceId]=temp;
              repaint();
              updateChanceToPlay();
              return;
            }
         



            if (yellowI[pieceId]==14) {
                 yellowRoundDone[pieceId]=true;
                 yellowI[pieceId]=4;
            }

           diceNumber--;
         //    diceNumber=0;
             repaint();
        }
   

 //     repaint();
    }
            else
            {
            if(chanceToPlay.equals("green"))
             { 
               if(greenI[pieceId]==-10)
               {
                updateChanceToPlay();
                return;
               }
               System.out.println(greenI[pieceId]);
               if(isGreenInPlay[pieceId]==false && diceNumber==6)
              {
               diceNumber=1;
               greenI[pieceId]=27-1;
               isGreenInPlay[pieceId]=true;
              }
              if(isGreenInPlay[pieceId]==false && diceNumber!=6)
              {
               repaint();
                updateChanceToPlay();
               return;
              }
                temp=greenI[pieceId];
                while (diceNumber > 0) {
       //      x = movePieces.get(greenI[0]+diceNumber).x();
         //   y  = movePieces.get(greenI[0]+diceNumber).y();
              if(greenRoundDone[pieceId])
             {
             greenI[pieceId]=greenI[pieceId]-1;   
             }
             else
            {
            greenI[pieceId]=greenI[pieceId]+1;
            }
              if (greenI[pieceId] > 47) {
                 greenI[pieceId]= 0;
            }

                if(greenRoundDone[pieceId]==true && greenI[pieceId]<0)
              {
               if(greenI[pieceId]==-1) {
                  greenI[pieceId]=-10;
                  isGreenInPlay[pieceId]=false;
                }
               else  greenI[pieceId]=temp;
              repaint();
               updateChanceToPlay();
              return;
            }
            if (greenI[pieceId]==26) {
                 greenRoundDone[pieceId]=true;
                 greenI[pieceId]=4;
            }



     diceNumber--;
         //   diceNumber=0;
           repaint();

        }
    }
             } 
            }
          }
               updateChanceToPlay();
         }
          

    

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    System.out.println("MyDrawingPanel:paint");  
     buildWorld(g);
    }


    public void restart() {
        x = 250;
        y = 0;
        index = 1;
        initWorld();
    }

}
