package dev.crafty.types;

import dev.crafty.types.enums.PowerGenerationType;
import dev.crafty.utils.Cuboid;
import org.bukkit.Location;
import org.bukkit.block.Block;

public class PowerGrid {
    private Location origin;
    private int maxPowerOutput;
    private int powerTransferRate; // Power per second
    private int powerStored;
    private int totalPowerGenerated;
    private int totalPowerTransferred;
    private int totalPowerStored;
    private int powerProductionRate; // Power per second
    private PowerGenerationType powerGenerationType;
    private boolean ableToGenerate; /// If the block meets criteria to generate power (e.g. if it's day for solar panels)
    private boolean enabled;

    public void scan() {
        Cuboid cuboid = new Cuboid(origin);
        cuboid.outset(Cuboid.CuboidDirection.Both, 1);
        for (Block block : cuboid.getBlocks()) {
            // use pdc to check if block is a machine
        }
    }


    public void generatePower() {
        switch (powerGenerationType) {
            case NUCLEAR:
                break;
            case COMBUSTION:
                break;
            case SOLAR:
                break;
            case WIND:
                break;
            case HYDRO:
                
                break;
            case GEOTHERMAL:
                break;
        }
    }
}
