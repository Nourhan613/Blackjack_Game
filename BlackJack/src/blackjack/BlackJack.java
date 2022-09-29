package blackjack;
import java.util.Scanner;
public class BlackJack {
    static Game game = new Game();
    public static void main(String[] args) {
        GUI gui = new GUI();
        game.generateCardDeck();
        game.setInfoPlayer();
        gui.runGUI( game.cards,
                game.players[0].getCards(),
                game.players[1].getCards(),
                game.players[2].getCards(),
                game.players[3].getCards());
        playerTurn(gui);
        game.updateHighScore();
        dealerTurn(gui);
        game.updateHighScore();
        checkWinner(gui);
    }
    public static void playerTurn(GUI gui){
        Scanner input = new Scanner(System.in);
        int[] replyPlayer = new int[3];
        int i;
        for(i=0 ; i<3 ; i++){
            while(!(replyPlayer[i]== 2)){
                System.out.println("If Plyer no. "+(i+1)+" Want To Hit Press 1 OR Want To Stand Press 2");
                replyPlayer[i] = input.nextInt();
                if(replyPlayer[i]== 1){
                    game.players[i].addCard(game.drwaCard());
                    gui.updatePlayerHand(game.drwaCard(), i);
                }
            }
        }
    }
    public static void dealerTurn(GUI gui){
        int highScore = 0;
        boolean dealerWin = true;
        for(int i=0 ; i<3 ; i++){
            if(game.highScore[i] >= game.players[3].score){
                dealerWin = false;
            }
            if(game.highScore[i] > highScore){
                highScore = game.highScore[i];
            }
        }
        if(!dealerWin){
            addCToDealer(gui, highScore);
        }
        else{
            return;
        }
    }
    
      public static void addCToDealer(GUI gui, int highScore){
        while(game.players[3].score < highScore){
            Card card = game.drwaCard();
             game.players[3].addCard(card);
             gui.updateDealerHand(card,game.cards);
        }
    }
    
    public static void checkWinner(GUI gui){
        int highScore = 0;
        int counter = 0;
        int WINNER = -1 ;
        for(int i=0 ; i<4 ; i++){
             if(game.highScore[i] > highScore){
                highScore = game.highScore[i];
                WINNER = i;
                counter++;
             }
        }
         if(counter > 1){
            System.out.println("*********************************************");
            System.out.println("PUSH");
        }
         else if(WINNER >= 0){
            System.out.println("*********************************************");
            System.out.println("The WINNER IS "+ game.players[WINNER].name + " & The score : " + highScore );
            }
    }
}