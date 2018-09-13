package imageManipulation;

/** The Driver class for ImageProcessor. Invokes different methods of class
 * ImageProcessor and stores results in the files. */
public class ImageProcessorDriver {
    public static final int NUM_ITERS = 5;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No image has been specified.");
            return;
        }

        // TODO: Specify an image as the first command line argument
        ImageProcessor processor = new ImageProcessor(args[0]);
        processor.convertToGrayscale(); // grayscale
        processor.store("inputImages/grayscale.jpg");

        processor = new ImageProcessor(args[0]);
        processor.addNoise(); // noise
        processor.store("inputImages/withNoise.jpg");

        processor = new ImageProcessor(args[0]);
        for (int i = 0; i < NUM_ITERS; i++) {
            processor.blur(); // blur
        }
        processor.store("inputImages/blur.jpg");

        processor = new ImageProcessor(args[0]);
        processor.flipHorizontally(); //flip image horizontally
        processor.store("inputImages/flipped.jpg");

        // Make sure to test your code on other images

    }
}
