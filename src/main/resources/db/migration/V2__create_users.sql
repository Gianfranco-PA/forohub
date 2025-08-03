CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(20) NOT NULL
);

INSERT INTO users (username, password, role)
VALUES ('FOROHUB', '$2a$10$JdxS3WFYu54yUezRvOOwCuNm0ucy2QekNQgBt3bEiGtbNVx0CoYea', 'ROLE_ADMIN');
