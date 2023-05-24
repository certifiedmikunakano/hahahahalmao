package test;
import java.util.*;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.*;

public class MainClass2 {
	public static void main(String[] jeff) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the folder that holds the frames: ");
		String inputFolderName = scan.nextLine();
		final File folder = new File(inputFolderName);
		ArrayList<BufferedImage> array = makeIntoArrayList(folder);
		ImageArray ia = new ImageArray(array);
		ia.encrypt();
		ArrayList<BufferedImage> encryptedArray = ia.getVideo();
		System.out.println("Enter the folder that holds the output: ");
		String outputFolderName = scan.nextLine();
		for (int i = 0; i < encryptedArray.size(); i++) {
			String str = outputFolderName + "\\frame_" + i + ".png";
			File h = new File (str);
	    	ImageIO.write(encryptedArray.get(i), "png", h);
		}
		
		
		
	}
	
	public static ArrayList<BufferedImage> makeIntoArrayList(final File folder) throws IOException {
		ArrayList<BufferedImage> result = new ArrayList<BufferedImage>();
	    for (final File frame : folder.listFiles()) {
	    	TheImage ti = new TheImage (frame.getAbsolutePath());
	    	ti.imageEncrypt();
	    	result.add(ti.getImage());
	    }
	    return result;
	}
	
	
}
