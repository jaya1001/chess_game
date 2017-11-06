package chess;

abstract class Piece
{
  String colorpiece;
  int status;
  int x,y;
  
  abstract boolean validMoveOfPiece(int xi,int yi,int xf,int yf);
}