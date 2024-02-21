import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int bankBalance;
    private List<Card> handCards;  //玩家的手牌

    public Player(String name, int bankBalance) {
        this.name = name;
        this.bankBalance = bankBalance;
        this.handCards = new ArrayList<Card>();
    }

    public List<Card> getHandCards() {
        return handCards;
    }

    public void addToHand(Card card) {  // 玩家增加一张手牌的方法
        this.handCards.add(card);
    }

    public String getName() {
        return name;
    }

    public int getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(int bankBalance) {
        this.bankBalance = bankBalance;
    }
}