package com.company;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException
    {

        Scanner scan = new Scanner(System.in);

        String input = "";
        int place = 0;
        char playerSymbol = 'x';
        char CPUSymbol = 'o';
        Random random = new Random();
        boolean checkGameBoard = false;
        boolean checkWin = false;
        boolean checkLoss = false;
        boolean checkTie = false;
        char[][] gameboard =
                        {
                        {' ', 'I', ' ', 'I', ' '},
                        {'-', '+', '-', '+', '-'},
                        {' ', 'I', ' ', 'I', ' '},
                        {'-', '+', '-', '+', '-'},
                        {' ', 'I', ' ', 'I', ' '}};

        drawGameBoard(gameboard);
        while (true)
        {
            //HUMAN PART
            do
            {
                place = TryParse(input, scan);
                checkGameBoard = checkGameBoard(gameboard, place, playerSymbol, CPUSymbol);
            } while (checkGameBoard == false);

            updateGameboard(gameboard, place, playerSymbol);
            drawGameBoard(gameboard);
            System.out.println(" ");
            checkWin = checkWin(gameboard, playerSymbol);

            if (checkWin == true)
            {
                System.out.println("You've Won!");

                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    Desktop.getDesktop().browse(new URI("https://youtu.be/3GwjfUFyY6M"));
                }
            }

            checkTie = checkTie(gameboard);

            if (checkTie == true)
            {
            System.out.println("Its a tie!");
            }

            //CPU PART
            do
            {
                place = random.nextInt(10);
                checkGameBoard = checkGameBoard(gameboard, place, playerSymbol, CPUSymbol);
            } while (checkGameBoard == false);

            updateGameboard(gameboard, place, CPUSymbol);
            drawGameBoard(gameboard);

            checkLoss = checkWin(gameboard, CPUSymbol);

            if (checkLoss == true)
            {
                System.out.println("You've LOST!");

                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    Desktop.getDesktop().browse(new URI("https://youtu.be/JDb3ZZD4bA0"));
                }
            }
            checkTie = checkTie(gameboard);

            if (checkTie == true)
            {
                System.out.println("Its a tie!");
            }

            System.out.println(" ");
        }
    }

    private static boolean checkTie(char[][] gameBoard)
    {
        if (gameBoard[0][0] != ' ' && gameBoard[0][2] != ' ' && gameBoard[0][4] != ' ' && gameBoard[2][0] != ' ' && gameBoard[2][2] != ' ' && gameBoard[2][4] != ' ' && gameBoard[4][0] != ' ' && gameBoard[4][2] != ' ' && gameBoard[4][4] != ' ' )
        {
            return true;
        }
        return false;
    }

    private static boolean checkWin(char[][] gameBoard, char symbol)
    {
        if (gameBoard[0][0] == symbol && gameBoard[0][2] == symbol && gameBoard[0][4] == symbol )
        {
            return true;
        }
        else if (gameBoard[2][0] == symbol && gameBoard[2][2] == symbol && gameBoard[2][4] == symbol )
        {
            return true;
        }
        else if (gameBoard[4][0] == symbol && gameBoard[4][2] == symbol && gameBoard[4][4] == symbol )
        {
            return true;
        }
        else if (gameBoard[0][0] == symbol && gameBoard[2][0] == symbol && gameBoard[4][0] == symbol )
        {
            return true;
        }
        else if (gameBoard[0][2] == symbol && gameBoard[2][2] == symbol && gameBoard[4][2] == symbol )
        {
            return true;
        }
        else if (gameBoard[0][4] == symbol && gameBoard[2][4] == symbol && gameBoard[4][4] == symbol )
        {
            return true;
        }
        else if (gameBoard[0][0] == symbol && gameBoard[2][2] == symbol && gameBoard[4][4] == symbol )
        {
            return true;
        }
        else if (gameBoard[0][4] == symbol && gameBoard[2][2] == symbol && gameBoard[4][0] == symbol )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private static boolean checkGameBoard(char[][] gameBoard, int place, char playerSymbol, char CPUSymbol)
    {
        if (place == 1 && (gameBoard[0][0] == playerSymbol || gameBoard[0][0] == CPUSymbol))
        {
            return false;
        }
        else if (place == 2 && (gameBoard[0][2] == playerSymbol || gameBoard[0][2] == CPUSymbol))
        {
            return false;
        }
        else if (place == 3 && (gameBoard[0][4] == playerSymbol || gameBoard[0][4] == CPUSymbol))
        {
            return false;
        }
        else if (place == 4 && (gameBoard[2][0] == playerSymbol || gameBoard[2][0] == CPUSymbol))
        {
            return false;
        }
        else if (place == 5 && (gameBoard[2][2] == playerSymbol || gameBoard[2][2] == CPUSymbol))
        {
            return false;
        }
        else if (place == 6 && (gameBoard[2][4] == playerSymbol || gameBoard[2][4] == CPUSymbol))
        {
            return false;
        }
        else if (place == 7 && (gameBoard[4][0] == playerSymbol || gameBoard[4][0] == CPUSymbol))
        {
            return false;
        }
        else if (place == 8 && (gameBoard[4][2] == playerSymbol || gameBoard[4][2] == CPUSymbol))
        {
            return false;
        }
        else if (place == 9 && (gameBoard[4][4] == playerSymbol || gameBoard[4][4] == CPUSymbol))
        {
            return false;
        }
        else if (place == 0)
        {
            return false;
        }
        else
            {
            return true;
            }
    }

    private static void updateGameboard(char[][] gameBoard, int place, char symbol)
    {
        if (place == 1)
        {
            gameBoard[0][0] = symbol;
        }
        else if (place == 2)
        {
            gameBoard[0][2] = symbol;
        }
        else if (place == 3)
        {
            gameBoard[0][4] = symbol;
        }
        else if (place == 4)
        {
            gameBoard[2][0] = symbol;
        }
        else if (place == 5)
        {
            gameBoard[2][2] = symbol;
        }
        else if (place == 6)
        {
            gameBoard[2][4] = symbol;
        }
        else if (place == 7)
        {
            gameBoard[4][0] = symbol;
        }
        else if (place == 8)
        {
            gameBoard[4][2] = symbol;
        }
        else if (place == 9)
        {
            gameBoard[4][4] = symbol;
        }
    }

    private static int TryParse(String input, Scanner scan)
    {
        int place = 0;
        boolean parseSuccessful = false;
        do {
            input = scan.nextLine();

            if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5") || input.equals("6") || input.equals("7") || input.equals("8") || input.equals("9"))
            {
                parseSuccessful = true;
                return Integer.parseInt(input);
            }
            else
            {
                parseSuccessful = false;
            }

        } while (!parseSuccessful);

        return Integer.parseInt(input);
    }

    private static void drawGameBoard(char[][] gameboard)
    {
        for ( int i = 0; i < gameboard.length; i++)
        {
            System.out.println(gameboard[i]);
        }
    }
}
