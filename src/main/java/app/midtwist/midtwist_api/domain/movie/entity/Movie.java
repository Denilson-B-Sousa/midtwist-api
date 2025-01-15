package app.midtwist.midtwist_api.domain.movie.entity;

import app.midtwist.midtwist_api.domain.movie.records.MovieDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "movies")
@Entity(name = "movie")
@EqualsAndHashCode(of = "id")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Version
    private Long version;
    private Boolean adult;
    private String backdropPath;
    @ElementCollection
    @CollectionTable(name = "movie_genre_ids", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genre_id")
    @JsonAlias("genre_ids")
    private List<Integer> genreIds;
    private Long movieId;
    private String originalLanguage;
    private String originalTitle;
    @Column(length = 1024)
    private String overview;
    private Double popularity;
    private String posterPath;
    private String releaseDate;
    private String title;
    private Boolean video;
    private Double voteAverage;
    private Integer voteCount;


    public Movie(MovieDTO movieDTO) {
        this.adult = movieDTO.adult();
        this.backdropPath = movieDTO.backdropPath();
        this.genreIds = movieDTO.genreIds();
        this.movieId = movieDTO.movieId();
        this.originalLanguage = movieDTO.originalLanguage();
        this.originalTitle = movieDTO.originalTitle();
        this.overview = movieDTO.overview();
        this.popularity = movieDTO.popularity();
        this.posterPath = movieDTO.posterPath();
        this.releaseDate = movieDTO.releaseDate();
        this.title = movieDTO.title();
        this.video = movieDTO.video();
        this.voteAverage = movieDTO.voteAverage();
        this.voteCount = movieDTO.voteCount();
    }
}
