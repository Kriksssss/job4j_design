INSERT INTO users (username, email) VALUES
    ('user1', 'user1@example.com'),
    ('user2', 'user2@example.com');

INSERT INTO roles (role_name) VALUES
    ('admin'),
    ('user');

INSERT INTO rules (rule_name) VALUES
    ('read'),
    ('write');

INSERT INTO items (title, user_id, category_id, state_id) VALUES
    ('Request 1', 1, 1, 1),
    ('Request 2', 2, 2, 1);

INSERT INTO comments (item_id, user_id, comment_text) VALUES
    (1, 1, 'Comment 1 for Request 1'),
    (1, 2, 'Comment 2 for Request 1'),
    (2, 1, 'Comment 1 for Request 2');

INSERT INTO attachs (item_id, file_path) VALUES
    (1, '/path/to/file1'),
    (1, '/path/to/file2'),
    (2, '/path/to/file3');

INSERT INTO states (state_name) VALUES
    ('Open'),
    ('Closed');

INSERT INTO categories (category_name) VALUES
    ('Category 1'),
    ('Category 2');

INSERT INTO role_rules (role_id, rule_id) VALUES
    (1, 1),
    (1, 2),
    (2, 1);

INSERT INTO item_roles (item_id, role_id) VALUES
    (1, 1),
    (2, 2);