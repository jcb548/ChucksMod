package net.chuck.chucksmod.util;

import com.google.common.collect.ImmutableSet;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.Direction;

import java.util.Collection;
import java.util.Optional;

public class DirectionIOProperty extends Property<String> {
    public static final DirectionIOProperty UP = DirectionIOProperty.of("up");
    public static final DirectionIOProperty DOWN = DirectionIOProperty.of("down");
    public static final DirectionIOProperty NORTH = DirectionIOProperty.of("north");
    public static final DirectionIOProperty SOUTH = DirectionIOProperty.of("south");
    public static final DirectionIOProperty EAST = DirectionIOProperty.of("east");
    public static final DirectionIOProperty WEST = DirectionIOProperty.of("west");
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
    protected DirectionIOProperty(String name) {
        super(name, String.class);
    }
    public static DirectionIOProperty of(String name){
        return new DirectionIOProperty(name);
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

    public static DirectionIOProperty getSide(byte side){
        switch (side){
            case 0: return DirectionIOProperty.UP;
            case 1: return DirectionIOProperty.DOWN;
            case 2: return DirectionIOProperty.NORTH;
            case 3: return DirectionIOProperty.SOUTH;
            case 4: return DirectionIOProperty.EAST;
            case 5: return DirectionIOProperty.WEST;
            default: return DirectionIOProperty.UP;
        }
    }

    public static DirectionIOProperty getProperty(Direction direction){
        switch (direction){
            case UP -> {
                return UP;
            }
            case DOWN -> {
                return DOWN;
            }
            case SOUTH -> {
                return SOUTH;
            }
            case EAST -> {
                return EAST;
            }
            case WEST -> {
                return WEST;
            }
            default -> {
                return NORTH;
            }
        }
    }
}
