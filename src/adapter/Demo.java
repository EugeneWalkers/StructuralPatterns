package adapter;

import adapter.adapters.AdapterForBToA;
import adapter.types.TypeA;
import adapter.types.TypeB;

public final class Demo {
    public static void main(final String[] args){
        final TypeA a1 = new TypeA(5);
        final TypeA a2 = new TypeA(6);
        System.out.println(a1.isMyNumberGreaterThan(a2));

        final TypeB b = new TypeB("4");
//        System.out.println(a1.isMyNumberGreaterThan(b)); // compileError

        final AdapterForBToA adapterForTypeB = new AdapterForBToA(b);
        System.out.println(a1.isMyNumberGreaterThan(adapterForTypeB));
    }
}
