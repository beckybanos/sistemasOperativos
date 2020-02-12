public class ProcesoG {
	private String nombre;
	private long tiempoServicio, tiempoEspera;
	private int bursts;

	public ProcesoG(String nombre, int bursts) {
		this.nombre = nombre;
		tiempoServicio = tiempoEspera = 0;
		this.bursts = bursts;
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

	public void setTiempoServicio(long tiempo) {
		tiempoServicio += tiempo;
	}

	public void setTiempoEspera(long tiempo) {
		tiempoEspera += tiempo;
	}

	public void decBursts() {
		bursts--;
	}
}