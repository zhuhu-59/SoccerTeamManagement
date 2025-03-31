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

public class MatchesFragment extends Fragment implements FilterAndSortable {
    private RecyclerView recyclerView;
    private MatchesAdapter adapter;
    private Repository<Match> repository;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matches, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_matches);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DataProvider<Match> dataProvider = new DataProvider<>();
        List<Match> matches = dataProvider.getMatches();

        repository = new Repository<>();
        matches.forEach(repository::add);

        adapter = new MatchesAdapter(repository.getAll());
        adapter.setOnItemClickListener(match -> {
            Log.d("MatchesFragment", "Match clicked: " + match.getName());
        });
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void filterData(String query) {
        List<Match> filtered = repository.getAll().stream()
                .filter(match -> match.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
        adapter.updateData(filtered);
    }

    @Override
    public void sortData() {
        List<Match> sorted = repository.getAll().stream()
                .sorted((m1, m2) -> m1.getDate().compareTo(m2.getDate()))
                .collect(Collectors.toList());
        adapter.updateData(sorted);
    }
}

