package battleshipGame.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Request {

    public Request(){}
    String player;
    int rowNum;
    int colNum;
}
