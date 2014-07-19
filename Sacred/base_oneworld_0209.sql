DROP TABLE IF EXISTS `oneworld`.`class`;
CREATE TABLE  `oneworld`.`class` (
  `ClassID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ClassName` varchar(45) NOT NULL,
  `DtClass` datetime NOT NULL,
  PRIMARY KEY (`ClassID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COMMENT='Class List';

DROP TABLE IF EXISTS `oneworld`.`country`;
CREATE TABLE  `oneworld`.`country` (
  `CountryID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CountryName` varchar(45) NOT NULL,
  `DTCountry` datetime DEFAULT NULL,
  PRIMARY KEY (`CountryID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `oneworld`.`enemy`;
CREATE TABLE  `oneworld`.`enemy` (
  `EnemyID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `EnemyName` varchar(45) NOT NULL,
  `EnemyTypeID` int(10) unsigned NOT NULL,
  `EnemyLevel` int(10) unsigned NOT NULL,
  `EnemyStr` int(10) unsigned NOT NULL,
  `EnemySta` int(10) unsigned NOT NULL,
  `EnemyAgi` int(10) unsigned NOT NULL,
  `EnemyInt` int(10) unsigned NOT NULL,
  `EnemySpr` int(10) unsigned NOT NULL,
  `EnemyExp` int(10) unsigned NOT NULL,
  `EnemyMana` int(10) unsigned NOT NULL,
  `EnemyArmor` int(10) unsigned NOT NULL,
  `EnemyDps` int(10) unsigned NOT NULL,
  `EnemyHeal` int(10) unsigned NOT NULL,
  `EnemySpellPower` int(10) unsigned NOT NULL,
  `DtEnemy` datetime NOT NULL,
  `EnemyHP` int(10) unsigned NOT NULL,
  PRIMARY KEY (`EnemyID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='enemy list';

DROP TABLE IF EXISTS `oneworld`.`enemyloot`;
CREATE TABLE  `oneworld`.`enemyloot` (
  `EnemyID` int(10) unsigned NOT NULL,
  `ItemID` int(10) unsigned NOT NULL,
  `QtdItem` int(10) unsigned NOT NULL,
  `Prob` float NOT NULL,
  PRIMARY KEY (`EnemyID`,`ItemID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `oneworld`.`enemytype`;
CREATE TABLE  `oneworld`.`enemytype` (
  `EnemyTypeID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `EnemyTypeDesc` varchar(50) NOT NULL,
  `DtEnemyType` datetime NOT NULL,
  PRIMARY KEY (`EnemyTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `oneworld`.`hero`;
CREATE TABLE  `oneworld`.`hero` (
  `HeroID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ClassID` int(10) unsigned NOT NULL,
  `HeroStr` int(10) unsigned NOT NULL,
  `HeroSta` int(10) unsigned NOT NULL,
  `HeroAgi` int(10) unsigned NOT NULL,
  `HeroInt` int(10) unsigned NOT NULL,
  `HeroSpr` int(10) unsigned NOT NULL,
  `DtHero` datetime NOT NULL,
  `HeroName` varchar(100) NOT NULL,
  `HeroLevel` int(10) unsigned NOT NULL,
  `HeroExp` int(10) unsigned NOT NULL,
  `HeroHp` int(10) unsigned NOT NULL,
  `HeroMana` int(10) unsigned NOT NULL,
  PRIMARY KEY (`HeroID`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `oneworld`.`heroequip`;
CREATE TABLE  `oneworld`.`heroequip` (
  `HeroID` int(10) unsigned NOT NULL,
  `SlotID` int(10) unsigned NOT NULL,
  `ItemID` int(10) unsigned NOT NULL,
  `QtdItem` int(10) unsigned NOT NULL,
  `Dtheroequip` datetime NOT NULL,
  PRIMARY KEY (`HeroID`,`SlotID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `oneworld`.`item`;
CREATE TABLE  `oneworld`.`item` (
  `ItemID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ItemName` varchar(100) NOT NULL,
  `ItemTypeID` int(10) unsigned NOT NULL,
  `ItemValue` int(10) unsigned NOT NULL,
  `ItemClassID` int(10) unsigned NOT NULL,
  `ItemDesc` varchar(200) NOT NULL,
  `ItemRarityID` int(10) unsigned NOT NULL,
  `DtItem` datetime NOT NULL,
  `AttributeID` int(10) unsigned DEFAULT NULL,
  `Itemlvl` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ItemID`),
  KEY `FK_item_attribute` (`AttributeID`),
  KEY `FK_item_rarity` (`ItemRarityID`),
  KEY `FK_item_class` (`ItemClassID`),
  KEY `FK_item_type` (`ItemTypeID`),
  CONSTRAINT `FK_item_attribute` FOREIGN KEY (`AttributeID`) REFERENCES `itemattribute` (`AttributeID`),
  CONSTRAINT `FK_item_class` FOREIGN KEY (`ItemClassID`) REFERENCES `class` (`ClassID`),
  CONSTRAINT `FK_item_rarity` FOREIGN KEY (`ItemRarityID`) REFERENCES `itemrarity` (`ItemRarityID`),
  CONSTRAINT `FK_item_type` FOREIGN KEY (`ItemTypeID`) REFERENCES `itemtype` (`ItemTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `oneworld`.`itemattribute`;
CREATE TABLE  `oneworld`.`itemattribute` (
  `AttributeID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Dps` int(10) unsigned NOT NULL,
  `Armor` int(10) unsigned NOT NULL,
  `Str` int(10) unsigned NOT NULL,
  `Sta` int(10) unsigned NOT NULL,
  `Agi` int(10) unsigned NOT NULL,
  `Inte` int(10) unsigned NOT NULL,
  `Spr` int(10) unsigned NOT NULL,
  `Heal` int(10) unsigned NOT NULL,
  `Spellpower` int(10) unsigned NOT NULL,
  `DtAttribute` datetime NOT NULL,
  PRIMARY KEY (`AttributeID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `oneworld`.`itemrarity`;
CREATE TABLE  `oneworld`.`itemrarity` (
  `ItemRarityID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ItemRarityDesc` varchar(50) NOT NULL,
  `DtItemRarity` datetime NOT NULL,
  PRIMARY KEY (`ItemRarityID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `oneworld`.`itemtype`;
CREATE TABLE  `oneworld`.`itemtype` (
  `ItemTypeID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ItemTypeDesc` varchar(50) NOT NULL,
  `DtItemType` datetime NOT NULL,
  PRIMARY KEY (`ItemTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `oneworld`.`mail`;
CREATE TABLE  `oneworld`.`mail` (
  `mailid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `useridfrom` int(10) unsigned NOT NULL,
  `useridto` int(10) unsigned NOT NULL,
  `mailbody` varchar(1000) NOT NULL,
  `dtmail` datetime NOT NULL,
  `mailsub` varchar(100) NOT NULL,
  PRIMARY KEY (`mailid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `oneworld`.`map_area`;
CREATE TABLE  `oneworld`.`map_area` (
  `mareaid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mcontinentid` int(10) unsigned NOT NULL,
  `mcountryid` int(10) unsigned NOT NULL,
  `mareadesc` varchar(100) NOT NULL,
  `mareatypeid` int(10) unsigned NOT NULL,
  `dtmarea` datetime NOT NULL,
  PRIMARY KEY (`mareaid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `oneworld`.`map_area_type`;
CREATE TABLE  `oneworld`.`map_area_type` (
  `mareatypeid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mareatypedesc` varchar(45) NOT NULL,
  `dtmareatype` varchar(45) NOT NULL,
  PRIMARY KEY (`mareatypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `oneworld`.`map_continent`;
CREATE TABLE  `oneworld`.`map_continent` (
  `mcontinentid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mcontinentdesc` varchar(45) NOT NULL,
  `dtmcontinent` datetime NOT NULL,
  PRIMARY KEY (`mcontinentid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `oneworld`.`map_country`;
CREATE TABLE  `oneworld`.`map_country` (
  `mcountryid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mcountrydesc` varchar(45) NOT NULL,
  `dtmcountry` datetime NOT NULL,
  PRIMARY KEY (`mcountryid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `oneworld`.`skill`;
CREATE TABLE  `oneworld`.`skill` (
  `SkillID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ClassID` int(10) unsigned NOT NULL,
  `SkillName` varchar(45) NOT NULL,
  `SkillDesc` varchar(300) NOT NULL,
  `DtSkill` datetime NOT NULL,
  PRIMARY KEY (`SkillID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Skill List';

DROP TABLE IF EXISTS `oneworld`.`slotequip`;
CREATE TABLE  `oneworld`.`slotequip` (
  `SlotID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `SlotName` varchar(50) NOT NULL,
  `DtSlot` datetime NOT NULL,
  PRIMARY KEY (`SlotID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `oneworld`.`user`;
CREATE TABLE  `oneworld`.`user` (
  `UserID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `UserName` varchar(100) NOT NULL,
  `UserLastName` varchar(100) NOT NULL,
  `UserEmail` varchar(100) NOT NULL,
  `UserAddress` varchar(100) NOT NULL,
  `UserCountry` varchar(100) NOT NULL,
  `UserPremmium` tinyint(1) NOT NULL,
  `DtUser` datetime NOT NULL,
  `UserPwd` varchar(45) NOT NULL,
  `UserLogin` varchar(100) NOT NULL,
  `UserCity` varchar(100) NOT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1 COMMENT='User Table';

DROP TABLE IF EXISTS `oneworld`.`userhero`;
CREATE TABLE  `oneworld`.`userhero` (
  `UserID` int(10) unsigned NOT NULL,
  `HeroID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`UserID`,`HeroID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP VIEW IF EXISTS `oneworld`.`attribute_total`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW  `oneworld`.`attribute_total` AS select `hp`.`userid` AS `userid`,`hp`.`heroid` AS `heroid`,`hp`.`userlogin` AS `userlogin`,`hp`.`heroname` AS `heroname`,`hp`.`herolevel` AS `herolevel`,sum(`ia`.`Dps`) AS `dps`,sum(`ia`.`Armor`) AS `armor`,sum(`ia`.`Heal`) AS `heal`,sum(`ia`.`Spellpower`) AS `spellpower`,sum(`ia`.`Str`) AS `Str`,sum(`ia`.`Sta`) AS `Sta`,sum(`ia`.`Agi`) AS `Agi`,sum(`ia`.`Inte`) AS `Inte`,sum(`ia`.`Spr`) AS `Spr` from ((`heroprofile` `hp` join `item` `i` on((`hp`.`itemid` = `i`.`ItemID`))) join `itemattribute` `ia` on((`i`.`AttributeID` = `ia`.`AttributeID`))) group by `hp`.`userid`,`hp`.`heroid`,`hp`.`userlogin`,`hp`.`heroname`,`hp`.`herolevel`;

DROP VIEW IF EXISTS `oneworld`.`enemyattribute`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW  `oneworld`.`enemyattribute` AS select `enemy`.`EnemyID` AS `enemyid`,`enemy`.`EnemyName` AS `enemyname`,`enemy`.`EnemyTypeID` AS `enemytypeid`,`enemy`.`EnemyLevel` AS `enemylevel`,`enemy`.`EnemyStr` AS `enemystr`,`enemy`.`EnemySta` AS `enemysta`,`enemy`.`EnemyAgi` AS `enemyagi`,`enemy`.`EnemyInt` AS `enemyint`,`enemy`.`EnemySpr` AS `enemyspr`,`enemy`.`EnemyExp` AS `enemyexp`,`enemy`.`EnemyMana` AS `enemymana`,`enemy`.`EnemyHP` AS `enemyhp`,(`enemy`.`EnemyArmor` + ((`enemy`.`EnemyStr` * 0.4) + (`enemy`.`EnemyAgi` * 0.1))) AS `armor`,(`enemy`.`EnemyDps` + ((`enemy`.`EnemyStr` * 0.25) + (`enemy`.`EnemyAgi` * 0.25))) AS `dps`,(`enemy`.`EnemyHeal` + ((`enemy`.`EnemySpr` * 0.4) + (`enemy`.`EnemyInt` * 0.1))) AS `heal`,(`enemy`.`EnemySpellPower` + ((`enemy`.`EnemySpr` * 0.4) + (`enemy`.`EnemyInt` * 0.1))) AS `spellpower` from `enemy`;

DROP VIEW IF EXISTS `oneworld`.`heroattribute`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW  `oneworld`.`heroattribute` AS select `hp`.`HeroID` AS `heroid`,`hp`.`HeroName` AS `heroname`,`u`.`UserLogin` AS `userlogin`,`hp`.`HeroLevel` AS `herolevel`,round((((`hp`.`HeroSta` + `attot`.`Sta`) * 2) + `hp`.`HeroHp`),0) AS `HP`,round((((`hp`.`HeroInt` + `attot`.`Inte`) * 2) + `hp`.`HeroMana`),0) AS `Mana`,(`attot`.`dps` + (((`hp`.`HeroStr` + `attot`.`Str`) * 0.5) + ((`hp`.`HeroAgi` + `attot`.`Agi`) * 0.5))) AS `Dps`,(`attot`.`armor` + (((`hp`.`HeroStr` + `attot`.`Str`) * 0.8) + ((`hp`.`HeroAgi` + `attot`.`Agi`) * 0.2))) AS `Armor`,(`attot`.`heal` + (((`hp`.`HeroSpr` + `attot`.`Spr`) * 0.8) + ((`hp`.`HeroInt` + `attot`.`Inte`) * 0.2))) AS `Heal`,(`attot`.`spellpower` + (((`hp`.`HeroSpr` + `attot`.`Spr`) * 0.2) + ((`hp`.`HeroInt` + `attot`.`Inte`) * 0.8))) AS `SpellPower`,(`hp`.`HeroStr` + `attot`.`Str`) AS `Str`,(`hp`.`HeroSta` + `attot`.`Sta`) AS `Sta`,(`hp`.`HeroAgi` + `attot`.`Agi`) AS `Agi`,(`hp`.`HeroInt` + `attot`.`Inte`) AS `Inte`,(`hp`.`HeroSpr` + `attot`.`Spr`) AS `Spr` from (((`hero` `hp` join `userhero` `uh` on((`uh`.`HeroID` = `hp`.`HeroID`))) join `user` `u` on((`uh`.`UserID` = `u`.`UserID`))) join `attribute_total` `attot` on((`hp`.`HeroID` = `attot`.`heroid`)));

DROP VIEW IF EXISTS `oneworld`.`heroitens`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW  `oneworld`.`heroitens` AS select `he`.`HeroID` AS `HeroID`,`he`.`SlotID` AS `SlotID`,`he`.`ItemID` AS `ItemID`,`he`.`QtdItem` AS `QtdItem`,`he`.`Dtheroequip` AS `Dtheroequip`,`h`.`HeroName` AS `heroname`,`h`.`HeroMana` AS `heromana`,`h`.`HeroHp` AS `herohp`,`h`.`HeroLevel` AS `herolevel`,`h`.`HeroExp` AS `heroexp`,`se`.`SlotName` AS `slotname`,`i`.`ItemName` AS `itemname`,`u`.`UserLogin` AS `userlogin` from (((((`heroequip` `he` join `hero` `h` on((`he`.`HeroID` = `h`.`HeroID`))) join `slotequip` `se` on((`se`.`SlotID` = `he`.`SlotID`))) join `item` `i` on((`i`.`ItemID` = `he`.`ItemID`))) join `userhero` `uh` on((`uh`.`HeroID` = `h`.`HeroID`))) join `user` `u` on((`u`.`UserID` = `uh`.`UserID`)));

DROP VIEW IF EXISTS `oneworld`.`heroprofile`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW  `oneworld`.`heroprofile` AS select `u`.`UserID` AS `userid`,`h`.`HeroID` AS `heroid`,`i`.`ItemID` AS `itemid`,`u`.`UserLogin` AS `userlogin`,`h`.`HeroName` AS `heroname`,`h`.`HeroLevel` AS `herolevel`,`h`.`HeroStr` AS `herostr`,`h`.`HeroSta` AS `herosta`,`h`.`HeroAgi` AS `heroagi`,`h`.`HeroInt` AS `heroint`,`h`.`HeroSpr` AS `herospr`,`se`.`SlotName` AS `slotname`,`i`.`ItemName` AS `itemname` from ((((((`hero` `h` join `heroequip` `he` on((`h`.`HeroID` = `he`.`HeroID`))) join `slotequip` `se` on((`he`.`SlotID` = `se`.`SlotID`))) join `item` `i` on((`i`.`ItemID` = `he`.`ItemID`))) join `itemattribute` `ia` on((`i`.`AttributeID` = `ia`.`AttributeID`))) join `userhero` `uh` on((`uh`.`HeroID` = `h`.`HeroID`))) join `user` `u` on((`uh`.`UserID` = `u`.`UserID`)));

DELIMITER $$

DROP PROCEDURE IF EXISTS `oneworld`.`EnemyLoot`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `oneworld`.`EnemyLoot`(
enemyid Int
)
BEGIN

set @enemyid = enemyid;

select
el.*,
e.enemyname,
e.enemyexp,
i.itemname
from
enemyloot el
inner join enemy e on
e.enemyid = el.enemyid
inner join item i on
i.itemid = el.itemid
where
el.enemyid = @enemyid;

END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `oneworld`.`proc_inBattleItens`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `oneworld`.`proc_inBattleItens`(
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

DELIMITER $$

DROP PROCEDURE IF EXISTS `oneworld`.`proc_ranking`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `oneworld`.`proc_ranking`()
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

DELIMITER $$

DROP PROCEDURE IF EXISTS `oneworld`.`proc_upBattleItens`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `oneworld`.`proc_upBattleItens`(
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

DELIMITER $$

DROP PROCEDURE IF EXISTS `oneworld`.`proc_updatehero`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `oneworld`.`proc_updatehero`(
dmgtaken Int,
userlogin varchar(50),
exp int
)
BEGIN

set @dmgtaken = dmgtaken,
    @userlogin = userlogin,
    @exp = exp;

update hero
set herohp = herohp - @dmgtaken,
heroexp = heroexp + @exp
where
heroid in
(
select
heroid
from
userhero uh
inner join user u on
uh.userid = u.userid
where
u.userlogin = @userlogin
);

END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `oneworld`.`proc_updateLifeMana`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `oneworld`.`proc_updateLifeMana`(
dmgtaken Int,
userlogin varchar(50)
)
BEGIN

set @dmgtaken = dmgtaken,
    @userlogin = userlogin;

update hero
set herohp = herohp - @dmgtaken
where
heroid in
(
select
heroid
from
userhero uh
inner join user u on
uh.userid = u.userid
where
u.userlogin = @userlogin
);

END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `oneworld`.`proc_upLost`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `oneworld`.`proc_upLost`(
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

DELIMITER $$

DROP PROCEDURE IF EXISTS `oneworld`.`UserHeroCreation`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `oneworld`.`UserHeroCreation`(
ClassID varchar(100),
Heroname varchar(100),
userlogin varchar(100)
)
BEGIN

set @Class = ClassID,
    @heroname = heroname,
    @userlogin = userlogin;


Insert into hero(
ClassID,
HeroName,
HeroLevel,
HeroExp,
HeroStr,
HeroSta,
HeroAgi,
HeroInt,
HeroSpr,
DtHero
)
Select
@Class,
@heroname,
1,
0,
Case
When @Class = 1 Then 4
When @Class = 2 Then 1
When @Class = 3 Then 2
When @Class = 4 Then 5
End as str,
Case
When @Class = 1 Then 5
When @Class = 2 Then 1
When @Class = 3 Then 2
When @Class = 4 Then 4
End as sta,
Case
When @Class = 1 Then 3
When @Class = 2 Then 3
When @Class = 3 Then 3
When @Class = 4 Then 5
End as agi,
Case
When @Class = 1 Then 1
When @Class = 2 Then 5
When @Class = 3 Then 4
When @Class = 4 Then 3
End as inte,
Case
When @Class = 1 Then 2
When @Class = 2 Then 4
When @Class = 3 Then 5
When @Class = 4 Then 1
End as spr,
SysDate();

END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `oneworld`.`UserHeroPart2`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `oneworld`.`UserHeroPart2`(
hname varchar(100),
login varchar(100)
)
BEGIN

set @hname = hname,
    @login = login;

Insert Into userhero(
userid,
heroid
)
Select
userid,
heroid
from
user
cross join hero
where
userlogin = @login
and heroname = @hname;

END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `oneworld`.`UserHeroPart3`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `oneworld`.`UserHeroPart3`(
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
12,
Case
When @Class = 1 Then 1
When @Class = 2 Then 2
When @Class = 3 Then 3
When @Class = 4 Then 4
End as weapon,
sysdate()
from
hero
where
heroname = @heroname;

END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `oneworld`.`UserHeroPart4`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `oneworld`.`UserHeroPart4`(
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

DELIMITER $$

DROP PROCEDURE IF EXISTS `oneworld`.`UserRegister`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `oneworld`.`UserRegister`(
Name varchar(100),
LastName varchar(100),
Email varchar(100),
Adress varchar(100),
Country varchar(100),
City varchar(100),
UserPremmium int,
UserLogin varchar(100),
UserPwd varchar(45)
)
BEGIN

set @Name = Name,
    @LastName = LastName,
    @Email = Email,
    @Adress = Adress,
    @Country = Country,
    @City = City,
    @UserPremmium = UserPremmium,
    @UserLogin = UserLogin,
    @UserPwd = UserPwd;

Insert into user(
UserName,
UserLastName,
UserEmail,
UserAddress,
UserCountry,
UserCity,
UserPremmium,
UserLogin,
UserPwd,
DtUser
)
Select
@Name,
@LastName,
@Email,
@Adress,
@Country,
@City,
@UserPremmium,
@UserLogin,
@UserPwd,
SysDate();

END $$

DELIMITER ;