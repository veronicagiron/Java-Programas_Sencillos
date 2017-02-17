package urjc.ist.playlist;
//Aqui hacemos compisicion, una clase utilizando otra creada previamente

import java.util.ArrayList; //Clase que permite crear un array dinamico
import urjc.ist.playlist.Cancion;
import java.util.Objects;


public class Album {
	/*
	 *  TODO Se pide completar la definición de la clase Album
	 *  Para ello, se puede consultar la URL sobre la clase de
	 *  utilidad ArrayList, que permite crear arrays de cualquier
	 *  tipo de objetos pero de longitud flexible (se pueden
	 *  extender o acortar en tiempo de ejecución
	 *  
	 *  // https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
	 */
	
	//private static final Boolean True = null; //Atributo que es comun para todas las clases 
	// es decir para todas las instancias valdra esto, hay una posicion en memoria
	// En definitiva, con static final indicamos que es una costante
	private String titulo;
	private String autor;
	private String grupo;
	private int duracionTotal;
	private ArrayList<Cancion> trackList;

	public Album() {
		titulo = "";
		autor = "";
		grupo = "";
		duracionTotal = 0;
		trackList = new ArrayList<Cancion>();
	}
	
	public Album(String titulo, String autor, String grupo) {
		setTitulo(titulo);
		setAutor(autor);
		this.grupo = grupo;
		duracionTotal = 0;
		trackList = new ArrayList<Cancion>();
	}
	
	// Metodo de obtencion y asignacion del titulo del Album
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	public String getTitulo () {
		return titulo;
	}
	
	//Metodo de obtencion y asignacion del autor del album
	public void setAutor(String autor){
		this.autor = autor;
	}
	public String getAutor(){
		return autor;
	}
	
	//Metodo de obtencion y asignacion del grupo del album
	public void setGrupo(String grupo){
		this.grupo = grupo;
	}
	public String getGrupo(){
		return grupo;
	}
	
	//Metodos de obtencion y asignacion de la duracion del album
	public void setDuracionTotal(int duracion){
		this.duracionTotal = duracion;
	}
	public int getDuracionTotal(){
		return duracionTotal;
	}
	
	public ArrayList<Cancion> getTrackList() {
		/**
		 * Método que devuelve la lista de canciones actualmente
		 * incluídas en el álbum
		 */
		return trackList;
	}
	
	public Cancion getTrack(int posicion) {
		/**
		 * Método que devuelve la canción que esté en la posición
		 * de la lista del álbum que se indica como argumento
		 */
		return trackList.get(posicion);
	}
	
	public void addTrack(Cancion unaCancion) {
		/**
		 * Método que añade una canción a la lista de canciones
		 * del álbum. Además, el método calcula y actualiza
		 * automáticamente la nueva duración total del álbum
		 */
		String grupo = unaCancion.getAutor();
		if (grupo == this.grupo){
			trackList.add(unaCancion);
			duracionTotal = duracionTotal + unaCancion.getDuracion();
		
		}
		System.out.println("Debe introducir Canciones del mismo grupo");
	}
	
	public void addTrack(int posicion, Cancion unaCancion) {
		/**
		 * Método que añade una canción al álbum(que pasamos
		 * como segundo argumento) en la posición que indique
		 * el int que recibe como primer argumento
		 */
		String grupo = unaCancion.getAutor();
		if (grupo == this.grupo){
			trackList.add(posicion, unaCancion);
			duracionTotal = duracionTotal + unaCancion.getDuracion();
		}
	}
	
	public void deleteLastTrack() {
		/**
		 * Método que borra la última canción de la lista del
		 * álbum
		 */
		trackList.remove(trackList.size() - 1);
	}
	
	public void deleteTrack(int posicion) {
		/**
		 * Método que borra la canción en la posición de la lista
		 * que indica el argumento que recibe
		 */
		trackList.remove(posicion);
	}
	
	public void clearAlbum() {
		/**
		 * Método que borra todas las canciones en la lista de
		 * un álbum
		 */
		trackList.removeAll(trackList);
		duracionTotal = 0;
	}
	
	@Override
	public String toString(){
		int hours = duracionTotal / 3600;
		int minutes = (duracionTotal % 3600) / 60;
		int seconds = duracionTotal % 60;
		
		String duration;
		if (hours > 0){
			duration = String.format("%02d:%02d:%02d", hours, minutes, seconds);
		} else {
			duration = String.format("%02d:%02d", minutes,seconds);
		}
		String albumString;
		albumString = String.join("\n", "--------------",
				"Titulo del Album " + titulo,
				"Nombre de los componente/es del grupo " + autor,
				"Nombre del grupo " + grupo,
				"Duracion del album " + duration,
				"Canciones del album" + trackList);
		return albumString;
	}
	
	@Override
	public boolean equals(Object other){
		if (other == null) return false; //Cuando el otro objeto es nulo
		if (other == this) return true; //Indica si ambos objetos estan en la misma posicion de memoria
		if (!(other instanceof Album)) return false;
		
		Album otroAlbum = (Album)other;
		if(this.titulo == otroAlbum.titulo && 
				this.autor == otroAlbum.autor &&
				this.grupo == otroAlbum.grupo &&
				this.duracionTotal == otroAlbum.duracionTotal &&
				this.trackList.equals(otroAlbum)){
			return true;
		}
		return false;
	}

	@Override
	public int hashCode(){
		return Objects.hash(titulo,autor,grupo,duracionTotal,trackList);
	}
	
	public static void main(String[] args) {
		
		//equals, y toString
		System.out.println("Clase Album");
		Album miAlbum = new Album ("Destrangis", "Hermanos Muñoz", "Estopa");
		miAlbum.setGrupo("Estopa");
		
//		//Vamos a probar el metodo añadir Cancion
//		Cancion track1 = new Cancion("Vino Tinto", "Estopa", 273, Cancion.Codecs.MP3);
//		Cancion track2 = new Cancion("Loba", "Shakira", 256, Cancion.Codecs.MP3);
//		miAlbum.addTrack(track1);
//		miAlbum.addTrack(track2);
//		System.out.println("Mi album tiene las siguientes canciones " + miAlbum.getTrackList() + " " +  miAlbum.getDuracionTotal());
////		/*
//		 * Cuando llamamos al print del trackList, como tiene objetos de Cancion, el operador
//		 * "+" llama al metodo toString del metodo Cancion
//		 */
		
		//Probamos el metodo getTrack
		//Cancion miCancionPreferida = miAlbum.getTrack(0);
		//System.out.println(miCancionPreferida);
		
		//Vamos a probar el metodo añadir en el album
		Cancion track3 = new Cancion("Demonios", "Estopa", 283, Cancion.Codecs.MP3);
//		miAlbum.addTrack(0, track3);
//		System.out.println("Mi album" + miAlbum.getTrackList() + "duracion de album" + miAlbum.duracionTotal);
//		
//		//Vamos a probar si borra
//		miAlbum.deleteTrack(0);
//		System.out.println(miAlbum.getTrackList());
	
		//Vamos a probar el metodo de borrar todo
//		miAlbum.clearAlbum();
//		System.out.println("Metodo para borrar todo el album\n" + miAlbum.trackList );
		
		//Vamos a probar el metodo toString
//		System.out.println(miAlbum);
		
		//Probamos el metodo equals
		Album album2 = new Album ("Destrangis", "Hermanos Muñoz", "Estopa");
		miAlbum.addTrack(0, track3);
		album2.addTrack(0, track3);
		System.out.println( "Mi Album \n" + miAlbum);
		System.out.println("album 2 \n" + album2);
		System.out.println(miAlbum.equals(track3));
		System.out.println(miAlbum.hashCode() + " " + album2.hashCode());
	}

}