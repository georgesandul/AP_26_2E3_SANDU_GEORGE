CREATE TABLE IF NOT EXISTS genres(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS movies(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL UNIQUE ,
    release_date TEXT,
    duration INTEGER,
    score REAL,
    genre_id INTEGER,
    FOREIGN KEY (genre_id) REFERENCES genres(id)
);

CREATE TABLE  IF NOT EXISTS actors(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS movie_actors(
    movie_id INTEGER,
    actor_id INTEGER,
    PRIMARY KEY (movie_id, actor_id),
    FOREIGN KEY (movie_id) REFERENCES movies(id),
    FOREIGN KEY (actor_id) REFERENCES actors(id)
);

CREATE VIEW IF NOT EXISTS movie_report AS
SELECT m.title, m.release_date, m.score, g.name AS genre
FROM movies m
         JOIN genres g ON m.genre_id = g.id;