DELIMITER $$

DROP PROCEDURE IF EXISTS `oneworld`.`proc_ranking` $$
CREATE PROCEDURE `oneworld`.`proc_ranking` ()
BEGIN

select
c.classname,
h.heroname,
h.herolevel,
h.heroexp
from
hero h
inner join class c on
c.classid = h.classid
order by
h.heroexp desc,
h.herolevel;

END $$

DELIMITER ;