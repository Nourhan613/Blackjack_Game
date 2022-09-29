package blackjack;
import java.util.Random;
import java.util.Scanner;
public class Game {
    public Player[] players= new Player[4];
    public Card[] cards= new Card[52];
    public int[] highScore = new int[4];

    public void generateCardDeck(){
        int value;
        int counter = 0;
        for(int suit=0 ; suit<4 ; suit++){
            for(int rank=0 ; rank<13 ; rank++){
                if(rank >= 10)
                    value = 10;
                else
                    value = rank+1;
                Card card = new Card(suit, rank, value);
                cards[counter]= card ;
                counter++;
            }
        }
    }
    public Card drwaCard(){
        Card card = new Card(0,0,0);
        Random rand = new Random();
        int randomChoice = rand.nextInt(52);
        for(int i =0 ; i<52 ; i++){
            if(cards[randomChoice]!= null){
                card = cards[randomChoice];
                 cards[randomChoice]=null;
            }
        }
        return  card;
    }   
    
   public void setInfoPlayer(){
       Scanner input = new Scanner(System.in);
       for(int i=0 ; i<3 ; i++){
           System.out.println("Enter The Name Of Player " +(i+1)+ ": ");
           players[i] = new Player();
           players[i].name = input.next();
           players[i].addCard(this.drwaCard());
           players[i].addCard(this.drwaCard());
       }
       players[3] = new Player();
       players[3].name ="Dealer";
       players[3].addCard(this.drwaCard());
       players[3].addCard(this.drwaCard());
   }
   
    public void updateHighScore(){
        for(int i=0 ; i<4 ; i++){
            if(players[i].score <= 21){
                highScore[i] = players[i].score;
            }
            else{ 
                highScore[i] = 0;
            }
        }
    }     
}