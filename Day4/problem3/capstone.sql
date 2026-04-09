CREATE DATABASE IF NOT EXISTS capstone;
USE capstone;

CREATE TABLE users(
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100),
    bio TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE posts(
    post_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    caption TEXT,
    media_url VARCHAR(225),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE likes(
    like_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    post_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(user_id, post_id),
    FOREIGN KEY(user_id) REFERENCES users(user_id),
    FOREIGN KEY(post_id) REFERENCES posts(post_id)
);

CREATE TABLE comments(
    comment_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    post_id INT,
    text TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(user_id, post_id),
    FOREIGN KEY(user_id) REFERENCES users(user_id),
    FOREIGN KEY(post_id) REFERENCES posts(post_id)
);

CREATE TABLE follows(
    follower_id INT,
    following_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(follower_id, following_id),
    FOREIGN KEY(follower_id) REFERENCES users(user_id),
    FOREIGN KEY(following_id) REFERENCES users(user_id)
);
INSERT INTO users (username, email, password, bio) VALUES
('vanshika', 'vanshika@gmail.com', '1234', 'Tech enthusiast'),
('rahul', 'rahul@gmail.com', 'abcd', 'Traveler'),
('ananya', 'ananya@gmail.com', 'pass123', 'Food lover'),
('rohit', 'rohit@gmail.com', 'xyz', 'Fitness freak');

INSERT INTO posts (user_id, caption, media_url) VALUES
(1, 'My first post!', 'img1.jpg'),
(2, 'Travel diaries ', 'img2.jpg'),
(3, 'Delicious food ', 'img3.jpg'),
(1, 'Coding life ', 'img4.jpg');

INSERT INTO likes (user_id, post_id) VALUES
(2, 1),
(3, 1),
(1, 2),
(4, 3),
(2, 4);

INSERT INTO follows (follower_id, following_id) VALUES
(1, 2),
(1, 3),
(2, 1),
(3, 4),
(4, 1);