package org.irel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;
    @BeforeEach
    void setUp() {
        player = new Player("John Doe", 20, "pass", 0);
    }

    @Test
    void getScore() {
        assertEquals(player.getScore(), 0);
        assertNotEquals(player.getScore(), 10);
    }

    @Test
    void getAge() {
        assertEquals(player.getAge(), 20);
        assertNotEquals(player.getAge(), 18);
    }

    @Test
    void getName() {
        assertTrue(player.getName().equalsIgnoreCase("John Doe"));
        assertFalse(player.getName().equalsIgnoreCase("doe john"));
    }
}