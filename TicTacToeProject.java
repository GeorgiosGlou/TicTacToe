package gr.aueb.cf.miniprojects;

import java.util.Scanner;

public class TicTacToeProject {

    public static void main(String[] args) {

        char[][]gameBoard={{' ',' ',' '}, {' ',' ',' '}, {' ',' ',' '}};
       printBoard(gameBoard);
       while (!gameIsfinished(gameBoard)){
           playerTurn(gameBoard);
           printBoard(gameBoard);
           break;
       }
    }

    public static void printBoard(char[][]gameBoard){
        System.out.println(gameBoard[0][0]+"|"+gameBoard[0][1]+"|"+gameBoard[0][2]);
        System.out.println(gameBoard[1][0]+"|"+gameBoard[1][1]+"|"+gameBoard[1][2]);
        System.out.println(gameBoard[2][0]+"|"+gameBoard[2][1]+"|"+gameBoard[2][2]);
    }

    public static void putInPosition(int position, int player, char[][] gameBoard) {
        char character='p';

        if (player == 1) {
            character = 'X';
        } else if (player==2){
            character = 'O';
        }

        switch (position) {

            case 1:
                gameBoard[0][0] = character;
                printBoard(gameBoard);
                break;
            case 2:
                gameBoard[0][1] = character;
                printBoard(gameBoard);
                break;
            case 3:
                gameBoard[0][2] = character;
                printBoard(gameBoard);
                break;
            case 4:
                gameBoard[1][0] = character;
                printBoard(gameBoard);
                break;
            case 5:
                gameBoard[1][1] = character;
                printBoard(gameBoard);
                break;
            case 6:
                gameBoard[1][2] = character;
                printBoard(gameBoard);
                break;
            case 7:
                gameBoard[2][0] = character;
                printBoard(gameBoard);
                break;
            case 8:
                gameBoard[2][1] = character;
                printBoard(gameBoard);
                break;
            case 9:
                gameBoard[2][2] = character;
                printBoard(gameBoard);
                break;

            default:
                break;
        }
    }

    static public boolean isPositionFree(char[][] gameBoard,int position){
        switch (position) {

            case 1:
                return (gameBoard[0][0]==' ');
            case 2:
                return (gameBoard[0][1]==' ');
            case 3:
                return (gameBoard[0][2]==' ');
            case 4:
                return (gameBoard[1][0]==' ');
            case 5:
                return (gameBoard[1][1]==' ');
            case 6:
                return (gameBoard[1][2]==' ');
            case 7:
                return (gameBoard[2][0]==' ');
            case 8:
                return (gameBoard[2][1]==' ');
            case 9:
                return (gameBoard[2][2]==' ');
            default:
                return false;
        }
    }

    public static void playerTurn(char[][]gameBoard){
        Scanner in=new Scanner(System.in);
        int move;
        int player=1;
        System.out.println("The game starts!!");
        System.out.println("Player1 is making the first move:(1-9)");
        move = in.nextInt();
        putInPosition(move,player,gameBoard);
        while (!gameIsfinished(gameBoard)){
            if (player==1){
                player=2;
            }else player=1;
            System.out.println("Please make your next move:(1-9)");
            move = in.nextInt();
            if (isPositionFree(gameBoard,move)){
                putInPosition(move,player,gameBoard);
            }else {
                System.out.println("Please select a valid position");
                if (player==1){
                    player=2;
                }else player=1;

            }
        }
    }

    public static boolean gameIsfinished(char[][]gameBoard){
        if (hasPlayerWon(gameBoard,'X')){
            printBoard(gameBoard);
            System.out.println("Player 1 wins!");
            return true;
        } else if (hasPlayerWon(gameBoard,'O')) {
            printBoard(gameBoard);
            System.out.println("Player 2 wins!");
            return true;
        }


        for (int i=0;i< gameBoard.length;i++){
            for (int j=0;j<gameBoard[i].length;j++){
                if (gameBoard[i][j]==' '){
                    return false;
                }
            }
        }
        printBoard(gameBoard);
        System.out.println("We have a tied game");
        return true;
    }

    public static boolean hasPlayerWon(char [][]gameBoard,char symbol){
        if (    (gameBoard[0][0]==symbol && gameBoard[0][1]==symbol && gameBoard[0][2]==symbol) ||
                (gameBoard[1][0]==symbol && gameBoard[1][1]==symbol && gameBoard[1][2]==symbol ) ||
                (gameBoard[2][0]==symbol && gameBoard[2][1]==symbol && gameBoard[2][2]==symbol ) ||
                (gameBoard[0][0]==symbol && gameBoard[1][0]==symbol && gameBoard[2][0]==symbol) ||
                (gameBoard[0][1]==symbol && gameBoard[1][1]==symbol && gameBoard[2][1]==symbol ) ||
                (gameBoard[0][2]==symbol && gameBoard[1][2]==symbol && gameBoard[2][2]==symbol ) ||
                (gameBoard[0][0]==symbol && gameBoard[1][1]==symbol && gameBoard[2][2]==symbol)||
                (gameBoard[0][2]==symbol && gameBoard[1][1]==symbol && gameBoard[2][0]==symbol )){
            return true;
        }
        return false;
    }
}

