DELIMITER $$

DROP PROCEDURE IF EXISTS `oneworld`.`proc_upLost` $$
CREATE PROCEDURE `oneworld`.`proc_upLost` (
heroname varchar(100)
)
BEGIN

set @heroname = heroname;

update hero
set herohp = 0
where
heroname = @heroname;

END $$

DELIMITER ;