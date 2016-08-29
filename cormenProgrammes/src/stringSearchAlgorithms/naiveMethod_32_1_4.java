package stringSearchAlgorithms;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class naiveMethod_32_1_4 {

	//assign gap character
private static final String GAP_CHARACTER="!";

	private static String text="DEFAULT",pattern="DEFAULT";
	private static int textLength,patternLength;
	private static final int NOT_FOUND_INDEX=-100;
	public  static void main (String[] args)
	{
	naiveMethod_32_1_4 nvMethod =new naiveMethod_32_1_4();	
	nvMethod.execute();
	}
	
	//algo execution starts here
	public void execute()
	{
	//take text and pattern string input
		text=getInputString();
		if(text==null)
			text="default";
		pattern=getInputString();
		if(pattern==null)
			pattern="default";
		
		//setLength params
		textLength=text.length();
		patternLength=pattern.length();
		//match and print matching index
		prepareString(text,pattern);
		
	}
	
	//take string input fron user
	public String getInputString(){
		 String inputString=null;
		//preparing buffer reader
		try{
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		      return(	 inputString=reader.readLine());
		}catch(Exception e)
		{
			//error occured
			e.printStackTrace();
		}
		 
		return inputString;
	}
	
	
	
	public void prepareString(String text,String pattern){
		// splititng pattern string in substring 
		final String[] subPattern=pattern.split("!",-1);//-1 doesnt remove trailing, initial empty string by def
	
		final int ungappedLength=pattern.length()-subPattern.length+1;//+1 bcoz min value of subpattern is 1
		System.out.println("pattern"+subPattern.length);
	    matchAndPrint(0,0,ungappedLength,subPattern,-1);//creates open end recur func
	
	}
	
	        // match and print
	public void matchAndPrint(int subWordIndex, int startpointIndex, int spareLength, String[] subPattern,
			int globalPoint) {
		for (int i = startpointIndex; i <= (textLength - spareLength); i++) {
			if (subPattern[subWordIndex].equals(text.substring(i, i + subPattern[subWordIndex].length()))) {
				if (subWordIndex == subPattern.length - 1)// i.e last word
				{
					int index;
					if (globalPoint == -1)
						index = i;
					else
						index = globalPoint;
					int endIndex = i + subPattern[subWordIndex].length();
					System.out.println("pattern " + pattern + " is present from index " + index + " to index "
							+ endIndex + " having string " + text.substring(index, endIndex) + " of string " + text);

				} else {
					if (subWordIndex == 0)// first word
						globalPoint = i;

					matchAndPrint(subWordIndex + 1, i + subPattern[subWordIndex].length(),
							spareLength - subPattern[subWordIndex].length(), subPattern, globalPoint);

				}
			}

		}

	}
	
}
