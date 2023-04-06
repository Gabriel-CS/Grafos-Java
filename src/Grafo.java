import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Grafo {

    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;
    private int ordem;
    private int tamanho;
    private boolean direcionado;

    public Grafo() {
        vertices = new ArrayList<>();
        arestas = new ArrayList<>();
    }

    public Grafo(boolean direcionado) {
        this.direcionado = direcionado;
        vertices = new ArrayList<>();
        arestas = new ArrayList<>();
    }

    public void addVertices(Vertice vertice) {
        vertices.add(vertice);
        ordem++;
    }

    public void addArestas(Aresta aresta) {
        arestas.add(aresta);
        tamanho++;
    }

    public boolean isDigrafo() {
        for (Aresta a : arestas) {
            if (a.getOrigem() == a.getDestino()) {
                System.out.println("É um digrafo, pois possui um SelfLoop no vértice: " + a.getOrigem().getNome());
                direcionado = true;
                return true;
            }
            for (Aresta b : arestas) {
                if (a.getOrigem() == b.getDestino() && a.getDestino() == b.getOrigem()) {
                    System.out.println("É um digrafo, pois possui arestas em duplo sentido nos vértices: " + a.getOrigem().getNome() + "," + b.getOrigem().getNome());
                    direcionado = true;
                    return true;
                }
            }
        }
        System.out.println("O grafo é não direcionado");
        return false;
    }

    public String toString() {
        StringBuilder infoGrafo = new StringBuilder();
        infoGrafo.append("Grafo -> Vértices:");
        infoGrafo.append(vertices.stream().map(vertice -> "\n" + vertice.getNome()).collect(Collectors.joining("")));
        infoGrafo.append("\nArestas: ").append(arestas);
        return infoGrafo.toString();

    }

    public void ordemETamanho() {
        System.out.println("A ordem do grafo é: " + ordem);
        System.out.println("O tamanho do grafo é: " + tamanho);
        System.out.println();
    }

    public void adjacencias() {
        if (direcionado) {
            for (Vertice v : vertices) {
                ArrayList<Vertice> adj = new ArrayList<>();
                for (Aresta a : arestas) {
                    if (a.getDestino() == v) {
                        adj.add(a.getOrigem());
                    }
                }
                System.out.println("O vértice " + v.getNome() + " é adjacente a: " + adj);
                System.out.println();
            }
        } else {
            for (Vertice v : vertices) {
                ArrayList<Vertice> adj = new ArrayList<>();
                for (Aresta a : arestas) {
                    if (a.getDestino() == v) {
                        adj.add(a.getOrigem());
                    }
                    if (a.getOrigem() == v) {
                        adj.add(a.getDestino());
                    }
                }
                System.out.println("O vértice " + v.getNome() + " é adjacente a: " + adj);
                System.out.println();
            }
        }
    }

    public void grau() {
        if (direcionado) {
            for (Vertice v : vertices) {
                int grauin = 0;
                int grauout = 0;
                for (Aresta a : arestas) {
                    if (a.getOrigem() == v) {
                        grauout++;
                    }
                    if (a.getDestino() == v) {
                        grauin++;
                    }
                }
                v.setGrauIn(grauin);
                v.setGrauOut(grauout);
                v.setGrau(grauin + grauout);

                System.out.println("O vértice " + v.getNome() + " possui grau in = " + v.getGrauIn());
                System.out.println("O vértice " + v.getNome() + " possui grau out = " + v.getGrauOut());
                System.out.println("O vértice " + v.getNome() + " possui grau total = " + v.getGrau());
                System.out.println();
            }
        } else {
            for (Vertice v : vertices) {
                int grau = 0;
                for (Aresta a : arestas) {
                    if (a.getOrigem() == v) {
                        grau++;
                    }
                    if (a.getDestino() == v) {
                        grau++;
                    }
                }
                v.setGrau(grau);

                System.out.println("O vértice " + v.getNome() + " possui o grau = " + v.getGrau());
            }
        }

    }

    public void matrizAdjacencia() {
        int[][] matriz = new int[ordem][ordem];
        if (direcionado) {
            for (Aresta aresta : arestas) {
                int origem = vertices.indexOf(aresta.getOrigem());
                int destino = vertices.indexOf(aresta.getDestino());
                matriz[origem][destino] = 1;
            }

            System.out.println();
            System.out.println("Matriz de adjacência do grafo direcionado:");

            for (int i = 0; i < ordem; i++) {
                for (int j = 0; j < ordem; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            for (Aresta aresta : arestas) {
                int origem = vertices.indexOf(aresta.getOrigem());
                int destino = vertices.indexOf(aresta.getDestino());
                matriz[origem][destino] = 1;
                matriz[destino][origem] = 1;
            }

            System.out.println();
            System.out.println("Matriz de adjacência do grafo não direcionado:");

            for (int i = 0; i < ordem; i++) {
                for (int j = 0; j < ordem; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    public void matrizIncidencia() {
        int[][] matriz = new int[ordem][tamanho];
        //Sai = -1 || Entra = +1
        if (direcionado) {
            int coluna = 0;
            for (Aresta aresta : arestas) {
                int origem = vertices.indexOf(aresta.getOrigem());
                int destino = vertices.indexOf(aresta.getDestino());
                matriz[origem][coluna] = -1;
                matriz[destino][coluna] = 1;

                coluna++;
            }

            System.out.println();
            System.out.println("Matriz de incidência do grafo direcionado:");

            for (int i = 0; i < ordem; i++) {
                for (int j = 0; j < coluna; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            int coluna = 0;
            for (Aresta aresta : arestas) {
                int origem = vertices.indexOf(aresta.getOrigem());
                int destino = vertices.indexOf(aresta.getDestino());

                matriz[origem][coluna] = 1;
                matriz[destino][coluna] = 1;

                coluna++;
            }

            System.out.println();
            System.out.println("Matriz de incidência do grafo não direcionado:");

            for (int i = 0; i < ordem; i++) {
                for (int j = 0; j < coluna; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
        }

    }
}