package dev.crafty.types;

import java.util.Map;

import dev.crafty.types.enums.PowerGenerationType;

public class PowerSource {
    private int maxPowerOutput;
    private int powerTransferRate; // Power per second
    private int powerStored;
    private int totalPowerGenerated;
    private int totalPowerTransferred;
    private int totalPowerStored;
    private int powerProductionRate; // Power per second
    private PowerGenerationType powerGenerationType;
    private boolean ableToGenerate; /// If the block meets crieteria to generate power (e.g. if it's day for solar panels)
    private boolean enabled;
    private boolean connectedToWire;
    private boolean connectedToGrid;
    private boolean connectedToMachine;
    private boolean connectedToInterface;
    /**
     * The key is the class of the machine, and the value is the amount of machines connected to this power source.
     * @key Class of the machine
     * @value The power transfer rate of the machine
     */
    private Map<Class<? extends Machine>, Integer> connectedMachines;






    public boolean validateTransferOutput() {
        return powerTransferRate <= maxPowerOutput;
    }

    public boolean canGenerate() {
        switch (powerGenerationType) {
            case COMBUSTION:
                break;
            case GEOTHERMAL:
                break;
            case HYDRO:
                break;
            case NUCLEAR:
                break;
            case SOLAR:
                break;
            case WIND:
                break;
            default:
                break;
            
        }
    }
}
