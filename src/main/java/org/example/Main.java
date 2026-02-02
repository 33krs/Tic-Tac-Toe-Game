package org.example;



import java.util.Scanner;

public class Main {
    static  String[] board;
    static String turn;

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        board = new String[9];
        turn = "";
        String winner;


        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
        System.out.println("Bienvenido a 3x3 TicTacToe");
//        System.out.println("X's empiezan, ingrese el numero que quiere marcar: ");

        //turn = turn.equals("X") ? "O" : "X";
        while(true){

            int num;
            turn = turn.equals("X") ? "O" : "X";
            while(true){
                printBoard();
                System.out.println("Es el turno de las "+ turn + "'s, ingrese el numero de casilla que quiere marcar: ");
                num = scanner.nextInt();
                //Validacion de casilla
                if (!(num > 0 && num <= 9)){
                    System.out.println("Por favor, ingrese un numero entre el 1 al 9...");
                    continue;
                }

                if (board[num - 1].contains(Integer.toString(num))) {
                    break;
                }else{
                    System.out.println("Casilla ocupada, ingresa otro numero.");
                }

            }
            board[num - 1] = turn;

            winner = checkWinner();
            if(winner != null){
                printBoard();
                if(winner.equals("Empate")){
                    System.out.println("Es un empate!!");
                }else {
                    System.out.println("Ganador: "+winner+"!!");
                }
                break;
            }
        }

        scanner.close();

    }

    static void printBoard(){
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }

    static String checkWinner(){
        for(int i=0; i < 8; i++){
            String line=null;

            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
                default:
                    break;
            }

            if(line.equalsIgnoreCase("XXX")){
                return "X";
            }else if(line.equalsIgnoreCase("OOO")){
                return "O";
            }
        }

//        for (int i = 0; i < 9; i++) {
//            if (Arrays.asList("1","2","3","4","5","6","7","8","9").contains(board[i])) {
//                return null;
//            }
//        }

        for(int i = 0 ; i < 9 ; i++){
            if(!board[i].equals("X") && !board[i].equals("O")){
                return null;
            }
        }
        return "Empate";


    }


}
