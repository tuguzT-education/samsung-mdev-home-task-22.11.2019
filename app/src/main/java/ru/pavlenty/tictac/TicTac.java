package ru.pavlenty.tictac;

public class TicTac {

        public static final int SIDE = 3;
        private int turn;
        private int [][] game;

        public TicTac( ) {
            // инициализация game?

            resetGame( );
        }

        public int play( int row, int col ) {
            int currentTurn = turn;
            if( row >= 0 && col >= 0 && row < SIDE && col < SIDE
                    && game[row][col] == 0 ) {
                game[row][col] = turn;
                if( turn == 1 )
                    turn = 2;
                else
                    turn = 1;

                // что-то нужно вернуть?
                return 0;

            }
            else
                return 0;
        }

        public int whoWon( ) {
            int rows = checkRows( );
            if ( rows > 0 )
                return rows;
            int columns = checkColumns( );
            if( columns > 0 )
                return columns;
            int diagonals = checkDiagonals( );
            if( diagonals > 0 )
                return diagonals;
            return 0;
        }

        protected int checkRows( ) {
            for( int row = 0; row < SIDE; row++ )
                if ( game[row][0] != 0 && game[row][0] == game[row][1]
                        && game[row][1] == game[row][2] )
                    return game[row][0];
            return 0;
        }

        protected int checkColumns( ) {
            for( int col = 0; col < SIDE; col++ )
                if ( game[0][col] != 0 && game[0][col] == game[1][col]
                        && game[1][col] == game[2][col] )

                    return game[0][col];
            return 0;
        }

        protected int checkDiagonals( ) {
            if ( game[0][0] != 0 && game[0][0] == game[1][1]
                    && game[1][1] == game[2][2] )
                return game[0][0];
            if ( game[0][2] != 0 && game[0][2] == game[1][1]
                    && game[1][1] == game[2][0] )
                return game[2][0];
            return 0;
        }

        public boolean canNotPlay( ) {
            boolean result = false;
            for (int row = 0; row < SIDE; row++)
                for( int col = 0; col < SIDE; col++ )
                    if ( game[row][col] == 0 )
                        result = false;
                    // что-то нужно вернуть?
            return false;

        }

        public boolean isGameOver( ) {
            // логика для gameover??
            return false;
        }

        public void resetGame( ) {
            // логика для сброса
            turn = 1;
        }

        public String result( ) {
            if( whoWon( ) > 0 )
                return "Player " + whoWon( ) + " won";
            else if( canNotPlay( ) )
                return "Tie Game";
            else
                return "PLAY !!";
        }
    }

