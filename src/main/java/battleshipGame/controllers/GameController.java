package battleshipGame.controllers;


import battleshipGame.domain.Request;
import battleshipGame.domain.Response;
import battleshipGame.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("/fireMissile")
    public Response fireMissile(@RequestParam("player") String player, @RequestParam("rowNum") int rowNum, @RequestParam("colNum") int colNum){
        System.out.println("Inside fireMissile");
        Request request = new Request(player, rowNum, colNum);
        Response response = gameService.fireMissiles(request);

        return response;
    }

    @GetMapping("/showOppositionOriginalBoard")
    public Response showMyOriginalBoard(@RequestParam("player") String player){
        Response response = gameService.showMyOriginalBoard(player);
        System.out.println("Inside showMyOriginalBoard");
        return response;
    }

    @GetMapping("/showMyGameBoard")
    public Response show(@RequestParam("player") String player){
        Response response = gameService.showMyGameBoard(player);

        return response;
    }

    @GetMapping("/test")
    public String res(@RequestParam("player") String player){
        return "Check";
    }

}
