package modularExponentiation;

/**
 * @author kapil
 *
 */

public class modularExpo {
	
public int getExponentiation(int a,int num,int n)
{
int c=0,d=1;
int numsize=getnumSize(num);
int[]  bitArray=getBitArray(num,numsize);
System.out.println(numsize);
for(int i=(numsize-1);i>=0;--i){
	c=2*c;
	d=(d*d)%n;
	if(bitArray[i]==1)
		c=c+1;
	d=(d*a)%n;
	
}
return d;
}
public int getnumSize(int num)
{return Integer.SIZE-Integer.numberOfLeadingZeros(num);	
}

public int[] getBitArray(int num,int numsize)
{
int[] bitArray= new int[numsize];
for(int i=0;i<numsize;i++)
{bitArray[i]=(num>>1)&1;
	}
return bitArray;
	}
}
