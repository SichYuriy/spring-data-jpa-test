-- USER ---------------------------------------------------
INSERT INTO `user`
	(`id`, `username`, `password`, `male`, `birth_date`)
VALUES
	(1, 'user1', 'pass1', 1, '1997-3-23');

-- AUTHOR -------------------------------------------------
INSERT INTO `author`
	(`id`, `name`)
VALUES
	(1, 'author1');

-- ALBUM --------------------------------------------------
INSERT INTO `album`
	(`id`, `author_id`, `title`, `description`)
VALUES
	(1, 1, 'album1', 'description of album1');

-- PLAYLIST -----------------------------------------------
INSERT INTO `playlist`
	(`id`, `owner_id`, `title`, `description`)
VALUES
	(1, 1, 'playlist1', 'desc1');

-- SONG ---------------------------------------------------
INSERT INTO `song`
	(`id`, `album_id`, `title`)
VALUES
	(1, 1, 'song1');