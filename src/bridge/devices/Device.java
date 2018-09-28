package bridge.devices;

public interface Device {

    int MAXCANAL = 30;
    int MINCANAL = 1;

    void setEnabled(boolean value);
    void setCanal(int canal);

    boolean getEnabled();
    int getCanal();

}
