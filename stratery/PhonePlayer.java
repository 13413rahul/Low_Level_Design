package stratery;

public class PhonePlayer extends VideoPlayer {
    PhonePlayer(Device device, Resolution resolution) {
        this.currDevice = device;
        this.currResolution = resolution;
    }

    @Override
    void display() {
        this.getDevice();
        this.getResolution();
    }
}
