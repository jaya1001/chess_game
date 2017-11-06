package chess;
class Pawn extends Piece
{
  Pawn(String colour)
  {
	  colorpiece = colour;
	  status = 0;
  }  
  
  boolean validMoveOfPiece(int xi,int yi,int xf,int yf)
  {
	  // check whether move is valid or not
	  if((yf-yi)==0)
	  {
        if(colorpiece=="white" && xi==1)
	    {
		  if((xf-xi)==2||(xf-xi)==1)
		  {
			  return true;
		  }
		  
		  else
		  {
			  return false;
		  }
	    }
		
		else if(colorpiece=="black" && xi==6)
		{
		  if((xf-xi)==-2||(xf-xi)==-1)
		  {
			  return true;
		  }
		  
		  else
		  {
			  return false;
		  }
	    }

        else if(colorpiece=="white")
		{
		  if((xf-xi)==1)
		  {
			  return true;
		  }
		}
 
        else
		{
		  if((xi-xf)==1)
		  {
			  return true;
		  }
		}			
	  }
	  
	  if(Math.abs(yi-yf)==1)
	  {
		  return true;
	  }
	  
	  return false;
	  
  }
}