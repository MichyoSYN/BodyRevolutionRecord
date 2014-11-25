package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.media.MediaLocator;

import org.opencv.core.Core;

import contour.ContourReco;
import face.DetectFace;
import video.JpegImagesToMovie;

public class ImageProcess {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		String inputFile = "src/1.jpg";
		String outputFile = "src/1_canny.jpg";
		
		faces(inputFile, outputFile);
		
		//String[] pictures = {"src/a.jpg", "src/b.jpg"};
		//transVideo(pictures, video);
		
		//String video = "src/video.mp4";
		//Vector<String> pics = new Vector<String>();
		//pics.add("src/320.jpg");
		//makeVideo(pics, video, 320, 320);
	}
	
	public static void run(String inputFile, String outputFile) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		// Amout of faces can be deteced in the picture now.
		int faces = new DetectFace().run(inputFile, outputFile);
		
		warningOfFaces(faces);
		
		new ContourReco().run(inputFile, outputFile);
	}
	
	public static void contour(String inputFile, String outputFile) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		new ContourReco().run(inputFile, outputFile);
	}
	
	public static void faces(String inputFile, String outputFile) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		// Amout of faces can be deteced in the picture now.
		int faces = new DetectFace().run(inputFile, outputFile);
		warningOfFaces(faces);
	}
	
	public static void makeVideo(Vector<String> inputPictures, String fileName, int width, int height) throws MalformedURLException {
	    JpegImagesToMovie imageToMovie = new JpegImagesToMovie();
	    MediaLocator oml;
	    if ((oml = JpegImagesToMovie.createMediaLocator(fileName)) == null) {
	        System.err.println("Cannot build media locator from: " + fileName);
	        System.exit(0);
	    }
	    int interval = 50;
	    imageToMovie.doIt(width, height, (1000 / interval), inputPictures, oml);

	}
	
	public static void warningOfFaces(int faces) {
		if(faces < 1) {
			System.out.print("NOTICE >> Please stand into the camera area!");
		}
		else if(faces > 1) {
			System.out.print("NOTICE >> Please keep only one person in camera area in a time!");
		}
		if (faces == 1){
			System.out.print("NOTICE >> Reconized! Please keep still to wait for taking photo!");	
		}
	}

}
