import java.util.Stack;

public class Tower
{
	private static Stack<Integer> disks;
	private static int index;
	
	public Tower(int i)
	{
		disks = new Stack<Integer>();
		index = i;
	}

	
	public static int getIndex()
	{
		return index;
	}
	
	public static void add(int d)
	{
		if(!disks.isEmpty() && disks.peek() <=d)
		{
			System.out.println("Error placing disk "+d);
		}
		else 
		{
			disks.push(d);
		}
	}
	
	
	public static void moveTopTo(Tower t)
	{
		int top = disks.pop();
		t.add(top);
	}
	
	public static void moveDisks(int n, Tower destination, Tower buffer)
	{
		if(n>0)
		{
			moveDisks(n-1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n-1, destination, buffer);
		}
	}
	
	
	public static void main(String[] args) 
	{
		int n = 3;
		Tower[] towers = new Tower[n];
		//Create three towers
		for(int i =0;i<3;i++)
		{
			Tower t = new Tower(i);
			towers[i]= t;
		}
		towers[0].moveDisks(n, towers[2], towers[1]); 
	}
	
	
}