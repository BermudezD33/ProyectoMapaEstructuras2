package estructuras.mapa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MapaUI extends JPanel {

    private static final String imagen = "/Users/Mega/Downloads/mapa6.jpg";

    private TablaHash tablaHash;
    private boolean verAdyacentes = false;
    private NodoHash verticeInicial;
    private NodoHash verticeFinal;
    private MapaPanel mapaPanel;
    private GrafoMapa grafoMapa;
    private NodoHash[] indiceNodoHash;
    private JFrame container;
    private JLayeredPane layeredPane;

    private JPanel opcionesPanel;

    private JButton btnElegirLugar;
    private JButton btnVerAdyacentes;
    private JButton btnVerCaminoMinimo;
    private JTextField ubicacionInicial;
    private JTextField ubicacionFinal;

    private JLabel titleUbicacionInicial;
    private JLabel titleUbicacionFinal;
    private JLabel lblDistancia;
    private JLabel distancia;

    public MapaUI(NodoHash[] indiceNodoHash, JFrame container, TablaHash tablaHash, GrafoMapa grafoMapa) {
        this.container = container;
        this.tablaHash = tablaHash;
        this.grafoMapa = grafoMapa;
        this.indiceNodoHash = indiceNodoHash;
        setupUI();
    }

    public void setupUI() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        layeredPane = new JLayeredPane();


        ImageIcon icon = new ImageIcon(imagen);
        icon.setImage(icon.getImage().getScaledInstance(this.container.getWidth(),
                this.container.getHeight(), Image.SCALE_DEFAULT));

        mapaPanel = new MapaPanel();
        mapaPanel.setBounds(0, 0, this.container.getWidth(), this.container.getHeight());
        mapaPanel.setIcon(icon);
        layeredPane.add(mapaPanel, 0);
        this.add(layeredPane);

        btnElegirLugar = new JButton();
        btnElegirLugar.setText("Mostrar ubicacion");
        btnElegirLugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verticeInicial = tablaHash.getNumero(tablaHash.hashing(ubicacionInicial.getText().trim()), ubicacionInicial.getText().trim());
                verticeFinal = null;
                repaint();
                btnVerAdyacentes.setEnabled(true);
                btnVerCaminoMinimo.setEnabled(true);
                verAdyacentes = false;
            }
        });
        btnVerAdyacentes = new JButton();
        btnVerAdyacentes.setText("Ver adyacentes");
        btnVerAdyacentes.setEnabled(false);
        btnVerAdyacentes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verticeInicial = tablaHash.getNumero(tablaHash.hashing(ubicacionInicial.getText().trim()), ubicacionInicial.getText().trim());
                verAdyacentes = true;
                verticeFinal = null;
                repaint();

            }
        });
        ubicacionInicial = new JTextField();
        ubicacionInicial.setColumns(10);
        titleUbicacionInicial = new JLabel();
        titleUbicacionInicial.setText("Ubicacion Inicial:");
        ubicacionFinal = new JTextField();
        ubicacionFinal.setColumns(10);
        titleUbicacionFinal = new JLabel();
        titleUbicacionFinal.setText("Ubicacion Final:");

        btnVerCaminoMinimo = new JButton();
        btnVerCaminoMinimo.setText("Ver camino minimo");
        btnVerCaminoMinimo.setEnabled(false);
        btnVerCaminoMinimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verAdyacentes = false;
                verticeInicial = tablaHash.getNumero(tablaHash.hashing(ubicacionInicial.getText().trim()), ubicacionInicial.getText().trim());
                verticeFinal = tablaHash.getNumero(tablaHash.hashing(ubicacionFinal.getText().trim()), ubicacionFinal.getText().trim());
                grafoMapa.algoritmoDijkstra(verticeInicial.getId(), verticeFinal.getId());
                repaint();

            }
        });
        lblDistancia = new JLabel();
        lblDistancia.setText("Distancia:");
        distancia = new JLabel();

        opcionesPanel = new JPanel();
        opcionesPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        opcionesPanel.setBackground(Color.LIGHT_GRAY);

        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        opcionesPanel.add(titleUbicacionInicial, c);

        c.insets = new Insets(10, 5, 0, 0);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0.5;
        opcionesPanel.add(ubicacionInicial, c);

        c.insets = new Insets(10, 0, 0, 0);
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0.5;
        opcionesPanel.add(btnElegirLugar, c);

        c.insets = new Insets(10, 0, 0, 2);
        c.gridx = 3;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0.5;
        opcionesPanel.add(btnVerAdyacentes, c);

        c.insets = new Insets(100, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 0;
        opcionesPanel.add(titleUbicacionFinal, c);

        c.insets = new Insets(100, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0.5;
        opcionesPanel.add(ubicacionFinal, c);

        c.insets = new Insets(100, 2, 0, 0);
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0.5;
        opcionesPanel.add(btnVerCaminoMinimo, c);

        c.insets = new Insets(0, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 1;
        opcionesPanel.add(lblDistancia, c);

        c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0.5;
        c.weighty = 0.5;
        opcionesPanel.add(distancia, c);

        opcionesPanel.setBounds(100, 430, 550, 250);
        layeredPane.add(opcionesPanel, 0);

    }

    class MapaPanel extends JLabel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            for (NodoHash nodo : tablaHash.getNodos()) {
                if (nodo != null) {
                    if (nodo.isSeleccionado()) {
                        g.setColor(Color.RED);
                    } else {
                        g.setColor(Color.BLACK);
                    }
                    g2d.fillOval(nodo.getxMapa(), nodo.getyMapa(), 15, 15);
                }
            }

            if (verticeInicial != null) {
                g.setColor(Color.RED);
                g2d.fillOval(verticeInicial.getxMapa() - 2, verticeInicial.getyMapa() - 2, 20, 20);
                if (verAdyacentes) {
                    int id = verticeInicial.getId();
                    List<Integer> listaAdyacencia = grafoMapa.getAdyacentes(id);
                    g.setColor(Color.BLUE);
                    g2d.setStroke(new BasicStroke(3));

                    for (Integer indice : listaAdyacencia) {
                        NodoHash nodo = indiceNodoHash[indice];
                        g2d.fillOval(nodo.getxMapa() - 2, nodo.getyMapa() - 2, 20, 20);
                        g2d.drawLine(verticeInicial.getxMapa() + 8, verticeInicial.getyMapa() + 8,
                                nodo.getxMapa() + 10, nodo.getyMapa() + 10);
                    }
                }
            }

            if (verticeFinal != null) {
                g.setColor(Color.GREEN);
                g2d.fillOval(verticeFinal.getxMapa() - 2, verticeFinal.getyMapa() - 2, 20, 20);
                List<Integer> caminoMasCorto = grafoMapa.getCaminoMasCorto();
                g.setColor(Color.YELLOW);
                g2d.setStroke(new BasicStroke(3));
                NodoHash nodoAnterior = null;
                for (Integer indice : caminoMasCorto) {
                    NodoHash nodo = indiceNodoHash[indice];
                    if (nodo.getId() != verticeInicial.getId() && nodo.getId() != verticeFinal.getId()) {
                        g2d.fillOval(nodo.getxMapa() - 2, nodo.getyMapa() - 2, 20, 20);
                    }
                    if (nodoAnterior != null) {
                        g2d.drawLine(nodoAnterior.getxMapa() + 8, nodoAnterior.getyMapa() + 8,
                                nodo.getxMapa() + 10, nodo.getyMapa() + 10);
                    }
                    nodoAnterior = nodo;
                }
                distancia.setText(String.valueOf(grafoMapa.getDistancia()));
            }
        }
    }
}