package stringSearchAlgorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class naiveMethod {

	private String text="DEFAULT",pattern="DEFAULT";
	
	public  static void main (String[] args)
	{
	naiveMethod nvMethod =new naiveMethod();	
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
		//match and print matching index
		matchString(text,pattern);
		
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
	
	public void matchString(String text,String pattern){
		for(int i=0;i<=(text.length()-pattern.length());i++)
		{
			if(pattern.equals(text.substring(i,i+pattern.length())))
			{System.out.println("pattern "+pattern+" is present at index "+i+" of string "+text );}
		}
	
	}
	
}
