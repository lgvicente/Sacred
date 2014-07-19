DELIMITER $$

DROP PROCEDURE IF EXISTS `oneworld`.`proc_inBattleItens` $$
CREATE PROCEDURE `oneworld`.`proc_inBattleItens` (
Qtd int,
Item varchar(100),
heroname varchar(100)
)
BEGIN

set @qtd = Qtd,
    @Item = Item,
    @heroname = heroname;

Insert into heroequip
(
heroid,
slotid,
itemid,
qtditem,
Dtheroquip
)
Select
h.heroid,
15,
i.itemid,
@qtd,
sysdate()
from
hero h
inner join item i on
i.itemname = @Item
where
heroname = @heroname;


END $$

DELIMITER ;