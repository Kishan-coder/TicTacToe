import com.scaler.model.CellSymbol;
import com.scaler.model.Game;
import com.scaler.model.player.Level;
import com.scaler.model.player.Player;
import com.scaler.model.player.PlayerType;
import com.scaler.model.player.UserRegistry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestTicTacToe {

    Game game;

    @BeforeEach
    public void setUp(){
        UserRegistry.registerUser("Kishan", new byte[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0});// id: 1
        UserRegistry.registerUser("Karan", new byte[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1});// id: 2
        UserRegistry.registerUser("Naman", new byte[]{1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0});// ..
        UserRegistry.registerUser("Priyam", new byte[]{0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0});
        game = new Game();
    }

    @Test
    public void testGameOfBotVsMan(){
        game.start(3, PlayerType.computer, PlayerType.human, Level.easy, 1);
        List<Player> players = game.getPlayers();
        Player currentPlayer = players.get(0).getPlayerSymbol().equals(CellSymbol.x) ? players.get(0) : players.get(1);
        System.out.println(String.format("Player 1 is %s while Player 2 is %s and game starts with %s", players.get(0).getPlayerSymbol(),
                players.get(1).getPlayerSymbol(), currentPlayer.getPlayerSymbol()));
        int totalMoves = 0;
        while (true){
            totalMoves += 1;
            System.out.print(String.format("Player %s makes move:", currentPlayer.getPlayerSymbol()));
            currentPlayer.playMove(game);
            if (game.isOver() || areAllCellsExhausted(totalMoves, game)) {
                System.out.println(String.format("Congrats!! Player %s won the game", currentPlayer.getPlayerSymbol()));
                return;
            }
            currentPlayer = (currentPlayer == players.get(0)) ? players.get(1) : players.get(0);
        }
    }

    private boolean areAllCellsExhausted(int totlaMoves, Game g){
        return totlaMoves == g.getBoard().getSize()*g.getBoard().getSize()? true: false;
    }

    @Test
    public void testInvalidBoard(){
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            game.start(1, PlayerType.computer, PlayerType.human, Level.easy, 1);
        });
    }
}
