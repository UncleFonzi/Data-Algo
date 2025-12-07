class Main7 {
  public static void main(String[] args) {
    // 1. Define the vertices (buildings) based on the campus map
    String[] vertices = {"Liberal Arts", "Student Services", "Health Careers & Sciences", "Health Technologies Center",
     "Recreation Center", "Technology Learning Center", "Business & Technology", "Theatre"};

    // 2-Define Edges
    int[][] edges = {
      {0,1}, {0,7},
      {1,0}, {1,4}, {1,5}, {1,6},
      {2,3}, {2,4},
      {3,2},
      {4,1}, {4,2},
      {5,1},
      {6,1}, {6,7},
      {7,0}, {7,6}
    };

    // 3. Create the graph (name "graph") using the vertices and edges
    Graph<String> graph = new UnweightedGraph<>(vertices, edges);

    // 4. Perform a depth-first search (name "dfs")(DFS) starting from the "Business & Technology" building
    UnweightedGraph<String>.SearchTree dfs =
      graph.dfs(graph.getIndex("Business & Technology"));

    // 5. Retrieve and print the search order of the DFS traversal
    java.util.List<Integer> searchOrders = dfs.getSearchOrder();
    System.out.println(dfs.getNumberOfVerticesFound() + " vertices serached in this order."); 
    for (int i = 0; i < searchOrders.size(); i++) 
      System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
    
    System.out.println();

    // 6. Print the parent-child relationships for each vertex during the DFS traversal
    for (int i = 0; i < searchOrders.size(); i++) {
      int v = searchOrders.get(i);
      if (dfs.getParent(v) != -1) {
      System.out.println("Parent of " + graph.getVertex(v) + " is " + graph.getVertex(dfs.getParent(v)));
      }
    }

    // 7. Call the printPath method (assuming this method exists in the UnweightedGraph class)
    dfs.printPath(graph.getIndex("Theatre"));

     // 8. Call printTree() to print the entire DFS tree (assuming this method exists in the UnweightedGraph class)
    dfs.printTree();
  }
}