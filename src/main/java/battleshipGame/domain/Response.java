package battleshipGame.domain;


import battleshipGame.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {

    String result;
    State[][] board;
}
