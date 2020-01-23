public class Main {

    public static void main(String[] args) {

        /*
         * 1. Реализовать программу, в которой задается граф из 10 вершин.
         * Задать ребра и найти кратчайший путь с помощью поиска в ширину.
         *
         *
         *
         * 0 - 1 - 2
         *         |
         *         3 - 4
         *             |
         *         6 - 5 - 7 - 9
         *                 |
         *                 8
         */

        Graph graph = new Graph(10);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(7, 8);
        graph.addEdge(7, 9);

        BreadthFirstPath breadthFirstPath = new BreadthFirstPath(graph, 0);
        System.out.println(breadthFirstPath.hasPathTo(2));
        System.out.println(breadthFirstPath.hasPathTo(9));
        System.out.println(breadthFirstPath.pathTo(7));
        System.out.println(breadthFirstPath.distTo(7));

    }
}
