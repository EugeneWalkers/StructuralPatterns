package bridge;

import bridge.devices.Device;
import bridge.devices.concreteDevices.Radio;
import bridge.remotes.Remote;
import bridge.remotes.concreteRemotes.AdvancedRemote;

public final class Demo {

    public static void main(final String[] args){
        final Device myRadio = new Radio();
        final Remote superRemote = new AdvancedRemote(myRadio);
        superRemote.upCanal();
    }

}
