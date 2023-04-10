public class Main {
    public static void main(String[] args) {

        Grafo g = new Grafo();

        Vertice v1 = new Vertice("U");
        Vertice v2 = new Vertice("V");
        Vertice v3 = new Vertice("W");
        Vertice v4 = new Vertice("X");
        Vertice v5 = new Vertice("Y");
        g.addVertices(v1);
        g.addVertices(v2);
        g.addVertices(v3);
        g.addVertices(v4);
        g.addVertices(v5);

        Aresta a1 = new Aresta(v1,v2);
        Aresta a2 = new Aresta(v2,v3);
        Aresta a3 = new Aresta(v3,v4);
        Aresta a4 = new Aresta(v2, v4);
        Aresta a5 = new Aresta(v3, v4);
        Aresta a6 = new Aresta(v1, v4);
        Aresta a7 = new Aresta(v4, v5);

        g.addArestas(a1);
        g.addArestas(a2);
        g.addArestas(a3);
        g.addArestas(a4);
        g.addArestas(a5);
        g.addArestas(a6);
        g.addArestas(a7);


        System.out.println(g);
        g.isDigrafo();
        g.ordemETamanho();
        g.adjacencias();
        g.grau();
        g.matrizAdjacencia();
        g.matrizIncidencia();
    }
}
