package abc.algo;

import java.util.List;
import java.util.ArrayList;

import abc.ds.BinarySearchTree.Node;
import abc.ds.Queue;

public interface BinarySearchTreeAlgo {

    interface Traversaler {
		public <T> List<T> inOrder(Node<T> root);
        public <T> List<T> reverseOrder(Node<T> root);
		public <T> List<T> preOrder(Node<T> root);
		public <T> List<T> postOrder(Node<T> root);
		public <T> List<T> levelOrder(Node<T> root);
	}

    class SimpleTraversaler implements Traversaler {

		@Override
		public <T> List<T> inOrder(Node<T> root) {

			List<T> rv = new ArrayList<T>();

            if (root == null) {
                return rv;
            }

            rv.addAll(inOrder(root.left));
            rv.add(root.val);
            rv.addAll(inOrder(root.right));

			return rv;
		}

        @Override
		public <T> List<T> reverseOrder(Node<T> root) {

			List<T> rv = new ArrayList<T>();

            if (root == null) {
                return rv;
            }

            rv.addAll(reverseOrder(root.right));
            rv.add(root.val);
            rv.addAll(reverseOrder(root.left));

			return rv;
		}

		@Override
		public <T> List<T> preOrder(Node<T> root) {

			List<T> rv = new ArrayList<T>();

            if (root == null) {
                return rv;
            }

            rv.add(root.val);
            rv.addAll(preOrder(root.left));
            rv.addAll(preOrder(root.right));

			return rv;
		}

		@Override
		public <T> List<T> postOrder(Node<T> root) {

			List<T> rv = new ArrayList<T>();

            if (root == null) {
                return rv;
            }

            rv.addAll(postOrder(root.left));
            rv.addAll(postOrder(root.right));
            rv.add(root.val);

			return rv;
		}

		@Override
		public <T> List<T> levelOrder(Node<T> root) {

			List<T> rv = new ArrayList<T>();

            if (root == null) {
                return rv;
            }

			Queue<Node<T>> queue = new Queue.LinkedQueue<>();
			queue.push(root);
			
			while(!queue.empty()) {
				
                Node<T> node = queue.pop();
				
                rv.add(node.val);

                if (node.left != null) {
                    queue.push(node.left);
                }

                if (node.right != null) {
                    queue.push(node.right);
                }
			}

			return rv;
		}
	}

    interface MinMax {
        public <T> T min(Node<T> root);
    }

    class RecursiveMinMax implements MinMax {

        @Override
        public <T> T min(Node<T> root) {
            
            if (root.left == null) {
                return root.val;
            } else {
                return min(root.left);
            }
        }
    }
}