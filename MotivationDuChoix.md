# MOTIVATION OF CHOICE OF THIS PART TESTED

CAL - Maintenance and evolution

* Group : 
	* Jean-Baptiste DELAETER
	* Pauline DESSINGUE
	* Dieulin MAMBOUANA
	* Thibaud VERBAERE

We decided to test the functionalities of ItemController. In particular the functionalities on the following actions : dropItem, equipItem, unequipSlot and useItem.

1. Action: void dropItem(ItemType type, int quantity) :
    - Scenario 1 : We remove an item with a quantity q possible (Done)
        * expected return : the player has q items in less in his inventory
    - Scenario 2 : We try to removed an item with a quantity greater than what is possible (Done)
        * expected return : no effect on the inventory 
    - Scenario 3 : We try to removed an item not contained in the user's inventory (Done)
        * expected return : apparently a crash because there's no catch !

2. Action: void equipItem(ItemType type, Inventory.WearSlot slot) :
    - Scenario 1 : We try to equip the player with an item during a combat whereas this item is not worn (Done)
        * expected return : no effect on the player's equipment
    - Scenario 2 : We try to equip the player with an item during a combat whereas this item is worn (Done)
        * expected return : the  player is equipped with this item 
    - Scenario 3 : We try to equip the player with an item that we don't have (Done)
        * expected return : no effect on the player's equipment
    - Scenario 4 : We equip the player with a two-handed weapon while having a shield on the player (Done)
        * expected return : the shield falls back in the inventory
    - Scenario 5 : We equip the player with a shield while having a two-handed weapon on the player (Done)
        * expected return : the two-handed weapon falls back in the inventory
    - Scenario 6 : We equip the player with a weapon (Done)
        * expected return : the player is equipped with this weapon

3. Action: void unequipSlot(ItemType type, Inventory.WearSlot slot) :
    - Scenario 1 : We try to remove an element from the player that he cannot put (Done)
        * expected return : no effect on the player's equipment
    - Scenario 2 : We try to remove an element from the player while he has no equipment (Done)
        * expected return : no effect on the player's equipment
    - Scenario 3 : We try to remove an used element from the player during a fight (Done)
        * expected return : the player no longer wears the item
    - Scenario 4 : We try to remove an element from the player during a fight (Done)
        * expected return : no effect on the player's equipment
    - Scenario 5 : We try to remove an element from the player (Done)
        * expected return : the player no longer wears the item et and the item falls back in the inventory

4. Action: void useItem(ItemType type)
    - Scenario 1 : We try to use an item who is not usable (Done)
        * expected return : no effect on the player
    - Scenario 2 : We try to use an item who is usable (Done)
        * expected return : the player no longer wears the item and the effect of the item are applied
    - Scenario 3 : We use an usable item (Done)
        * expected return : the item is added to the list of items used 
    - Scenario 4 : We try to use an item who is totally consumed
        * expected return : the item has been removed from the inventory
