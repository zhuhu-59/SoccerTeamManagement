package com.example.soccerteammanagement;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TeamIterator implements Iterator<Team> {
    private List<Team> teams;
    private int index = 0;

    public TeamIterator(List<Team> teams) {
        if(teams == null) {
            throw new IllegalArgumentException("Team list cannot be null");
        }
        this.teams = teams;
    }

    @Override
    public boolean hasNext() {
        return index < teams.size();
    }

    @Override
    public Team next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more teams");
        }
        return teams.get(index++);
    }
}

