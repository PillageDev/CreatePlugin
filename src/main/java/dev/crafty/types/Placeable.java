package dev.crafty.types;

import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;

import java.util.List;

public class Placeable {
    private Block block;
    private boolean isPlaced;
    private Class<? extends Placeable> type;
    private ItemStack itemStack;

    public Placeable(Block block) {
        this.block = block;
    }
    public Placeable(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public Placeable(Machine machine) {
        this.block = machine.getBlock();
    }

    private boolean fillMetadata() {

    }
}
