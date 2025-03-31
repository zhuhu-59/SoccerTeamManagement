package com.example.soccerteammanagement;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.MatchViewHolder> {
    private List<Match> matches;
    private OnItemClickListener onItemClickListener;

    public MatchesAdapter(List<Match> matches) {
        this.matches = matches;
    }

    public interface OnItemClickListener {
        void onItemClick(Match match);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void updateData(List<Match> newMatches) {
        this.matches = newMatches;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Match match = matches.get(position);
        holder.matchTitle.setText(match.getName());
        holder.matchDetails.setText(match.getCompetition() + " | " + match.getDate());
        holder.itemView.setOnClickListener(v -> {
            if(onItemClickListener != null) {
                onItemClickListener.onItemClick(match);
            }
        });
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    static class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView matchTitle;
        TextView matchDetails;
        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            matchTitle = itemView.findViewById(R.id.match_title);
            matchDetails = itemView.findViewById(R.id.match_details);
        }
    }
}

