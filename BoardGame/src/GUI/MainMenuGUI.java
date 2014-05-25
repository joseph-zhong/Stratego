/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boardgame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 *  Joseph Zhong
 *  ASSIGNMENT_NUMBER
 *  PROGRAM_DESCRIPTION
 *  PROGRAM_TITLE
 *  DATE
 *
 **/

public class MainMenuGUI
{
    private static ArrayList<ButtonGUI> MenuContents;

    public MainMenuGUI()
    {
        MenuContents = new ArrayList<>();
    }

    public void displayAll(Graphics g)
    {
        for(int i = 0; i < MenuContents.size(); i++)
        {
            MenuContents.get(i).draw(g);
        }
    }

    public void addButton(ButtonGUI b)
    {
        MenuContents.add(b);
    }
}
