CREATE VIEW `oneworld`.`HeroItens` AS
Select
he.*,
h.heroname,
h.heromana,
h.herohp,
h.herolevel,
h.heroexp,
se.slotname,
i.itemname,
u.userlogin
from
heroequip he
inner join hero h on
he.heroid = h.heroid
inner join slotequip se on
se.slotid = he.slotid
inner join item i on
i.itemid = he.itemid
inner join userhero uh on
uh.heroid = h.heroid
inner join user u on
u.userid = uh.userid;