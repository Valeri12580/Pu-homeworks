import engine.Game;
import models.player.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private  static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Player firstPlayer = initPlayer('w');
        Player secondPlayer =initPlayer('b');

        List<Player> playerList = Arrays.asList(firstPlayer, secondPlayer);

        Game game = new Game(scanner, playerList);

        game.run();


    }

    public static Player initPlayer(char color){
        System.out.println("Enter the name of the player:");
        return new Player(scanner.nextLine(),color);
    }



}
