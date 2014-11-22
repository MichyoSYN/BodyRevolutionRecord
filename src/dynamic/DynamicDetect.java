package dynamic;
import static org.opencv.imgproc.Imgproc.COLOR_BGR2GRAY;
import static org.opencv.imgproc.Imgproc.cvtColor;

import org.opencv.core.Size;
import static org.opencv.imgproc.Imgproc.*;
import static org.opencv.highgui.Highgui.*;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class DynamicDetect {
	String face_cascade_name = "data/haarcascades/haarcascade_frontalface_alt.xml";
	String eyes_cascade_name = "data/haarcascades/haarcascade_eye_tree_eyeglasses.xml";
	CascadeClassifier face_cascade;
	CascadeClassifier eyes_cascade;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void detectAndDisplay(Mat frame) {
		MatOfRect faces = new MatOfRect();
		Mat frame_gray = new Mat();
		
		cvtColor(frame, frame_gray, COLOR_BGR2GRAY);
		equalizeHist(frame_gray, frame_gray);
		
		face_cascade.detectMultiScale(frame_gray, faces, 1.1, 2, 0, new Size(20, 20), new Size(40, 40));
		
		for(int i = 0; i < faces.toArray().length; i++) {
			Point center = new Point(faces.toArray()[i].x + faces.toArray()[i].width * 0.5, faces.toArray()[i].y + faces.toArray()[i].height * 0.5);
		}
	}

}
