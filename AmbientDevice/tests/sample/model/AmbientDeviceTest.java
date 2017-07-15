package sample.model;
    import org.junit.jupiter.api.Test;

    import static org.junit.jupiter.api.Assertions.*;

class AmbientDeviceTest {
  @Test
  void getColor() {
//    AmbientDevice myDevice;
//    myDevice = new AmbientDevice();
//
//    myDevice.setColor(1);
//    assertEquals("0x00ff00ff", myDevice.getColor());
//
//    myDevice.setColor(50);
//    assertEquals("#E0FF00", myDevice.getColor());
//
//    myDevice.setColor(100);
//    assertEquals("#A9A9A9", myDevice.getColor());
//
//    myDevice.setColor(0);
//    assertEquals("#00FF00", myDevice.getColor());

  }
  @Test
  void getBrightness() {
    AmbientDevice myDevice;
    myDevice = new AmbientDevice();

    myDevice.setBrightness(1);

    assertEquals(10.0, myDevice.getBrightness());

    myDevice.setBrightness(50);
    assertEquals(4.0, myDevice.getBrightness());

    myDevice.setBrightness(100);
    assertEquals(1.0, myDevice.getBrightness());

    myDevice.setBrightness(0);
    assertEquals(12.0, myDevice.getBrightness());

  }
}