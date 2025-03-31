package com.example.soccerteammanagement;

public class Player implements SoccerEntity {
    private String name;
    private int age;
    private String nationality;
    private String position;
    private String team;
    private int number;

    public Player(String name, int age, String nationality, String position, String team, int number) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty");
        }
        if(age <= 0) {
            throw new IllegalArgumentException("Age must be positive");
        }
        if(nationality == null || nationality.trim().isEmpty()) {
            throw new IllegalArgumentException("Nationality cannot be null or empty");
        }
        if(position == null || position.trim().isEmpty()) {
            throw new IllegalArgumentException("Position cannot be null or empty");
        }
        if(team == null || team.trim().isEmpty()) {
            throw new IllegalArgumentException("Team cannot be null or empty");
        }
        if(number <= 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.position = position;
        this.team = team;
        this.number = number;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPosition() {
        return position;
    }

    public String getTeam() {
        return team;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                ", number=" + number +
                '}';
    }
}

