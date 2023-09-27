import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Erstellen eines TicTacToeBoard-Objekts
        Board board = new Board();
        // Erstellen von Spieler-Objekten 1 ('X') und Spieler-Objekt 2 ('O')
        Player player1 = new Player('X');
        Player player2 = new Player('O');

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Anzeigen des aktuellen Spielfelds
            board.printBoard();
            // Ermitteln des aktuellen Spielers ('X' oder 'O')
            Player currentPlayer = (board.getCurrentPlayer() == player1.getSymbol()) ? player1 : player2;
            System.out.println("Spieler " + currentPlayer.getSymbol() + ", geben Sie Ihre Koordinaten ein (senkrecht horizontal): ");

            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (board.isValidMove(row, col)) {
                    // Wenn der Zug gültig ist, wird der zug dargestellt
                    board.makeMove(row, col, currentPlayer.getSymbol());
                    if (board.checkWin(currentPlayer.getSymbol())) {
                        // Überprüfen auf Gewinner
                        board.printBoard();
                        System.out.println("Spieler " + currentPlayer.getSymbol() + " gewinnt!");
                        break;
                    } else if (board.isBoardFull()) {
                        // Überprüfen auf ein Unentschieden
                        board.printBoard();
                        System.out.println("Unentschieden!");
                        break;
                    }
                    // Spieler wechseln
                    board.togglePlayer();
                }
                else {
                    System.out.println("Ungültiger Zug. Bitte erneut versuchen.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Bitte gebe Zeile und Spalte als ganze Zahlen ein.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}



