import javax.swing.*;

public class Connect4Model {
    private int[][] board;
    private int playersTurn;
    private boolean gameWon;
    private int[] coordinates;
    private int[][] winnerMoves;

    public Connect4Model(){
        board = new int[6][7];
        playersTurn = 0;
        gameWon = false;
        coordinates = new int[0];
        winnerMoves = new int[2][4];
    }

    public int[][] getBoard()
    { return board; }

    public int getPlayersTurn()
    { return playersTurn; }

    public boolean getGameIsWon()
    { return gameWon; }


    public void makeMove(int col){
        int k = -1;
        for(int i = board.length-1;i >= 0; i--){
            if(board[i][col] == 0){ k = i; break;}
        }
        if(validateMove(col)) {
            if(playersTurn % 2 == 0){ board[k][col] = 1; }
            else{ board[k][col] = 2; }
            addCoordinates(col,k);
            playersTurn++;
        }
    }

    public int[] getCoordinates(){
        return coordinates;
    }

    public void addCoordinates(int x,int y){
        int[] cords = new int[coordinates.length + 2];
        for(int i = 0; i < coordinates.length; i++){
            cords[i] = coordinates[i];
        }
        cords[cords.length-2] = x;
        cords[cords.length-1] = y;
        coordinates = cords;
    }

    private boolean validateMove(int col){
        boolean validMove = true;
        if(board[0][col] != 0){
            JOptionPane.showMessageDialog(null, "ERROR: Full column.\nTry another.");
            validMove = false;
        }
        return validMove;
    }

    public void checkForWin(){
        if(playersTurn >= 7){
            for(int i = 0; i < board.length; i++){//horizontal
                for(int j = 0; j < board[0].length-3; j++){
                    if(board[i][j]!=0 && board[i][j]==board[i][j+1] && board[i][j+1]==board[i][j+2] && board[i][j+2]==board[i][j+3]) {
                        gameWon = true;
                        winnerMoves[0][0] = i; winnerMoves[1][0] = j;
                        winnerMoves[0][1] = i; winnerMoves[1][1] = j+1;
                        winnerMoves[0][2] = i; winnerMoves[1][2] = j+2;
                        winnerMoves[0][3] = i; winnerMoves[1][3] = j+3;
                    }
                }
            }

            for(int i = 0; i < board.length-3; i++){//vertical
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j]!=0 && board[i][j]==board[i+1][j] && board[i+1][j]==board[i+2][j] && board[i+2][j]==board[i+3][j]) {
                        gameWon = true;
                        winnerMoves[0][0] = i; winnerMoves[1][0] = j;
                        winnerMoves[0][1] = i+1; winnerMoves[1][1] = j;
                        winnerMoves[0][2] = i+2; winnerMoves[1][2] = j;
                        winnerMoves[0][3] = i+3; winnerMoves[1][3] = j;
                    }
                }
            }

            for(int i = 0; i < board.length-3; i++){
                for(int j = 0; j < board[0].length-3; j++){//diagonal
                    if(board[i][j]!=0 && board[i][j]==board[i+1][j+1] && board[i+1][j+1]==board[i+2][j+2] && board[i+2][j+2]==board[i+3][j+3]) {
                        gameWon = true;
                        winnerMoves[0][0] = i; winnerMoves[1][0] = j;
                        winnerMoves[0][1] = i+1; winnerMoves[1][1] = j+1;
                        winnerMoves[0][2] = i+2; winnerMoves[1][2] = j+2;
                        winnerMoves[0][3] = i+3; winnerMoves[1][3] = j+3;
                    }
                }
                for(int j = board[0].length-1; j >= 3; j--){//antidiagonal
                    if(board[i][j]!=0 && board[i][j]==board[i+1][j-1] && board[i+1][j-1]==board[i+2][j-2] && board[i+2][j-2]==board[i+3][j-3]) {
                        gameWon = true;
                        winnerMoves[0][0] = i; winnerMoves[1][0] = j;
                        winnerMoves[0][1] = i+1; winnerMoves[1][1] = j-1;
                        winnerMoves[0][2] = i+2; winnerMoves[1][2] = j-2;
                        winnerMoves[0][3] = i+3; winnerMoves[1][3] = j-3;
                    }
                }
            }
        }
    }

    public int[][] getWinnersMoves(){ return  winnerMoves; }

    public int wonGame(){
        int winner = 0;
        if(gameWon){
            if(playersTurn % 2 == 1){ winner = 1; }
            else if(playersTurn % 2 == 0){ winner = 2; }
            else{ winner = 0; }
        }
        return winner;
    }
}
