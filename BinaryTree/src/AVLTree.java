public class AVLTree {
    private Node root = null;

    public AVLTree() {}

    public void insert(int value){this.root = __insert__(this.root, value);}
    public void remove(int value){this.root = __remove__(this.root, value);}
    public void search(int value){__search__(this.root, value);}

    public void print() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        __print__(root, "", true);
    }

    // Recursive helper method for insertion
    private Node __insert__(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.getValue()) {
            currentNode.setLeft(__insert__(currentNode.getLeft(), value));
        } else if (value > currentNode.getValue()) {
            currentNode.setRight(__insert__(currentNode.getRight(), value));
        } else {
            // Duplicate values are not allowed in this AVL tree
            return currentNode;
        }

        // Update height of the current node
        currentNode.setHeight(1 + Math.max(
                __nodeHeight__(currentNode.getLeft()),
                __nodeHeight__(currentNode.getRight())
        ));

        // Perform rotation if needed to maintain balance
        return __balance__(currentNode);
    }

    // Recursive helper method for deletion
    private Node __remove__(Node currentNode, int value) {
        if (currentNode == null) {
            return currentNode;
        }

        if (value < currentNode.getValue()) {
            currentNode.setLeft(__remove__(currentNode.getLeft(), value));
        } else if (value > currentNode.getValue()) {
            currentNode.setRight(__remove__(currentNode.getRight(), value));
        } else {
            // Node with one child or no child
            if (currentNode.getLeft() == null || currentNode.getRight() == null) {
                Node temp = (currentNode.getLeft() != null) ? currentNode.getLeft() : currentNode.getRight();

                // No child case
                if (temp == null) {
                    temp = currentNode;
                    currentNode = null;
                } else { // One child case
                    currentNode = temp; // Copy the contents of the non-empty child
                }
            } else { // Node with two children
                Node temp = __minValueNode__(currentNode.getRight());
                currentNode.setValue(temp.getValue());
                currentNode.setRight(__remove__(currentNode.getRight(), temp.getValue()));
            }
        }

        if (currentNode == null) {
            return currentNode;
        }

        // Update height of the current node
        currentNode.setHeight(1 + Math.max(
                __nodeHeight__(currentNode.getLeft()),
                __nodeHeight__(currentNode.getRight())
        ));

        // Perform rotation if needed to maintain balance
        return __balance__(currentNode);
    }

    // Recursive helper method for searching
    private boolean __search__(Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        }

        if (value == currentNode.getValue()) {
            return true;
        } else if (value < currentNode.getValue()) {
            return __search__(currentNode.getLeft(), value);
        } else {
            return __search__(currentNode.getRight(), value);
        }
    }

    // Utility function to get the height of a node
    private int __nodeHeight__(Node node) {
        if (node == null) return 0;
        return node.getHeight();
    }

    // Utility function to get the balance factor of a node
    private int __calculateBalance__(Node node) {
        if (node == null) {
            return 0;
        }
        return __nodeHeight__(node.getLeft()) - __nodeHeight__(node.getRight());
    }

    // Perform rotations to maintain AVL tree balance
    private Node __balance__(Node node) {
        int balance = __calculateBalance__(node);

        // Left Heavy
        if (balance > 1) {
            if (__calculateBalance__(node.getLeft()) >= 0) {
                return rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                return rotateRight(node);
            }
        }

        // Right Heavy
        if (balance < -1) {
            if (__calculateBalance__(node.getRight()) <= 0) {
                return rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                return rotateLeft(node);
            }
        }

        return node;
    }

    // Perform a left rotation
    private Node rotateLeft(Node node) {
        Node newRoot = node.getRight();
        Node temp = newRoot.getLeft();
        newRoot.setLeft(node);
        node.setRight(temp);
        node.setHeight(1 + Math.max(__nodeHeight__(node.getLeft()), __nodeHeight__(node.getRight())));
        newRoot.setHeight(1 + Math.max(__nodeHeight__(newRoot.getLeft()), __nodeHeight__(newRoot.getRight())));
        return newRoot;
    }

    // Perform a right rotation
    private Node rotateRight(Node node) {
        Node newRoot = node.getLeft();
        Node temp = newRoot.getRight();
        newRoot.setRight(node);
        node.setLeft(temp);
        node.setHeight(1 + Math.max(__nodeHeight__(node.getLeft()), __nodeHeight__(node.getRight())));
        newRoot.setHeight(1 + Math.max(__nodeHeight__(newRoot.getLeft()), __nodeHeight__(newRoot.getRight())));
        return newRoot;
    }

    // Find the node with the minimum value in the AVL tree
    private Node __minValueNode__(Node node) {
        Node current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    private void __print__(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getValue());
            __print__(node.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
            __print__(node.getRight(), prefix + (isLeft ? "│   " : "    "), false);
        }
    }
}
