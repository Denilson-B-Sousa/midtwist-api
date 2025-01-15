package app.midtwist.midtwist_api.domain.movie.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.*;

import java.util.List;

public record MovieDTO (

         Long id,

         @NotNull(message = "Adult flag is required.")
         Boolean adult,

         @NotBlank(message = "Backdrop Path is required.")
         @JsonAlias({"backdrop_path", "backdropPath"})
         String backdropPath,

         @JsonAlias("genre_ids")
         List<Integer> genreIds,

         @JsonAlias({"id", "movie_id"})
         Long movieId,

         @NotBlank(message = "Original language is required.")
         @JsonAlias({"original_language", "originalLanguage"})
         String originalLanguage,

         @NotBlank(message = "Original title is required.")
         @JsonAlias({"original_title", "originalTitle"})
         String originalTitle,

         @NotBlank(message = "Overview is required.")
         String overview,

         @NotNull(message = "Popularity is required.")
         @DecimalMin(value = "0.0", inclusive = false, message = "Popularity must be greater than zero.")
         Double popularity,

         @NotBlank(message = "Poster Path is required.")
         @JsonAlias({"poster_path", "posterPath"})
         String posterPath,

         @NotBlank(message = "Release Date is required.")
         @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Release date must be in the format dd-MM-yyyy.")
         @JsonAlias({"release_date", "releaseDate"})
         String releaseDate,

         @NotBlank(message = "Title must be provided.")
         String title,

         @NotNull(message = "Video flag must be provided.")
         Boolean video,

         @NotNull(message = "Vote average must be provided.")
         @DecimalMin(value = "0.0", inclusive = false, message = "Vote average must be greater than zero.")
         @JsonAlias({"vote_average", "voteAverage"})
         Double voteAverage,

         @NotNull(message = "Vote count must be provided.")
         @Min(value = 0, message = "Vote count must be a non-negative number.")
         @JsonAlias({"vote_count", "voteCount"})
         Integer voteCount
){}
