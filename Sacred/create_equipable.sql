CREATE TABLE `equipable` (
  `EquipableID` int(11) NOT NULL AUTO_INCREMENT,
  `ItemTypeID` int(11) NOT NULL,
  `SlotID` int(11) NOT NULL,
  `Date` datetime NOT NULL,
  PRIMARY KEY (`EquipableID`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=latin1;