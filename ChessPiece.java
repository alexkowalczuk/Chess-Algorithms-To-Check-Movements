public class ChessPiece
{
    private int x;
    private int y;
    private boolean isFree;

    public ChessPiece(int x, int y, boolean isFree)
    {
        super();
        this.x = x;
        this.y = y;
        this.isFree = isFree;
    }

    public boolean isFree()
    {
        return isFree;
    }

    public void setFree(boolean isFree)
    {
        this.isFree = isFree;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public boolean isValid(ChestBoard board, int fromX, int fromY, int toX, int toY)
    {
        if (toX == fromX && toY == fromY)
            return false; // because you cant move nothing
        if (toX < 0 || toX > 8 || fromX < 0 || fromX > 8 || toY < 0 || toY > 8 || fromY < 0 || fromY > 8)
            return false;
        return true;
    }






}


