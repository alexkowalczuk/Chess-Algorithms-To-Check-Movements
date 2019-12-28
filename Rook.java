public class Rook extends ChessPiece
{
    public Rook(int x, int y, boolean isFree) {
        super(x, y, isFree);


        }
        @Override
        public boolean isValid(ChestBoard board, int fromX, int fromY, int toX, int toY) {
            if(super.isValid(board, fromX, fromY,toX,toY) == false)
                return false; //check if its empty. for loop ex. exception(bounce out of bpard)
            if(toX == fromX)
                return true;
            if(toY == fromY)
                return true;
            return false;
        }



        @Override
        public String toString(){
            return " -r- ";
        }
}
