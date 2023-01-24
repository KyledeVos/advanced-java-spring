package platform.codingnomads.co.springdata.example.mybatis.mapperslesson;

import lombok.*;

@Data
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class Song {

    private Long id;

    private String name;

    //allowed to be null if single
    private String album_name;

    private String artist_name;

    //song length in seconds
    private int song_length;
}
