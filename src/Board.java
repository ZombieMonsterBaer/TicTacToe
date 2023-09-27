class Board {
    private char[][] board;
    private char currentPlayer;

    public Board() {
        // Vorbereiten des Spielfelds und des aktuellen Spielers
        board = new char[4][4];
        initializeBoard();
        currentPlayer = 'X';
    }

    public void initializeBoard() {
        // Spielfeld mit leeren Feldern vorbereiten
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        // Spielfeld anzeigen
        System.out.println("  1   2   3");
        for (int i = 1; i < 4; i++) {
            System.out.print(i + " ");
            for (int j = 1; j < 4; j++) {
                System.out.print(board[i][j]);
                if (j < 3) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 3) {
                System.out.println("  --+---+--");
            }
        }
        System.out.println();
    }

    public boolean isValidMove(int row, int col) {
        // Überprüfen, ob Zug gültig ist
        return (row >= 1 && row < 4 && col >= 1 && col < 4 && board[row][col] == ' ');
    }

    public void makeMove(int row, int col, char symbol) {
        // Zug auf dem Spielfeld ausführen
        board[row][col] = symbol;
    }

    public boolean checkWin(char symbol) {
        // Überprüfen, ob Spieler gewonnen hat
        // Gewinnbedingungen für Zeilen, Spalten und Diagonalen überprüfen
        for (int i = 1; i < 4; i++) {
            if (board[i][1] == symbol && board[i][2] == symbol && board[i][3] == symbol) {
                return true;
            }
            if (board[1][i] == symbol && board[2][i] == symbol && board[3][i] == symbol) {
                return true;
            }
        }
        if (board[1][1] == symbol && board[2][2] == symbol && board[3][3] == symbol) {
            return true;
        }
        if (board[1][3] == symbol && board[2][2] == symbol && board[3][1] == symbol) {
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
        // Überprüfen, ob Spielfeld voll (Unentschieden)
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public char getCurrentPlayer() {
        // Symbol des aktuellen Spielers zurückgeben
        return currentPlayer;
    }

    public void togglePlayer() {
        // Aktuellen Spieler wechseln
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}


