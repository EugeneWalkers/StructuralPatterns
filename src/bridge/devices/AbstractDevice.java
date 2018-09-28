package bridge.devices;

public abstract class AbstractDevice implements Device {

    private boolean isOn;
    private int canal;

    @Override
    public boolean getEnabled() {
        return isOn;
    }

    @Override
    public void setEnabled(final boolean value) {
        isOn = value;
    }

    @Override
    public int getCanal() {
        return canal;
    }

    @Override
    public void setCanal(final int canal) {
        this.canal = canal;
    }

}
