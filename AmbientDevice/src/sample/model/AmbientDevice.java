package sample.model;

import javafx.scene.paint.Color;

public class AmbientDevice {

  private int colorNumber;
  private int brightnessNumber;


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

  public Color getBrightnessValue(double value)
  {
    double grayScaleValue=((255*value)/100) ;   //Calculates the grayscale value from temperature. We have created the range here. So, that each change in temperature, will also effect the change in color

    if(grayScaleValue>255)  //If range of grayscale value is exceeds from 255; 255 is the maximum gray level
      grayScaleValue=255;   //So then we set it to 255. So, that it should not exceed
    return Color.web(String.format("#%02x%02x%02x", (int)grayScaleValue,(int) grayScaleValue, (int)grayScaleValue));
  }

  public  Color getColor() {
    int colorValue=100-colorNumber; ///Color range is from Red to yellow to green. But we want Green to yellow to red. So, i subtract from 100 to get the reverse
    int greenMaximum = 220;
    int redMaximum = 220;

    //Red, Green, Blue variables are used because there are 3 channels of color. So, we can change value of these channels to get different colors

    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    int minimumColorValue=0;
    int maximumColorValue=99;

    if (colorValue > 50)
    {
      redValue = 255;
      // greenValue = (int)(255*colorValue/50)+30;
      greenValue = Math.abs( (int)(255*(colorValue-50)/50)+30);


      greenValue=255-greenValue;

      if(greenValue<0)
        greenValue=0;
    }
    else
    {
      greenValue = 255;
      redValue =  Math.abs((int)(255*(colorValue-50)/50)+30);


      redValue=255-redValue;
      if(redValue<0)
        redValue=0;
    }

    ///Converting the R,G,B value to Hex Code string
    String hex = String.format("#%02x%02x%02x", redValue, greenValue, blueValue);


    return Color.web(hex);

    /*
    switch (colorNumber) {
      case 0:
        return Color.web("#00FF00");
      case 1:
        return Color.web("#00FF00");
      case 2:
        return Color.web("#12FF00");
      case 3:
        return Color.web("#1CFF00");
      case 4:
        return Color.web("#1FFF00");
      case 5:
        return Color.web("#24FF00"); 
      case 6:
        return Color.web("#2CFF00");
      case 7:
        return Color.web("#2DFF00"); 
      case 8:
        return Color.web("#2FFF00");
      case 9:
        return Color.web("#30FF00"); 
      case 10:
        return Color.web("#35FF00");
      case 11:
        return Color.web("#3CFF00"); 
      case 12:
        return Color.web("#3FFF00");
      case 13:
        return Color.web("#40FF00"); 
      case 14:
        return Color.web("#47FF00");
      case 15:
        return Color.web("#50FF00"); 
      case 16:
        return Color.web("#55FF00");
      case 17:
        return Color.web("#5CFF00");
      case 18:
        return Color.web("#5FFF00");
      case 19:
        return Color.web("#60FF00"); 
      case 20:
        return Color.web("#65FFF0");
      case 21:
        return Color.web("#68FF00"); 
      case 22:
        return Color.web("#6CFF00");
      case 23:
        return Color.web("#6DFF00"); 
      case 24:
        return Color.web("#6FFF00");
      case 25:
        return Color.web("#70FF00"); 
      case 26:
        return Color.web("#75FF00");
      case 27:
        return Color.web("#7AFF00"); 
      case 28:
        return Color.web("#7CFF00");
      case 29:
        return Color.web("#7FFF00"); 
      case 30:
        return Color.web("#80FF00");
      case 31:
        return Color.web("#85FF00"); 
      case 32:
        return Color.web("#8CFF00");
      case 33:
        return Color.web("#8FFF00"); 
      case 34:
        return Color.web("#90FF00");
      case 35:
        return Color.web("#9AFF00"); 
      case 36:
        return Color.web("#9FFF00");
      case 37:
        return Color.web("#A0FF00"); 
      case 38:
        return Color.web("#ACFF00");
      case 39:
        return Color.web("#B0FF00"); 
      case 40:
        return Color.web("#B5FF00");
      case 41:
        return Color.web("#BBFF00"); 
      case 42:
        return Color.web("#BFFF00");
      case 43:
        return Color.web("#C0FF00"); 
      case 44:
        return Color.web("#C2FF00");
      case 45:
        return Color.web("#C9FF00"); 
      case 46:
        return Color.web("#CDFF00");
      case 47:
        return Color.web("#D0FF00"); 
      case 48:
        return Color.web("#D4FF00");
      case 49:
        return Color.web("#DCFF00"); 
      case 50:
        return Color.web("#E0FF00");
      case 51:
        return Color.web("#E2FF00"); 
      case 52:
        return Color.web("#E5FF00");
      case 53:
        return Color.web("#ECFF00"); 
      case 54:
        return Color.web("#F0FF00");
      case 55:
        return Color.web("#FCFF00"); 
      case 56:
        return Color.web("#F7FF00");
      case 57:
        return Color.web("#F8FF00"); 
      case 58:
        return Color.web("#FFFF00");
      case 59:
        return Color.web("#FFF600"); 
      case 60:
        return Color.web("#FFF000");
      case 61:
        return Color.web("#FFEC00"); 
      case 62:
        return Color.web("#FFE400");
      case 63:
        return Color.web("#FFE000"); 
      case 64:
        return Color.web("#FFDC00");
      case 65:
        return Color.web("#FFD900"); 
      case 66:
        return Color.web("#FFD000");
      case 67:
        return Color.web("#FFCC00"); 
      case 68:
        return Color.web("#FFC100");
      case 69:
        return Color.web("#FFBB00"); 
      case 70:
        return Color.web("#FFAF00");
      case 71:
        return Color.web("#FFAA00"); 
      case 72:
        return Color.web("#FFA000");
      case 73:
        return Color.web("#FF9D00"); 
      case 74:
        return Color.web("#FF9E00");
      case 75:
        return Color.web("#FF9900"); 
      case 76:
        return Color.web("#FF9000");
      case 77:
        return Color.web("#FF8F00"); 
      case 78:
        return Color.web("#FF8C00");
      case 79:
        return Color.web("#FF8500"); 
      case 80:
        return Color.web("#FF7F00");
      case 81:
        return Color.web("#FF7C00"); 
      case 82:
        return Color.web("#FF7800");
      case 84:
        return Color.web("#FF7500"); 
      case 85:
        return Color.web("#FF7000");
      case 86:
        return Color.web("#FF6F00");
      case 87:
        return Color.web("#FF6900");
      case 88:
        return Color.web("#FF6000");
      case 89:
        return Color.web("#FF5700");
      case 90:
        return Color.web("#FF5500");
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
        return Color.web("#FF2C00");
      case 97:
        return Color.web("#FF2100");
      case 98:
        return Color.web("#FF1D00");
      case 99:
        return Color.web("#FF1000");
      default:
        return Color.web("#A9A9A9");
    }

    */

  }

  public double getBrightness() {
    if (brightnessNumber <= 0) {
      return 12.0;                           // indicates the device is off
    } else if (brightnessNumber < 10) {
      return 10.0;
    } else if (brightnessNumber < 20) {
      return 8.0;
    } else if (brightnessNumber < 40) {
      return 6.0;
    } else if (brightnessNumber < 60) {
      return 4.0;
    } else if (brightnessNumber < 80) {
      return 2.0;
    } else return 1.0;
  }
}