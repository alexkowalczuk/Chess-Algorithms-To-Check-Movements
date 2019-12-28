import java.util.ArrayList;


public class Player {
    public final int PAWNS = 8;
    public final int BISHOPS = 2;
    public final int ROOKS = 2;
    public boolean white;

    private ArrayList<ChessPiece> ChessPiece = new ArrayList<>();

    public Player(boolean white) {
        super();
        this.white = white;
    }

    public ArrayList<ChessPiece> getChessPiece() {
        return ChessPiece;
    }


    public void initializePieces(){
        if(this.white == true){
            for(int i=0; i<PAWNS; i++){ // draw pawns
               // ChessPiece.add(new Pawn(true,i,2));
            }
            //ChessPiece.add(new Rook(isFree: ));
            ChessPiece.add(new Rook(7, 0, true));
            //ChessPiece.add(new Bishop(true, 2, 0));
            //ChessPiece.add(new Bishop(true, 5, 0));
            //ChessPiece.add(new Knight(true, 1, 0));
            //ChessPiece.add(new Knight(true, 6, 0));
        }
        else{
            for(int i=0; i<PAWNS; i++){ // draw pawns
               // ChessPiece.add(new Pawn(true,i,6));
            }
            ChessPiece.add(new Rook(0, 7, true));
            //ChessPiece.add(new Rook(true, 7, 7));
            //ChessPiece.add(new Bishop(true, 2, 7));
            //ChessPiece.add(new Bishop(true, 5, 7));
            //ChessPiece.add(new Knight(true, 1, 7));
            //ChessPiece.add(new Knight(true, 6, 7));

        }

    }

        }

