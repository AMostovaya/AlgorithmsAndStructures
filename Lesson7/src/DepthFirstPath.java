import java.util.LinkedList;

// Алгоритм (DFS) обхода графа в глубину

public class DepthFirstPath {

    private boolean[] marked; // хранение посещаемости
    private int[] edgeTo; // массив с родителями
    private int source; // исходная вершина

    public DepthFirstPath(Graph g , int source) {
        this.source = source;
        marked = new boolean[g.getVertexCount()];
        edgeTo = new int[g.getVertexCount()];
        dfs(g, source);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true; // вершина посещена
        for (int w : g.getAdjList(v)) {
            if (!marked[w]) { // если не посещали
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    public boolean hasPathTo(int dist) {
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist) {
        if (!hasPathTo(dist)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = dist;
        while (vertex != source){
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }

}
