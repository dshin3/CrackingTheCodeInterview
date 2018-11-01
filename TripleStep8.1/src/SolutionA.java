public class SolutionA
{
	//Given a staircase of three possible moves: 1 step, 2 steps, and 3 steps,
	//find 
	public static int tripleSteps(int n)
	{
		if(n == 1)
		{
			return 1;
		}
		if(n == 2)
		{
			return 2;
		}
		if(n == 3)
		{
			return 4;
		}
		
		int[] memo = new int[n+1];
		
		return tripleStepHelper(n,memo);
	}
	
	public static int tripleStepHelper(int n , int[] memo)
	{
		memo[n] = tripleSteps(n-1) + tripleSteps(n-2);
		return memo[n];
	}
	
	
	public static void main(String[]args)
	{
		for(int i =1;i<11;i++)
		{	
			System.out.println(i+": "+tripleSteps(i));
		}
	}
}