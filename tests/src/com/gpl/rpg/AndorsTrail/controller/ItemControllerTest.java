package com.gpl.rpg.AndorsTrail.controller;

import android.test.AndroidTestCase;
import com.gpl.rpg.AndorsTrail.AndorsTrailApplication;
import com.gpl.rpg.AndorsTrail.context.ControllerContext;
import com.gpl.rpg.AndorsTrail.context.WorldContext;
import com.gpl.rpg.AndorsTrail.model.ModelContainer;
import com.gpl.rpg.AndorsTrail.model.item.Inventory;
import com.gpl.rpg.AndorsTrail.model.item.ItemType;
import com.gpl.rpg.AndorsTrail.model.map.PredefinedMap;
import com.gpl.rpg.AndorsTrail.util.TestUtils;
import org.junit.Before;
import org.junit.Test;

public class ItemControllerTest extends AndroidTestCase {

    private ItemController itemcontroller;
    private WorldContext world;
    private PredefinedMap map;

    @Before
    public void setUp() {

        // Create the App :
        AndorsTrailApplication andor = new AndorsTrailApplication();

        // Create the world :
        this.world = new WorldContext();

        // Create a map :
        this.map = TestUtils.createPredefinedMap();

        // Init the World :
        this.world.model = new ModelContainer();
        this.world.model.currentMap = map;

        // Create all controllers :
        ControllerContext context = new ControllerContext(andor, world);

        // Retrieve the controller for tests :
        this.itemcontroller = context.itemController;

    }

    @Test
    public void testDropItemInInventoryWithBiggerQuantity() {

        // Create an item :
        ItemType item = TestUtils.createNonEquipableOrUsableItemType();

        // Add two items in the inventory :
        this.world.model.player.inventory.addItem(item, 2);

        // Verification : 2 items in the inventory :
        assertEquals(2, this.world.model.player.inventory.getItemQuantity(item.id));

        // Try to remove 4 items :
        this.itemcontroller.dropItem(item, 4);

        // Verification : already 2 items in the inventory :
        assertEquals(2, this.world.model.player.inventory.getItemQuantity(item.id));

        // Verification : no items in the map at current position :
        assertNull(this.map.getBagAt(this.world.model.player.position));
    }

    @Test
    public void testDropItemInInventoryWithCorrectQuantity() {

        // Create an item :
        ItemType item = TestUtils.createNonEquipableOrUsableItemType();

        // Add two items in the inventory :
        this.world.model.player.inventory.addItem(item, 2);

        // Verification : 2 items in the inventory :
        assertEquals(2, this.world.model.player.inventory.getItemQuantity(item.id));

        // Try to remove one item :
        this.itemcontroller.dropItem(item, 1);

        // Verification : there is only one item in the inventory :
        assertEquals(1, this.world.model.player.inventory.getItemQuantity(item.id));

        // Verification : an item is in the map at current position :
        assertEquals(1, this.map.getBagAt(this.world.model.player.position).items.getItemQuantity(item.id));
    }

    @Test
    public void testDropItemNotInInventory() {

        // Create an item :
        ItemType item = TestUtils.createNonEquipableOrUsableItemType();

        // Try to remove one item :
        this.itemcontroller.dropItem(item, 1);

        // Verification : there is no item in the inventory :
        assertEquals(0, this.world.model.player.inventory.getItemQuantity(item.id));

        // Verification : an item is in the map at current position :
        assertNull(this.map.getBagAt(this.world.model.player.position));
    }

    /*
    BOOOUUUUMMMMMM !!!!!!!!!! A CRASH !

    @Test
    public void testDropItemInInventoryWithNegativeQuantity() {

        // Create an item :
        ItemType item = ToolsForTests.createItemType();

        // Add two items in the inventory :
        world.model.player.inventory.addItem(item, 2);

        // Verification : 2 items in the inventory :
        assertEquals(2, world.model.player.inventory.getItemQuantity(item.id));

        // Try to remove 4 items :
        itemcontroller.dropItem(item, -2);

        // Verification : already 2 items in the inventory :
        assertEquals(2, world.model.player.inventory.getItemQuantity(item.id));

        // Verification : no items in the map at current position :
        assertNull(map.getBagAt(world.model.player.position));
    }
    */

    @Test
    public void testEquipItemNotInInventory() {

        // Create an item :
        ItemType item = TestUtils.createEquipableItemType();

        // Try to equip the player with the item :
        this.itemcontroller.equipItem(item, Inventory.WearSlot.body);

        // Verification : the player doesn't wear the item :
        assertFalse(this.world.model.player.inventory.isWearing(item.id));
    }

    @Test
    public void testEquipItemNonEquipableItem() {

        // Create an item :
        ItemType item = TestUtils.createNonEquipableOrUsableItemType();

        // Add the item in the inventory :
        this.world.model.player.inventory.addItem(item, 1);

        // Verification : the item is in the inventory :
        assertEquals(1, this.world.model.player.inventory.getItemQuantity(item.id));

        // Try to equip the player with the item :
        this.itemcontroller.equipItem(item, Inventory.WearSlot.body);

        // Verification : the player doesn't wear the item :
        assertFalse(this.world.model.player.inventory.isWearing(item.id));
    }

    /**
     * Test for the method useItem
     * usage of an unusable item
     */
    @Test
    public void testUseItemNotusableItem() {

        // Create an item
        ItemType item = TestUtils.createNonEquipableOrUsableItemType();

        // Add the item in the inventory :
        this.world.model.player.inventory.addItem(item, 1);

        // verify if the item is in the player's inventory
        assertNotNull(this.world.model.player.inventory.findItem(item.id));

        // use the item
        this.itemcontroller.useItem(item);

        // verify that the item was not removed from the player's inventory
        assertNotNull(this.world.model.player.inventory.findItem(item.id));
    }

    /**
     * Test for the method useItem
     * usage of an unusable item
     */
    @Test
    public void testUseItemUsableItem() {

        // Create an item
        ItemType item = TestUtils.createUsableItemType();

        // Add the item in the player inventory
        this.world.model.player.inventory.addItem(item, 1);

        // verify if the item is in the player's inventory
        assertNotNull(this.world.model.player.inventory.findItem(item.id));

        // use the item
        this.itemcontroller.useItem(item);

        // verify that the item was removed from the player's inventory
        assertNull(this.world.model.player.inventory.findItem(item.id));
    }


}
