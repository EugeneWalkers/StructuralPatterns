package bridge.remotes.concreteRemotes;

import bridge.devices.Device;

public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(final Device device) {
        super(device);
    }

    public void goToCanal(final int canal) {
        if (canal >= Device.MINCANAL && canal <= Device.MAXCANAL) {
            device.setCanal(canal);
        }
    }

}
