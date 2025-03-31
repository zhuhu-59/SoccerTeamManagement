package com.example.soccerteammanagement;


import android.os.Parcel;
import android.os.Parcelable;

public class Team implements SoccerEntity, Parcelable {
    private String name;
    private String country;
    private String league;
    private String stadium;
    private int foundationYear;

    public Team(String name, String country, String league, String stadium, int foundationYear) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be null or empty");
        }
        if(country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Country cannot be null or empty");
        }
        if(league == null || league.trim().isEmpty()) {
            throw new IllegalArgumentException("League cannot be null or empty");
        }
        if(stadium == null || stadium.trim().isEmpty()) {
            throw new IllegalArgumentException("Stadium cannot be null or empty");
        }
        if(foundationYear < 1800) {
            throw new IllegalArgumentException("Foundation year seems invalid");
        }
        this.name = name;
        this.country = country;
        this.league = league;
        this.stadium = stadium;
        this.foundationYear = foundationYear;
    }

    protected Team(Parcel in) {
        name = in.readString();
        country = in.readString();
        league = in.readString();
        stadium = in.readString();
        foundationYear = in.readInt();
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };

    @Override
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getLeague() {
        return league;
    }

    public String getStadium() {
        return stadium;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", league='" + league + '\'' +
                ", stadium='" + stadium + '\'' +
                ", foundationYear=" + foundationYear +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(name);
        parcel.writeString(country);
        parcel.writeString(league);
        parcel.writeString(stadium);
        parcel.writeInt(foundationYear);
    }
}


