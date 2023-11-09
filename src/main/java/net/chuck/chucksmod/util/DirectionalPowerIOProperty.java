package net.chuck.chucksmod.util;

import com.google.common.collect.ImmutableSet;
import net.minecraft.state.property.Property;

import java.util.Collection;
import java.util.Optional;

public class DirectionalPowerIOProperty extends Property<Byte> {
    public static final byte DISABLED = 0;
    public static final byte INSERT = 1;
    public static final byte EXTRACT = 2;
    private final ImmutableSet<Byte> values = ImmutableSet.of(DISABLED, INSERT, EXTRACT);
    protected DirectionalPowerIOProperty(String name) {
        super(name, Byte.class);
    }
    public static DirectionalPowerIOProperty of(String name){
        return new DirectionalPowerIOProperty(name);
    }

    @Override
    public Collection<Byte> getValues() {
        return this.values;
    }

    @Override
    public String name(Byte value) {
        return value.toString();
    }

    @Override
    public Optional<Byte> parse(String name) {
        if(name.equals("disabled") || name.equals("0")){
            return Optional.of(DISABLED);
        }
        if(name.equals("insert") || name.equals("1")){
            return Optional.of(INSERT);
        }
        if(name.equals("extract") || name.equals("2")){
            return Optional.of(EXTRACT);
        }
        return Optional.empty();
    }
}
