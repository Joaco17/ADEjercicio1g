package almacen_libro;

import java.util.ArrayList;

public class Almacen_libro {

	//Declaracion de libros
		private static Libro libro1;
		private static Libro libro2;
		private static Libro libro3;
		
		//Atributo de tipo almacenLibros
		private static Almacen almacen;
		
		public static void main(String[] args) {
			//Creación de objetos tipo libro.
			libro1 = new Libro("El niño sin pijama", "Joaquin", 1994, "Salamandra", 666);
			libro2 = new Libro("Calaveras al aire", "Paco", 1987, "El barco de Vapor", 860);
			libro3 = new Libro("Javier Perez y la Roca Filosófica", "Ivan", 2001, "Anaya", 429);
			
			//Creacion de un nuevo objeto Almacen.
			almacen = new Almacen();
			
			//OPCIONES DISPONIBLES SOBRE EL OBJETO LIBRO:
			
			//GUARDAR 
			almacen.guardarLibro(libro3, "libro3Guardado.txt");
			//SE CREARRÁ UN TXT CON EL OBJETO LIBRO3
			
			//RECUPERAR
			Libro libroRecuperado = almacen.recuperarLibro("libro3Guardado.txt");
			
			
			
			//GUARDAR LISTAS DE LIBROS 
			
			
			//EN PRIMER LUGAR GENERAMOS UNA NUEVA LISTA (ArrayList<Libro>)
			ArrayList<Libro> listaLibros = new ArrayList<Libro>();
			listaLibros.add(libro1);
			listaLibros.add(libro2);
			listaLibros.add(libro3);
			
			almacen.guardarLista(listaLibros, "listaLibros.txt");

			//MODIFICACIÓN DE TÍTULO Y AUTOR
			//TITULO AUTOR Y AÑO EN PRIMERA INSTANCIA
			System.out.println("Primero el titulo es: "+libroRecuperado.getTitulo());
			System.out.println("Primero el autor es: "+libroRecuperado.getAutor());
			System.out.println("Primero el año es: "+libroRecuperado.getAño());
			
			//MODIFICACION DE ATRIBUTOS
			libroRecuperado.setTitulo("Nuevo titulo del libro");
			libroRecuperado.setAutor("Nuevo autor del libro");
			libroRecuperado.setAño(2012);
			
			//COMPROBACIÓN DEL CAMBIO
			System.out.println(libroRecuperado.getTitulo());
			System.out.println(libroRecuperado.getAutor());
			System.out.println("Nuevo año de publicacion: "+libroRecuperado.getAño());
				
			
			
		}
}
