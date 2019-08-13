package battleshipGame.services;

import battleshipGame.domain.Request;
import battleshipGame.domain.Response;
import battleshipGame.enums.Players;
import battleshipGame.gameStart.GameBoard;
import battleshipGame.processor.MissilePosition;
import battleshipGame.enums.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameService {

    @Autowired
    MissilePosition missilePosition;

    public Response fireMissiles(Request request){
        String gameStatus = missilePosition.isGameEnded();
        //Check if game has ended or not
        if(gameStatus!=null){
            return new Response("Game has ended. "+gameStatus+" has won the game! Please start a new game.", null);
        }
        //Get the status of missile fire either miss/hit
        State fireStatus = missilePosition.fireMissile(request.getRowNum(), request.getColNum(), Players.valueOf(request.getPlayer()));
        //Check if all the miss are hit or not
        boolean areAllShipHist = missilePosition.areAllShipsHit(Players.valueOf(request.getPlayer()));
        String message=fireStatus.toString();
        if(areAllShipHist){
            message="All ships are hit!! you've won the game.";
        }
        State[][] updatedBoard = missilePosition.myGameBoard(Players.valueOf(request.getPlayer()));
        Response response = new Response(message, updatedBoard);
        return  response;
    }

    public Response showMyOriginalBoard(String player){
        State[][] board = GameBoard.myGameBoardByPlayer.get(Players.valueOf(player));
        return  new Response(null, board);
    }

    public Response showMyGameBoard(String player){
        State[][] board = GameBoard.oopGameBoardByPlayer.get(Players.valueOf(player));
        return new Response(null, board);
    }

}
