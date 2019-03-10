package ds;

import java.util.List;
import java.util.ArrayList;

public interface Tree {

	class Node<T> {
		
		T val;
		List<Node<T>> children;
		
		public Node(T val) {
			this.val = val;
			children = new ArrayList<Node<T>>();
		}

		public void addChild(Node<T> child) {
			children.add(child);
		}

		public List<Node<T>> getChildred() {
			return children;
		}

		public T getVal() {
			return val;
		}
	}

	interface Traversaler {
		public <T> List<T> inOrder(Node<T> root);
		public <T> List<T> preOrder(Node<T> root);
		public <T> List<T> postOrder(Node<T> root);
		public <T> List<T> levelOrder(Node<T> root);
	}

	class RecursiveTraversaler implements Traversaler {

		@Override
		public <T> List<T> inOrder(Node<T> root) {

			List<T> rv = new ArrayList<T>();

			if (root.children.size() == 0) {
				rv.add(root.val);
			}

			if (root.children.size() == 1) {
				rv.addAll(inOrder(root.children.get(0)));
				rv.add(root.val);
			}

			if (root.children.size() == 2) {
				rv.addAll(inOrder(root.children.get(0)));
				rv.add(root.val);	
				rv.addAll(inOrder(root.children.get(1)));
			}

			return rv;
		}

		@Override
		public <T> List<T> preOrder(Node<T> root) {

			List<T> rv = new ArrayList<T>();

			if (root.children.size() == 0) {
				rv.add(root.val);
			}

			if (root.children.size() == 1) {
				rv.add(root.val);
				rv.addAll(preOrder(root.children.get(0)));
			}

			if (root.children.size() == 2) {
				rv.add(root.val);
				rv.addAll(preOrder(root.children.get(0)));
				rv.addAll(preOrder(root.children.get(1)));
			}

			return rv;
		}

		@Override
		public <T> List<T> postOrder(Node<T> root) {

			List<T> rv = new ArrayList<T>();

			if (root.children.size() == 0) {
				rv.add(root.val);
			}

			if (root.children.size() == 1) {
				rv.addAll(postOrder(root.children.get(0)));
				rv.add(root.val);
			}

			if (root.children.size() == 2) {
				rv.addAll(postOrder(root.children.get(0)));
				rv.addAll(postOrder(root.children.get(1)));
				rv.add(root.val);
			}

			return rv;
		}

		@Override
		public <T> List<T> levelOrder(Node<T> root) {

			List<T> rv = new ArrayList<T>();

			Queue<Node<T>> queue = new Queue.LinkedQueue<>();
			queue.push(root);
			
			while(!queue.empty()) {
				Node<T> node = queue.pop();
				rv.add(node.val);
				for (Node<T> n : node.children) {
					queue.push(n);
				}
			}

			return rv;
		}
	}

	interface Searcher {
		public <T> Node<T> bfs(Node<T> root, T val);
		public <T> Node<T> dfs(Node<T> root, T val);
	}

	class SimpleSearcher implements Searcher {

		@Override
		public <T> Node<T> bfs(Node<T> root, T val) {

			Queue<Node<T>> queue = new Queue.LinkedQueue<>();
			queue.push(root);

			while(!queue.empty()) {

				Node<T> node = queue.pop();

				if (node.val == val) {
					return node;
				}

				for(Node<T> child : node.children) {
					queue.push(child);	
				}
			}

			return null;
		}

		@Override
		public <T> Node<T> dfs(Node<T> root, T val) {
			
			Stack<Node<T>> stack = new Stack.LinkedStack<>();
			stack.push(root);

			while(!stack.empty()) {

				Node<T> node = stack.pop();

				if(node.val == val) {
					return node;
				}

				for(Node<T> child : node.children) {
					stack.push(child);
				}
			}

			return null;
		}
	}

	class RecursiveSearcher implements Searcher {

		@Override
		public <T> Node<T> bfs(Node<T> root, T val) {
			
			// recursive implementation is just a stupid recursive transformation of the 
			// iterative implementation using a queue

			// left for the reader to implement
			// or maybe for the future me :)

			return null;
		}

		@Override
		public <T> Node<T> dfs(Node<T> root, T val) {
			
			if(root.val == val) {
				return root;
			}

			Node<T> ans;

			for(Node<T> child : root.children) {

				if((ans = dfs(child, val)) != null) {
					return ans;	
				}
			}

			return null;
		}
	}

}