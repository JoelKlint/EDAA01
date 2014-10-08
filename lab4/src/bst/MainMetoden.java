package bst;

public class MainMetoden {
	public static void main (String[] args)	{
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(1);
		tree.add(2);
		tree.add(-5);
		tree.add(-6);
		tree.add(-7);
		tree.add(-8);
		tree.add(-9);
		tree.add(10);
		tree.add(100);
		tree.add(15);
		tree.add(-45);
		tree.add(34);
		tree.add(48);
		tree.add(46);
		tree.rebuild();
//		tree.printTree();
		BSTVisualizer vis = new BSTVisualizer("titel", 2000, 500);
		vis.drawTree(tree);
//		System.out.println(tree.height());
	}

}
