package com.example.demo.repository.modelo;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "materia")
public class Materia {
	
	//Atributos mencionados en el apartado P2
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_materia")
	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
	@Column(name = "mate_id")
	private Integer id;
	
	@Column(name = "mate_nombre")
	private String nombre;
	
	@Column(name = "mate_codigo")
	private String codigo;
	
	@Column(name = "mate_numero_creditos")
	private String numeroCredito;
	
	@Column(name = "mate_cedula_profesor")
	private String cedulaProfesor;
	
	//relacion con la tabla matricula
	
	@OneToMany(mappedBy = "materia", fetch = FetchType.LAZY) //un materia tiene varias matriculas
	private List<Matricula> matriculas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNumeroCredito() {
		return numeroCredito;
	}

	public void setNumeroCredito(String numeroCredito) {
		this.numeroCredito = numeroCredito;
	}

	public String getCedulaProfesor() {
		return cedulaProfesor;
	}

	public void setCedulaProfesor(String cedulaProfesor) {
		this.cedulaProfesor = cedulaProfesor;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", numeroCredito=" + numeroCredito
				+ ", cedulaProfesor=" + cedulaProfesor + "]";
	}
	
	

}

