

package imageManipulation;

import java.awt.image.BufferedImage;
import java.util.Random;

import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;

public class ImageProcessor {
    private Picture myImage; // reference to the Picture object


    /**
     * Constructor: creates a Picture from the given image file
     *
     * @param imageFilename the file with the image
     */
    public ImageProcessor(String imageFilename) {

        this.myImage = new Picture(imageFilename);
    }

    /**
     * Reset myImage by loading the image from the given file
     *
     * @param imageFilename name of the file with an image
     */
    public void setImage(String imageFilename) {

        this.myImage = new Picture(imageFilename);
    }

    /**
     * Convert myImage to grayscale using the following formula:
     * New r, g, b values of a pixel should be set to the following sum:
     * 30% of current red value of the pixel  +
     * 59% of current green value of the pixel +
     * 11% of blue value of the pixel.
     */
    public void convertToGrayscale() {
        // FILL IN CODE


        for (int i = 0; i < myImage.getWidth(); i++) {
            for (int j = 0; j < myImage.getHeight(); j++) {
                int red = myImage.getPixel(i, j).getRed();
                int green = myImage.getPixel(i, j).getGreen();
                int blue = myImage.getPixel(i, j).getBlue();
                double avg = .3 * red + .59 * green + .11 * blue;
                int avgCast = (int) avg;

                Pixel pixel = new Pixel(avgCast, avgCast, avgCast);
                myImage.setPixel(i, j, pixel);
            }
        }
        // Use myImage.getWidth() to find the width of the image
        // and myImage.getHeight to get the height
        // To access the pixel at (i,j), use myImage.getPixel(i, j).
        // RGB values of a pixel can be accessed using getRed(), getGreen() and getBlue() methods
        // Use setPixel method to set new values for a particular pixel.
    }

    /**
     * Flips image horizontally
     */
    public void flipHorizontally() {
        // FILL IN CODE


        for (int y = 0; y < myImage.getHeight(); y++) {

            //     myImage.getPixel(i, j); set as variable
            // swap pixels with setPixel method


            for (int x = 0; x < myImage.getWidth() / 2; x++) {

                Pixel temp = myImage.getPixel(myImage.getWidth() - 1 - x, y);
                myImage.setPixel(myImage.getWidth() - 1 - x, y, myImage.getPixel(x, y));
                myImage.setPixel(x, y, temp);

            }


        }


    }


    /**
     * Add random noise to myImage. Go over each pixel, and add
     * a random number from 0 to 255 to each of the components. Make
     * sure you adjust the range so that the max for each component is 255.
     */
    public void addNoise() {
        // FILL IN CODE
        // make sure not > 255
        // create new pixels EACH for r g b
        Random random = new Random();

        for (int i = 0; i < myImage.getWidth(); i++) {
            for (int j = 0; j < myImage.getHeight(); j++) {
                int red = myImage.getPixel(i, j).getRed() + random.nextInt(256);
                int green = myImage.getPixel(i, j).getGreen() + random.nextInt(256);
                int blue = myImage.getPixel(i, j).getBlue() + random.nextInt(256);

                if (red > 255) {
                    do {
                        red = myImage.getPixel(i, j).getRed() + random.nextInt(256);
                    } while (red > 255);
                }
                if (green > 255) {
                    do {
                        green = myImage.getPixel(i, j).getGreen() + random.nextInt(256);
                    } while (green > 255);
                }
                if (blue > 255) {
                    do {
                        blue = myImage.getPixel(i, j).getBlue() + random.nextInt(256);
                    } while (blue > 255);
                }

                Pixel pixel = new Pixel(red, green, blue);
                myImage.setPixel(i, j, pixel);
            }
        }
    }


    /**
     * Make the image blurry using convolution
     */


    public void blur() {


        int[][] matrix = {{-1, -1, -1},
                {-1, 9, -1},
                {-1, -1, -1}};


        int redTot = 0;
        int greenTot = 0;
        int blueTot = 0;

        for (int y = 0; y < myImage.getWidth(); y++) {
            for (int x = 0; x < myImage.getHeight(); x++) {
                redTot += myImage.getPixel(x, y).getRed();
                greenTot += myImage.getPixel(x, y).getGreen();
                blueTot += myImage.getPixel(x, y).getBlue();

                Pixel pixel = new Pixel(redTot, greenTot, blueTot);
                myImage.setPixel(x, y, pixel);
            }

        }

    }

    /**
     * Store this picture in the file with the specified name
     *
     * @param imageFilename name of the file where th
     */
    public void store(String imageFilename) {
        myImage.store(imageFilename);
    }

}


