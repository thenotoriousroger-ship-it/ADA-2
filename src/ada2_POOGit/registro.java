package ada2_POOGit;

import java.time.LocalDate;

public class registro {
	
	private String nombre;
	private double glucosa;
	private LocalDate fecha;

	public registro() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getGlucosa() {
		return glucosa;
	}

	public void setGlucosa(double glucosa) {
		this.glucosa = glucosa;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public registro(String nombre, double glucosa, LocalDate fecha) {
		setNombre(nombre);
		setGlucosa(glucosa);
		setFecha(fecha);
	}

}
