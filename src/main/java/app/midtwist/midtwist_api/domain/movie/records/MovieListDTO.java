package app.midtwist.midtwist_api.domain.movie.records;

import app.midtwist.midtwist_api.domain.movie.entity.Movie;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record MovieListDTO(

            Long id,

            Boolean adult,

            String backdropPath,

            @JsonAlias("genre_ids")
            List<Integer> movieGenreIds,

            @JsonAlias({"id", "movie_id"})
            Long movieId,

            String originalLanguage,

            String originalTitle,

            String overview,

            Double popularity,

            String posterPath,

            String releaseDate,

            String title,

            Boolean video,

            Double voteAverage,

            Integer voteCount
    ) {

        public MovieListDTO(Movie movie) {
            this(movie.getId(), movie.getAdult(), movie.getBackdropPath(), movie.getGenreIds(), movie.getMovieId(),
                 movie.getOriginalLanguage(), movie.getOriginalTitle(), movie.getOverview(), movie.getPopularity(),
                 movie.getPosterPath(), movie.getReleaseDate(), movie.getTitle(), movie.getVideo(),
                 movie.getVoteAverage(), movie.getVoteCount()
            );
        }
    }

