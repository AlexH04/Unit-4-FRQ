import java.lang.Math;
public class CoinGame

{

    private int startingCoins; // starting number of coins

    private int maxRounds; // maximum number of rounds played



    public CoinGame(int s, int r)

    {

        startingCoins = s;

        maxRounds = r;

    }



    /** Returns the number of coins (1, 2, or 3) that player 1 will spend.

     */

    public int getPlayer1Move()

    {

        /* implementation not shown. */

    }



    /** Returns the number of coins (1, 2, or 3) that player 2 will spend, as described in part (a).

     */

    public int getPlayer2Move(int round)

    {
        int result;
        if (round % 3 == 0) {
            result = 3;
        } else if (round % 2 == 0) {
            result = 2;
        } else {
            result = 1;
        }
        return result;
    }



    /** Plays a simulated game between two players, as described in part (b).

     */

    public void playGame()

    {
        int p1coins = startingCoins, p2coins = startingCoins;
        for (int round = 1; round <= maxRounds; round++) {
            int p1move = getPlayer1Move();
            int p2move = getPlayer2Move(round);
            if (p1move == p2move) {
                p2coins++;
            } else if (Math.abs(p1move - p2move) == 1) {
                p2coins++;
            } else {
                p1coins += 2;
            }
        }
        if (p1coins > p2coins) {
            System.out.println("player 1 wins");
        } else if (p2coins > p1coins) {
            System.out.println("player 2 wins");
        } else {
            System.out.println("tie game");
        }
    }

}