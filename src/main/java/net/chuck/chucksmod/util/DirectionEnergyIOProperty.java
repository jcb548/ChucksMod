package net.chuck.chucksmod.util;

import com.google.common.collect.ImmutableSet;
import net.minecraft.state.property.Property;

import java.util.Collection;
import java.util.Optional;

public class DirectionEnergyIOProperty extends Property<String> {
    public static final DirectionEnergyIOProperty UP = DirectionEnergyIOProperty.of("up");
    public static final DirectionEnergyIOProperty DOWN = DirectionEnergyIOProperty.of("down");
    public static final DirectionEnergyIOProperty NORTH = DirectionEnergyIOProperty.of("north");
    public static final DirectionEnergyIOProperty SOUTH = DirectionEnergyIOProperty.of("south");
    public static final DirectionEnergyIOProperty EAST = DirectionEnergyIOProperty.of("east");
    public static final DirectionEnergyIOProperty WEST = DirectionEnergyIOProperty.of("west");
    public static final String DISABLED = "d";
    public static final String INSERT = "i";
    public static final String EXTRACT = "e";
    public static final byte UP_KEY = 0;
    public static final byte DOWN_KEY = 1;
    public static final byte NORTH_KEY = 2;
    public static final byte SOUTH_KEY = 3;
    public static final byte EAST_KEY = 4;
    public static final byte WEST_KEY = 5;
    private final ImmutableSet<String> values = ImmutableSet.of(DISABLED, INSERT, EXTRACT);
    protected DirectionEnergyIOProperty(String name) {
        super(name, String.class);
    }
    public static DirectionEnergyIOProperty of(String name){
        return new DirectionEnergyIOProperty(name);
    }

    @Override
    public Collection<String> getValues() {
        return this.values;
    }

    @Override
    public String name(String value) {
        return value;
    }

    @Override
    public Optional<String> parse(String name) {
        if(name.equals("disabled") || name.equals(DISABLED)){
            return Optional.of(DISABLED);
        }
        if(name.equals("insert") || name.equals(INSERT)){
            return Optional.of(INSERT);
        }
        if(name.equals("extract") || name.equals(EXTRACT)){
            return Optional.of(EXTRACT);
        }
        return Optional.empty();
    }

    public static String getNextState(String start){
        if(start.equals(DISABLED)){
            return INSERT;
        }
        if(start.equals(INSERT)){
            return EXTRACT;
        }
        return DISABLED;
    }

    public static DirectionEnergyIOProperty getSide(byte side){
        switch (side){
            case 0: return DirectionEnergyIOProperty.UP;
            case 1: return DirectionEnergyIOProperty.DOWN;
            case 2: return DirectionEnergyIOProperty.NORTH;
            case 3: return DirectionEnergyIOProperty.SOUTH;
            case 4: return DirectionEnergyIOProperty.EAST;
            case 5: return DirectionEnergyIOProperty.WEST;
            default: return DirectionEnergyIOProperty.UP;
        }
    }
}
