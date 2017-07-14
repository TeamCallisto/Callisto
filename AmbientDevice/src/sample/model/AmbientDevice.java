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
    switch (colorNumber) {
      case 1:
        return Color.web("#00FF00");
      case 2:
        return Color.web("#12FF00");
      case 3:
        return Color.web("#00FF00"); //skip
      case 4:
        return Color.web("#1FFF00");
      case 5:
        return Color.web("#00FF00"); //skip
      case 6:
        return Color.web("#24FF00");
      case 7:
        return Color.web("#00FF00"); //skip
      case 8:
        return Color.web("#2FFF00");
      case 9:
        return Color.web("#00FF00"); //skip
      case 10:
        return Color.web("#35FF00");
      case 11:
        return Color.web("#00FF00"); //skip
      case 12:
        return Color.web("#3FFF00");
      case 13:
        return Color.web("#00FF00"); //skip
      case 14:
        return Color.web("#47FF00");
      case 15:
        return Color.web("#00FF00"); //skip
      case 16:
        return Color.web("#50FF00");
      case 17:
        return Color.web("#00FF00"); //skip
      case 18:
        return Color.web("#5FFF00");
      case 19:
        return Color.web("#00FF00"); //skip
      case 20:
        return Color.web("#65FFF0");
      case 21:
        return Color.web("#00FF00"); //skip
      case 22:
        return Color.web("#6CFF00");
      case 23:
        return Color.web("#00FF00"); //skip
      case 24:
        return Color.web("#6FFF00");
      case 25:
        return Color.web("#00FF00"); //skip
      case 26:
        return Color.web("#75FF00");
      case 27:
        return Color.web("#00FF00"); //skip
      case 28:
        return Color.web("#7CFF00");
      case 29:
        return Color.web("#00FF00"); //skip
      case 30:
        return Color.web("#80FF00");
      case 31:
        return Color.web("#00FF00"); //skip
      case 32:
        return Color.web("#8FFF00");
      case 33:
        return Color.web("#00FF00"); //skip
      case 34:
        return Color.web("#90FF00");
      case 35:
        return Color.web("#00FF00"); //skip
      case 36:
        return Color.web("#9FFF00");
      case 37:
        return Color.web("#00FF00"); //skip
      case 38:
        return Color.web("#B0FF00");
      case 39:
        return Color.web("#00FF00"); //skip
      case 40:
        return Color.web("#B5FF00");
      case 41:
        return Color.web("#00FF00"); //skip
      case 42:
        return Color.web("#BFFF00");
      case 43:
        return Color.web("#00FF00"); //skip
      case 44:
        return Color.web("#C2FF00");
      case 45:
        return Color.web("#00FF00"); //skip
      case 46:
        return Color.web("#CDFF00");
      case 47:
        return Color.web("#00FF00"); //skip
      case 48:
        return Color.web("#D4FF00");
      case 49:
        return Color.web("#00FF00"); //skip
      case 50:
        return Color.web("#E0FF00");
      case 51:
        return Color.web("#00FF00"); //skip
      case 52:
        return Color.web("#E5FF00");
      case 53:
        return Color.web("#00FF00"); //skip
      case 54:
        return Color.web("#F0FF00");
      case 55:
        return Color.web("#00FF00"); //skip
      case 56:
        return Color.web("#F7FF00");
      case 57:
        return Color.web("#00FF00"); //skip
      case 58:
        return Color.web("#FFF600");
      case 59:
        return Color.web("#00FF00"); //skip
      case 60:
        return Color.web("#FFF000");
      case 61:
        return Color.web("#00FF00"); //skip
      case 62:
        return Color.web("#FFE400");
      case 63:
        return Color.web("#00FF00"); //skip
      case 64:
        return Color.web("#FFD900");
      case 65:
        return Color.web("#00FF00"); //skip
      case 66:
        return Color.web("#FFD000");
      case 67:
        return Color.web("#00FF00"); //skip
      case 68:
        return Color.web("#FFC100");
      case 69:
        return Color.web("#00FF00"); //skip
      case 70:
        return Color.web("#FFAF00");
      case 71:
        return Color.web("#00FF00"); //skip
      case 72:
        return Color.web("#FFA000");
      case 73:
        return Color.web("#00FF00"); //skip
      case 74:
        return Color.web("#FF9E00");
      case 75:
        return Color.web("#00FF00"); //skip
      case 76:
        return Color.web("#FF9000");
      case 77:
        return Color.web("#00FF00"); //skip
      case 78:
        return Color.web("#FF8C00");
      case 79:
        return Color.web("#00FF00"); //skip
      case 80:
        return Color.web("#FF7F00");
      case 81:
        return Color.web("#00FF00"); //skip
      case 82:
        return Color.web("#FF7B00");
      case 84:
        return Color.web("#00FF00"); //skip
      case 85:
        return Color.web("#FF7000");
      case 86:
        return Color.web("#FF6900");
      case 87:
        return Color.web("#FF6900");
      case 88:
        return Color.web("#FF6000");
      case 89:
        return Color.web("#FF5700");
      case 90:
        return Color.web("#00FF00");
      case 91:
        return Color.web("#FF5000");
      case 92:
        return Color.web("#FF4600");
      case 93:
        return Color.web("#FF4000");
      case 94:
        return Color.web("#FF3400");
      case 95:
        return Color.web("#FF3000");
      case 96:
        return Color.web("#FF2300");
      case 97:
        return Color.web("#FF2100");
      case 98:
        return Color.web("#FF1100");
      case 99:
        return Color.web("#FF1000");
      default:
        return Color.web("#FF0000");
    }

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