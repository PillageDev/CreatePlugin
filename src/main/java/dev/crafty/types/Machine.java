package dev.crafty.types;

import dev.crafty.Create;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Locale;
import java.util.Objects;

public class Machine extends Placeable implements Listener {
    private Block block;
    private ItemStack itemStack;
    private int maxPowerInput;

    private NamespacedKey id = new NamespacedKey(Create.getInstance(), "identifier");

    public Machine(Block block) {
        super(block);
        this.block = block;
    }

    public Machine(ItemStack itemStack) {
        super(itemStack);
        this.itemStack = itemStack;
        itemStack.getItemMeta().getPersistentDataContainer().set(id, PersistentDataType.STRING, "machine");
    }

    public Block getBlock() {
        return block;
    }

    public boolean validateMachine() {

    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlock().equals(block)) {
            if (Objects.requireNonNull(event.getItemInHand().getItemMeta()).getPersistentDataContainer().has(id, PersistentDataType.STRING)) {
                if (Objects.requireNonNull(event.getItemInHand().getItemMeta().getPersistentDataContainer().get(id, PersistentDataType.STRING)).equals("machine")) {
                    NamespacedKey locationKey = new NamespacedKey(Create.getInstance(), "location");
                    event.getBlock().getChunk().getPersistentDataContainer().set(id, PersistentDataType.STRING, "machine");
                    event.getBlock().getChunk().getPersistentDataContainer().set(locationKey, PersistentDataType.STRING, event.getBlock().getLocation().toString());
                    // todo: set other values in the block's chunk's persistent data container
                }
            }
        }
    }

}
