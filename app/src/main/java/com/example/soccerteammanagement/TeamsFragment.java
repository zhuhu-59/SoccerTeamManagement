package com.example.soccerteammanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.stream.Collectors;

public class TeamsFragment extends Fragment implements FilterAndSortable {
    private RecyclerView recyclerView;
    private TeamsAdapter adapter;
    private Repository<Team> repository;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teams, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_teams);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DataProvider<Team> dataProvider = new DataProvider<>();
        List<Team> teams = dataProvider.getTeams();

        repository = new Repository<>();
        teams.forEach(repository::add);

        adapter = new TeamsAdapter(repository.getAll());
        // 设置点击回调，点击后启动 TeamDetailActivity
        adapter.setOnItemClickListener(team -> {
            Intent intent = new Intent(getContext(), TeamDetailActivity.class);
            intent.putExtra("team", team);
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void filterData(String query) {
        List<Team> filtered = repository.getAll().stream()
                .filter(team -> team.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
        adapter.updateData(filtered);
    }

    @Override
    public void sortData() {
        List<Team> sorted = repository.getAll().stream()
                .sorted((t1, t2) -> t1.getName().compareToIgnoreCase(t2.getName()))
                .collect(Collectors.toList());
        adapter.updateData(sorted);
    }
}


