

CREATE TABLE wiseSaying (
id int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
author varchar(100) NOT NULL,
content text NOT NULL
);
SELECT * FROM wiseSaying;
INSERT INTO wiseSaying
SET id = 1,
author = "test1",
content = "test1";