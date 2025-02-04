import org.code.media.Pixel;
import org.code.media.Color;
import org.code.media.Image;


//This code is mostly used from Kai Kalma



public class ImageFilter extends Image {

    public ImageFilter(String filename) {
        super(filename);
    }

    /*
     * PIXELATE FILTER
     * This method pixelates the image based on the given grid size.
     */
    public void pixelate(int gridSize) {
        int numRows = getHeight();
        int numCols = getWidth();

        for (int rowStart = 0; rowStart < numRows; rowStart += gridSize) {
            for (int colStart = 0; colStart < numCols; colStart += gridSize) {
                int redSum = 0, greenSum = 0, blueSum = 0, pixelCount = 0;
                int rowEnd = Math.min(rowStart + gridSize, numRows);
                int colEnd = Math.min(colStart + gridSize, numCols);

                for (int row = rowStart; row < rowEnd; row++) {
                    for (int col = colStart; col < colEnd; col++) {
                        Pixel pixel = getPixel(col, row);
                        redSum += pixel.getRed();
                        greenSum += pixel.getGreen();
                        blueSum += pixel.getBlue();
                        pixelCount++;
                    }
                }

                int avgRed = redSum / pixelCount;
                int avgGreen = greenSum / pixelCount;
                int avgBlue = blueSum / pixelCount;

                for (int row = rowStart; row < rowEnd; row++) {
                    for (int col = colStart; col < colEnd; col++) {
                        Pixel pixel = getPixel(col, row);
                        pixel.setRed(avgRed);
                        pixel.setGreen(avgGreen);
                        pixel.setBlue(avgBlue);
                    }
                }
            }
        }
    }

    /*
     * MOTION BLUR FILTER
     * This method applies a motion blur effect in a given direction.
     */
    public void motionBlur(int length, String direction) {
        int width = getWidth();
        int height = getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int redTotal = 0, greenTotal = 0, blueTotal = 0, count = 0;

                for (int i = 0; i < length; i++) {
                    int newX = x;
                    int newY = y;

                    if (direction.equals("horizontal")) {
                        newX = x + i;
                    } else if (direction.equals("vertical")) {
                        newY = y + i;
                    } else if (direction.equals("diagonal")) {
                        newX = x + i;
                        newY = y + i;
                    }

                    if (newX >= 0 && newX < width && newY >= 0 && newY < height) {
                        Pixel currentPixel = getPixel(newX, newY);
                        redTotal += currentPixel.getRed();
                        greenTotal += currentPixel.getGreen();
                        blueTotal += currentPixel.getBlue();
                        count++;
                    }
                }

                if (count > 0) {
                    int avgRed = redTotal / count;
                    int avgGreen = greenTotal / count;
                    int avgBlue = blueTotal / count;
                    Pixel pixel = getPixel(x, y);
                    pixel.setRed(avgRed);
                    pixel.setGreen(avgGreen);
                    pixel.setBlue(avgBlue);
                }
            }
        }
    }

    /*
     * THRESHOLD FILTER
     * This method converts an image into black and white based on a threshold value.
     */
    public void threshold(int value) {
        int width = getWidth();
        int height = getHeight();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Pixel currentPixel = getPixel(col, row);
                int avgRGB = (currentPixel.getRed() + currentPixel.getGreen() + currentPixel.getBlue()) / 3;

                if (avgRGB < value) {
                    currentPixel.setRed(0);
                    currentPixel.setGreen(0);
                    currentPixel.setBlue(0);
                } else {
                    currentPixel.setRed(255);
                    currentPixel.setGreen(255);
                    currentPixel.setBlue(255);
                }
            }
        }
    }

    /*
     * ZERO GREEN FILTER
     * This method removes all green from the image.
     */
    public void zeroGreen() {
        int width = getWidth();
        int height = getHeight();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Pixel currentPixel = getPixel(col, row);
                currentPixel.setGreen(0);
            }
        }
    }
}
