INSERT INTO `user`(`id`, `username`, `password`, `male`, `birth_date`)
VALUES(1, 'user1', 'pass1', 1, '1997-3-23');

INSERT INTO `author`(`id`, `name`)
VALUES(1, 'author1');

INSERT INTO `album`(`id`, `author_id`, `title`, `description`)
VALUES(1, 1, 'album1', 'description of album1');