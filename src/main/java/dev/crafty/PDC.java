package dev.crafty;

import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.lang.model.type.PrimitiveType;

public class PDC {
    private Block block;
    private PersistentDataContainer pdc;
    public PDC(Block block) {
        this.block = block;
        pdc = block.getChunk().getPersistentDataContainer();
    }

    public void add(String key, String value) {
        NamespacedKey namespacedKey = new NamespacedKey(Create.getInstance(), key);
        pdc.set(namespacedKey, PersistentDataType.STRING, value);
    }


}
