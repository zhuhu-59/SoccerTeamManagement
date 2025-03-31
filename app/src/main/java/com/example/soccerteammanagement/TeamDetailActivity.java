package com.example.soccerteammanagement;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TeamDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);

        TextView detailTextView = findViewById(R.id.detail_text_view);

        Team team = getIntent().getParcelableExtra("team");
        if (team != null) {
            String details = "Name: " + team.getName() + "\n" +
                    "Country: " + team.getCountry() + "\n" +
                    "League: " + team.getLeague() + "\n" +
                    "Stadium: " + team.getStadium() + "\n" +
                    "Foundation Year: " + team.getFoundationYear();
            detailTextView.setText(details);
        }
    }
}
