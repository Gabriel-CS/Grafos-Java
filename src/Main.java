public class Main {
    public static void main(String[] args) {

        Grafo g = new Grafo();

        Vertice v1 = new Vertice("A");
        Vertice v2 = new Vertice("B");
        Vertice v3 = new Vertice("C");
        g.addVertices(v1);
        g.addVertices(v2);
        g.addVertices(v3);

        Aresta a1 = new Aresta(v1,v2);
        Aresta a2 = new Aresta(v1,v3);
        Aresta a3 = new Aresta(v2,v3);
        //Aresta a4 = new Aresta(v3, v2);

        g.addArestas(a1);
        g.addArestas(a2);
        g.addArestas(a3);
        //g.addArestas(a4);


        System.out.println(g);
        g.isDigrafo();
        g.ordemETamanho();
        g.adjacencias();
        g.grau();
        g.matrizAdjacencia();
        g.matrizIncidencia();
    }
}