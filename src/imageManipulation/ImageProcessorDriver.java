package imageManipulation;

/** The Driver class for ImageProcessor. Invokes different methods of class
 * ImageProcessor and stores results in the files. */
public class ImageProcessorDriver {
    public static final int NUM_ITERS = 5;

    public static void main(String[] args) {

        // Pikachu image ---------------
        ImageProcessor processor = new ImageProcessor("inputImages/Pikachu.jpg");
        processor.convertToGrayscale(); // grayscale
        processor.store("inputImages/grayscalePikachu.jpg");

        processor = new ImageProcessor("inputImages/Pikachu.jpg");
        processor.addNoise(); // noise
        processor.store("inputImages/withNoisePikachu.jpg");

        processor = new ImageProcessor("inputImages/Pikachu.jpg");
        for (int i = 0; i < NUM_ITERS; i++) {
            processor.blur(); // blur
        }
        processor.store("inputImages/PikachuBlur.jpg");

        processor = new ImageProcessor("inputImages/Pikachu.jpg");
        processor.flipHorizontally();
        processor.store("inputImages/flippedPikachu.jpg");

        // Make sure to test your code on other images

    }
}
