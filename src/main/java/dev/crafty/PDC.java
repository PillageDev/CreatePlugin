package dev.crafty;

import dev.crafty.types.Machine;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.lang.model.type.PrimitiveType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PDC {
    private static List<Block> blocks = new ArrayList<>();
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

    public Object lookup(Block block) {
        Object value = null;
        blocks.forEach(b -> {
            if (b.equals(block)) {
                PersistentDataContainer pdc = b.getChunk().getPersistentDataContainer();
                String type = pdc.get(new NamespacedKey(Create.getInstance(), "type"), PersistentDataType.STRING);
                if (type == null) return;
                switch (type) {
                    case "machine":
                        break;
                    case "powergrid":
                        // todo: construct using the pdc values into the class and return it
                        break;
                    default:
                        break;
                }
            }
        });
        return value;
    }
}
