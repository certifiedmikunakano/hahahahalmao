package test;
import java.util.*;
import java.awt.image.BufferedImage;

public class ImageArray {

	//video is exactly [safe prime] frames long
	int safePrime = 83;
	ArrayList <BufferedImage> video;
	public ImageArray (ArrayList<BufferedImage> vid) {
		video = vid;
	}
	
	public int size () {
		return video.size();
	}
	
	public ArrayList<BufferedImage> getVideo () {
		return video;
	}
	
	public void encrypt () {
		if (video.size() != safePrime) {
			System.out.println("Incorrect length for encryption.");
			return;
		}
		ArrayList <BufferedImage> result = new ArrayList<BufferedImage>();
		for (int i = 0; i < video.size(); i++) {
	   		 result.add(video.get(prToThe(i, 7)));
	   	 }
	   	video = result;

	}
	
	private int prToThe (int base, int k) {
	   	 int value = 1;
	   	 for (int i = 0; i < k; i++) {
	   		 value*=base;
	   		 value%=safePrime;
	   	 }
	   	 return value;
	}
}
