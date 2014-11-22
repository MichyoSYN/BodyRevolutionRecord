package contour;

import org.opencv.core.*;
import static org.opencv.imgproc.Imgproc.*;
import static org.opencv.highgui.Highgui.*;

public class ContourReco {

	public void run(String inputFile, String outputFile) {
		// TODO Auto-generated method stub
		
		Mat I = imread(inputFile);
		cvtColor(I, I, COLOR_BGR2GRAY);
		
		Mat contours = new Mat();
		Canny(I, contours, 120, 350);
		
		threshold(contours, contours, 128, 255, THRESH_BINARY);
		
		imwrite(outputFile, contours);
		
		//new DetectFaceDemo().run();
	}

}
