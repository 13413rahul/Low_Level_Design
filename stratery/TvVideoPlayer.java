package stratery;

public class TvVideoPlayer extends VideoPlayer {

    TvVideoPlayer(Device device, Resolution resolution) {
        this.currDevice = device;
        this.currResolution = resolution;
    }

    @Override
    void display() {
        this.getDevice();
        this.getResolution();
    }
}
