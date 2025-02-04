import org.code.theater.*;
import org.code.media.*;

public class KoreaStory extends Scene {

  private String[][] koreanCulture = {
    {"koreanflag.png"},
    {"koreanclothing.jpg"},
    {"koreanfood.jpg"},
    {"bts.png", "hms.jpg", "koreanbuildings.jpg", "squidgame.jpg"}
  };

  public void print() {
    //What this does is shows a white screen and plays the intro of Gangnam Style for four seconds while it prints the title
    clear("white");
    playSound("Gangnam-Style.wav");
    setTextHeight(30);
    drawText("Project: Personal Narrative", 30, 160);
    drawText("Korean Nationality", 80, 200);
    pause(4.0); 
    // Pauses for 4 seconds to show the intro

    // Scene 1: South Korean Flag
    clear("white");
    setTextHeight(25);
    drawText("Here is the South Korean flag", 30, 200); 
    // Displays text
    pause(3.0); 
    // Shows the text for 3 seconds

    clear("white");
    ImageFilter flagImageBlurry = new ImageFilter(koreanCulture[0][0]);
    flagImageBlurry.motionBlur(20, "horizontal"); 
    // Applys blur filter
    drawImage(flagImageBlurry, 0, 0, 400); 
    // Shows blurry image
    pause(3.0); 
    // Pause for 3 seconds to show the blurry version

    clear("white");
    ImageFilter flagImageClear = new ImageFilter(koreanCulture[0][0]);
    drawImage(flagImageClear, 0, 0, 400); // Show clear image
    pause(3.0); 
    // Pause for 3 seconds to show the clear version

    // Scene 2: Korean Cultural Clothing
    // Same as the first scene it will show white and display text but no music
    clear("white");
    setTextHeight(25);
    drawText("Korean Cultural Clothing", 30, 200); // Displays text
    pause(3.0);
    // Shows the text for 3 seconds

    clear("white");
    ImageFilter clothingImagePixelated = new ImageFilter(koreanCulture[1][0]);
    clothingImagePixelated.pixelate(10); 
    // Applys pixelate filter
    drawImage(clothingImagePixelated, 0, 0, 400); 
    // Shows pixelated image
    pause(3.0); 
    // Pause for 3 seconds to show the pixelated version

    clear("white");
    ImageFilter clothingImageClear = new ImageFilter(koreanCulture[1][0]);
    drawImage(clothingImageClear, 0, 0, 400);
    // Shows clear image
    pause(3.0); 
    // Pause for 3 seconds to show the clear version

    // Scene 3: Korean Food
    //Same as second scene but food scene
    clear("white");
    setTextHeight(25);
    drawText("Korean Food", 30, 200);
    // Displays text
    pause(3.0);
    // Shows the text for 3 seconds

    clear("white");
    ImageFilter foodImageThreshold = new ImageFilter(koreanCulture[2][0]);
    foodImageThreshold.threshold(128); 
    // Applys threshold filter instead of pixelate
    drawImage(foodImageThreshold, 0, 0, 400); 
    // Shows threshold image
    pause(3.0); 
    // Pause for 3 seconds to show the threshold version

    clear("white");
    ImageFilter foodImageClear = new ImageFilter(koreanCulture[2][0]);
    drawImage(foodImageClear, 0, 0, 400); // Show clear image
    pause(3.0);
    // Pause for 3 seconds to show the clear version


    
    // Scene 4: Part of Korea's Popularity\
    //This part was trouble so I used the help of classmates and chatgpt to code it
    
    //I got it to display four different images in four different parts of the screen while having motion blur and zero green . Zero green I used from Kai Kalma's code
    
clear("white");
setTextHeight(25);
drawText("Part of Korea's Popularity", 30, 200); // Displays text
pause(3.0); // Shows the text for 3 seconds

clear("white");

// Show filtered images
ImageFilter btsImageZeroGreen = new ImageFilter(koreanCulture[3][0]);
btsImageZeroGreen.zeroGreen();
drawImage(btsImageZeroGreen, 200, 200, 200);

ImageFilter hmsImageZeroGreen = new ImageFilter(koreanCulture[3][1]);
hmsImageZeroGreen.zeroGreen();
drawImage(hmsImageZeroGreen, 200, 0, 200);

ImageFilter koreanbuildingsMotionBlur = new ImageFilter(koreanCulture[3][2]);
koreanbuildingsMotionBlur.motionBlur(15, "diagonal");
drawImage(koreanbuildingsMotionBlur, 0, 200, 200);

ImageFilter squidgameMotionBlur = new ImageFilter(koreanCulture[3][3]);
squidgameMotionBlur.motionBlur(15, "diagonal");
drawImage(squidgameMotionBlur, 0, 0, 200);

pause(3.0);
// Pause for 3 seconds to show the filtered version

// Clear screen and display original images
clear("white");

ImageFilter btsImageClear = new ImageFilter(koreanCulture[3][0]);
drawImage(btsImageClear, 200, 200, 200);

ImageFilter hmsImageClear = new ImageFilter(koreanCulture[3][1]);
drawImage(hmsImageClear, 200, 0, 200);

ImageFilter koreanbuildingsClear = new ImageFilter(koreanCulture[3][2]);
drawImage(koreanbuildingsClear, 0, 200, 200);

ImageFilter squidgameClear = new ImageFilter(koreanCulture[3][3]);
drawImage(squidgameClear, 0, 0, 200);

pause(3.0);
    // Pauses for 3 seconds to show the clear version

    
  }
}
