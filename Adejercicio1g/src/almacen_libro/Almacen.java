package almacen_libro;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Almacen {

	public void guardarLibro(Libro l, String f){
		
		//Declaramos e inicializamos el ObjectOutputStream
			ObjectOutputStream out = null;
				
				//Tratado de errores
				try {
					//Creamos el ObjectOutputStream que recibe el fichero de salida
					out = new ObjectOutputStream(new FileOutputStream(f));
					//Escribimos sobre el Stream de salida el objeto Libro
					out.writeObject(l);
					//Comprobacion del guardado
					System.out.println(l.getTitulo()+" guardado correctamente.");
				}
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					//Cerramos el stream mediante el metodo close creado
					this.cerrar(out);
				}
			}
			
			/*Método cuya función es guardar una lista de libros en un fichero de salida, recibe por parámetro:
			- ArrayList<Libro> (Lista de libros)
			- String (Fichero salida)
			*/
			public void guardarLista(ArrayList<Libro> lista, String salida){
				ObjectOutputStream listaOut = null;
				
				try {
					//En este caso el Stream de salida recibe el String de la lista de libros
					listaOut = new ObjectOutputStream(new FileOutputStream(salida));
					//Escrbimos sobre el stream de salida el contenido del arrayList
					listaOut.writeObject(lista);
					//Comprobacion del guardado de la lista
					System.out.println("Lista: "+salida+" guardada correctamente.");
				}
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					//Cerramos de nuevo el Stream con el metodo cerrar
					this.cerrar(listaOut);
				}
			}
			
			//Método que recupera un libro dado un String fichero
			
			public Libro recuperarLibro(String entrada){
				//Declaramos e inicializamos un objeto de tipo Libro donde almacenaremos la entrada del libro recuperado
				Libro libroRecuperado = null;
				//Declaramos e inicializamos un ObjectInputStream )
				ObjectInputStream in = null;
				try {
					//Creamos el Stream de objetos de entrada que recibe por parámetro el libro a recuperar
					in = new ObjectInputStream(new FileInputStream(entrada));
					//Almacenamiento del libro recuperado en variable;
					libroRecuperado = (Libro) in.readObject();
					//""
					System.out.println(libroRecuperado.getTitulo()+" recuperado correctamente.");
				}
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					this.cerrar(in);
				}
				//Devolvemos un libro
				return libroRecuperado;
			}
			
			
			//Cerraremos los streams de manera segura
			public void cerrar(Closeable c){
				try {
					if(c != null){
						c.close();
					}
				}
				catch (IOException errorCerrado) {
					// TODO Auto-generated catch block
					errorCerrado.printStackTrace();
					
					System.err.println("Error al cerrar el Stream.");
				}
			}
	}

