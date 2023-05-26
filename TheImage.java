package test;
import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;
public class TheImage {
    
	private BufferedImage image; 
	private BufferedImage rawImage;
	
	private String fileName;
	public TheImage (String fn) {
		fileName = fn;
	}
	
	public TheImage (BufferedImage im) {
		rawImage = im;
	}
	
	public BufferedImage getImage () {
		return image;
	}
	
	
    public void imageEncrypt () throws IOException{
   	 Random random = new Random();
    	int width = 1018;	//width of the image
    	int height = 1018;   //height of the image
    	//generate the primitive roots mod 1019
   	 
    	ArrayList <Integer> proots = new ArrayList <Integer> ();
    	for (int i = 0; i < 1018; i++) {
   		 proots.add(i);
    	}
    	for (int i = 0; i < 1019; i++) {
   		 int j = proots.indexOf((i*i) % 1019);
   		 if (j != -1) {
   			 proots.remove(j);
   		 }
   		 
    	}
    	int randomIndex1 = random.nextInt(proots.size());
    	int randomIndex2 = random.nextInt(proots.size());
    	int proot1 = proots.get(randomIndex1);
    	int proot2 = proots.get(randomIndex2);
   	 
   	 
    	File f = null;
   	 
    	//read image
    	try{
      	f = new File(fileName); //image file path
      	rawImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
      	rawImage = ImageIO.read(f);
      	image = resizeImage(rawImage, width, height);
      	System.out.println("Reading complete.");
    	}catch(IOException e){
      	System.out.println("Error: "+e);
    	}
   	 
    	BufferedImage scrambledImage = scramble(image, proot1);

    	BufferedImage scrambledImage2 = scramble2(scrambledImage, proot2);
    	System.out.println("Image Scrambled.");
   	 
    	 
    	ImageIO.write(scrambledImage2, "png", f);
    	System.out.println("Image writing complete.");
    	
    	image = scrambledImage2;
   	 
    	int secretCode = 10000 * proot1 + proot2;
   	 
    	System.out.println("Your decryption code is: " + secretCode + ". Keep this code to yourself but don't lose it!");
   	 	
   	 
      }
    
    public void imageDecrypt () throws IOException{
    	int width = 1018;	//width of the image
    	int height = 1018;   //height of the image
    	BufferedImage image = null;
    	File f = null;
    	Scanner scan = new Scanner(System.in);
   	 
    	//read image
    	try{
      	f = new File(fileName); //image file path
      	BufferedImage rawImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
      	rawImage = ImageIO.read(f);
      	image = resizeImage(rawImage, width, height);
      	System.out.println("Reading complete.");
    	}catch(IOException e){
      	System.out.println("Error: "+e);
    	}
   	 
    	System.out.println("Enter the decryption code for that image: ");
   	 
    	String codestring = scan.nextLine();
    	int code = Integer.parseInt(codestring);
    	int root1 = code / 10000;
    	int root2 = code % 10000;
   	 
    	BufferedImage unscrambledImage1 = unscrambleCols (image, root1);

    	BufferedImage unscrambledImage2 = unscrambleRows (unscrambledImage1, root2);
    	System.out.println("Image unscrambled.");
   	 
   			    	 
    	ImageIO.write(unscrambledImage2, "png", f);
    	System.out.println("Writing complete.");
    	
    	image = unscrambledImage2;
      	 	
      	 
         }
    
    public void enhancedDecrypt () throws IOException{
    	int width = 1018;	//width of the image
    	int height = 1018;   //height of the image
    	BufferedImage image = null;
    	File f = null;
    	Scanner scan = new Scanner(System.in);
   	 
    	//read image
    	try{
      	f = new File(fileName); //image file path
      	BufferedImage rawImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
      	rawImage = ImageIO.read(f);
      	image = resizeImage(rawImage, width, height);
      	System.out.println("Reading complete.");
    	}catch(IOException e){
      	System.out.println("Error: "+e);
    	}
   	 
    	System.out.println("Enter the decryption code for that image: ");
   	 
    	String codestring = scan.nextLine();
    	String[] rootsArray = codestring.split(" ");
    
    	int root1 = Integer.parseInt(rootsArray[0]);
    	int root2 = Integer.parseInt(rootsArray[1]);
    	int root3 = Integer.parseInt(rootsArray[2]);
    	int root4 = Integer.parseInt(rootsArray[3]);
    	int root5 = Integer.parseInt(rootsArray[4]);
    	int root6 = Integer.parseInt(rootsArray[5]);

    	
   	 
    	BufferedImage unscrambledImage1 = unscrambleCols (image, root1);

    	BufferedImage unscrambledImage2 = unscrambleRows (unscrambledImage1, root2);
    	
    	BufferedImage unscrambledImage3 = unscrambleD1 (unscrambledImage2, root3, root4);

    	BufferedImage unscrambledImage4 = unscrambleD2 (unscrambledImage3, root5, root6);

    	System.out.println("Image unscrambled.");
   	 
   			    	 
    	ImageIO.write(unscrambledImage4, "png", f);
    	System.out.println("Writing complete.");
    	
    	image = unscrambledImage4;
      	 	
      	 
         }
    
    public void enhancedEncrypt () throws IOException{
      	 Random random = new Random();
       	int width = 1018;	//width of the image
       	int height = 1018;   //height of the image
       	//generate the primitive roots mod 1019
      	 
       	ArrayList <Integer> proots = new ArrayList <Integer> ();
       	for (int i = 0; i < 1018; i++) {
      		 proots.add(i);
       	}
       	for (int i = 0; i < 1019; i++) {
      		 int j = proots.indexOf((i*i) % 1019);
      		 if (j != -1) {
      			 proots.remove(j);
      		 }
      		 
       	}
       	int randomIndex1 = random.nextInt(proots.size());
       	int randomIndex2 = random.nextInt(proots.size());
       	int randomIndex3 = random.nextInt(proots.size());
       	int randomIndex4 = random.nextInt(proots.size());
       	int randomIndex5 = random.nextInt(proots.size());
       	int randomIndex6 = random.nextInt(proots.size());

       	int proot1 = proots.get(randomIndex1);
       	int proot2 = proots.get(randomIndex2);
       	int proot3 = proots.get(randomIndex3);
       	int proot4 = proots.get(randomIndex4);
       	int proot5 = proots.get(randomIndex5);
       	int proot6 = proots.get(randomIndex6);

      	 
       	File f = null;
      	 
       	//read image
       	try{
         	f = new File(fileName); //image file path
         	rawImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
         	rawImage = ImageIO.read(f);
         	image = resizeImage(rawImage, width, height);
         	System.out.println("Reading complete.");
       	}catch(IOException e){
         	System.out.println("Error: "+e);
       	}
      	 
       	BufferedImage scrambledImage = scramble(image, proot1);

       	BufferedImage scrambledImage2 = scramble2(scrambledImage, proot2);
       	
       	BufferedImage scrambledImage3 = scrambleD1(scrambledImage2, proot3, proot4);

       	BufferedImage scrambledImage4 = scrambleD2(scrambledImage3, proot5, proot6);

       	System.out.println("Image Scrambled.");
      	 
       	 
       	ImageIO.write(scrambledImage4, "png", f);
       	System.out.println("Image writing complete.");
       	
       	image = scrambledImage4;
      	 
       	String secretCode = proot1 + " " + proot2 + " " + proot3 + " " + proot4 + " " + proot5 + " " + proot6;
      	 
       	System.out.println("Your decryption code is: " + secretCode + ". Keep this code to yourself but don't lose it!");
      	 	
      	 
         }
    
    private static int prToThe (int base, int k) {
   	 int value = 1;
   	 for (int i = 0; i < k; i++) {
   		 value*=base;
   		 value%=1019;
   	 }
   	 return value;
    }
    
    static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
    	BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
    	Graphics2D graphics2D = resizedImage.createGraphics();
    	graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
    	graphics2D.dispose();
    	return resizedImage;
    }
    
    private static ArrayList<Color> encrypt (ArrayList <Color> original, int pr) {
   	 ArrayList<Color> newArr = new ArrayList<Color>();
   	 for (int i = 0; i < original.size(); i++) {
   		 newArr.add(original.get(prToThe(pr, i) - 1));
   	 }
   	 return newArr;
    }
    
    private static ArrayList<Color> encrypt2 (ArrayList <Color> original, int pr) {
   	 ArrayList<Color> newArr = new ArrayList<Color>();
   	 for (int i = 0; i < original.size(); i++) {
   		 newArr.add(original.get(prToThe(pr, i) - 1));
   	 }
   	 return newArr;
    }

    
    private static BufferedImage scramble (BufferedImage original, int pr) {
   		 BufferedImage scrambled = new BufferedImage (original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
   		 
   		 //scramble each row
   		 for (int y = 0; y < original.getHeight(); y++) {
   			 ArrayList<Color> origRow = new ArrayList <Color> ();
   			 for (int j = 0; j < original.getWidth(); j++) {
   				 Color c = new Color(original.getRGB(j, y));
   				 origRow.add(c);
   			 }
   			 
   			 ArrayList<Color> scrambledRow = encrypt (origRow, pr);
   			 for (int j = 0; j < original.getWidth(); j++) {
   				 int newRGB = scrambledRow.get(j).getRGB();
   				 scrambled.setRGB(j, y, newRGB);
   			 }
   		 }
   		 return scrambled;
   	 }
    
    private static BufferedImage scramble2 (BufferedImage original, int pr) {
   	 BufferedImage scrambled = new BufferedImage (original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
   	 
   	 //scramble each column
   	 for (int x = 0; x < original.getWidth(); x++) {
   		 ArrayList<Color> origCol = new ArrayList <Color> ();
   		 for (int j = 0; j < original.getHeight(); j++) {
   			 Color c = new Color(original.getRGB(x, j));
   			 origCol.add(c);
   		 }
   		 
   		 ArrayList<Color> scrambledCol = encrypt2 (origCol, pr);
   		 for (int j = 0; j < original.getHeight(); j++) {
   			 int newRGB = scrambledCol.get(j).getRGB();
   			 scrambled.setRGB(x, j, newRGB);
   		 }
   	 }
   	 return scrambled;
    }
    
    private static BufferedImage scrambleD1 (BufferedImage original, int pr1, int pr2) {
  		 BufferedImage scrambled = new BufferedImage (original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
  		 
  		 //scramble each row
  		 for (int y = 0; y < original.getHeight(); y++) {
  			 ArrayList<Color> origRow = new ArrayList <Color> ();
  			 for (int j = 0; j < original.getWidth(); j++) {
  				 int modifiedY = (y + (prToThe(pr1, j))) % 1018;
  				 Color c = new Color(original.getRGB(j, modifiedY));
  				 origRow.add(c);
  			 }
  			 
  			 ArrayList<Color> scrambledRow = encrypt (origRow, pr2);
  			 for (int j = 0; j < original.getWidth(); j++) {
  				 int modifiedY = (y + (prToThe(pr1, j))) % 1018;
  				 int newRGB = scrambledRow.get(j).getRGB();
  				 scrambled.setRGB(j, modifiedY, newRGB);
  			 }
  		 }
  		 return scrambled;
  	 }
    
    private static BufferedImage scrambleD2 (BufferedImage original, int pr1, int pr2) {
      	 BufferedImage scrambled = new BufferedImage (original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
      	 
      	 //scramble each column
      	 for (int x = 0; x < original.getWidth(); x++) {
      		 ArrayList<Color> origCol = new ArrayList <Color> ();
      		 for (int j = 0; j < original.getHeight(); j++) {
      			 int modifiedX = (x + (prToThe(pr1, j))) % 1018;
      			 Color c = new Color(original.getRGB(modifiedX, j));
      			 origCol.add(c);
      		 }
      		 
      		 ArrayList<Color> scrambledCol = encrypt2 (origCol, pr2);
      		 for (int j = 0; j < original.getHeight(); j++) {
      			 int modifiedX = (x + (prToThe(pr1, j))) % 1018;
      			 int newRGB = scrambledCol.get(j).getRGB();
      			 scrambled.setRGB(modifiedX, j, newRGB);
      		 }
      	 }
      	 return scrambled;
       }
    
    public static int discreteLogBasePrMod1019 (int base, int k) {
      	 int value = 0;
      	 for (int i = 0; i < 1019; i++) {
      		 if (prToThe(base, i) % 1019 == k) {
      			 value = i;
      			 break;
      		 }
      	 }
      	 return value;
       }
       
       //use pr1
       public static ArrayList<Color> decryptRows (ArrayList <Color> original, int pr) {
      	 ArrayList<Color> newArr = new ArrayList<Color>();
      	 for (int i = 0; i < original.size(); i++) {
      		 newArr.add(original.get(discreteLogBasePrMod1019(pr, i+1)));
      	 }
      	 return newArr;
       }
       
       //use pr2
       public static ArrayList<Color> decryptCols (ArrayList <Color> original, int pr) {
      	 ArrayList<Color> newArr = new ArrayList<Color>();
      	 for (int i = 0; i < original.size(); i++) {
      		 newArr.add(original.get(discreteLogBasePrMod1019(pr, i+1)));
      	 }
      	 return newArr;
       }

       
       public static BufferedImage unscrambleCols (BufferedImage original, int pr) {
      		 BufferedImage unscrambled = new BufferedImage (original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
      		 
      		 //scramble each row
      		 for (int y = 0; y < original.getHeight(); y++) {
      			 ArrayList<Color> origRow = new ArrayList <Color> ();
      			 for (int j = 0; j < original.getWidth(); j++) {
      				 Color c = new Color(original.getRGB(j, y));
      				 origRow.add(c);
      			 }
      			 
      			 ArrayList<Color> unscrambledRow = decryptRows (origRow, pr);
      			 for (int j = 0; j < original.getWidth(); j++) {
      				 int newRGB = unscrambledRow.get(j).getRGB();
      				 unscrambled.setRGB(j, y, newRGB);
      			 }
      			 System.out.println("Column " + y + " unscrambled");

      		 }
      		 return unscrambled;
      	 }
       
       public static BufferedImage unscrambleRows (BufferedImage original, int pr) {
      	 BufferedImage unscrambled = new BufferedImage (original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
      	 
      	 //scramble each column
      	 for (int x = 0; x < original.getWidth(); x++) {
      		 ArrayList<Color> origCol = new ArrayList <Color> ();
      		 for (int j = 0; j < original.getHeight(); j++) {
      			 Color c = new Color(original.getRGB(x, j));
      			 origCol.add(c);
      		 }
      		 
      		 ArrayList<Color> unscrambledCol = decryptCols (origCol, pr);
      		 for (int j = 0; j < original.getHeight(); j++) {
      			 int newRGB = unscrambledCol.get(j).getRGB();
      			 unscrambled.setRGB(x, j, newRGB);
      		 }
      		 System.out.println("Row " + x + " unscrambled");

      	 }
      	 return unscrambled;
       }
       
       public static BufferedImage unscrambleD1 (BufferedImage original, int pr1, int pr2) {
    		 BufferedImage unscrambled = new BufferedImage (original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
    		 
    		 //scramble each row
    		 for (int y = 0; y < original.getHeight(); y++) {
    			 ArrayList<Color> origRow = new ArrayList <Color> ();
    			 for (int j = 0; j < original.getWidth(); j++) {
      				 int modifiedY = (y + (prToThe(pr1, j))) % 1018;
    				 Color c = new Color(original.getRGB(j, modifiedY));
    				 origRow.add(c);
    			 }
    			 
    			 ArrayList<Color> unscrambledRow = decryptRows (origRow, pr2);
    			 for (int j = 0; j < original.getWidth(); j++) {
      				 int modifiedY = (y + (prToThe(pr1, j))) % 1018;
    				 int newRGB = unscrambledRow.get(j).getRGB();
    				 unscrambled.setRGB(j, modifiedY, newRGB);
    			 }
    			 System.out.println("Column " + y + " unscrambled");

    		 }
    		 return unscrambled;
    	 }
       
       public static BufferedImage unscrambleD2 (BufferedImage original, int pr1, int pr2) {
        	 BufferedImage unscrambled = new BufferedImage (original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
        	 
        	 //scramble each column
        	 for (int x = 0; x < original.getWidth(); x++) {
        		 ArrayList<Color> origCol = new ArrayList <Color> ();
        		 for (int j = 0; j < original.getHeight(); j++) {
          			 int modifiedX = (x + (prToThe(pr1, j))) % 1018;
        			 Color c = new Color(original.getRGB(modifiedX, j));
        			 origCol.add(c);
        		 }
        		 
        		 ArrayList<Color> unscrambledCol = decryptCols (origCol, pr2);
        		 for (int j = 0; j < original.getHeight(); j++) {
          			 int modifiedX = (x + (prToThe(pr1, j))) % 1018;
        			 int newRGB = unscrambledCol.get(j).getRGB();
        			 unscrambled.setRGB(modifiedX, j, newRGB);
        		 }
        		 System.out.println("Row " + x + " unscrambled");

        	 }
        	 return unscrambled;
         }

}

