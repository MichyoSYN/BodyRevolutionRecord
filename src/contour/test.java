package contour;

import face.DetectFaceDemo;

import org.opencv.core.*;
import static org.opencv.imgproc.Imgproc.*;
import static org.opencv.imgcodecs.Imgcodecs.*;

public class test {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		// TODO Auto-generated method stub
		Mat I = imread("src/a.jpg");
		cvtColor(I, I, COLOR_BGR2GRAY);
		
		Mat contours = new Mat();
		Canny(I, contours, 150, 225);
		
		threshold(contours, contours, 180, 200, THRESH_BINARY);
		
		imwrite("src/a_canny.jpg", contours);
		
		new DetectFaceDemo().run();
	}

}
