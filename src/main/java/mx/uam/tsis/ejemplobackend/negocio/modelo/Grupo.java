package mx.uam.tsis.ejemplobackend.negocio.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity // Indica que hay que persistir en BD
public class Grupo {
	
	@Id
	@GeneratedValue // Autogenera un ID único
	private Integer id;
	
	@NotBlank
	private String clave;
	
	@OneToMany(targetEntity = Alumno.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id") // No crea tabla intermedia	
	private List <Alumno> alumnos = new ArrayList <> ();
	
	public Grupo() {
	}

	public Grupo(Integer id, String clave, List<Alumno> alumnos) {
		this.id = id;
		this.clave = clave;
		this.alumnos = alumnos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public boolean addAlumno(Alumno alumno) {
		return alumnos.add(alumno);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Grupo grupo = (Grupo) o;
		return Objects.equals(id, grupo.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public static class Builder {
		private Integer id;
		private String clave;
		private List<Alumno> alumnos = new ArrayList<>();

		public Builder id(Integer id) {
			this.id = id;
			return this;
		}

		public Builder clave(String clave) {
			this.clave = clave;
			return this;
		}

		public Builder alumnos(List<Alumno> alumnos) {
			this.alumnos = alumnos;
			return this;
		}

		public Grupo build() {
			return new Grupo(id, clave, alumnos);
		}
	}

	public static Builder builder() {
		return new Builder();
	}
}
