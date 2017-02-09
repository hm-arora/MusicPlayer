package com.makroid.musicplayer.Model;


public class Song {
    private long id;
    private String title,artist,album;
    public Song(long songID, String songTitle, String songArtist,String Album) {
        id=songID;
        album = Album;
        title=songTitle;
        artist=songArtist;
    }
    public long getID(){return id;}
    public String getAlbum(){return album;}
    public String getTitle(){return title;}
    public String getArtist(){return artist;}
}
