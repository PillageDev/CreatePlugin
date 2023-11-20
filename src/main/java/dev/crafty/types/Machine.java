package dev.crafty.types;

import org.bukkit.block.Block;

public class Machine extends Placeable {
    private Block block;

    public Machine(Block block) {
        super(block);
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }
}
