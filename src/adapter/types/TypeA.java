package adapter.types;

public class TypeA {

    private int a;

    protected TypeA(){

    }

    public TypeA(final int a){
        this.a = a;
    }

    public boolean isMyNumberGreaterThan(final TypeA second){
        return getA() > second.getA();
    }

    public int getA() {
        return a;
    }
}
