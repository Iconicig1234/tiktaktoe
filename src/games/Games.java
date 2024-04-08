package games;

import java.util.*;
import player.Player;
import board.Board;

public class Games {
    Player [] players;
    Board board;
    int turn;
    int no_of_moves;
    boolean game_over;
    String zero;
    String cross;

    public Games(Player[] players, Board board){
        this.players = players;
        this.turn = 0;
        this.board = board;
        this.no_of_moves = 0;
        this.game_over = false;

        StringBuilder z = new StringBuilder();
        StringBuilder c = new StringBuilder();

        for(int i=0;i<board.size;i++){
            z.append('O');
            c.append('X');
        }

        this.zero = z.toString();
        this.cross = c.toString();
    }

public void printBoardConfig(){
    int sz = board.size;
    for(int i=0;i<sz;i++){
        for(int j=0;j<sz;j++){
            System.out.print(board.matrix[i][j]+" ");
        }
        System.out.println();
    }
}

public void play(){
    printBoardConfig();

    int sz = board.size;

    while(!game_over){
        no_of_moves++;
    
        int idx = get_index();
        int row = idx/sz;
        int col = idx%sz;
    
        board.matrix[row][col] = players[turn].getPlayers_Symbol();
    
        if(no_of_moves >= sz*sz){
            System.out.println("Game Over!!");
            return;
        }
    
        if(no_of_moves>=2*sz-1 && Is_Valid_Combination()){
            game_over = true;
            printBoardConfig();
            System.out.println("Winner is :" + players[turn].getPlayers_Name());
            return;
        }

        turn = (turn+1)%2; //if turn = 0 -> 1%2=1; else turn=1 -> 2%2=0
        printBoardConfig();
    }
}

public int get_index(){
    while(true){
    System.out.println("Player "+players[turn].getPlayers_Name()+" enter the position:");
    Scanner scn = new Scanner(System.in);
    int posn = scn.nextInt()-1;

    int sz = board.size;

    int row = posn/sz;
    int col = posn%sz;

    if(row<0 || row>=sz || col<0 || col>=sz){
        System.out.println("Invalid position entered - try again");
        continue;
    }

    else if(board.matrix[row][col]!='-'){
        System.out.println("Position is already occupied - try again");
        continue;
    }

    return posn;
    }
}

public boolean Is_Valid_Combination(){
    int sz = board.size;

    //rowise
    for(int i=0;i<sz;i++){
        StringBuilder s = new StringBuilder();
        for(int j=0;j<sz;j++){
            s.append(board.matrix[i][j]);
        }
        String str = s.toString();
        if(str.equals(zero) || str.equals(cross)) return true;
    }

    //columnwise
    for(int i=0;i<sz;i++){
        StringBuilder s = new StringBuilder();
        for(int j=0;j<sz;j++){
            s.append(board.matrix[j][i]);
        }
        String str = s.toString();
        if(str.equals(zero) || str.equals(cross)) return true;
    }

    //diagonal row++, col++
    int i=0,j=0;
    StringBuilder s = new StringBuilder();
    while(i<sz){
        s.append(board.matrix[i][j]);
        i++; j++;
    }
    String str = s.toString();
    if(str.equals(zero) || str.equals(cross)) return true;

    //anti-diagonal row++,col--;
    i=0; j=sz-1;
    s = new StringBuilder();
    while(i<sz){
        s.append(board.matrix[i][j]);
        i++; j--;
    }
    str = s.toString();
    if(str.equals(zero) || str.equals(cross)) return true;

    return false;
}


}
