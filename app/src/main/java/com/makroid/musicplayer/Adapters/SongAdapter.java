package com.makroid.musicplayer.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.makroid.musicplayer.Model.Song;
import com.makroid.musicplayer.R;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    ArrayList<Song> songList;
    Context context;
    private LayoutInflater inflater;
    public SongAdapter(ArrayList<Song> songList, Context context) {
        this.songList = songList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.song_row, parent, false);
//        int hieght = parent.getMeasuredHeight()/8;
//        view.setMinimumHeight(hieght);
        return new SongViewHolder(view);
    }
        @Override
    public void onBindViewHolder(SongViewHolder holder, final int position) {

//        if(position == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams =
                    (ViewGroup.MarginLayoutParams) holder.layout.getLayoutParams();
        if(position == 0)
            marginLayoutParams.setMargins(0, 30, 0, 100); //Left top right bottom
            else
            marginLayoutParams.setMargins(0, 0, 0, 100);
            holder.layout.setLayoutParams(marginLayoutParams);
//        }
            Song item = songList.get(position);
        holder.imageView.setImageResource(R.drawable.ic_music_player);
        holder.textView.setText(item.title);
        holder.artistView.setText(item.artistName);
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder{
        protected ImageView imageView;
        protected TextView textView;
        protected TextView artistView;
        protected LinearLayout layout;

        public SongViewHolder(View itemView) {
            super(itemView);
            layout = (LinearLayout) itemView.findViewById(R.id.linear_layout);
            imageView = (ImageView) itemView.findViewById(R.id.album_art);
            textView = (TextView) itemView.findViewById(R.id.song_name);
            artistView = (TextView) itemView.findViewById(R.id.artist);
        }

    }
}
