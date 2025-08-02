CREATE TABLE topics
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    message    TEXT         NOT NULL,
    created_at DATETIME NULL,
    status     VARCHAR(50),
    author     VARCHAR(100),
    course     VARCHAR(100)
);
