package bridge.remotes.concreteRemotes;

import bridge.devices.Device;
import bridge.remotes.Remote;

public class BasicRemote implements Remote {

    protected Device device;

    public BasicRemote(final Device device) {
        this.device = device;
        device.setCanal(Device.MINCANAL);
    }

    @Override
    public void enable() {
        device.setEnabled(true);
    }

    @Override
    public void disable() {
        device.setEnabled(false);
    }

    @Override
    public void upCanal() {
        int canal = device.getCanal();
        if (canal == Device.MAXCANAL) {
            canal = Device.MINCANAL;
        } else {
            canal++;
        }
        device.setCanal(canal);
    }

    @Override
    public void downCanal() {
        int canal = device.getCanal();
        if (canal == Device.MINCANAL) {
            canal = Device.MAXCANAL;
        } else {
            canal--;
        }
        device.setCanal(canal);
    }
}
