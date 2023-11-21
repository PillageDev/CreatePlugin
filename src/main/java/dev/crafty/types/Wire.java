package dev.crafty.types;

import dev.crafty.PDC;
import dev.crafty.utils.Cuboid;
import org.bukkit.block.Block;

public class Wire {
    private Block block;
    private Placeable[] connections;
    private int wireLength;
    private int maxPowerTransfer;


    public Placeable[] getConnections() {
        return connections;
    }

    private void addConnection(Placeable connection) {
        for (int i = 0; i < connections.length; i++) {
            if (connections[i] == null) {
                connections[i] = connection;
                break;
            }
        }
    }

    private void scan() {
        // Scan for connections
        Cuboid cuboid = new Cuboid(block.getLocation());
        cuboid.outset(Cuboid.CuboidDirection.Both, 1);
        for (Block block : cuboid.getBlocks()) {
            Object lookup = PDC.lookup(block);
            if (lookup instanceof Wire) {
                Wire wire = (Wire) lookup;
                wire.scan();
            }
            if (lookup instanceof Machine) {
                Machine machine = (Machine) lookup;
                addConnection(machine);
                machine.scan();
            }
        }
    }
}
