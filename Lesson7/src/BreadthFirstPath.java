import java.util.LinkedList;

public class BreadthFirstPath {

    private int[] edgeTo;
    private int[] distTo;
    private boolean[] marked;
    private int source;
    private static final int INF = Integer.MAX_VALUE;

    public BreadthFirstPath(Graph graph, int source) {
        if (source < 0){
            throw  new IllegalArgumentException();
        }
        if (source >= graph.getVertexCount()){
            throw  new IndexOutOfBoundsException();
        }
        marked = new boolean[graph.getVertexCount()];
        edgeTo = new int[graph.getVertexCount()];
        distTo = new int[graph.getVertexCount()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = INF;
        }
        this.source = source;
        bfs(graph, source);
    }

    // Обход графа в ширину
    private void bfs(Graph graph, int source){

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.addLast(source); //добавляем в очередь для проверки
        marked[source] = true;
        distTo[source] = 0;

        while (!queue.isEmpty()){
            int v = queue.removeFirst();
            for (int w : graph.getAdjList(v)) { // пошли по списку смежных вершин
                if (!marked[w]){ // еще не посещали
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    queue.addLast(w);
                }
            }

        }
    }

   // Проверяем путь до вершины
    public boolean hasPathTo(int dist){
        if (dist < 0){
            throw  new IllegalArgumentException();
        }
        if (dist >= marked.length){
            throw  new IndexOutOfBoundsException();
        }
        return marked[dist];
    }

   public LinkedList pathTo(int dist){
        if (!hasPathTo(dist)){
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<Integer>();

        int v = dist;
        while (v != source){
            stack.push(v);
            v = edgeTo[v];
        }
        return stack;
    }

    // Кратчайшее расстояние
    public int distTo(int dist){
        if (dist < 0){
            throw  new IllegalArgumentException();
        }
        if (dist >= marked.length){
            throw  new IndexOutOfBoundsException();
        }
        return distTo[dist];
    }
}
