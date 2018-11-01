import java.util.Collections;

public class SolutionB
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
	
	
	
	
	public static int createStack(ArrayList<Box> boxes)
	{
		Collections.sort(boxes,new BoxComparator());
		int[] stackMap = new int[boxes.size()];
		return createStack(boxes, null , 0, stackMap);
	}
	
	
	public static int createStack(ArrayList<Box>, Box bottom, int offset, int[] stackMap)
	{
		if(offset >= boxes.size())
		{
			return 0;
		}
		
		Box newBottom = boxes.get(offset);
		int heightWithBottom = 0;
		if(bottom == null || newBottom.canBeAbove(bottom))
		{
			stackMap[offset] = createStack(boxes, newBottom, offset+1, stackMap)
			stackMap[offset]  += new newBottom.height;
								
		}
		
		heightWithBottom = stackMap[offset];
	
	
	int heightWithoutBottom = createStack(boxes, bottom, offset+1, stackMap);
	return Math.max(heightWithBottom, heightWithoutBottom);
	}
	
	public static void main(String[] args)
	{
		
	}
}