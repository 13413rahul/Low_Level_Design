package stratery;

public abstract class VideoPlayer {
    Device currDevice;
    Resolution currResolution;

    abstract void display();

    public void getDevice() {
        currDevice.display();
    }

    public void getResolution() {
        currResolution.resolution();
    }
}
