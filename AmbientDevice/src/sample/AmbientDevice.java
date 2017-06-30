package sample;
public class AmbientDevice {

  private static int colorNumber;
  private static int brightnessNumber;

  //public constructor

  public AmbientDevice(int colorNumber, int brightnessNumber) {
    this.colorNumber = colorNumber;
    this.brightnessNumber = brightnessNumber;
  }

  public void setColor(int newColor) {
    colorNumber = newColor;
  }

  public void setBrightness(int newBrightness) {
    brightnessNumber = newBrightness;
  }

  public static String getColor() {
    if (colorNumber > 99 || colorNumber < 0){
      return "#ffffff";
    } else if (colorNumber < 10) {
      return "#8000ff";
    } else if (colorNumber < 20) {
      return "#bf00ff";
    } else if (colorNumber < 40) {
      return "#ff00bf";
    } else if (colorNumber < 60) {
      return "#ff0080";
    } else if (colorNumber < 80) {
      return "#ff0040";
    } else return "#ff0000";
  }

  public static double getBrightness() {
    if (brightnessNumber <= 0) {
      return 1.0;                           // indicates the device is off
    } else if (brightnessNumber < 10) {
      return 0.4;
    } else if (brightnessNumber < 20) {
      return 0.3;
    } else if (brightnessNumber < 40) {
      return 0.25;
    } else if (brightnessNumber < 60) {
      return 0.2;
    } else if (brightnessNumber < 80) {
      return 0.1;
    } else return 0.0;
  }
}
