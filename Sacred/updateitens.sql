select * from item;
select * from slotequip;
select * from itemtype;
select * from heroequip;
select itemtypeid, count(slotid) from equipable group by itemtypeid;
select * from equipable order by 2;

-- Lista de itens do usuário e os códigos
select he.heroID, u.username, he.SlotId, se.SlotName, he.ItemID, i.Itemname, it.ItemtypeID, it.ItemTypeDesc
from heroequip he
inner join userhero uh on he.heroID = uh.heroID
inner join user u on uh.userID = u.userID
inner join slotequip se on he.slotID = se.slotID
inner join item i on he.ItemID = i.ItemID
inner join itemtype it on i.ItemtypeID = it.ItemtypeID
where
u.username = 'soulartist';

-- Item selecionado do inventário
select he.heroID, u.username, he.SlotId, se.SlotName, he.ItemID, i.Itemname, it.ItemtypeID, it.ItemTypeDesc
from heroequip he
inner join userhero uh on he.heroID = uh.heroID
inner join user u on uh.userID = u.userID
inner join slotequip se on he.slotID = se.slotID
inner join item i on he.ItemID = i.ItemID
inner join itemtype it on i.ItemtypeID = it.ItemtypeID
where
u.username = 'soulartist'
AND he.SlotID > 15
AND i.itemID = 13;

-- View criada a partir da query acima

select * from heroitemtype
where
username = 'soulartist'
AND SlotID > 15
AND itemID = 13;

-- Local onde o ítem do inventário deve ser equipado
select
SlotId,
itemtypeId,
Sysdate()
From
equipable
where
itemtypeId = 2
And SlotId < 15; -- varia se for equipar do inventário ou dos itens atuais



select itemID, heroid from heroitemtype where slotid = 12 and username = 'soulartist';

-- equipa item novo
update heroequip
set SlotId = 12,
    Dtheroequip = Sysdate()
where
HeroId = 72
and ItemId = 13
and SlotId = 19;

CALL proc_equipitem(12,72,13,19);
-- coloca item antigo no inventario
update heroequip
set SlotId = 19,
    Dtheroequip = Sysdate()
where
HeroId = 72
and ItemId = 1
and SlotId = 12;

CALL proc_equipitem(19,1,12,72);

select * from heroequip where heroid = 72 and slotid = 12;

CALL proc_equipitem(19,72,13,12);

CALL proc_equipitem(12,72,1,19);

CALL proc_equipitem(newslotid,ItemID,SlotID,heroid);

update heroequip
set SlotId = 19,
    Dtheroequip = Sysdate()
where
HeroId = 72
and ItemId = 13
and SlotId = 12;

update heroequip
set SlotId = 12,
    Dtheroequip = Sysdate()
where
HeroId = 72
and ItemId = 1
and SlotId = 19;

select * from heroequip where heroid = 72;

update heroequip
set slotid = 19
where itemid = 1;

update heroequip
set slotid = 16
where itemid = 8;

update heroequip
set slotid = 13
where itemid = 7;