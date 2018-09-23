# chess_game
In this project, I have tried to implement the game of Chess using the concepts of Object Oriented Programming. Basically, we can of the
entities involved in the game of chess like the board, the pieces like King, Queen, Pawn, Bishop etc. as the objects which will be related
to each other.

So Classes involved in this game can be:
Driver Class
Board Class
Piece Class(abstract)
King, Queen, Bishop, Pawn, Rook etc. will be the subclasses extending the Piece class forming is-a relationship(Inheritance in OOP).

Now, Board class will be having two players with corresponding color of pieces(white or black). Board class will be having pieces(King,
Queen, Pawns etc.), thus giving the has-a relationship(composition in OOP).

Again these pieces subclasses will be implementing the validMove() method accordingly as we know from the rules of the game.  
