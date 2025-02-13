public class TraversalPractice {
  
  /**
   * Prints the odd values of the nodes in a tree.
   * Each value is printed on a separate line.
   * The nodes are traversed post-order.
   * 
   * @param node The root of the tree to print
   */
  public static void printOddNodes(Node<Integer> node) {
    /*
     * if node is null return
     * traverse through the node using post-order algo
     * if node is not even, store and print the odd value 
     * 
     */
    // Returning if the node is null
     if (node == null) return;
    // Traverse through the nodes
     printOddNodes(node.left);
     printOddNodes(node.right);
    // If node is not even, print
     if (node.value % 2 != 0) {
        System.out.println(node.value);
     }
  }

  /**
   * Prints the values of the nodes that have exactly one child in a tree.
   * Each value is printed on a separate line.
   * The nodes are traversed pre-order.
   * 
   * @param <T> The type of value the nodes hold
   * @param node The root of the tree to print
   */
  public static <T> void printNodesWithOneChild(Node<T> node) {
    // return if node null
    if (node == null) return;

    // search through each child to see if it's null and print value
    if (node.left != null && node.right == null){
      System.out.println(node.value);
    } else if (node.left == null && node.right != null){
      System.out.println(node.value);
    }
    // traverse pre-order
    printNodesWithOneChild(node.left);
    printNodesWithOneChild(node.right);
  }

    /**
   * Returns the sum of the values of all nodes in a tree.
   * Edge Case:
   *   Returns 0 if node is null
   *  
   * @param node The root of the tree
   * @return the sum 
   */
  public static int treeSum(Node<Integer> node) {
    // return 0 if node is null
    if (node == null) return 0;

    // set sum = to the node value
    int sum = node.value;

    // if the left child has a node add it to the sum
    if (node.left != null) {
      sum += treeSum(node.left);
    }

    // if the right child has a node add it to the sum
    if (node.right != null) {
      sum += treeSum(node.right);
    }

    // return sum
    return sum;
  }

  /**
   * Returns the maximum value stored in a tree.
   * Assumes all values are positive.
   * Edge case:
   *   Returns 0 if node is null.
   * 
   * @param node The root of the tree
   * @return the max value
   */
  public static int maxVal(Node<Integer> node) {
    // return 0 if node is null
    if(node == null) return 0;

    // convert and set the root the int datatype
    int max = node.value;

    // convert the other childs to int datatypes to avoid bad operand types
    int leftMax = maxVal(node.left);
    int rightMax = maxVal(node.right);

    //return max with Math.max to find the maxVal
    return Math.max(max, Math.max(leftMax, rightMax));
  }

  /**
   * Returns the number of levels in the tree.
   * Edge cases: 
   *   Returns 0 if node is null, returns 1 if there is only a root with no children.
   * 
   * @param <T> The type of value the nodes hold
   * @param node The root of the tree
   * @return The number of levels in the tree
   */
  public static <T> int numLevels(Node<T> node) {
    // return 0 if node is null
    if (node == null) return 0;
    // return 1 if root has no children
    if (node.left == null && node.right == null) return 1;

    // setting the nodes to be able to find the max level
    int leftChild = numLevels(node.left);
    int rightChild = numLevels(node.right);

    // return the number of levels using Math.max()
    return Math.max(leftChild, rightChild) + 1;
  }

  public static void main(String[] args) {
    /*
     *         99
     *       /    \
     *     45      82
     *    /  \        \
     *   9   5       16
     */

     // Replace the below line to create a tree 
     // as represented in the diagram above
     Node<Integer> smallTree = new Node<Integer>(99,
      new Node<Integer>(45, // 45 is left child of 99
        new Node<Integer>(9, null, null), // 9 is the left child of 45
          new Node<Integer>(5, null, null)), // 5 is the right child of 45
      new Node<Integer>(85, null, // 85 is the right child of 99, with no left no children
        new Node<Integer>(16, null, null))); // 82 is the right child of 99


    /*
     *              42
     *          /       \
     *       17           63
     *      /  \            \
     *     9    21           87
     *    /    /  \          /
     *   3    19   25     76
    */

    Node<Integer> largeTree = new Node<>(42,
        new Node<>(17, // 17 is left child of 42
                new Node<>(9, // 9 is the left child of 17
                        new Node<>(3, null, null), // 3 is the left child of 9
                        null), // no right child of 9
                new Node<>(21, // 21 is the right child of 17
                        new Node<>(19, null, null), // 19 is the left child of 21
                        new Node<>(25, null, null))), // 25 is the right child of 21
        new Node<>(63, // 63 is right child of 42
                null, // no left child of 63
                new Node<>(87, // 87 is right child of 63
                        new Node<>(76, null, null), // 76 is the left child of 87
                        null))); // no right child of 87
  }
}