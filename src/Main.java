import Application.Album;
import Application.Song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("welcome to Listenify world!");


        Album album1=new Album("New Hindi Songs" ,"Arijit Singh");
        album1.addNewSongToAlbum("Tum Hi Ho",3.5);
        album1.addNewSongToAlbum("What Jhumka",4.5);
        album1.addNewSongToAlbum("Kesariy",5.0);
        album1.addNewSongToAlbum("Shayad",6.1);

        Album album2=new Album("Old Hindi Songs","Kishor Kumar");

        album2.addNewSongToAlbum("Ek Chatur Narr",3.5);
        album2.addNewSongToAlbum("Neele Neele Amber Prr",5.1);
        album2.addNewSongToAlbum("Mere Sapno Ki Rani",5.3);

        List<Song> playList =new ArrayList<>();

        album1.addSongToPlayList(1,playList);
        album1.addSongToPlayList(3,playList);

        album2.addSongToPlayList("Neele Neele Amber Prr",playList);
        album2.addSongToPlayList("Mere Sapno Ki Rani",playList);

        printMenu();

        startSong(playList);

    }
    public static void startSong(List<Song> playList){
        int idx=0;
        System.out.println("Now Playing "+ playList.get(idx).toString());

        Scanner sc=new Scanner(System.in);
        boolean continuePlayList=true;

        while(continuePlayList){
            System.out.println("Enter your choose !!");
            int choice=sc.nextInt();

            switch (choice){
                case 1:
                    if(idx<playList.size()-1){
                        idx++;
                        System.out.println("Now Playing "+ playList.get(idx).toString());
                    }
                    else{
                        System.out.println("you are already in last Song");
                    }
                    break;

                case 2:
                     if(idx>0){
                         idx--;
                         System.out.println("Now Playing "+ playList.get(idx).toString());
                     }
                     else{
                         System.out.println("you are already on first Song ");
                     }
                     break;

                case 3:
                    System.out.println("Now Playing "+ playList.get(idx).toString());
                     break;

                case 4:
                        System.out.println("Song that are present in list are");
                        for(Song song : playList){
                            System.out.println(song.toString());
                        }
                        break;
                case 5:
                    printMenu();
                    break;

                case 6:
                     playList.remove(idx);
                     if(idx==playList.size()){
                         idx=0;
                     }
                     break;
                case 7:
                    Collections.shuffle(playList);
                    break;

                case 8:
                      continuePlayList=false;
                      break;


            }
        }
    }
    public static void printMenu(){
        System.out.println("There are the options you can choose form");
        System.out.println("1. GoTo and play next Song");
        System.out.println("2. GoTo the previous Song");
        System.out.println("3. Repeat the same Song");
        System.out.println("4. Show all Songs of playList");
        System.out.println("5. Print the Menu");
        System.out.println("6. Delete the current Song");
        System.out.println("7. Shuffle the playList");
        System.out.println("8. exit ");
    }
}