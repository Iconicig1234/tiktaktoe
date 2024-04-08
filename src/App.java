import java.util.*;
import board.Board;
import player.Player;
import games.Games;

public class App {
    public App(){

    }
    public static void main(String[] args) throws Exception {
        System.out.println("tic-tac-toe!");
        
        //to take input from the user.
        /*Scanner sr = new Scanner(System.in);
        String name = sr.nextLine();
        int age = sr.nextInt(); 
        char symbol = sr.nextLine().charAt(0);*/

        //printing the initial board config.
        Board b = new Board(3,'-');
        b.printBoardConfig();

        //setting players details.
        Player p1 = new Player();
        p1.setPlayers_Detail("Ipshita", 20, 'X', "okipshi@gmail.com", 987654321);

        Player p2 = new Player();
        p2.setPlayers_Detail("Sakshi", 20, 'O', "sharmasakshi@gmail.com", 987654320);

        //getting players detail
        /*System.out.println("player1-Details:-");
        p1.getPlayers_Detail();

        System.out.println("player2-Details:-");
        p2.getPlayers_Detail();*/

        //changing symbol
        /*p1.change_symbol('Y');
        char newsymbol = p1.getPlayers_Symbol();
        System.out.println(newsymbol);*/

        // getting name and symbol
        p1.getPlayers_Name_Symbol();
        p2.getPlayers_Name_Symbol();

        Games game = new Games(new Player[] {p1,p2}, b);
        game.play();

    }
}
