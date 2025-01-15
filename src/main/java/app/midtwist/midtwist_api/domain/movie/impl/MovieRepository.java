package app.midtwist.midtwist_api.domain.movie.impl;

import app.midtwist.midtwist_api.domain.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Long> {

}
