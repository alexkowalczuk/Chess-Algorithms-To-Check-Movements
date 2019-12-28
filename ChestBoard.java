import static java.lang.System.*;

public class ChestBoard {
    private String[][] board;
    private static final int ROWS = 8;
    private static final int COLUMNS = 8;

    //Constructs an empty board.
    public void ChestBoard() {
        board = new String[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLUMNS; j++)
                //numerate board (rows)
                board[i][j] = " --- ";
        }

    public String toString()
    {

        int count = 7;
        String r = "";
        String last = "=== "+ " =0= "+ " =1= "+ " =2= "+ " =3= "+ " =4= "+ " =5= "+ " =6= "+ " =7="; //hard code last row of table.
        for (int i = 0; i < COLUMNS; i++) {
            r = r + "=" +count+"=" + " ";
            count = count - 1;
            for (int j = 0; j < ROWS; j++)
                r = r + board[COLUMNS -i-1][j]; //going from the bottom left to the top right
            r = r + "\n\n";
        }
        return r + last;

    }

    public boolean setPiece(ChessPiece piece, int ROWS, int COLUMNS) //setting piece on the board if its empty " --- "
    {
        if (this.board[COLUMNS][ROWS].equals( " --- " ) )
        {
            this.board[COLUMNS][ROWS ] = piece.toString();
            return true;
        }
        else
        {
            return false;
        }
    }

    boolean checkKnight(int x1, int y1, int x2, int y2){ //function to check knight move
        int trueX = Math.abs(x2 - x1  ); //absolute value to get good results
        int trueY = Math.abs( y2 - y1 );

        if (trueX == 2 && trueY == 1 || trueX ==1 && trueY ==2){
            return true;
        }
        return  false;
    }

//throws exceptions
    boolean move(int x1, int y1, int x2, int y2) throws OutOfBoardException, PathwayException, IllegalChessMoveException {

        if (x1 >= COLUMNS ||x2 >= COLUMNS ||y1 >= COLUMNS ||y2 >= COLUMNS || x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0 ){
            throw new OutOfBoardException("You tried to move out of board.... -.- "); //printing messages for exceptions

        }

        String piece = board[y1][x1];

        if (piece.equals(" --- ") || !board[y2][x2].equals(" --- ")){
            throw new PathwayException( "There is something on the way bro.... -,- " );

        } else if (piece.equals(" -p- ")){ //pawn

            if(x1 == x2){
                if ((y2 == y1 + 1 || y1 == 0 && y2 == 2)&& y2 < COLUMNS){ //if pawn is in first row then can go 2 up. if not then one up.
                    board[y2][x2] = " -p- ";
                    board[y1][x1] = " --- ";
                }
            } else {
                throw new IllegalChessMoveException( "Do you even chess bro? -,-" );
            }

        } else if (piece.equals( " -r- " )){ //rookie

            if(x1 == x2){ // left - right move
                if(y2 > y1 ) {
                    for (int i = y1 + 1; i <= y2; i++) {
                        if (!board[i][x1].equals( " --- " )) {
                            throw new PathwayException( "There is something on the way bro.... -,- " );
                        }
                    }
                } else if (y1 > y2){
                    for (int i = y2; i < y1; i++) {
                        if (!board[i][x1].equals( " --- " )) {
                            throw new PathwayException( "There is something on the way bro.... -,- " );
                        }
                    }
                }

                board[y2][x2] = " -r- ";
                board[y1][x1] = " --- ";
                return true;

            } else if (y1 == y2) { //up down move
                if (x2 > x1) {
                    for (int i = x1 + 1; i <= x2; i++) {
                        if (!board[y1][i].equals( " --- " )) {
                            throw new PathwayException( "There is something on the way bro.... -,- " );
                        }
                    }
                } else if (x1 > x2){
                    for (int i = x2 ; i < x1; i++) {
                        if (!board[y1][i].equals( " --- " )) {
                            throw new PathwayException( "There is something on the way bro.... -,-  " );
                        }
                    }
                }
                board[y2][x2] = " -r- ";
                board[y1][x1] = " --- ";
                return true;

            }

        }
        else if (piece.equals(" -h- ")){

            if(checkKnight( x1, y1, x2, y2 )){
                board[y2][x2] = " -h- ";
                board[y1][x1] = " --- ";
                return true;
            } else {
                throw new IllegalChessMoveException( "Do you even chess bro? -,- " );
            }

        }else if (piece.equals(" -b- ")){
            if (Math.abs( x2 - x1  )== Math.abs( y2 - y1 )){ //absolute value
                if(Math.signum( x2 - x1 ) == Math.signum( y2 - y1 )){ // checking if difference is negative
                    if (Math.signum( x2 - x1 ) == 1){
                        for(int i = x1 + 1; i < x2; i++){
                            for(int j = y1+ 1; j < y2; j++ ){
                                if (!board[j][i].equals( " --- " )){
                                    throw new PathwayException( "There is something on the way bro.... -,-  " );
                                }
                            }
                        }
                    } else if (Math.signum( x2 - x1 ) == -1) {
                        for(int i = x1 -1; i > x2; i--){
                            for(int j = y1 - 1; j > y2; j-- ){
                                if (!board[j][i].equals( " --- " )){
                                    throw new PathwayException( "There is something on the way bro.... -,-  " );
                                }
                            }
                        }
                    }

                } else if(Math.signum( x2 - x1 ) == -Math.signum( y2 - y1 )){
                    if (Math.signum( x2 - x1 ) == 1){
                        for(int i = x1 + 1; i < x2; i++){
                            for(int j = y1 - 1; j > y2; j-- ){
                                if (!board[j][i].equals( " --- " )){
                                    throw new PathwayException( "There is something on the way bro.... -,-  " );
                                }
                            }
                        }
                    } else if (Math.signum( x2 - x1 ) == -1) {
                        for(int i = x1 -1; i > x2; i--){
                            for(int j = y1+ 1; j < y2; j++ ){
                                if (!board[j][i].equals( " --- " )){
                                    throw new PathwayException( "There is something on the way bro.... -,-  " );
                                }
                            }
                        }
                    }

                }
                board[y2][x2] = " -b- ";
                board[y1][x1] = " --- ";
                return true;
            }
        }
    return false;
    }
}