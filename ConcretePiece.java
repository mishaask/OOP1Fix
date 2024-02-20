import java.util.ArrayList;

import static java.lang.Math.abs;

public abstract class ConcretePiece implements Piece {
    public int nKills;
    public Position position;
    public Player pieceOwner;
    public String pieceString;
    protected int number;
    public int totalDistance = 0;
    private final ArrayList<Position> Moves = new ArrayList<>();

    @Override
    public Player getOwner() {
        return pieceOwner;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {this.number = number;}
    public void removeLastMove(){
        Moves.removeLast();
    }

    @Override
    public String getType() {
        return null;
    }
    public String getString(){return pieceString;}

    public void setPosition(Position newPos){
        position = newPos;
        Moves.add(newPos);
    }
    public ArrayList<Position> getMoves(){
        return Moves;
    }
    public void addKill(){nKills++;}
    public void deductKill(){nKills--;}
    public int getKills(){return nKills;}
    public void calDistance(){
        totalDistance = 0;
        for(int i = 1; i< getMoves().size(); i++){
            totalDistance += abs(getMoves().get(i).getX() - getMoves().get(i-1).getX()) + abs(getMoves().get(i).getY() - getMoves().get(i-1).getY());
        }
    }
    public int getTotalDistance(){return totalDistance;}
}


