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
import java.util.ArrayList;
import java.util.Arrays;
import Pieces.*;

public class Computer
{
    public static final int forget = 4; //The number of turns before AI forgets player move
    private Move[] oppMoves = new Move[4];
    private Random r = new Random();

    private Board board;

    private ArrayList<Piece> totalPiecesForSetup;
    private ArrayList<Piece> totalPiecesForGamePlay;

    private Piece[] singles;
    private Colonel[] colonels;
    private Major[] majors;
    private Captain[] captains;
    private Lieutenant[] lieutenants;
    private Sergeant[] sergeants;
    private Miner[] miners;
    private Scout[] scouts;
    private Bomb[] bombs;

    private int temp;


    public Computer()
    {
        board = new Board();
        totalPiecesForGamePlay = new ArrayList(40);
        instantiatePieceArrays();
        addSingles();
        addPieces();
        addToTotalList();
        boardSetUp();
    }

    private void instantiatePieceArrays()
    {
        totalPiecesForSetup = new ArrayList(40);

        singles = new Piece[4];
        colonels = new Colonel[2];
        majors = new Major[3];
        captains = new Captain[4];
        lieutenants = new Lieutenant[4];
        sergeants = new Sergeant[4];
        miners = new Miner[5];
        scouts = new Scout[8];
        bombs = new Bomb[6];
    }

    private void addPieces()
    {
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
        int flagCol = -1;            //randomized column of the flag in the random middle scenario


        //Decide where flag should be
        flagPos = r.nextInt(3) + 1;
        switch (flagPos)
        {
            case 1 :
                board.getCell(0, 0).put(singles[3]);        //set flag
                board.getCell(1, 0).put(bombs[0]);          //set bomb 1
                board.getCell(0, 1).put(bombs[1]);          //set bomb 2
                break;
            case 2 :
                flagCol = r.nextInt(7) + 1;                 //random col
                board.getCell(0, flagCol).put(singles[3]);  //set flag
                break;
            case 3 :
                board.getCell(0, 9).put(singles[3]);        //set flag
                board.getCell(0, 8).put(bombs[0]);          //set bomb 1
                board.getCell(1, 9).put(bombs[1]);          //set bomb 2
                break;
        }

        //decide how many bombs should be set around flag
        if (flagPos == 2)               //in the center
        {
            bombsToProtect = r.nextInt(4) + 2;
            //find number of bombs to use (between 2 and 5)
            //temp = bombsToProtect;
            switch (bombsToProtect)
            {

                case 1 : //for 2 bombs
                    board.getCell(1, (flagCol - 1)).put(bombs[0]);
                    board.getCell(1, (flagCol + 1)).put(bombs[1]);

                    System.out.println("MESSAGE FROM AI: Flag's position - " + flagPos);
                    System.out.println("MESSAGE FROM AI: Bombs protecting flag -: " + bombsToProtect);

                    break;
                case 2 : //for 3 bombs
                    board.getCell(0, (flagCol - 1)).put(bombs[0]);
                    board.getCell(0, (flagCol + 1)).put(bombs[1]);
                    board.getCell(1, flagCol).put(bombs[2]);

                    System.out.println("MESSAGE FROM AI: Flag's position - " + flagPos);
                    System.out.println("MESSAGE FROM AI: Bombs protecting flag -: " + bombsToProtect);

                    break;
                case 3 :    //for four bombs
                    board.getCell(0, (flagCol - 1)).put(bombs[0]);
                    board.getCell(1, (flagCol - 1)).put(bombs[1]);
                    board.getCell(1, (flagCol + 1)).put(bombs[2]);
                    board.getCell(0, (flagCol + 1)).put(bombs[3]);

                    System.out.println("MESSAGE FROM AI: Flag's position - " + flagPos);
                    System.out.println("MESSAGE FROM AI: Bombs protecting flag -: " + bombsToProtect);

                    break;
                case 4:     //for five bombs
                    board.getCell(0, (flagCol - 1)).put(bombs[0]);
                    board.getCell(1, (flagCol - 1)).put(bombs[1]);
                    board.getCell(1, flagCol).put(bombs[2]);
                    board.getCell(1, (flagCol + 1)).put(bombs[3]);
                    board.getCell(0, (flagCol + 1)).put(bombs[4]);

                    System.out.println("MESSAGE FROM AI: Flag's position - " + flagPos);
                    System.out.println("MESSAGE FROM AI: Bombs protecting flag -: " + bombsToProtect);

                    break;
            }
        }
        /*
        System.out.println("MESSAGE FROM AI: Flag's position - " + flagPos);
        System.out.println("MESSAGE FROM AI: Bombs protecting flag -: " + temp);
        *   */

    }

    private void addToTotalList()
    {
        totalPiecesForSetup.addAll(Arrays.asList(singles));
        totalPiecesForSetup.addAll(Arrays.asList(colonels));
        totalPiecesForSetup.addAll(Arrays.asList(majors));
        totalPiecesForSetup.addAll(Arrays.asList(captains));
        totalPiecesForSetup.addAll(Arrays.asList(lieutenants));
        totalPiecesForSetup.addAll(Arrays.asList(sergeants));
        totalPiecesForSetup.addAll(Arrays.asList(miners));
        totalPiecesForSetup.addAll(Arrays.asList(scouts));
        totalPiecesForSetup.addAll(Arrays.asList(bombs));
    }

    private boolean checkIfCellIsFree(int row, int col)
    {
        if (board.getCell(row, col) == null)
            return false;
        return true;
    }

    private void randomPieceSetup()
    {

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                Piece curPiece = totalPiecesForSetup.get(r.nextInt(totalPiecesForSetup.size()));
                totalPiecesForSetup.remove(curPiece);
                totalPiecesForGamePlay.add(curPiece);
                if (checkIfCellIsFree(i, j))
                    board.getCell(i, j).put(curPiece);
                else
                    j++;
            }
        }
    }


    public void makeRandMove(int startR, int startC)
    {
       int rRow = r.nextInt(10);
       int rCol = r.nextInt(10);

        while (!board.canMove(startR, startC, rRow, rCol))
        {
            rRow = r.nextInt(10);
            rCol = r.nextInt(10);
        }
        board.getCell(rRow, rCol).put(board.getCell(startR, startC).get());
        board.getCell(startR, startC).removePiece();
    }
}
