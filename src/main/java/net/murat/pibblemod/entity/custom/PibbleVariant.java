package net.murat.pibblemod.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum PibbleVariant {
    DEFAULT(0),
    WASHINGTON(1);

    private static final PibbleVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(PibbleVariant::getId)).toArray(PibbleVariant[]::new);

    private final int id;

    PibbleVariant(int id) { this.id = id;}

    public int getId(){
        return this.id;
    }

    public static PibbleVariant byId(int id){
        return BY_ID[id % BY_ID.length];
    }
}
