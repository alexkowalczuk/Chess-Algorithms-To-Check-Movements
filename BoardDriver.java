import java.util.*;
import java.io.*;
import java.util.Objects;

public class BoardDriver
{
//throws all of mine exception :)
    public static void main(String[] args) throws IOException, OutOfBoardException, IllegalChessMoveException, PathwayException {
        ChestBoard board = new ChestBoard();
        board.ChestBoard();

        Scanner scan = new Scanner(new File( "input/input.txt" )); //reading my file
        String line;
        String[] lineSegment;


        while(scan.hasNextLine())
        {
            line = scan.nextLine();
            lineSegment = line.split(" ");


            try { //for exceptions
                if (lineSegment[0].equals( "knight" )) {
                    int x = Integer.parseInt( lineSegment[1] );
                    int y = Integer.parseInt( lineSegment[2] );
                    board.setPiece( new Knight( x, y, true ), x, y );
                }
                // System.out.println("hello knight "+lineSegment[1]+" "+lineSegment[2]);
                else if (lineSegment[0].equals( "pawn" )) {
                    int x = Integer.parseInt( lineSegment[1] );
                    int y = Integer.parseInt( lineSegment[2] );
                    board.setPiece( new Pawn( x, y, true ), x, y );
                } else if (lineSegment[0].equals( "rook" )) {
                    int x = Integer.parseInt( lineSegment[1] );
                    int y = Integer.parseInt( lineSegment[2] );
                    board.setPiece( new Rook( x, y, true ), x, y );
                } else if (lineSegment[0].equals( "bishop" )) {
                    int x = Integer.parseInt( lineSegment[1] );
                    int y = Integer.parseInt( lineSegment[2] );
                    board.setPiece( new Bishop( x, y, true ), x, y );
                } else if (lineSegment[0].equals( "move" )) { //reading move from the file and printing it down on the board.
                    board.move( Integer.parseInt( lineSegment[1] ), Integer.parseInt( lineSegment[2] ), Integer.parseInt( lineSegment[3] ), Integer.parseInt( lineSegment[4] ) );
                }

            } catch (Exception e){ // finding all of mine exceptions and printing ;)
                System.out.println(e);
            }
        }



        /*
        board.move( 5,5,5,6 );
        board.move( 5,6,5,7 );
        board.move( 5,7,5,8 );
        board.move( 1,5,1,6 );
        board.move( 3,3,2,5 );

        board.move( 2,5,6,1 );
        board.move( 6,1,2,5 );
        board.move( 2,5,0,7 );

*/





        System.out.println(board.toString());




    }

    }
