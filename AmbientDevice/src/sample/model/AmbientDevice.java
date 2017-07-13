package sample.model;

import javafx.scene.paint.Color;

public class AmbientDevice {

  private static int colorNumber;
  private static int brightnessNumber;


  //public constructor

  public AmbientDevice() {
    this.colorNumber = 0;
    this.brightnessNumber = 0;
  }

  public void setColor(int newColor) {
    colorNumber = newColor;
  }

  public void setBrightness(int newBrightness) {
    brightnessNumber = newBrightness;
  }

  public static Color getColor() {
    if (colorNumber == 0) {
      return Color.rgb(0,0,255);
    } else if (colorNumber == 10) {
      return Color.rgb(0,255,94);
    } else if (colorNumber == 20) {
      return Color.rgb(26,255,0);
    } else if (colorNumber == 30) {
      return Color.rgb(213,255,0);
    } else if (colorNumber == 40) {
      return Color.rgb(255,255,0);
    } else if (colorNumber == 50) {
      return Color.rgb(255,239,0);
    } else if (colorNumber == 60) {
      return Color.rgb(255,205,0);
    } else if (colorNumber == 70) {
      return Color.rgb(255,162,0);
    } else if (colorNumber == 80) {
      return Color.rgb(255,128,0);
    } else if (colorNumber == 90) {
      return Color.rgb(255,51,51);
    } else if (colorNumber == 100) {
      return Color.rgb(204,0,0);
    } else return Color.rgb(64,64,64);
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