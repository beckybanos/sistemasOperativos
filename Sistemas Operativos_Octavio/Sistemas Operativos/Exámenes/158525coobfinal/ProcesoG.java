public class ProcesoG {

    private String nombre;
    private long tiempoServicio, tiempoEspera, tiempoReady;
    private int bursts, paginas;
    private int[] pageTable;

    public ProcesoG(String nombre, int bursts, int paginas) {
        this.nombre = nombre;
        tiempoServicio = tiempoEspera = tiempoReady = 0;
        this.bursts = bursts;
        this.paginas = paginas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getBursts() {
        return bursts;
    }

    public long getTiempoServicio() {
        return tiempoServicio;
    }

    public long getTiempoEspera() {
        return tiempoEspera;
    }

    public long getTiempoReady() {
        return tiempoReady;
    }

    public long getTurnAround(){
        long tiempo = tiempoReady + tiempoServicio + tiempoEspera;
        return tiempo;
    }

    public void setTiempoReady(long tiempo) {
        tiempoReady += tiempo;
    }

    public void setTiempoServicio(long tiempo) {
        tiempoServicio += tiempo;
    }

    public void setTiempoEspera(long tiempo) {
        tiempoEspera += tiempo;
    }

    public void decBursts() {
        bursts--;
    }

    public int getPaginas() {
        return paginas;
    }

    public String[] getPageTable() {
        String[] res = new String[pageTable.length];
        for (int i = 0; i < pageTable.length; i++) {
            res[i] = "Usando pagina " + pageTable[i];
        }
        return res;
    }

    public void setPageTable(int[] pageTable) {
        this.pageTable = pageTable;
    }
}
