package net.chuck.chucksmod.util;

import com.google.common.collect.ImmutableSet;
import net.minecraft.state.property.Property;

import java.util.Collection;
import java.util.Optional;

public class DirectionEnergyIOProperty extends Property<String> {
    public static final String DISABLED = "disabled";
    public static final String INSERT = "insert";
    public static final String EXTRACT = "extract";
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
        if(name.equals("disabled")){
            return Optional.of(DISABLED);
        }
        if(name.equals("insert")){
            return Optional.of(INSERT);
        }
        if(name.equals("extract")){
            return Optional.of(EXTRACT);
        }
        return Optional.empty();
    }
}
