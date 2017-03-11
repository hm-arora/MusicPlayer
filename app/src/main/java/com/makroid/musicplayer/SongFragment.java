package com.makroid.musicplayer;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makroid.musicplayer.Adapters.SongAdapter;
import com.makroid.musicplayer.Model.Song;

import java.io.File;
import java.util.ArrayList;

public class SongFragment extends Fragment{
    RecyclerView recyclerView;
    private File storage = Environment.getExternalStorageDirectory();
    LinearLayoutManager layoutManager;
    ArrayList<Song> songArrayList;
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public SongFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        SongFragment fragment = new SongFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }
    //connect to the service


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("adsdas",storage.toString());
        View view = inflater.inflate(R.layout.songs_fragment, container, false);
        songArrayList = SongLoader.getAllSongs(getActivity());
                recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        SongAdapter songAdapter = new SongAdapter(songArrayList,getActivity());
        recyclerView.setAdapter(songAdapter);
        return view;
    }

}
