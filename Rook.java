package chess;

class Rook extends Piece
{
 Rook(String colour)
  {
	  colorpiece = colour;
	  status = 0;
  }  
  
  boolean validMoveOfPiece(int xi,int yi,int xf,int yf)
  {
	  // check whether move is valid or not
	  if((xi-xf)==0 || (yi-yf)==0)
	  {
		  return true;
      }	  
	  else
	  {
		  return false;
      }	  
  }
}