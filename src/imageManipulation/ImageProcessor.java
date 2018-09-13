package imageManipulation;

public class ImageProcessor {
    private Picture myImage; // reference to the Picture object

    /**
     * Constructor: creates a Picture from the given image file
     * @param imageFilename the file with the image
     */
    public ImageProcessor(String imageFilename) {

        this.myImage = new Picture(imageFilename);
    }

    /** Reset myImage by loading the image from the given file
     *
     * @param imageFilename name of the file with an image
     */
    public void setImage(String imageFilename) {

        this.myImage = new Picture(imageFilename);
    }

    /** Convert myImage to grayscale using the following formula:
     *  New r, g, b values of a pixel should be set to the following sum:
     *  30% of current red value of the pixel  +
     *  59% of current green value of the pixel +
     *  11% of blue value of the pixel.
     *
     */
    public void convertToGrayscale() {
        // FILL IN CODE

        // Use myImage.getWidth() to find the width of the image
        // and myImage.getHeight to get the height
        // To access the pixel at (i,j), use myImage.getPixel(i, j).
        // RGB values of a pixel can be accessed using getRed(), getGreen() and getBlue() methods
        // Use setPixel method to set new values for a particular pixel.
    }

    /** Flips image horizontally */
    public void flipHorizontally() {
        // FILL IN CODE

    }


    /** Add random noise to myImage. Go over each pixel, and add
     *  a random number from 0 to 255 to each of the components. Make
     *  sure you adjust the range so that the max for each component is 255.
     */
    public void addNoise() {
        // FILL IN CODE
    }



    /** Make the image blurry using convolution */
    public void blur() {
        // FILL IN CODE

    }

    /**
     * Store this picture in the file with the specified name
     * @param imageFilename name of the file where th
     */
    public void store(String imageFilename) {
        myImage.store(imageFilename);
    }

}
