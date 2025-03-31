package com.example.soccerteammanagement;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PlayerIterator implements Iterator<Player> {
    private List<Player> players;
    private int index = 0;

    public PlayerIterator(List<Player> players) {
        if(players == null) {
            throw new IllegalArgumentException("Player list cannot be null");
        }
        this.players = players;
    }

    @Override
    public boolean hasNext() {
        return index < players.size();
    }

    @Override
    public Player next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more players");
        }
        return players.get(index++);
    }
}

