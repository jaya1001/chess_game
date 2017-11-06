package chess;

class Queen extends Piece
{
 Queen(String colour)
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
	  
	  else if((xi-xf)==0 || (yi-yf)==0)
	  {
		  return true;
      }
	  
	  else
	  {
		  return false;
	  }
  }
}