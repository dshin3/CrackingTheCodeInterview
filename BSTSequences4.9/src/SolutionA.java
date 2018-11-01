import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class SolutionA
{
	public static ArrayList<LinkedList<Integer>> allSequences(Node node)
	{
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		
		if(node == null)
		{
			result.add(new LinkedList<Integer>());
			return result;
		}
		
		LinkedList<Integer>prefix = new LinkedList<Integer>();
		prefix.add(node.val);
		
		//Recurse on left and right subtrees.
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
		
		//Weave toegther each list from the left and right sides.
		for(LinkedList<Integer> left: leftSeq)
		{
			for(LinkedList<Integer> right: rightSeq)
			{
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(left,right,weaved,prefix);
				result.addAll(weaved);
				
			}
		}
		
		return result;
	}
	
	
	public static void weaveLists(LinkedList<Integer>first, LinkedList<Integer> second,
			ArrayList<LinkedList<Integer>>results,
			LinkedList<Integer>prefix)
	{
		//If one list is empty, add remainder to cloned prefix and store result.
		if(first.size()==0 || second.size() ==0)
		{
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		
		//Recurse with ehad of first added to the prefix.
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first,second,results,prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		//Do the same thing with second, damaging and then restoring the list.
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first,second,results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}
	
	public static void print(ArrayList<LinkedList<Integer>> al)
	{
		int i=1;
		for(LinkedList<Integer> e: al)
		{
			System.out.println(i+": "+e);
			i++;
		}
	}
	
	public static void main(String[] args)
	{
		/*
		System.out.println("Hello");
		Node bottomLeft = new Node(1);
		Node bottomRight = new Node(3);
		Node top = new Node(2,bottomLeft,bottomRight);
		ArrayList<LinkedList<Integer>>al = allSequences(top);
		print(al);*/
		
		//Bottom layer
		Node A = new Node(10);
		Node B = new Node(25);
		Node C = new Node(52);
		Node D = new Node(70);
		
		//mid layer
		Node E = new Node(20,A,B);
		Node F = new Node(60,C,D);
		//top layer
		Node G = new Node(50,E,F);
		
		ArrayList<LinkedList<Integer>>al = allSequences(G);
		print(al);
	}

}



class Node
{
	public int val = 0;
	public Node left = null;
	public Node right = null;
	//Constructors
	Node(int val)
	{
		this.val = val;
	}
	Node(int val, Node left, Node right)
	{
		this.val= val;
		this.left= left;
		this.right=right;
	}
}
	
	
