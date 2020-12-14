package estructuras.mapa;

import java.util.ArrayList;
import java.util.List;

public class GrafoMapa {

    private int matrixAdyacencia[][];
    private int numVertices;
    private int distancia = 0;
    private List<Integer> caminoMasCorto;

    public GrafoMapa(int numVertices) {
        this.numVertices = numVertices;
        matrixAdyacencia = new int[numVertices][numVertices];
    }

    public int[][] getMatrixAdyacencia() {
        return matrixAdyacencia;
    }

    public void addArco(int x, int y, int distanciaArco) {
        matrixAdyacencia[x][y] = distanciaArco;
        matrixAdyacencia[y][x] = distanciaArco;
    }

    public void quitarArco(int x, int y) {
        matrixAdyacencia[x][y] = 0;
        matrixAdyacencia[y][x] = 0;
    }

    static final int num_Vertices = 25;
    private static final int NO_PARENT = -1;



    void algoritmoDijkstra(int nodoSrc, int nodoDestino) {

        distancia = 0;
        caminoMasCorto = new ArrayList<>();
        int rutasMasCortas[] = new int[num_Vertices];

        Boolean verticesAgregados[] = new Boolean[num_Vertices];



        for (int i = 0; i < num_Vertices; i++) {
            rutasMasCortas[i] = Integer.MAX_VALUE;
            verticesAgregados[i] = false;
        }


        rutasMasCortas[nodoSrc] = 0;


        int[] parents = new int[num_Vertices];

        parents[nodoSrc] = NO_PARENT;



        for (int i = 1; i < num_Vertices; i++) {


            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < num_Vertices; vertexIndex++) {
                if (!verticesAgregados[vertexIndex] &&
                        rutasMasCortas[vertexIndex] < shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = rutasMasCortas[vertexIndex];
                }
            }


            verticesAgregados[nearestVertex] = true;


            for (int vertexIndex = 0; vertexIndex < num_Vertices; vertexIndex++) {
                int edgeDistance = matrixAdyacencia[nearestVertex][vertexIndex];
                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < rutasMasCortas[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    rutasMasCortas[vertexIndex] = shortestDistance + edgeDistance;
                }
            }
        }

        printSolution(nodoSrc, rutasMasCortas, parents, nodoDestino);
    }


    private void printSolution(int startVertex, int[] distances, int[] parents, int verticeFinal) {
        int nVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");

        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            if (vertexIndex == verticeFinal) {
                System.out.print("\n" + startVertex + " -> ");
                System.out.print(vertexIndex + "\t\t ");
                System.out.print(distances[vertexIndex] + " \t\t ");
                distancia = distances[vertexIndex];
                printPath(vertexIndex, parents);
            }
        }
        System.out.println("         ");

    }


    private void printPath(int currentVertex, int[] parents) {


        if (currentVertex == NO_PARENT) {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
        caminoMasCorto.add(currentVertex);
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (double j : matrixAdyacencia[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }


    public List<Integer> getAdyacentes(int idNodo) {
        List<Integer> resultado = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            if (matrixAdyacencia[idNodo][i] > 0) {
                resultado.add(i);
            }
        }
        return resultado;
    }

    public List<Integer> getCaminoMasCorto() {
        return caminoMasCorto;
    }

    public int getDistancia() {
        return distancia;
    }
}
