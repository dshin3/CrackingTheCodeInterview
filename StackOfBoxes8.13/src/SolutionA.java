import java.util.ArrayList;
import java.util.Collections;


public class SolutionA
{
	public static class Box
	{
		public int depth = 0;
		public int length = 0;
		public int width =0;
		public int size = 0;
		public Box(int size, int depth, int length, int width)
		{
			this.depth = depth;
			this.length = length;
			this.width = width;
			this.size = size;
		}
	}
	
	
	
	public static ArrayList<Integer> createStack(ArrayList<Box> boxes)
	{
		//Sort the boxes by height
		Collections.sort(boxes, new BoxComparator());
		int maxHeight = 0;
		for(int i =0;boxes.size() ;i++)
		{
			int height = createStack(boxes, i);
			maxHeight = Math.max(maxHeight, height);
		}
		return maxHeight;
	}
	
	
	public static int createStack(ArrayList<Box> boxes, int bottomIndex)
	{
		Box bottom = boxes.get(bottomIndex);
		int maxHeight = 0;
		for(int i = bottomIndex +1; i<boxes.size(); i++)
		{
			if(boxes.get(i).canBeAbove(bottom))
			{
				int height = createStack(boxes, i);
				maxHeight = Math.max(height,maxHeight);
			}
		}
		maxHeight += bottom.height;
		return maxHeight;
	}
	
	
	class BoxComparator implements Comparator<Box>
	{
		@Override 
		public int compare(Box x, Box y)
		{
			return y.height - x.height;
		}
	}
	
	
	
	public static int createStack(ArrayList<Box> boxes)
	{
		Collections.sort(boxes, new BoxComparator());
		int maxHeight = 0;
		int[] stackMap = new int[boxes.size()];
		for(int i=0;i<boxes.size(); i++)
		{
			int height = createStack(boxes, i,stackMap);
			maxHeight = Math.max(maxHeight, height);
		}
	}
	
	public static createStack(ArrayList<Box> boxes, int bottomIndex, int[] stackMap)
	{
		if(bottomindex < boxes.size() && stackMap[bottomIndex] > 0)
		{
			int height = createStack(boxes, i, stackMap);
			maxHeight = Math.max(height, maxHeight );
		}
		
		maxHeight += bottom.height;
		stackMap[bottomIndex]= maxHeight;
		return maxHeight;
	}
	
	
	
	
	public static void main(String[] args)
	{
		
	}
}