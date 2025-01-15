CREATE TABLE movies (
                        id BIGSERIAL PRIMARY KEY,
                        adult BOOLEAN NOT NULL,
                        backdrop_path VARCHAR(1000) NOT NULL,
                        genre_ids INTEGER[],
                        movie_id BIGINT  UNIQUE,
                        original_language VARCHAR(10) NOT NULL,
                        original_title VARCHAR(1000) NOT NULL,
                        overview TEXT NOT NULL,
                        popularity DOUBLE PRECISION NOT NULL,
                        poster_path VARCHAR(1000) NOT NULL,
                        release_date VARCHAR(255) NOT NULL,
                        title VARCHAR(1000) NOT NULL,
                        video BOOLEAN NOT NULL,
                        vote_average DOUBLE PRECISION NOT NULL,
                        vote_count INTEGER NOT NULL
);
