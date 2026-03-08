import java.util.*;
public class tictactoe 
{
    static char[] board = {'0','1','2','3','4','5','6','7','8','9'};
    static void showBoard() 
    {
        System.out.println("\n        TIC TAC TOE        \n");
        System.out.println("    " + board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("   ---|---|---");
        System.out.println("    " + board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("   ---|---|---");
        System.out.println("    " + board[7] + " | " + board[8] + " | " + board[9]);
        System.out.println();
    }
    static int checkWin() 
    {
        if (board[1] == board[2] && board[2] == board[3]) return 1;
        if (board[4] == board[5] && board[5] == board[6]) return 1;
        if (board[7] == board[8] && board[8] == board[9]) return 1;

        if (board[1] == board[4] && board[4] == board[7]) return 1;
        if (board[2] == board[5] && board[5] == board[8]) return 1;
        if (board[3] == board[6] && board[6] == board[9]) return 1;

        if (board[1] == board[5] && board[5] == board[9]) return 1;
        if (board[3] == board[5] && board[5] == board[7]) return 1;

        for (int i = 1; i <= 9; i++) 
        {
            if (board[i] == (char)('0' + i)) 
            {
                return -1;
            }
        }
        return 0; 
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int player = 1, choice, status;
        char mark;
        do 
        {
            showBoard();

            player = (player % 2 != 0) ? 1 : 2;
            mark = (player == 1) ? 'X' : 'O';

            System.out.print("Player " + player + ", enter your choice: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 9 && board[choice] == (char)('0' + choice)) 
            {
                board[choice] = mark;
            } else 
            {
                System.out.println("Invalid move! Try again.");
                player--;
            }
            status = checkWin();
            player++;

        }
            while (status == -1);

        showBoard();

        if (status == 1)
            System.out.println(" Player " + (player - 1) + " wins!");
        else
            System.out.println("Game Draw!");
        sc.close();
    }
}














