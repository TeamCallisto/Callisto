package sample.model;
    import javafx.scene.paint.Color;
    import javafx.scene.paint.PhongMaterial;
    import org.junit.jupiter.api.Test;

    import java.io.IOException;

    import static org.junit.jupiter.api.Assertions.*;

//Class to test for critical methods in AmbientDevice class
class AmbientDeviceTest {
  @Test
  void getColor() {
    AmbientDevice myDevice;
    myDevice = new AmbientDevice();

    //Check to ensure the default values are correct
    assertEquals(Color.web("0x1eff00ff"), myDevice.getColor());


    //Set colors to multiple values to test correct output
    myDevice.setColor(0);
    assertEquals(Color.web("0x1eff00ff"), myDevice.getColor());
    myDevice.setColor(10);
    assertEquals(Color.web("0x51ff00ff"), myDevice.getColor());
    myDevice.setColor(50);
    assertEquals(Color.web("0xffe100ff"), myDevice.getColor());
    myDevice.setColor(75);
    assertEquals(Color.web("0xff6200ff"), myDevice.getColor());
    myDevice.setColor(99);
    assertEquals(Color.web("0xff0000ff"), myDevice.getColor());

  }
  @Test
  void getBrightness() throws IOException {
    AmbientDevice myDevice;
    myDevice = new AmbientDevice();

  }
}