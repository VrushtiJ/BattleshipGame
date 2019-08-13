package battleshipGame.gameStart;

import battleshipGame.enums.Players;
import battleshipGame.enums.State;

import java.util.HashMap;
import java.util.Map;

public class GameBoard {
    public static State[][] myGameBoard1;
    public static State[][] oppGameBoard1;
    public static State[][] myGameBoard2;
    public static State[][] oopGameBoard2;
    public static Map<Players, State[][]> myGameBoardByPlayer;
    public static Map<Players, State[][]> oopGameBoardByPlayer;
    static{
        myGameBoard1 = createPlayer1Board();
        oppGameBoard1 = createEmptyPlayerBoard();
        myGameBoard2 = createPlayer2Board();
        oopGameBoard2 = createEmptyPlayerBoard();
        myGameBoardByPlayer = new HashMap<Players, State[][]>(){
            {
                put(Players.P1, myGameBoard1);
                put(Players.P2, myGameBoard2);
            }
        };

        oopGameBoardByPlayer = new HashMap<Players, State[][]>(){
            {
                put(Players.P1, oopGameBoard2);
                put(Players.P2, oppGameBoard1);
            }
        };
    }

    private static State[][] createEmptyPlayerBoard() {
        State[][] board = new State[10][10];
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                board[i][j] = State.blank;
            }
        }
        return board;
    }

    private static State[][] createPlayer1Board() {
        State[][] board = {
                {State.blank, State.blank, State.blank, State.blank, State.ship, State.ship, State.ship, State.blank, State.blank, State.blank},
                {State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank},
                {State.ship, State.ship, State.ship, State.ship, State.ship, State.blank, State.blank, State.blank, State.blank, State.blank},
                {State.blank, State.blank, State.blank, State.ship, State.ship, State.ship, State.ship, State.blank, State.blank, State.blank},
                {State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.ship, State.blank, State.blank},
                {State.blank, State.blank, State.blank, State.blank, State.ship, State.blank, State.blank, State.ship, State.blank, State.blank},
                {State.blank, State.blank, State.blank, State.blank, State.ship, State.blank, State.blank, State.blank, State.blank, State.blank},
                {State.blank, State.blank, State.blank, State.blank, State.ship, State.blank, State.blank, State.blank, State.blank, State.blank},
                {State.blank, State.blank, State.blank, State.blank, State.ship, State.blank, State.blank, State.blank, State.blank, State.blank},
                {State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank},
        };
        return board;
    }

    private static State[][] createPlayer2Board() {
        State[][] board = {
                {State.blank, State.blank, State.blank, State.blank, State.ship, State.ship, State.ship, State.blank, State.blank, State.blank},
                {State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank},
                {State.ship, State.ship, State.ship, State.ship, State.ship, State.blank, State.blank, State.blank, State.blank, State.blank},
                {State.blank, State.blank, State.blank, State.ship, State.ship, State.blank, State.blank, State.blank, State.blank, State.blank},
                {State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.ship, State.blank, State.blank},
                {State.blank, State.blank, State.blank, State.blank, State.ship, State.blank, State.blank, State.ship, State.blank, State.blank},
                {State.blank, State.blank, State.blank, State.blank, State.ship, State.blank, State.blank, State.ship, State.blank, State.blank},
                {State.blank, State.blank, State.blank, State.blank, State.ship, State.blank, State.blank, State.blank, State.blank, State.blank},
                {State.blank, State.blank, State.blank, State.blank, State.ship, State.blank, State.blank, State.blank, State.blank, State.blank},
                {State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank, State.blank},
        };
        return board;
    }
}
