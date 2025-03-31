package com.example.soccerteammanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamViewHolder> {
    private List<Team> teams;
    private OnItemClickListener onItemClickListener;

    public TeamsAdapter(List<Team> teams) {
        this.teams = teams;
    }

    public interface OnItemClickListener {
        void onItemClick(Team team);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void updateData(List<Team> newTeams) {
        this.teams = newTeams;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.teamName.setText(team.getName());
        holder.itemView.setOnClickListener(v -> {
            if(onItemClickListener != null) {
                onItemClickListener.onItemClick(team);
            }
        });
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    static class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView teamName;
        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.team_name);
        }
    }
}

