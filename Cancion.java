package urjc.ist.playlist;

import java.util.Objects;

public class Cancion {
	
	public enum Codecs { 		//Declaracion de tipo enumerado, para ello se ponen los literales
		MP3, FLAC
	}
	/*
	 * Para referirme a un tipo numerado--> nombre del tipo.(literal).         
	 */
	private String titulo;  // Título de la canción
	private String autor;  // Autor(a) de la canción
	private int duracion;  // Duración en segundos
	private Codecs formato;  // Codificación de la canción
	
	public Cancion() {
		titulo = "";
		autor = "";
		duracion = 0;
		formato = null;
	}
	System.out.println("te he modificado");	
	public Cancion(String titulo, String autor, int duracion, Codecs format) {
		this.titulo = titulo;
		this.autor = autor;
		this.duracion = duracion;
		this.formato = format; //Con el this, me refiero con this al atributo private siendo ,this.titulo el del objeto y titulo al argumento del constructor
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public Codecs getFormato() {
		return formato;
	}
	
	public void setFormato(Codecs formato) {
		this.formato = formato;
	}
	
	@Override //Es un decorador para indicar al compilador que sustituya el metodo de mismo nombre de la clase Objeto (superclase)
	//Otro decorador de gran utilidad es @Deprecated --> para indicar que tal metodo puede desaparecer
	// 			el metodo obsoleto, aparecera tachado
	public String toString() {
		/**
		 * Creación de una representación del contenido de la
		 * Canción en formato String
		 */
		int hours = duracion / 3600;
		int minutes = (duracion % 3600) / 60;
		int seconds = duracion % 60;

		String timeString;
		if (hours > 0) {
			timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
		} else {
			timeString = String.format("%02d:%02d", minutes, seconds);
		}
		return String.join("\n", "----------",
				"Título: " + titulo,
				"Autor: " + autor,
				"Duración: " + timeString,
				"Formato: " + (formato == Codecs.MP3 ? "MP3" : "FLAC"),
				"----------");
	}
	
	@Override
	/*
	 * El metodo equals de la clase objeto, lo que compara no son los atributos, sino el lugar en memoria
	 *  donde estan ambos objetos declarados
	 */
	public boolean equals(Object other) {
		/**
		 * Implementación de un método de comparación del contenido
		 * de dos canciones
		 */
		if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Cancion)) return false; //Aqui miramos si el objeto es de la misma clase
	    
	    Cancion otherCancion = (Cancion)other;
	    if (this.titulo == otherCancion.titulo &&
	    		this.autor == otherCancion.autor &&
	    		this.duracion == otherCancion.duracion &&
	    		this.formato == otherCancion.formato) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
	@Override
	public int hashCode(){
		return Objects.hash(titulo,autor,duracion,formato);
	}
	
	public static void main(String[] args) {
		Cancion track1 = new Cancion("The Song of the Sun", "Mike Olfield", 273, Codecs.MP3);
		Cancion track2 = new Cancion("The Song of the Sun", "Mike Olfield", 273, Codecs.MP3);
		Cancion pista2 = new Cancion();
		System.out.println(pista2);
		System.out.println(track1);
		System.out.println(track1.equals(track2));
		System.out.println(track1.hashCode());
	}

}
