package chess;

public class Knight extends Piece
{
 Knight(String colour)
  {
	  colorpiece = colour;
	  status = 0;
  }  
  
  boolean validMoveOfPiece(int xi,int yi,int xf,int yf)
  {
	  // check whether move is valid or not
	    if((xi-1)==xf && (yi+2)==yf) 
			return true;
		
		else if((xi-1)==xf && (yi-2)==yf)
            return true;
		
		else if((xi+1)==xf && (yi-2)==yf)
            return true;
		
		else if((xi+1)==xf && (yi+2)==yf)
            return true;
                        
        else if((xi-2)==xf && (yi+1)==yf)						
            return true;
		
		else if((xi-2)==xf && (yi-1)==yf)
            return true;
		
		else if((xi+2)==xf && (yi+1)==yf)
            return true;
		
		else if((xi+2)==xf && (yi-1)==yf)
            return true;
		
		else
			return false;
  }
}