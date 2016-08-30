/**
 * 
 */
package imageChanger;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author kapil
 *
 */
public class imageChanger {

	/**
	 * @param args
	 */
public static void main(String[] args){
	try{
		BufferedImage original =ImageIO.read(new File("kk.png"));
	BufferedImage binarized =new BufferedImage(80,80
			//original.getWidth(), original.getHeight()
			,BufferedImage.TYPE_BYTE_BINARY);
	int red,blue,green;
	int newPixel=0;
	int threshold =230;
	System.out.println(original.getHeight()+" "+original.getWidth());
	int i_index,j_index,i_mod,j_mod,k=0;
	int[][] arr=new int[80][80];
	for(int j=0; j<original.getHeight(); j++)
{
		for(int i=0; i<original.getWidth(); i++){// Get pixels 
			
			i_index=(i)/16;
			j_index=(j)/16;
			i_mod=(i+1)%16;
			j_mod=(j+1)%16;
			red =new Color(original.getRGB(i, j)).getRed();
			blue =new Color(original.getRGB(i, j)).getBlue();
			green =new Color(original.getRGB(i, j)).getGreen();
			int alpha =new Color(original.getRGB(i, j)).getAlpha();
		//	if(red > threshold)
			if((0.21*red+0.71*green+0.08*blue)<127)
			{ newPixel =0;}
			else{ newPixel =255;}
		
		//	System.out.println(" "+newPixel);
			arr[i_index][j_index]+=newPixel==255?1:0;
		
			if((i_mod==0)&&(j_mod==0))
			{++k;
			if(k%80==0)
				System.out.print("\n");
				newPixel=arr[i_index][j_index]<127?0:255;
			if(newPixel==0)
				System.out.print("0");//no light
			else
				System.out.print("1");//white
			
				newPixel = colorToRGB(alpha, newPixel, newPixel, newPixel);
				binarized.setRGB(i_index, j_index, newPixel);
			}
		
		//	System.out.println(newPixel);
		//	binarized.setRGB(i, j, newPixel);
			}}
	ImageIO.write(binarized,"png",new File("blackwhiteimage"));
	}catch(IOException e){ e.printStackTrace();
	}}
private static int colorToRGB(int alpha,int red,int green,int blue)
{int newPixel =0;
newPixel += alpha;
newPixel = newPixel <<8;
newPixel += red;
newPixel = newPixel <<8;
newPixel += green;
newPixel = newPixel <<8;
newPixel += blue;
return newPixel;
}
		
	
	
}