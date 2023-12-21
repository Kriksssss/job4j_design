CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,
    book_title VARCHAR(255)
);

CREATE TABLE authors (
    author_id SERIAL PRIMARY KEY,
    author_name VARCHAR(255)
);

CREATE TABLE books_authors (
    id SERIAL PRIMARY KEY,
    book_id INT REFERENCES books(book_id),
    author_id INT REFERENCES authors(author_id),
    UNIQUE (book_id, author_id)
);

INSERT INTO books (book_title) VALUES ('The Great Gatsby');
INSERT INTO authors (author_name) VALUES ('F. Scott Fitzgerald');
INSERT INTO books_authors (book_id, author_id) VALUES (1, 1);

SELECT * FROM books;
SELECT * FROM authors;
