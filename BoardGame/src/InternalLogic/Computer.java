/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalLogic;

/**
 *
 * @author Adarsh
 */
import java.util.Random;
public class Computer
{
    public static final int forget = 4; //The number of turns before AI forgets player move
    private Move[] oppMoves = new Move[4];
    private Random r = new Random();


    private Piece[] singles;
    private Colonel[] colonels;
    private Major[] majors;
    private Captain[] captains;
    private Lieutenant[] lieutenants;
    private Sergeant[] sergeants;
    private Miner[] miners;
    private Scout[] scouts;
    private Bomb[] bombs;
    private int count;


    public Computer()
    {
        count = 0;
        instantiatePieceArrays();
        addSingles();
        addPieces();
        boardSetUp();
    }

    private void instantiatePieceArrays()
    {
        singles = new Piece[4];
        colonels = new Colonel[2];
        majors = new Major[3];
        captains = new Captain[4];
        lieutenants = new Lieutenant[4];
        sergeants = new Sergeant[4];
        miners = new Miner[5];
        scouts = new Scout[8];
    }

    private void addPieces()
    {
        addSingles();
        for (int i = 0; i < colonels.length; i++)
            colonels[i] = new Colonel();
        for (int i = 0; i < majors.length; i++)
            majors[i] = new Major();
        for (int i = 0; i < captains.length; i++)
            captains[i] = new Captain();
        for (int i = 0; i < lieutenants.length; i++)
            lieutenants[i] = new Lieutenant();
        for (int i = 0; i < sergeants.length; i++)
            sergeants[i] = new Sergeant();
        for (int i = 0; i < miners.length; i++)
            miners[i] = new Miner();
        for (int i = 0; i < scouts.length; i++)
            scouts[i] = new Scout();
        for (int i = 0; i < bombs.length; i++)
            bombs[i] = new Bomb();
    }

    private void addSingles()
    {
        singles[0] = new Marshal();
        singles[1] = new General();
        singles[2] = new Spy();
        singles[3] = new Flag();
    }


    public void boardSetUp()
    {
        flagSetUp();
        randomPieceSetup();
    }

    public void flagSetUp()
    {
        int flagPos;            //1, 2 or 3 representing left corner, random in middle or right corner
        int bombsToProtect;     //The number of bombs allocated to protect the flag


        //Decide where flag should be
        flagPos = r.nextInt(3) + 1;
        switch (flagPos)
        {
            case 1 : singles[3].setCell(0, 0);
                break;
            case 2 : singles[3].setCell(0, (r.nextInt(7) + 1));
                break;
            case 3 : singles[3].setCell(0, 9);
        }

        //decide how many bombs should be set around flag
        if (flagPos == 2)               //in the center
        {
            bombsToProtect = r.nextInt(4) + 2;
            switch (bombsToProtect)
            {
                case 2 :
                    bombs[0].setCell(1, singles[3].getCell().getCol() - 1);
                    bombs[1].setCell(1, singles[3].getCell().getCol() + 1);
                    break;
                case 3 :
                    bombs[0].setCell(0, singles[3].getCell().getCol() - 1);
                    bombs[1].setCell(0, singles[3].getCell().getCol() + 1);
                    bombs[2].setCell(1, singles[3].getCell().getCol());
                    break;
                case 4 :
                    bombs[0].setCell(0, singles[3].getCell().getCol() - 1);
                    bombs[1].setCell(1, singles[3].getCell().getCol() - 1);
                    bombs[3].setCell(1, singles[3].getCell().getCol() + 1);
                    bombs[4].setCell(0, singles[3].getCell().getCol() + 1);
                    break;
                case 5:
                    bombs[0].setCell(0, singles[3].getCell().getCol() - 1);
                    bombs[1].setCell(1, singles[3].getCell().getCol() - 1);
                    bombs[2].setCell(1, singles[3].getCell().getCol());
                    bombs[3].setCell(1, singles[3].getCell().getCol() + 1);
                    bombs[4].setCell(0, singles[3].getCell().getCol() + 1);
                    break;
            }
        }
        else if (flagPos == 1)          //in the left corner
        {
            bombs[0].setCell(1, 0);
            bombs[1].setCell(0, 1);
        }
        else
        {
            bombs[0].setCell(0, 8);
            bombs[1].setCell(1, 9);
        }

    }

    public void randomPieceSetup()
    { }
}
