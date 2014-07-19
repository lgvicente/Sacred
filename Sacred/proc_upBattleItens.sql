DELIMITER $$

DROP PROCEDURE IF EXISTS `oneworld`.`proc_upBattleItens` $$
CREATE PROCEDURE `oneworld`.`proc_upBattleItens` (
Qtd int,
heroname varchar(50)
)
BEGIN

set @qtd = Qtd,
    @heroname = heroname;

Update heroequip
Set QtdItem = QtdItem + @qtd
where
slotid = 16
and heroid in
(select heroid from hero where heroname = @heroname);

END $$

DELIMITER ;