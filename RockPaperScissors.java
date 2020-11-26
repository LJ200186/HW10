/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.util.*;

public class RockPaperScissors {

    static Scanner Input = new Scanner(System.in);
    static Random random = new Random();
        
    public static void main(String[] args) {
        
        int UserWins = 0;
        int ComputerWins = 0;
                
        for (int i = 0; i < 8; i++) {
            int Game = Play();
            
            if(Game == 1){
                UserWins++;
            }else if (Game == 0){
                ComputerWins++;
            }
            
            System.out.println("Computer ("+ComputerWins+") vs User ("+UserWins+")");
        }
        
        if(ComputerWins >= UserWins){
            
            boolean draw = ComputerWins == UserWins;
            
            if(draw){
                System.out.println("After the past 8 rounds you are drawing with the computer! Would you like a lifeline to potentially win the game? (Y/N)");
            }else{
                System.out.println("After the past 8 rounds you are losing to the computer! Would you like a lifeline to potentially win the game? (Y/N)");
            }
            
            char option = (Input.next()).charAt(0);
            
            if('Y' == option){
                
                int EndGame = Play();
                
                switch (EndGame) {
                    case 1:
                        System.out.print("At the end of 9 rounds you won against the computer. Well done!");
                        break;
                    case 0:
                        System.out.print("At the end of 9 rounds you lost against the computer.");
                        break;
                    default:
                        System.out.print("At the end of 9 rounds you lost against the computer.");
                }
                
            }else{
                if(draw){
                    System.out.println("Well then, at the end of 8 rounds you drew with the computer.");
                }else{
                    System.out.println("Well then, at the end of 8 rounds you lost against the computer.");
                }
            }
        }else{
            System.out.print("At the end of 8 rounds you won against the computer. Well done!");
        }
    }
    
    public static int Play(){
        
        int win = 0;
        
        System.out.println("Pick: Rock (R), Paper (P), Scissors (S)");
        
        char UserPick = (Input.next()).charAt(0);
        
        int ComputerPick = random.nextInt(3)+1;
        
        if((UserPick == 'R' && ComputerPick == 3) || (UserPick == 'S' && ComputerPick == 2) || (UserPick == 'P' && ComputerPick == 1)){
            win = 1;
        }else if((UserPick == 'R' && ComputerPick == 1) || (UserPick == 'S' && ComputerPick == 3) || (UserPick == 'P' && ComputerPick == 2)){
            win = 2;
        }
        
        switch (win) {
            case 1:
                System.out.print("You won! The computer picked ");
                break;
            case 0:
                System.out.print("You lost! The computer picked ");
                break;
            default:
                System.out.print("You drew! The computer picked ");
                break;
        }
        
        switch (ComputerPick) {
            case 1:
                System.out.print("rock\n");
                break;
            case 2:
                System.out.print("paper\n");
                break;
            case 3:
                System.out.print("scissors\n");
                break;
        }
        
        return win;
    }
    
}
