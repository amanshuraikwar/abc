package abc.ds;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

import abc.util.Comparator;

public interface BinarySearchTree<T> {

    public Node<T> getRoot();
    public boolean add(T val);
    public boolean remove(T val);
    public T min();
    public T max();
    public int height();

    class Node<T> {

        public T val;
        public Node<T> left;
        public Node<T> right;

        public Node(T val) {
            this.val = val;
        }
    }

    class SimpleBinarySearchTree<T> implements BinarySearchTree<T> {

        private Comparator<T> comparator;
        private Node<T> root;

        public SimpleBinarySearchTree(Comparator<T> comparator) {
            this.comparator = comparator;
        }

        @Override
        public Node<T> getRoot() {
            return root;
        }

        @Override
        public boolean add(T val) {
            
            if (root == null) {
                root = new Node<>(val);
                return true;
            }

            Node<T> curNode = root;
            
            while (true) {
                
                int comparedValue = comparator.compare(val, curNode.val);
                
                if (comparedValue == 0) {
                    return false;
                }

                if (comparedValue < 0) {
                    
                    if (curNode.left == null) {
                        curNode.left = new Node<T>(val);
                        return true;
                    }

                    curNode = curNode.left;
                }

                if (comparedValue > 0) {

                    if (curNode.right == null) {
                        curNode.right = new Node<T>(val);
                        return true;
                    }

                    curNode = curNode.right;
                }
            }
        }

        @Override
        public boolean remove(T val) {
            
            Node<T> curNode = root;
            Node<T> parentNode = null;

            while (true) {

                if (curNode == null) {
                    break;
                }

                int comparedValue = comparator.compare(val, curNode.val);

                if (comparedValue == 0) {
                    break;
                } else if (comparedValue < 0) {
                    parentNode = curNode;
                    curNode = curNode.left;
                } else {
                    parentNode = curNode;
                    curNode = curNode.right;
                }
            }

            // the root is itself null
            // i.e. there is no tree in the first place
            if (curNode == null && parentNode == null) {
                return false;
            }

            // we searched to the leaf 
            // and never found the node to delete
            if (curNode == null) {
                return false;
            }

            removeNode(curNode, parentNode);   
            return true;
        }

        @Override 
        public T min() {
            
            if (root == null) {
                return null;
            }

            return findMin(root, null).get(0).val;
        }

        @Override
        public T max() {

            if (root == null) {
                return null;
            }

            return findMax(root, null).get(0).val;
        }

        @Override
        public int height() {
            return findHeight(root, 0);
        }

        private int findHeight(Node<T> root, int curHeight) {

            if (root == null) {
                return curHeight;
            }

            return Math.max(findHeight(root.left, curHeight + 1), findHeight(root.right, curHeight + 1));
        }

        private void removeNode(Node<T> node, Node<T> parent) {
            
            if (isLeaf(node)) {
            
                if (parent == null) {
                    // remove a leaf node which is also the root
                    root = null;
                } else if (parent.left == node) {
                    parent.left = null;
                } else if (parent.right == node) {
                    parent.right = null;
                }

            } else if (node.left != null && node.right != null) {
                
                List<Node<T>> minVal = findMin(node.right, node);
                node.val = minVal.get(0).val;
                removeNode(minVal.get(0), minVal.get(1));

            } else {

                if (node.left != null) {
                    
                    if (parent.left == node) {
                        parent.left = node.left;
                    } else {
                        parent.right = node.left;
                    }

                } else {

                    if (parent.left == node) {
                        parent.left = node.right;
                    } else {
                        parent.right = node.right;
                    }
                    
                }
            }
        }

        private List<Node<T>> findMin(Node<T> node, Node<T> parent) {

            if (node.left == null) {
                List<Node<T>> rv = new ArrayList<>();
                rv.add(node);
                rv.add(parent);
                return rv;
            }

            return findMin(node.left, node);
        }

        private List<Node<T>> findMax(Node<T> node, Node<T> parent) {

            if (node.right == null) {
                List<Node<T>> rv = new ArrayList<>();
                rv.add(node);
                rv.add(parent);
                return rv;
            }

            return findMax(node.right, node);
        }

        private boolean isLeaf(Node<T> node) {
            return node.left == null && node.right == null;
        }

        private Node<T> find(Node<T> root, T val) {

            if (root == null) {
                return null;
            }

            int comparedValue = comparator.compare(val, root.val);

            if (comparedValue == 0) {
                return root;
            } else if (comparedValue < 0) {
                return find(root.left, val);
            } else {
                return find(root.right, val);
            }
        }
    }
}