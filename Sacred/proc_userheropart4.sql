DELIMITER $$

DROP PROCEDURE IF EXISTS `UserHeroPart4` $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `UserHeroPart4`(
hname varchar(100)
)
BEGIN

set @hname = hname;

Insert Into heroequip
(
HeroId,
SlotId,
ItemId,
Dtheroequip
)
select
heroid,
16,
8 as gold,
0,
sysdate()
from
hero
where
heroname = @heroname;

END $$

DELIMITER ;