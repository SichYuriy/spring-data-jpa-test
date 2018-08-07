CREATE TABLE `user`(
  `id`          BIGINT      NOT NULL AUTO_INCREMENT,
  `username`    VARCHAR(75) NOT NULL UNIQUE,
  `password`    VARCHAR(75) NOT NULL,
  `male`        TINYINT(1),
  `birth_date`  DATETIME,
   PRIMARY KEY (`id`)
);

CREATE TABLE `playlist`(
  `id`          BIGINT      NOT NULL AUTO_INCREMENT,
  `title`       VARCHAR(75) NOT NULL,
  `description` VARCHAR(75),
  `owner_id`    BIGINT      NOT NULL,
  PRIMARY KEY (`id`),
  INDEX	`fk_playlist_user_index` (`owner_id` ASC),
  CONSTRAINT `fk_playlist_user`
		FOREIGN KEY (`owner_id`)
    REFERENCES `user` (`id`)
);

CREATE TABLE `author`(
	`id`    BIGINT        NOT NULL AUTO_INCREMENT,
	`name`  VARCHAR (75)  NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `album`(
	`id`          BIGINT      NOT NULL AUTO_INCREMENT,
	`title`       VARCHAR(75) NOT NULL,
	`description` VARCHAR(75),
	`author_id`   BIGINT      NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `fk_album_author_index` (`author_id` ASC),
	CONSTRAINT `fk_album_user`
		FOREIGN KEY (`author_id`)
		REFERENCES `author` (`id`)
);

CREATE TABLE `song` (
	`id`        BIGINT      NOT NULL AUTO_INCREMENT,
	`title`     VARCHAR(75) NOT NULL,
	`album_id`  BIGINT      NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `fk_song_album_index` (`album_id` ASC),
	CONSTRAINT `fk_song_album`
		FOREIGN KEY (`album_id`)
		REFERENCES `album` (`id`)
);

CREATE TABLE `user_playlist_map`(
	`id`          BIGINT NOT NULL AUTO_INCREMENT,
	`user_id`     BIGINT NOT NULL,
	`playlist_id` BIGINT NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `fk_user_playlist_map_user_index` (`user_id` ASC),
	INDEX `fk_user_playlist_map_playlist_index` (`playlist_id` ASC),
	CONSTRAINT `fk_user_playlist_map_user`
		FOREIGN KEY (`user_id`)
		REFERENCES `user` (`id`),
	CONSTRAINT `fk_user_playlist_map_playlist`
		FOREIGN KEY (`playlist_id`)
		REFERENCES `playlist` (`id`)
);

CREATE TABLE `song_playlist_map`(
	`id`          BIGINT NOT NULL AUTO_INCREMENT,
	`song_id`     BIGINT NOT NULL,
	`playlist_id` BIGINT NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `fk_song_playlist_map_song_index` (`song_id` ASC),
	INDEX `fk_song_playlist_map_playlist_index` (`playlist_id` ASC),
	CONSTRAINT `fk_song_playlist_map_song`
		FOREIGN KEY (`song_id`)
		REFERENCES `song` (`id`),
	CONSTRAINT `fk_song_playlist_map_playlist`
		FOREIGN KEY (`playlist_id`)
		REFERENCES `playlist` (`id`)
);