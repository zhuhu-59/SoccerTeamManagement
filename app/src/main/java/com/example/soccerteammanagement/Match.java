package com.example.soccerteammanagement;

public class Match implements SoccerEntity {
    private String homeTeam;
    private String awayTeam;
    private String score;
    private String competition;
    private String date;
    private String venue;

    public Match(String homeTeam, String awayTeam, String score, String competition, String date, String venue) {
        if(homeTeam == null || homeTeam.trim().isEmpty() || awayTeam == null || awayTeam.trim().isEmpty()) {
            throw new IllegalArgumentException("Team names cannot be null or empty");
        }
        if(score == null || score.trim().isEmpty()) {
            throw new IllegalArgumentException("Score cannot be null or empty");
        }
        if(competition == null || competition.trim().isEmpty()) {
            throw new IllegalArgumentException("Competition cannot be null or empty");
        }
        if(date == null || date.trim().isEmpty()) {
            throw new IllegalArgumentException("Date cannot be null or empty");
        }
        if(venue == null || venue.trim().isEmpty()) {
            throw new IllegalArgumentException("Venue cannot be null or empty");
        }
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
        this.competition = competition;
        this.date = date;
        this.venue = venue;
    }

    @Override
    public String getName() {
        return homeTeam + " vs " + awayTeam;
    }

    public String getScore() {
        return score;
    }

    public String getCompetition() {
        return competition;
    }

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    @Override
    public String toString() {
        return "Match{" +
                "homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", score='" + score + '\'' +
                ", competition='" + competition + '\'' +
                ", date='" + date + '\'' +
                ", venue='" + venue + '\'' +
                '}';
    }
}


