package Spieldaten;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class GameData {
    private final int money;
    private final List<String> playerIDs;

    private GameData(int money, List<String> playerIDs) {
        this.money = money;
        this.playerIDs = Collections.unmodifiableList(new ArrayList<>(playerIDs));
    }
    public int getMoney() {
        return money;
    }
    public List<String> getPlayerIDs() {
        return playerIDs;
    }

    public static class GameDataBuilder {
        private int money;
        private List<String> playerIDs;

        public GameDataBuilder money(int money) {
            this.money = money;
            return this;
        }

        public GameDataBuilder add(String playerID) {
            playerIDs.add(playerID);
            return this;
        }

        public GameData build() {
            return new GameData(money, playerIDs);
        }
    }
}
