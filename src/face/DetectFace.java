package face;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import static org.opencv.highgui.Highgui.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

/*
 * Detects faces in an image, draws boxes around them, and writes the results
 * to "faceDetection.png".
 */
public class DetectFace {
    public int run(String inputFile, String outputFile) {
        System.out.println("\nRunning DetectFaceDemo");

        // Create a face detector from the cascade file in the resources
        // directory.
        CascadeClassifier faceDetector = new CascadeClassifier("data/haarcascades/haarcascade_frontalface_alt.xml");
        Mat image = imread(inputFile);

        // Detect faces in the image.
        // MatOfRect is a special container class for Rect.
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);

        System.out.println(String.format("Detected %s faces",
                faceDetections.toArray().length));

        // Draw a bounding box around each face.
        for (Rect rect : faceDetections.toArray()) {
            Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x
                    + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }

        // Save the visualized detection.
        System.out.println(String.format("Writing %s", outputFile));
        imwrite(outputFile, image);
        return faceDetections.toArray().length;
    }
}
