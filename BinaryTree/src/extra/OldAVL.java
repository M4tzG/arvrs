//package extra;
//
//public class OldAVL {
//    private Node root = null;
//
//    public OldAVL(){}
//
//    public void insert(int value){__insert__(this.root = this.root, value);}
//    public void remove(int value){__remove__(this.root = this.root, value);}
//    public void search(int value){__search__(this.root, value);}
//
//    private Node __insert__(Node root, int value){
//
//        // If this.root is null, just set it to the value.
//        if (this.isEmpty()) {
//            this.root = new Node(value);
//            return root;
//        }
//
//        if(root == null) return new Node(value);
//        if(value < root.getValue()) {
//            root.setLeft(this.__insert__(root.getLeft(), value));
//        } else root.setRight(this.__insert__(root.getRight(), value));
//
//        root.setHeight(1 + Math.max(root.getLeft().getHeight(), root.getRight().getHeight()));
//        int balance = this.__calculateBalance__(root);
//
//        // cases
//        //left-to-left
//        if(balance > 1 && value < root.getLeft().getValue())
//            return this.__rotateRight__(root);
//        //right-right
//        if(balance < -1 && value > root.getRight().getValue())
//            return this.__rotateLeft__(root);
//        //left-right
//        if(balance > 1 && value > root.getLeft().getValue()) {
//            root.setLeft(this.__rotateLeft__(root.getLeft()));
//            return this.__rotateRight__(root);
//        }
//        //right-left
//        if(balance < 1 && value < root.getLeft().getValue()) {
//            root.setRight(this.__rotateRight__(root.getRight()));
//            return this.__rotateLeft__(root);
//        }
//        //again, always return root
//        return root;
//    }
//
//    public boolean isEmpty() {
//        return this.root == null;
//    }
//
//    private Node __search__(Node root, int value){
//        // curr root is null, return null
//        if(root == null) return null;
//        // value is equals to the curr root value
//        if(root.getValue() == value) return root;
//
//        // else, test val < root -> l || r
//        if(value < root.getValue())
//            return __search__(root.getLeft(), value);
//        else return __search__(root.getRight(), value);
//    }
//
//    private Node __remove__(Node root, int value){
//        if(root == null) return root;
//        if(value < root.getValue())
//            root.setLeft(this.__remove__(root.getLeft(), value));
//        else if (value > root.getValue())
//            root.setRight(this.__remove__(root.getRight(), value));
//        else {
//            if(root.getLeft() == null) {
//                Node holder = root.getRight();
//                root = null;
//                return holder;
//            } else if (root.getRight() == null) {
//                Node holder = root.getRight();
//                root = null;
//                return holder;
//            }
//            // For a node with two children you must get the inorder successor (smallest
//            // in the right subtree) and copy its data to this node...
//            Node holder = this.__findLesserNode__(root.getRight());
//            root.setValue(holder.getValue());
//
//            // Then delete the inorder successor...
//            root.setRight(this.__remove__(root.getRight(), holder.getValue()));
//        }
//
//        // Update the weight of the root (current)
//        root.setHeight(1 + Math.max(root.getLeft().getHeight(), root.getRight().getHeight()));
//
//        //calc the balance
//        int balance = this.__calculateBalance__(root);
//
//        // cases
//        //left-to-left
//        if(balance > 1 && this.__calculateBalance__(root.getLeft()) >= 0)
//            return this.__rotateRight__(root);
//        //right-right
//        if(balance < -1 && this.__calculateBalance__(root.getRight()) <= 0)
//            return this.__rotateLeft__(root);
//        //left-right
//        if(balance > 1 && this.__calculateBalance__(root.getLeft()) < 0) {
//            root.setLeft(this.__rotateLeft__(root.getLeft()));
//            return this.__rotateRight__(root);
//        }
//        //right-left
//        if(balance < 1 && this.__calculateBalance__(root.getRight()) > 0) {
//            root.setRight(this.__rotateRight__(root.getRight()));
//            return this.__rotateLeft__(root);
//        }
//
//        //...again
//        return root;
//    }
//
//    public void print() {
//        if (root == null) {
//            System.out.println("Tree is empty.");
//            return;
//        }
//
//        __print__(root, "", true);
//    }
//    private Node __rotateLeft__(Node c){
//        Node a = c.getRight();
//        Node b = c.getRight().getLeft();
//
//        a.setLeft(c);
//        c.setRight(b);
//
//        c.setHeight(1 + Math.max(c.getLeft().getHeight(), c.getRight().getHeight()));
//        a.setHeight(1 + Math.max(a.getLeft().getHeight(), a.getRight().getHeight()));
//
//        return a;
//    }
//
//    //Same logic, just inverse the dirs
//    private Node __rotateRight__(Node c){
//        Node a = c.getLeft();
//        Node b = c.getLeft().getRight();
//
//        a.setRight(c);
//        c.setLeft(b);
//
//        c.setHeight(1 + Math.max(c.getLeft().getHeight(), c.getRight().getHeight()));
//        a.setHeight(1 + Math.max(a.getLeft().getHeight(), a.getRight().getHeight()));
//
//        return a;
//    }
//
//    private int __calculateBalance__(Node n) {
//        if(n == null) return 0;
//        return n.getLeft().getHeight() - n.getRight().getHeight();
//    }
//
//    private Node __findLesserNode__(Node base) {
//        if(base.getLeft() == null) return base;
//        return __findLesserNode__(base.getLeft());
//    }
//
//    private void __print__(Node node, String prefix, boolean isLeft) {
//        if (node != null) {
//            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getValue());
//            __print__(node.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
//            __print__(node.getRight(), prefix + (isLeft ? "│   " : "    "), false);
//        }
//    }
//
//}
