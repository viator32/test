package Spieldaten;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.util.Arrays;

public class GameDataTest {
    @Test
    public void testGameData() {
        GameData.GameDataBuilder builder = new GameData.GameDataBuilder();
        GameData data = builder.money(1000).add("abc")
        .add("safsd")
        .add("fdsg")
        .add("safsd")
        .build();
        assertEquals(1000, data.getMoney());
        List<String> expectedPlayerIDs = Arrays.asList("abc");
        assertEquals(expectedPlayerIDs, data.getPlayerIDs());

        try {
            data.getPlayerIDs().add("bla");
            fail("Expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
           e.printStackTrace(); // expected exception
        }
    }
}
