package app.midtwist.midtwist_api.domain.movie.service;

import app.midtwist.midtwist_api.domain.movie.entity.Movie;
import app.midtwist.midtwist_api.domain.movie.impl.MovieRepository;
import app.midtwist.midtwist_api.domain.movie.records.MovieDTO;
import app.midtwist.midtwist_api.domain.movie.records.MovieDetails;
import app.midtwist.midtwist_api.domain.movie.records.MovieReleaseData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional
    public MovieDetails createMovie(MovieDTO movieDTO) {
        var movie = new Movie(movieDTO);

        if(movie.getId() != null && movieRepository.existsById(movie.getId())) {
            movie = entityManager.merge(movie);
        } else {
            movie = movieRepository.saveAndFlush(movie);
        }

        return new MovieDetails(movie);
    }

    @Transactional
    public Page<MovieDetails> listMovie(Pageable pagination) {
        return movieRepository.findAll(pagination).map(MovieDetails::new);
    }

    @Transactional
    public MovieDetails releaseMovie(MovieReleaseData data) {
        var movie = movieRepository.getReferenceById(data.id());
        return new MovieDetails(movie);
    }

    @Transactional
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
