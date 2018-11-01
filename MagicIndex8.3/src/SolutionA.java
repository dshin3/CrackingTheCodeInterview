//Naive solution.


public class SolutionA
{
	
	public static int magicIndex(int[] array)
	{
		int last = array[array.length-1];
		int first = array[0];
		
		for(int i =0;i<array.length;i++)
		{
			if(i == array[i])
			{	
				return i;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args)
	{
		int[] tempArray = new int[] {-4,-2,0,1,4};
		System.out.println(magicIndex(tempArray));
	}
}