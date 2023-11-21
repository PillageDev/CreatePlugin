package dev.crafty.types;

import dev.crafty.PDC;
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

    public PowerGrid(Location origin, int maxPowerOutput, int powerTransferRate, int powerStored, int totalPowerGenerated, int totalPowerTransferred, int totalPowerStored, int powerProductionRate, PowerGenerationType powerGenerationType, boolean ableToGenerate, boolean enabled) {
        this.origin = origin;
        this.maxPowerOutput = maxPowerOutput;
        this.powerTransferRate = powerTransferRate;
        this.powerStored = powerStored;
        this.totalPowerGenerated = totalPowerGenerated;
        this.totalPowerTransferred = totalPowerTransferred;
        this.totalPowerStored = totalPowerStored;
        this.powerProductionRate = powerProductionRate;
        this.powerGenerationType = powerGenerationType;
        this.ableToGenerate = ableToGenerate;
        this.enabled = enabled;
    }

    public void scan() {
        Cuboid cuboid = new Cuboid(origin);
        cuboid.outset(Cuboid.CuboidDirection.Both, 1);
        for (Block block : cuboid.getBlocks()) {
            Object lookup = PDC.lookup(block);
            if (lookup instanceof Machine) {
                // Collect machine data and add it to the power grid's data
                // Make sure to validate the machine first
                // Once validated, shrink the past cuboid to the machine's location
                // Then, scan the machine's cuboid for wires and other machines (again using a 3x3 cuboid)
                // Repeat this process until all machines and wires are scanned
                // The end result should be a cuboid that contains all machines and wires in the power grid
                // Then, add the power grid's data to the power grid's data
                Machine machine = (Machine) lookup;
                machine.scan();

            }
            if (lookup instanceof Wire) {
                Placeable[] connections = ((Wire) lookup).getConnections();
                for (Placeable connection : connections) {
                    if (connection instanceof Machine) {
                        // Collect machine data and add it to the power grid's data
                    }
                }
            }
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
