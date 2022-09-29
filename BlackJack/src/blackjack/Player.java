package blackjack;
public class Player {
    public String name;
    public int score = 0;
    private Card[] cards = new Card[11];
    public Player(String name){
        this.name = name;
    }

    Player() {
        
    }
    public String getName(){
        return name;
    }
  
    int index = 0;
    public void addCard(Card c){
        if(index < 11){
            cards[index] = c;
            index++;
            score += c.getValue();
        }
    }

    public Card[] getCards() {
        return cards;
    }
    
}
