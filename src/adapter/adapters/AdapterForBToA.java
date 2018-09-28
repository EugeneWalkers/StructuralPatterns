package adapter.adapters;

import adapter.types.TypeA;
import adapter.types.TypeB;

public class AdapterForBToA extends TypeA {

    private final TypeB b;

    public AdapterForBToA(final TypeB b) {
        this.b = b;
    }

    @Override
    public int getA() {
        return Integer.valueOf(b.getNumberInAString());
    }
}
