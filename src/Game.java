import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private List<Player> players = new ArrayList<>();
    private List<Property> properties = new ArrayList<>();
    private List<Card> deck = new ArrayList<>();  // 游戏的卡牌库


    public Game() {
        // Initialize some players
        players.add(new Player("Alice", 1500));
        players.add(new Player("Bob", 1500));

        // Initialize some properties
        properties.add(new Property("Park Place", 350, null));
        properties.add(new Property("Boardwalk", 400, null));

        // Initialize deck of cards
        deck.add(new Card("Chance card", 200));
        deck.add(new Card("Community Chest card", -50));

    }

    public Card getNextCard() {  // 获取下一张牌的方法，从卡牌库中拿一张牌
        if (deck.isEmpty()) {
            return null;  // 如果卡牌库已经空了，返回null
        }
        return deck.remove(deck.size() - 1);
    }

    public void dealHand(Player player) {  // 给玩家发牌的方法
        Card card;
        if ((card = getNextCard()) != null) {
            player.addToHand(card);
        }
        if ((card = getNextCard()) != null) {
            player.addToHand(card);
        }

        if (player.getHandCards().isEmpty()) {
            System.out.println("No more cards to deal, " + player.getName() + " got none.");
        }
    }


    public void buyProperty(Player player, Property property) {
        if(player.getBankBalance() >= property.getPropertyCost() && property.getPropertyOwner() == null) {
            player.setBankBalance(player.getBankBalance() - property.getPropertyCost());
            property.setPropertyOwner(player);
            System.out.println(player.getName() + " bought " + property.getPropertyName() + " for " + property.getPropertyCost());
        } else {
            System.out.println("Cannot buy property.");
        }
    }

    public boolean checkWinCondition() {
        // Just an example. You could have more specific conditions.
        return players.get(0).getBankBalance() <= 0 || players.get(1).getBankBalance() <= 0;
    }

    public boolean hasWonGame(Player player) {  // 判断某个玩家是否赢得游戏
        int maxBalance = 0;
        for (Player p : players) {
            if (p.getBankBalance() > maxBalance) {
                maxBalance = p.getBankBalance();
            }
        }
        return player.getBankBalance() >= maxBalance;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.buyProperty(game.players.get(0), game.properties.get(0));
        System.out.println("Is game over? " + game.checkWinCondition());
        game.buyProperty(game.players.get(1), game.properties.get(1));
        System.out.println("Is game over? " + game.checkWinCondition());

        for(Player player : game.players) {
            game.dealHand(player);
            System.out.println("Player " + player.getName() + " has cards: " + player.getHandCards().stream().map(Card::getCardName).collect(Collectors.toList()));
            System.out.println(player.getName() + " has won the game: " + game.hasWonGame(player));
        }
    }
}