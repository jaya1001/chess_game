package chess;
import java.lang.*;
class Bishop extends Piece
{
 Bishop(String colour)
  {
	  colorpiece = colour;
	  status = 0;
  }  
  
  boolean validMoveOfPiece(int xi,int yi,int xf,int yf)
  {
	  // check whether move is valid or not
	  if(Math.abs(xi-xf) == Math.abs(yi-yf))
	  {
	      return true;
	  }
	  else
	  {
		  return  false;
	  }
  }
}