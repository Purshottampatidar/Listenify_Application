package Application;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private String albumName;
    private String artistName;

    private List<Song> songList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList=new ArrayList<>();
    }

    public Album(String albumName, String artistName, List<Song> songList) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = songList;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public boolean findSong(String title){
        for(Song song : songList){
            if(song.getName().equals(title)){
                return true;
            }
        }
        return false;
    }

    public String addNewSongToAlbum(String title,double duration){
        if(findSong(title)){
            return "Song is Already present in songList";
        }

        Song newSong=new Song(title,duration);
        songList.add(newSong);
        return "Song "+title + " is added to songList";
    }

    public String addSongToPlayList(int songNo,List<Song> playList){
        int idx=songNo-1;
        if(idx>=0 && idx<songList.size()){
            Song song=songList.get(idx);
            playList.add(song);
            return "Song added to playList";
        }
        else{
            return "Invalid songNo";
        }
    }

    public String addSongToPlayList(String songName,List<Song> playList){
        for(Song song : songList){
            if(song.getName().equals(songName)){
                playList.add(song);
                return "song added to playList";
            }
        }
        return "Invalid song Name";
    }
}
