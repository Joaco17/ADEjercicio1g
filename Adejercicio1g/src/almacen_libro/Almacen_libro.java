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
			//Creaci�n de objetos tipo libro.
			libro1 = new Libro("El ni�o sin pijama", "Joaquin", 1994, "Salamandra", 666);
			libro2 = new Libro("Calaveras al aire", "Paco", 1987, "El barco de Vapor", 860);
			libro3 = new Libro("Javier Perez y la Roca Filos�fica", "Ivan", 2001, "Anaya", 429);
			
			//Creacion de un nuevo objeto Almacen.
			almacen = new Almacen();
			
			//OPCIONES DISPONIBLES SOBRE EL OBJETO LIBRO:
			
			//GUARDAR 
			almacen.guardarLibro(libro3, "libro3Guardado.txt");
			//SE CREARR� UN TXT CON EL OBJETO LIBRO3
			
			//RECUPERAR
			Libro libroRecuperado = almacen.recuperarLibro("libro3Guardado.txt");
			
			
			
			//GUARDAR LISTAS DE LIBROS 
			
			
			//EN PRIMER LUGAR GENERAMOS UNA NUEVA LISTA (ArrayList<Libro>)
			ArrayList<Libro> listaLibros = new ArrayList<Libro>();
			listaLibros.add(libro1);
			listaLibros.add(libro2);
			listaLibros.add(libro3);
			
			almacen.guardarLista(listaLibros, "listaLibros.txt");

			//MODIFICACI�N DE T�TULO Y AUTOR
			//TITULO AUTOR Y A�O EN PRIMERA INSTANCIA
			System.out.println("Primero el titulo es: "+libroRecuperado.getTitulo());
			System.out.println("Primero el autor es: "+libroRecuperado.getAutor());
			System.out.println("Primero el a�o es: "+libroRecuperado.getA�o());
			
			//MODIFICACION DE ATRIBUTOS
			libroRecuperado.setTitulo("Nuevo titulo del libro");
			libroRecuperado.setAutor("Nuevo autor del libro");
			libroRecuperado.setA�o(2012);
			
			//COMPROBACI�N DEL CAMBIO
			System.out.println(libroRecuperado.getTitulo());
			System.out.println(libroRecuperado.getAutor());
			System.out.println("Nuevo a�o de publicacion: "+libroRecuperado.getA�o());
				
			
			
		}
}
