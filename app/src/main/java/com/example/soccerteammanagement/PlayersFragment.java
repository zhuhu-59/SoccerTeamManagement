package com.example.soccerteammanagement;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.stream.Collectors;

public class PlayersFragment extends Fragment implements FilterAndSortable {
    private RecyclerView recyclerView;
    private PlayersAdapter adapter;
    private Repository<Player> repository;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_players, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_players);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DataProvider<Player> dataProvider = new DataProvider<>();
        List<Player> players = dataProvider.getPlayers();

        repository = new Repository<>();
        players.forEach(repository::add);

        adapter = new PlayersAdapter(repository.getAll());
        adapter.setOnItemClickListener(player -> {
            Log.d("PlayersFragment", "Player clicked: " + player.getName());
        });
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void filterData(String query) {
        List<Player> filtered = repository.getAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
        adapter.updateData(filtered);
    }

    @Override
    public void sortData() {
        List<Player> sorted = repository.getAll().stream()
                .sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .collect(Collectors.toList());
        adapter.updateData(sorted);
    }
}

