package com.example.demo.service.to;

public class MatriculaTO {
	
	//Para almacenar temporalmente los datos ingresados por el usuario en el formulario
	
	
	private String cedulaEstudiante;
	private String codigoUno;
	private String codigoDos;
	private String codigoTres;
	private String codigoCuadro;
	
	public MatriculaTO() {
	}

	public MatriculaTO(String cedulaEstudiante, String codigoUno, String codigoDos, String codigoTres,
			String codigoCuadro) {
		super();
		this.cedulaEstudiante = cedulaEstudiante;
		this.codigoUno = codigoUno;
		this.codigoDos = codigoDos;
		this.codigoTres = codigoTres;
		this.codigoCuadro = codigoCuadro;
	}

	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}

	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}

	public String getCodigoUno() {
		return codigoUno;
	}

	public void setCodigoUno(String codigoUno) {
		this.codigoUno = codigoUno;
	}

	public String getCodigoDos() {
		return codigoDos;
	}

	public void setCodigoDos(String codigoDos) {
		this.codigoDos = codigoDos;
	}

	public String getCodigoTres() {
		return codigoTres;
	}

	public void setCodigoTres(String codigoTres) {
		this.codigoTres = codigoTres;
	}

	public String getCodigoCuadro() {
		return codigoCuadro;
	}

	public void setCodigoCuadro(String codigoCuadro) {
		this.codigoCuadro = codigoCuadro;
	}
	
	

}
