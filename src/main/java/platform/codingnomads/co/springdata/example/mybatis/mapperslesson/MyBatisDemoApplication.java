package platform.codingnomads.co.springdata.example.mybatis.mapperslesson;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class MyBatisDemoApplication {

    /* Before running this app, be sure to:

        * create a new empty schema in the mysql database named "mybatis"

        * execute the SQL found "songs_table.sql" on the mybatis schema

        * update the "spring.datasource.url" property in your application.properties file to
          jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

     */

    public static void main(String[] args) {
        SpringApplication.run(MyBatisDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper) {
        return (args) -> {
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbum_name("Bon Iver");
            song1.setArtist_name("Bon Iver");
            song1.setSong_length(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbum_name("Orca");
            song2.setArtist_name("Gus Dapperton");
            song2.setSong_length(279);

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);

            Song song3 = songMapper.getSongById(1L);

            ArrayList<Song> longSongs = songMapper.getSongsWithLengthGreaterThan(250);

            longSongs.forEach(System.out::println);

            System.out.println(song3.toString());

            //TASK
            //My own methods
            songMapper.insertTwoSongs(
                    Song.builder().name("639").artist_name("Fetty Wap").album_name("Eclipse").
                            song_length(5).build(),
                    Song.builder().name("Lucid Dreams").artist_name("JuiceWrld").album_name("forever").
                            song_length(3).build()
            );

            songMapper.insertTwoSongs(
                    Song.builder().name("Mirror").artist_name("Bruno Mars").album_name("Eternal").
                            song_length(5).build(),
                    Song.builder().name("Flaws and Sins").artist_name("JuiceWrld").album_name("forever").
                            song_length(4).build()
            );

            System.out.println(songMapper.updateSongNameById("2Chains", 1));

            //Implementing unused methods

            System.out.println("\n***********Get Song By Name************");
            System.out.println(songMapper.getSongsByName("Post Humorous"));

            System.out.println("\n***********Get Song List by Artist_Name and Album************");
            songMapper.getSongsByAlbumAndArtist("JuiceWrld", "forever")
                    .forEach(System.out::println);

            System.out.println("\n***********Update Song Details and Get Song List by Artist Name************");
            //print old song details by artist
            System.out.println("OLD LIST");
            songMapper.getSongsByArtist("JuiceWrld").forEach(System.out::println);

            Song song = new Song(4L, "The Other Side", "forever", "JuiceWrld", 3);
            songMapper.updateSong(song);
            System.out.println("NEW LIST");
            songMapper.getSongsByArtist("JuiceWrld").forEach(System.out::println);

            System.out.println("\n***********Delete a Song BY ID************");
            songMapper.deleteSongById(4L);

            System.out.println("\n***********Delete all Songs belonging to an artist and album************");
            songMapper.deleteSongsByAlbumAndArtist("JuiceWrld", "forever");
        };
    }
}
