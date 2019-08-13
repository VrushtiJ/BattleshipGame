package battleshipGame.processor;

import battleshipGame.gameStart.GameBoard;
import battleshipGame.enums.Players;
import battleshipGame.enums.State;
import org.springframework.stereotype.Component;

@Component
public class MissilePosition {


    public State fireMissile(int row, int col, Players currPlayer){
        Players oppPlayer = findOppPlayer(currPlayer);
        State[][] originalBoard = GameBoard.myGameBoardByPlayer.get(oppPlayer);
        State[][] gameBoard = GameBoard.oopGameBoardByPlayer.get(currPlayer);
        State fireState;
        if((State.ship).equals(originalBoard[row][col])){
            originalBoard[row][col]= State.hit;
            gameBoard[row][col]= State.hit;
            fireState = State.hit;
        }
        else{
            originalBoard[row][col]= State.miss;
            gameBoard[row][col] = State.miss;
            fireState = State.miss;
        }
        GameBoard.myGameBoardByPlayer.put(oppPlayer, originalBoard);
        GameBoard.oopGameBoardByPlayer.put(currPlayer, gameBoard);
        return fireState;
    }

    private Players findOppPlayer(Players player) {
        if(Players.P1.equals(player)){
            return Players.P2;
        }
        return Players.P1;
    }

    public boolean areAllShipsHit(Players p){
        Players oppPlayer = findOppPlayer(p);
        State[][] board = GameBoard.myGameBoardByPlayer.get(oppPlayer);
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(State.ship.equals(board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    public State[][] myGameBoard(Players p){
        return GameBoard.oopGameBoardByPlayer.get(findOppPlayer(p));
    }

    public String   isGameEnded(){
        if(areAllShipsHit(Players.P1)){
            return "Player 2";
        }
        if(areAllShipsHit(Players.P2)){
            return "Player 1";
        }
        return null;
    }

}
