public class SolutionB
{
	
	public static int magicFast(int[] array)
	{
		return magicFast(array,0, array.length-1);
	}
	
	public static int magicFast(int[] array,int startIndex,int endIndex)
	{
		if(endIndex < startIndex)
		{
			return -1;
		}
		int middleIndex = (startIndex +endIndex)/2;
		if(array[middleIndex] == middleIndex)
		{
			return middleIndex;
		}
		else if(array[middleIndex] > middleIndex)
		{
			return magicFast(array,startIndex,middleIndex-1);
		}
		else 
		{
			return magicFast(array,middleIndex+1,endIndex);
		}
	}
	
	public static void main(String[] args)
	{
		int[] tempArray = new int[] {-4,-2,0,1,4};
		System.out.println(magicFast(tempArray));
	}
}