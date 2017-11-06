package chess;
import java.lang.*;
public class Board
{
  Square bo[][] = new Square[8][8];
  King k[] = new King[2];
  Queen q[] = new Queen[2];
  Rook r[] = new Rook[4];
  Bishop b[] = new Bishop[4];
  Knight kn[] = new Knight[4];
  Pawn pn[] = new Pawn[16];
  
 
  Board()                                            // CONSTRUCTOR.....
  {
    k[0] = new King("white");
    k[1] = new King("black");
    q[0] = new Queen("white");
    q[1] = new Queen("black");
    r[0] = new Rook("white");
    r[1] = new Rook("white");
    r[2] = new Rook("black");
    r[3] = new Rook("black");
    b[0] = new Bishop("white");
    b[1] = new Bishop("white");
    b[2] = new Bishop("black");
    b[3] = new Bishop("black");
    kn[0] = new Knight("white");
    kn[1] = new Knight("white");
    kn[2] = new Knight("black");
    kn[3] = new Knight("black");
  
    for(int i=0;i<8;i++)
	   pn[i] = new Pawn("white");
 
    for(int i=8;i<16;i++)
	   pn[i] = new Pawn("black");
  
    for(int i=0;i<8;i++)
     {
	   for(int j=0;j<8;j++)
	    {
		  bo[i][j] = new Square();  
	    }
     }	  
  }
  
  
  // TYPE OF PIECE METHOD.....
  private Piece typeOfPiece(int xi,int yi)
  {
	return bo[xi][yi].p1;  
  }
  
  
  // MOVE METHOD.....
  boolean move(String color,int xi,int yi,int xf,int yf)
  {
	  Piece p = typeOfPiece(xi,yi);                               // FINDS THE TYPE OF PIECE.....
	  System.out.println("color of piece at initial position...... " +p.colorpiece);
	  
	  boolean ch = false;                                         //initialize ch.....
	
	  if(p.colorpiece == color)                                   // check color of player and piece.....              
	  {
	    boolean valid = p.validMoveOfPiece(xi,yi,xf,yf);          // IS THE MOVE VALID FOR PIECE.....            
		System.out.println("Is the move valid for piece....... " +valid);  
		
	    if(valid)
	    {
           boolean ch1 = validMoveOfGame(p,xi,yi,xf,yf);		   // IS THE MOVE VALID FOR GAME.....
		   System.out.println("   "+ch1);
           return ch1;			   
		}
	  }                                             // end of loop for color
	  
      else
	    ch = false;
	
	  return ch;
  }
  
  // CHECK IF THE FINAL POSITION IS FREE OR OCCUPIED BY OTHER SIDE AND UPDATE THE STATUS.....
  boolean update(String color,int xi,int yi,int xf,int yf)
  {
	  if(bo[xf][yf].p1==null)
      {
		  bo[xf][yf].p1 = bo[xi][yi].p1;
		  bo[xi][yi].p1 = null;
		  return true;
	  }	

      if(bo[xf][yf].p1!=null)
      {
		  if(bo[xf][yf].p1.colorpiece == color)
			  return false;
		  
		  else
		  {
		    bo[xf][yf].p1.status = -1;
			bo[xf][yf].p1 = bo[xi][yi].p1;
		    bo[xi][yi].p1 = null;
			return true;
		  }
	  }	
      return false;	  
  }
  
  // DISPLAY OF THE BOARD.....
  void display()
  {
	for(int i=7;i>=0;i--)
	{
		for(int j=0;j<8;j++)
		{
			Piece d = bo[i][j].p1;
			if( d == null)
				System.out.print("[ ]\t");
			
			else if(d.colorpiece == "white")
			{
		      if(d==k[0])
				System.out.print("king,w\t");
			
			  else if(d==r[0] || d==r[1])
				System.out.print("rook,w\t");  
			
			  else if(d==kn[0] || d==kn[1])
				System.out.print("niht,w\t");

              else if(d==b[0] || d==b[1])
				System.out.print("biso,w\t");

              else if(d==q[0])
				System.out.print("quen,w\t"); 

              else
				System.out.print("pawn,w\t"); 				  
			}
			
			else if(d.colorpiece == "black")
			{
		      if(d==k[1])
				System.out.print("king,b\t");
			
			  else if(d==r[2] || d==r[3])
				System.out.print("rook,b\t");  
			
			  else if(d==kn[2] || d==kn[3])
				System.out.print("niht,b\t");

              else if(d==b[2] || d==b[3])
				System.out.print("biso,b\t");

              else if(d==q[1])
				System.out.print("quen,b\t"); 

              else
				System.out.print("pawn,b\t"); 				  
			}
		}
		System.out.println();
	}
    System.out.println();	
  }
  
  
  boolean validMoveOfGame(Piece p,int xi,int yi,int xf,int yf)
  {
	   // check the valid move in game
	   boolean ch = false; 	                                               // initialize ch.....
	   int y = yi;
	    // FOR ROOK.....
		
	      if(p==r[0] || p==r[1] || p==r[2] || p==r[3])                     
            {
		      if (xi == xf && Math.abs(yi-yf)!=1)                          // SAME ROW.....
	           {
                 int dx = (yi < yf) ? 1 : -1;
                 for (int i = yi + dx; i != yf; i += dx)
		         {
			        if (bo[xi][i].p1 != null)
                        return false;
					
					else
						ch = true;
		         }
               } 
	
       	      else if (yi == yf && Math.abs(xi-xf)!=1)                     // SAME COLUMN.....
	           { 
                 int dy = (xi < xf) ? 1 : -1;
                 for (int i = xi + dy; i != xf; i += dy)
		         { 
			        if (bo[i][yi].p1 != null)
                        return false;
					
					else
						ch = true;
		         }
               }
	  
              else 
	           { 
                  ch = true;
               }
            }
           
		  // FOR BISHOP.....
		  
		   else if(p==b[0] || p==b[1] || p==b[2] || p==b[3])
		    {
			  if((xi-xf)==(yi-yf) && Math.abs(xi-xf)!=1)                        // BOTH ROW AND COLUMN INCREAING OR DECREASING.....
			   {
			     int dx = (xi < xf) ? 1 : -1;
                 for(int i = xi + dx; i!=xf;i += dx)
				 {
				    y = y+dx;
					if(bo[i][y].p1 != null)
                        return false; 

                    else
                        ch = true;						
				 }					 
			   }

              else if((xi-xf)==(yf-yi) && Math.abs(xi-xf)!=1)                   // INVERSE FOR ROW AND COLUMN.....
			   {
				 int dx = (xi < xf) ? 1 : -1;
                 for(int i = xi + dx; i!=xf;i += dx)
				 {
					y = y-dx;
					if(bo[i][y].p1 != null)
                        return false; 

                    else
                        ch = true;						
				 }	 
			   }

              else
			   {
				  ch = true;  
			   }				  
		    }
			
		  // FOR KNIGHT.....
		  
           else if(p==kn[0] || p==kn[1] || p==kn[2] || p==kn[3])   
		    {
			    ch = true;
		    }	
 
          // FOR QUEEN.....
		  
           else if(p==q[0] || p==q[1])
		    {
			   if (xi == xf && Math.abs(yi-yf)!=1)                                //  SAME ROW.....
	           {
                 int dx = (yi < yf) ? 1 : -1;
                 for (int i = yi + dx; i != yf; i += dx)
		         {
			        if (bo[xi][i].p1 != null)
                        return false;
					
					else
						ch = true;
		         }
               } 
	
       	       else if (yi == yf && Math.abs(xi-xf)!=1)                            //  SAME COLUMN.....
	           { 
                 int dy = (xi < xf) ? 1 : -1;
                 for (int i = xi + dy; i != xf; i += dy)
		         { 
			        if (bo[i][yi].p1 != null)
                        return false;
					
					else
						ch = true;
		         }
               }
			   
			   else if((xi-xf)==(yi-yf) && Math.abs(xi-xf)!=1)
			   {
			     int dx = (xi < xf) ? 1 : -1;
                 for(int i = xi + dx; i!=xf;i += dx)
				 {
					y = y+dx;
					if(bo[i][y].p1 != null)
                        return false;

                    else
                        ch = true;						
				 }					 
			   }

               else if((xi-xf)==(yf-yi) && Math.abs(xi-xf)!=1)	
			   {
				 int dx = (xi < xf) ? 1 : -1;
                 for(int i = xi + dx; i!=xf;i += dx)
				 {
					y = y-dx;
					if(bo[i][y].p1 != null)
                        return false; 	

                    else
                        ch = true;						
				 }	 
			   }
			   
			   else 
	           { 
                  ch = true;
               }
            }	
          
		  // FOR KING..... 
		  
            else if(p==k[0] || p==k[1])                                 
		    {
			    ch = true;
		    }			
			
		  // FOR PAWN.....
			else
			{
				if((yf-yi)==0 && bo[xf][yf].p1!=null)                                 // NO ELEMENT AT DIAGONAL POSITION.....
					return false;
				
				else if(Math.abs(xf-xi)==2)
				{
					int dx = (xi < xf) ? 1 : -1;
				    if(bo[xi+dx][yi].p1 != null)
					  return false;
				
				    else
					  ch = true;
				}
				
				// FOR PAWN ATTACKING MOVE.....
			    else if((xf-xi)==1 && Math.abs(yf-yi)==1)
			    {     
		          if(p.colorpiece == "white" && bo[xf][yf].p1!=null)
			      {
					  return true;
				  }
				  
			      else
			         ch = false;
			    }
			
			
			    else if((xi-xf)==1 && Math.abs(yf-yi)==1)
			    {
				  if(p.colorpiece == "black" && bo[xf][yf].p1!=null)
			      {
					  return true;
				  }
				 
				  else
					ch = false;
			    }
			 
			    else
				  ch = true;
			}
	    return ch;		                                    
    }
  
  
  // FOR CHECKMATE CONDITION METHOD.....
  boolean checkPlayer(String color,int xi,int yi)
  {
	 int xc=-1,yc=-1;
	 boolean ch = false;
	 for(int i=0;i<8;i++)                                                  // STORE POSITION OF KING....
	 {
		for(int j=0;j<8;j++)
		 {
			if(color =="white" && bo[i][j].p1 == k[0])            
			{
				xc = i;
				yc = j;
			}

            if(color =="black" && bo[i][j].p1 == k[1])
			{
				xc = i;
				yc = j;
			}			
		 }
	 }
	 
	 if(color == "black")                                                  // FOR BLACK COLOUR.....
	 {
       if((xc-xi)==0)                                                      // IF KING AND PIECE WERE IN SAME ROW.....
	   {
		 for(int i=0;i<8;i++)
		 {
			 if(bo[xc][i].p1==null)
			 {
				 ch = false; 
			 }
			 
			 else if(bo[xc][i].p1.colorpiece == "white")
			 {
				 if(bo[xc][i].p1 == r[0] || bo[xc][i].p1 == r[1] || bo[xc][i].p1 == q[0])
				 {
					 if(validMoveOfGame(bo[xc][i].p1,xc,i,xc,yc))
					     return true;
					 
					 else
						 ch = false;
				 }
				 
				 else
					 ch = false;
			 }
			 
			 else
				 ch = false;
		 }
	   }
	   
	   else if((yc-yi)==0)                                       // IF PIECE AND KING WERE IN SAME COLUMN.....
	   {
		 for(int i=0;i<8;i++)
		 {
			 if(bo[i][yc].p1==null)
			 {
				 ch = false; 
			 }
			 
			 else if(bo[i][yc].p1.colorpiece == "white")
			 {
				 if(bo[i][yc].p1 == r[0] || bo[i][yc].p1 == r[1] || bo[i][yc].p1 == q[0])
				 {
					 if(validMoveOfGame(bo[i][yc].p1,xc,i,xc,yc))
					     return true;
					 
					 else
						 ch = false;
				 }
				 
				 else
					 ch = false;
			 }
			 
			 else
				 ch = false;
		 }
	   }
	   
	   else if((xi-xc) == (yi-yc))                                               // IF PIECE AND KING WERE DIAGONALLY PRESENT.....
	   {
	    int dx = (xi > xc) ? 1 : -1;
		int x = xc+dx;
		int y = yc+dx;
		while((x<8 && x>-1) && (y<8 && y>-1))
		 {
			 if(bo[x][y].p1==null)
			 {
				 ch = false; 
			 }
			 
			 else if(bo[x][y].p1.colorpiece == "white")
			 {
				 if(bo[x][y].p1 == b[0] || bo[x][y].p1 == b[1] || bo[x][y].p1 == q[0])
				 {
					 if(validMoveOfGame(bo[x][y].p1,x,y,xc,yc))
					     return true;
					 
					 else
						 ch = false;
				 }
				 
				 else
					 ch = false;
			 }
			 
			 else
				 ch = false;
			 x = x+dx;
			 y = y+dx;
		 }   
	   }
	   
	   else if((xi-xc) == (yc-yi))                                  // IF PIECE AND KING WERE DIAGONALLY PRESENT IN ANOTHER DIRECTION.....
	   {
	    int dx = (xi > xc) ? 1 : -1;
		int x = xc+dx;
		int y = yc-dx;
		while((x<8 && x>-1) && (y<8 && y>-1))
		 {
			 if(bo[x][y].p1==null)
			 {
				 ch = false; 
			 }
			 
			 else if(bo[x][y].p1.colorpiece == "white")
			 {
				 if(bo[x][y].p1 == b[0] || bo[x][y].p1 == b[1] || bo[x][y].p1 == q[0])
				 {
					 if(validMoveOfGame(bo[x][y].p1,x,y,xc,yc))
					     return true;
					 
					 else
						 ch = false;
				 }
				 
				 else
					 ch = false;
			 }
			 
			 else
				 ch = false;
			 x = x+dx;
			 y = y-dx;
			 
		 }   
	   }
	   
	   else
		   ch = false;
	 }
	 
	 else                                                    // FOR WHITE COLOUR.....
	 {
       if((xc-xi)==0)                                               // IF KING AND PIECE WERE IN SAME ROW.....
	   {
		 for(int i=0;i<8;i++)
		 {
			 
			 if(bo[xc][i].p1==null)
			 {
				 ch = false; 
			 }
			 
			 else if(bo[xc][i].p1.colorpiece == "black")
			 {
				 if(bo[xc][i].p1 == r[2] || bo[xc][i].p1 == r[3] || bo[xc][i].p1 == q[1])
				 {
					 if(validMoveOfGame(bo[xc][i].p1,xc,i,xc,yc))
					     return true;
					 
					 else
						 ch = false;
				 }
				 
				 else
					 ch = false;
			 }
			 
			 else
				 ch = false;
		 }
	   }
	   
	   else if((yc-yi)==0)                                               // IF KING AND PIECE WERE IN SAME COLUMN.....
	   {
		 for(int i=0;i<8;i++)
		 {
			 if(bo[i][yc].p1==null)
			 {
				 ch = false; 
			 }
			 
			 else if(bo[i][yc].p1.colorpiece == "black")
			 {
				 if(bo[i][yc].p1 == r[2] || bo[i][yc].p1 == r[3] || bo[i][yc].p1 == q[1])
				 {
					 if(validMoveOfGame(bo[i][yc].p1,xc,i,xc,yc))
					     return true;
					 
					 else
						 ch = false;
				 }
				 
				 else
					 ch = false;
			 }
			 
			 else
				 ch = false;
		 }
	   }
	   
	   else if((xi-xc) == (yi-yc))                                   // IF KING AND PIECE WERE PRESENT DIAGONALLY.....
	   {
	    int dx = (xi > xc) ? 1 : -1;
		int x = xc+dx;
		int y = yc+dx;
		while((x<8 && x>-1) && (y<8 && y>-1))
		 {
			 if(bo[x][y].p1==null)
			 {
				 ch = false; 
			 }
			 
			 else if(bo[x][y].p1.colorpiece == "black")
			 {
				 if(bo[x][y].p1 == b[2] || bo[x][y].p1 == b[3] || bo[x][y].p1 == q[1])
				 {
					 if(validMoveOfGame(bo[x][y].p1,x,y,xc,yc))
					     return true;
					 
					 else
						 ch = false;
				 }
				 
				 else
					 ch = false;
			 }
			 
			 else
				 ch = false;
			 x = x+dx;
			 y = y+dx;
		 }   
	   }
	   
	   else if((xi-xc) == (yc-yi))                                     // IF KING AND PIECE WERE IN PRESENT DIAGONALLY IN ANOTHER DIRECTION.....
	   {
	    int dx = (xi > xc) ? 1 : -1;
		int x = xc+dx;
		int y = yc-dx;
		while((x<8 && x>-1) && (y<8 && y>-1))
		 {
			 if(bo[x][y].p1==null)
			 {
				 ch = false; 
			 }
			 
			 else if(bo[x][y].p1.colorpiece == "black")
			 {
				 if(bo[x][y].p1 == b[2] || bo[x][y].p1 == b[3] || bo[x][y].p1 == q[1])
				 {
					 if(validMoveOfGame(bo[x][y].p1,x,y,xc,yc))
					     return true;
					 
					 else
						 ch = false;
				 }
				 
				 else
					 ch = false;
			 }
			 
			 else
				 ch = false;
			 x = x+dx;
			 y = y-dx;
		 }   
	   }
	   
	   else
		   ch = false;
	 }
	 return ch;
  }
}