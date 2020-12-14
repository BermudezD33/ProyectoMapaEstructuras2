package estructuras.mapa;

public class NodoHash {

    private int id;
    private String nombreLocalizacion;
    private int xMapa;
    private int yMapa;
    private boolean seleccionado = false;
    private NodoHash sig;

    public NodoHash() {
        id = 0;
        sig = null;
    }

    public NodoHash(int id, String nombreLocalizacion, int xMapa, int yMapa) {
        this.id = id;
        this.nombreLocalizacion = nombreLocalizacion;
        this.xMapa = xMapa;
        this.yMapa = yMapa;

    }

    public NodoHash(int num) {
        id = num;
        sig = null;
    }

    void setSig(NodoHash ptr) {
        sig = ptr;
    }

    NodoHash getSig() {
        return sig;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreLocalizacion() {
        return nombreLocalizacion;
    }

    public void setNombreLocalizacion(String nombreLocalizacion) {
        this.nombreLocalizacion = nombreLocalizacion;
    }

    public int getxMapa() {
        return xMapa;
    }

    public void setxMapa(int xMapa) {
        this.xMapa = xMapa;
    }

    public int getyMapa() {
        return yMapa;
    }

    public void setyMapa(int yMapa) {
        this.yMapa = yMapa;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
}
