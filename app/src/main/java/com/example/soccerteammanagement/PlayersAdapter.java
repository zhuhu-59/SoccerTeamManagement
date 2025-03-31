package com.example.soccerteammanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder> {
    private List<Player> players;
    private OnItemClickListener onItemClickListener;

    public PlayersAdapter(List<Player> players) {
        this.players = players;
    }

    public interface OnItemClickListener {
        void onItemClick(Player player);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void updateData(List<Player> newPlayers) {
        this.players = newPlayers;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_player, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        Player player = players.get(position);
        holder.playerName.setText(player.getName());
        holder.playerInfo.setText(player.getPosition() + " - " + player.getTeam());
        // 显示年龄
        holder.playerAge.setText("Age: " + player.getAge());
        holder.itemView.setOnClickListener(v -> {
            if(onItemClickListener != null) {
                onItemClickListener.onItemClick(player);
            }
        });
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    static class PlayerViewHolder extends RecyclerView.ViewHolder {
        TextView playerName;
        TextView playerInfo;
        TextView playerAge;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            playerName = itemView.findViewById(R.id.player_name);
            playerInfo = itemView.findViewById(R.id.player_info);
            playerAge = itemView.findViewById(R.id.player_age);
        }
    }
}


