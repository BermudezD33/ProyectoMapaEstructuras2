package estructuras.mapa;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NodoHash[] indiceNodoHash = new NodoHash[25];
        Scanner scaner = new Scanner(System.in);
        GrafoMapa grafo = new GrafoMapa(25);
        TablaHash tablaHash = new TablaHash();

        indiceNodoHash[0] = new NodoHash(0, "San Jose", 755, 295);
        indiceNodoHash[1] = new NodoHash(1, "Santa Cruz", 80, 220);
        indiceNodoHash[2] = new NodoHash(2, "Perez Zeledon", 1000, 425);
        indiceNodoHash[3] = new NodoHash(3, "Puriscal", 600, 350);
        indiceNodoHash[4] = new NodoHash(4, "Barva", 794, 213);
        indiceNodoHash[5] = new NodoHash(5, "Caldera", 350, 320);
        indiceNodoHash[6] = new NodoHash(6, "La Cruz", 70, 75);
        indiceNodoHash[7] = new NodoHash(7, "San Rafael", 750, 250);
        indiceNodoHash[8] = new NodoHash(8, "Grecia", 654, 265);
        indiceNodoHash[9] = new NodoHash(9, "Jaco", 432, 253);
        indiceNodoHash[10] = new NodoHash(10, "Golfito", 1130, 570);
        indiceNodoHash[11] = new NodoHash(11, "Liberia", 196, 145);
        indiceNodoHash[12] = new NodoHash(12, "Siquirres", 1050, 235);
        indiceNodoHash[13] = new NodoHash(13, "Los Chiles", 534, 45);
        indiceNodoHash[14] = new NodoHash(14, "Sarapiqui", 746, 136);
        indiceNodoHash[15] = new NodoHash(15, "Tilaran", 354, 165);
        indiceNodoHash[16] = new NodoHash(16, "Pococi", 924, 150);
        indiceNodoHash[17] = new NodoHash(17, "Quepos", 700, 385);
        indiceNodoHash[18] = new NodoHash(18, "Zarcero", 365, 84);
        indiceNodoHash[19] = new NodoHash(19, "San Carlos", 570, 166);
        indiceNodoHash[20] = new NodoHash(20, "Osa", 1250, 521);
        indiceNodoHash[21] = new NodoHash(21, "Cartago", 900, 350);
        indiceNodoHash[22] = new NodoHash(22, "Nicoya", 180, 27);
        indiceNodoHash[23] = new NodoHash(23, "Talamanca", 1190, 400);
        indiceNodoHash[24] = new NodoHash(24, "Coto Brus", 970, 610);


        tablaHash.addValor(tablaHash.hashing("San Jose"), indiceNodoHash[0]);
        tablaHash.addValor(tablaHash.hashing("Santa Cruz"), indiceNodoHash[1]);
        tablaHash.addValor(tablaHash.hashing("Perez Zeledon"), indiceNodoHash[2]);
        tablaHash.addValor(tablaHash.hashing("Puriscal"), indiceNodoHash[3]);
        tablaHash.addValor(tablaHash.hashing("Barva"), indiceNodoHash[4]);
        tablaHash.addValor(tablaHash.hashing("Caldera"), indiceNodoHash[5]);
        tablaHash.addValor(tablaHash.hashing("La Cruz"), indiceNodoHash[6]);
        tablaHash.addValor(tablaHash.hashing("San Rafael"), indiceNodoHash[7]);
        tablaHash.addValor(tablaHash.hashing("Grecia"), indiceNodoHash[8]);
        tablaHash.addValor(tablaHash.hashing("Jaco"), indiceNodoHash[9]);
        tablaHash.addValor(tablaHash.hashing("Golfito"), indiceNodoHash[10]);
        tablaHash.addValor(tablaHash.hashing("Liberia"), indiceNodoHash[11]);
        tablaHash.addValor(tablaHash.hashing("Siquirres"), indiceNodoHash[12]);
        tablaHash.addValor(tablaHash.hashing("Los Chiles"), indiceNodoHash[13]);
        tablaHash.addValor(tablaHash.hashing("Sarapiqui"), indiceNodoHash[14]);
        tablaHash.addValor(tablaHash.hashing("Tilaran"), indiceNodoHash[15]);
        tablaHash.addValor(tablaHash.hashing("Pococi"), indiceNodoHash[16]);
        tablaHash.addValor(tablaHash.hashing("Quepos"), indiceNodoHash[17]);
        tablaHash.addValor(tablaHash.hashing("Zarcero"), indiceNodoHash[18]);
        tablaHash.addValor(tablaHash.hashing("San Carlos"), indiceNodoHash[19]);
        tablaHash.addValor(tablaHash.hashing("Osa"), indiceNodoHash[20]);
        tablaHash.addValor(tablaHash.hashing("Cartago"), indiceNodoHash[21]);
        tablaHash.addValor(tablaHash.hashing("Nicoya"), indiceNodoHash[22]);
        tablaHash.addValor(tablaHash.hashing("Talamanca"), indiceNodoHash[23]);
        tablaHash.addValor(tablaHash.hashing("Coto Brus"), indiceNodoHash[24]);

      //  NodoHash n = tablaHash.getNumero(tablaHash.hashing("San Isidro"), "San Isidro");


        //System.out.println("Nombre: " + n.getNombreLocalizacion() + ", ID: " + n.getId() + ", X: " + n.getxMapa() + ", Y: " + n.getyMapa());


        grafo.addArco(0, 8, 10);

        grafo.addArco(0, 12, 20);

        grafo.addArco(0, 7, 18);

        grafo.addArco(12, 16, 19);

        grafo.addArco(16, 24, 29);

        grafo.addArco(24, 20, 28);

        grafo.addArco(20, 21, 21);

        grafo.addArco(21, 13, 13);

        grafo.addArco(13, 1, 14);

        grafo.addArco(13, 6, 19);

        grafo.addArco(1, 7, 17);

        grafo.addArco(6, 7, 16);

        grafo.addArco(6, 22, 29);

        grafo.addArco(22, 5, 26);

        grafo.addArco(5, 11, 12);

        grafo.addArco(5, 18, 17);

        grafo.addArco(18, 4, 15);

        grafo.addArco(4, 19, 25);

        grafo.addArco(11, 19, 14);

        grafo.addArco(11, 2, 13);

        grafo.addArco(2, 17, 14);

        grafo.addArco(17, 10, 24);

        grafo.addArco(19, 23, 10);

        grafo.addArco(23, 15, 20);

        grafo.addArco(15, 14, 14);

        grafo.addArco(14, 3, 15);

        grafo.addArco(14, 9, 13);

        grafo.addArco(15, 8, 14);

        //  System.out.println(grafo.toString());

        System.out.println("Digite el nombre de la localizacion inicial: ");
        //String nombreInicial = scaner.nextLine();
        System.out.println("Digite el nombre de la localizacion final: ");
        //  String nombreFinal = scaner.nextLine();

//
//        NodoHash verticeInicial = tablaHash.getNumero(tablaHash.hashing(nombreInicial), nombreInicial);
//        NodoHash verticeFinal = tablaHash.getNumero(tablaHash.hashing(nombreFinal), nombreFinal);

//        System.out.println("VerticeInicial: "+ verticeInicial.getId());
//        System.out.println("VerticeFinal: "+verticeFinal.getId());
//
//        grafo.algoritmoDijkstra(grafo.getMatrixAdyacencia(), verticeInicial.getId(),verticeFinal.getId());

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createUI(tablaHash, grafo,indiceNodoHash);
            }
        });
    }

    private static void createUI(TablaHash tablaHash, GrafoMapa grafoMapa, NodoHash[] indiceNodoHash) {
        JFrame frame = new JFrame("Proyecto Estructuras 2 - Mapa de Grafos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);

        JComponent mapaUI = new MapaUI(indiceNodoHash,frame, tablaHash, grafoMapa);
        frame.setContentPane(mapaUI);
    }

}
