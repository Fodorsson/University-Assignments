package elevens;

public final class Card {
    //These are the two attributes of a card.
    private final String rankName;
    private final String suit;
    
    //The only constructor for a card object requires a rank and a suit. It is assumed that non-existent values won't be entered.
    public Card(String RankName, String Suit){
        rankName = RankName;
        suit = Suit;
    }
    
    public int getRankValue(){
        return calculateRankValue(rankName);
    }
    
    //rankValue is derived automatically from RankName
    public int calculateRankValue(String RankName){
        //The default RankValue is set to 0, which means it is a picture card (Jack/Queen/King)
        int RankValue = 0;
        
        //If it's not a picture card, the RankValue is to be changed accordingly
        switch (RankName){
            case "Ace":
                RankValue = 1;
                break;
            case "2":
                RankValue = 2;
                break;
            case "3":
                RankValue = 3;
                break;
            case "4":
                RankValue = 4;
                break;
            case "5":
                RankValue = 5;
                break;
            case "6":
                RankValue = 6;
                break;
            case "7":
                RankValue = 7;
                break;
            case "8":
                RankValue = 8;
                break;
            case "9":
                RankValue = 9;
                break;
            case "10":
                RankValue = 10;
                break;
        }
        
        return RankValue;
    }
    
    public String getRankName(){
        return rankName;
    }
    
    public String getSuit(){
        return suit;
    }
    
    public String getName(){
        return rankName + " of " + suit;
    }
    
}
