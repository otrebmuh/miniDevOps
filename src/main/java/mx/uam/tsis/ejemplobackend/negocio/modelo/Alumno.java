package mx.uam.tsis.ejemplobackend.negocio.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 
 * La clase que representa los alumno
 * 
 * @author humbertocervantes
 *
 */
@Entity // Indica que hay que persistir en BD
public class Alumno {
	
	@NotNull
	@Schema(description = "Matricula del alumno", required = true)
	@Id // Indica que este es llave primaria
	private Integer matricula;
	
	@NotBlank
	@Schema(description = "Nombre del alumno", required = true)
	private String nombre;

	@NotBlank
	@Schema(description = "Carrera del alumno", required = true)
	private String carrera;

	public Alumno() {
	}

	public Alumno(Integer matricula, String nombre, String carrera) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.carrera = carrera;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Alumno alumno = (Alumno) o;
		return Objects.equals(matricula, alumno.matricula);
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	public static class Builder {
		private Integer matricula;
		private String nombre;
		private String carrera;

		public Builder matricula(Integer matricula) {
			this.matricula = matricula;
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = nombre;
			return this;
		}

		public Builder carrera(String carrera) {
			this.carrera = carrera;
			return this;
		}

		public Alumno build() {
			return new Alumno(matricula, nombre, carrera);
		}
	}

	public static Builder builder() {
		return new Builder();
	}
}
