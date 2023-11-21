package dev.crafty;

import dev.crafty.types.PowerGrid;
import dev.crafty.types.enums.PowerGenerationType;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

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

    public static Object lookup(Block block) {
        AtomicReference<Object> value = new AtomicReference<>();
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
                        String location = pdc.get(new NamespacedKey(Create.getInstance(), "location"), PersistentDataType.STRING);
                        int maxPowerOutput = pdc.get(new NamespacedKey(Create.getInstance(), "maxPowerOutput"), PersistentDataType.INTEGER);
                        int powerTransferRate = pdc.get(new NamespacedKey(Create.getInstance(), "powerTransferRate"), PersistentDataType.INTEGER);
                        int powerStored = pdc.get(new NamespacedKey(Create.getInstance(), "powerStored"), PersistentDataType.INTEGER);
                        int totalPowerGenerated = pdc.get(new NamespacedKey(Create.getInstance(), "totalPowerGenerated"), PersistentDataType.INTEGER);
                        int totalPowerTransferred = pdc.get(new NamespacedKey(Create.getInstance(), "totalPowerTransferred"), PersistentDataType.INTEGER);
                        int totalPowerStored = pdc.get(new NamespacedKey(Create.getInstance(), "totalPowerStored"), PersistentDataType.INTEGER);
                        int powerProductionRate = pdc.get(new NamespacedKey(Create.getInstance(), "powerProductionRate"), PersistentDataType.INTEGER);
                        String powerGenerationType = pdc.get(new NamespacedKey(Create.getInstance(), "powerGenerationType"), PersistentDataType.STRING);
                        boolean ableToGenerate = pdc.get(new NamespacedKey(Create.getInstance(), "ableToGenerate"), PersistentDataType.INTEGER) == 1;
                        boolean enabled = pdc.get(new NamespacedKey(Create.getInstance(), "enabled"), PersistentDataType.INTEGER) == 1;
                        value.set(new PowerGrid(block.getLocation(), maxPowerOutput, powerTransferRate, powerStored, totalPowerGenerated, totalPowerTransferred, totalPowerStored, powerProductionRate, PowerGenerationType.valueOf(powerGenerationType.toUpperCase(Locale.ROOT)), ableToGenerate, enabled));
                        break;
                    default:
                        break;
                }
            }
        });
        return value;
    }
}
