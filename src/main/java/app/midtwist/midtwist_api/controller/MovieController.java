package app.midtwist.midtwist_api.controller;

import app.midtwist.midtwist_api.domain.movie.records.MovieDTO;
import app.midtwist.midtwist_api.domain.movie.records.MovieDetails;
import app.midtwist.midtwist_api.domain.movie.records.MovieReleaseData;
import app.midtwist.midtwist_api.domain.movie.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieDetails> createMovie(@RequestBody @Valid MovieDTO movieDTO,
                                                    UriComponentsBuilder uriComponentsBuilder) {
        var movieDetails = movieService.createMovie(movieDTO);
        var uri = uriComponentsBuilder.path("/movies/{id}").buildAndExpand(movieDetails.id()).toUri();
        return ResponseEntity.created(uri).body(movieDetails);

    }

    @GetMapping
    public ResponseEntity<Page<MovieDetails>> findMovie(@PageableDefault(size = 21) Pageable pagination) {
        var movies = movieService.listMovie(pagination);
        return ResponseEntity.ok(movies);
    }

    @PutMapping
    public ResponseEntity<MovieDetails> release(@RequestBody @Valid MovieReleaseData data) {
        var movieDetails = movieService.releaseMovie(data);
        return ResponseEntity.ok(movieDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
