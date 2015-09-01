package tree;

import java.util.ArrayList;
import java.util.List;

public class SimpleTree {
	TreeNode root;
	public SimpleTree() {
		root = new TreeNode("ROOT");
		
		TreeNode node = new TreeNode("A");
		node.getChildren().add(new TreeNode("A1"));
		node.getChildren().add(new TreeNode("A2"));
		root.getChildren().add(node);
		
		
		node = new TreeNode("B");
		node.getChildren().add(new TreeNode("B1"));
		node.getChildren().add(new TreeNode("B2"));
		root.getChildren().add(node);
	}
	
	public void bfs(TreeNode node) {//广度优先
		for(TreeNode subNode : node.getChildren()) {
			System.out.println(subNode.getInfo());
		}
		
		for(TreeNode subNode : node.getChildren()) {
			bfs(subNode);
		}
	}
	
	public void dfs(TreeNode node) {//深度优先
		for(TreeNode subNode : node.getChildren()) {
			System.out.println(subNode.getInfo());
			bfs(subNode);
		}
	}

	public static void main(String[] args) {
		SimpleTree st = new SimpleTree();
		System.out.println("BFS");
		st.bfs(st.root);
		System.out.println();
		
		System.out.println("DFS");
		st.dfs(st.root);
	}
}

class TreeNode {
	private TreeNode parent;
	private String info;
	private List<TreeNode> children = new ArrayList<TreeNode>();
	
	public TreeNode(String info) {
		this.info = info;
	}
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	public List<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
}