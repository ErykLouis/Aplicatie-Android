package com.example.app_in_51;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

public class BuyArtFragment extends Fragment {

    private ListView listView;
    private ArtObjectAdCustomAdapter arrayAdapter;
    private View rootView;
    private ArtObjectAd[] artObjectAds = new ArtObjectAd[]{
            new ArtObjectAd("Title 1","art_pottery", "This is a description"),
            new ArtObjectAd("Title 2","art_sculpture", "This is second description"),
            new ArtObjectAd("Title 1","art_sculpture2","This is a description"),
            new ArtObjectAd("Title 2","art_sculpture", "This is second description"),
            new ArtObjectAd("Title 1","art_pottery", "This is a description"),
            new ArtObjectAd("Title 2","art_sculpture", "This is second description"),
            new ArtObjectAd("Title 1","art_sculpture2","This is a description"),
            new ArtObjectAd("Title 2","art_sculpture", "This is second description"),
    };

    public BuyArtFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.rootView = inflater.inflate(R.layout.fragment_buy_art, container, false);
        this.listView = rootView.findViewById(R.id.buy_art_list_view);
        if (getActivity() != null) {
             this.arrayAdapter = new ArtObjectAdCustomAdapter(
                    getActivity(), R.layout.art_object_list_item, artObjectAds);

            if (this.listView != null) {
                listView.setAdapter(this.arrayAdapter);
            }
        }
        return rootView;
    }
}