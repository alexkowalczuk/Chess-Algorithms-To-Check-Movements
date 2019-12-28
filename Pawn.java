public class Pawn extends ChessPiece
{
    public Pawn (int x, int y, boolean isFree)
    {
        super(x, y, isFree);
    }

    @Override
    public boolean isValid(ChestBoard board, int fromX, int fromY, int toX, int toY)
    {
        if(super.isValid( board, fromX, fromY, toX, toY ) == false)
            return false;
        if(toY == fromY)
            return true;

        return false;

    }



    @Override
    public String toString(){
        return " -p- ";
    }
}



