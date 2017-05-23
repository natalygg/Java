package ui;


import java.util.Scanner;
import dao.DAOLibro;
import datos.Db;
import modelo.Libro;


public class Principal {
	
private static Scanner teclado=new Scanner(System.in);

	public static void main(String[] args) {
		
Db.init();//conexión a la BBDD
		
	boolean continuar=true;
	
	while(continuar){
			imprimirMenu();
			System.out.println("\nIntroduzca la opción");
			String s=teclado.nextLine();
			s=s.trim();//elimina los espacios,tabuladores y saltos de linea que hay en blanco al principio o al final de la cadena
			if(s.length()>0){
				char o=s.charAt(0);//obtiene el primer caracter de la cadena
				switch(o){
				case '1':
					insertarLibro();
					break;
				case'2':
					buscarLibro();
					break;
				case'3':
					borrarLibro();
					break;
				case'4':
					System.out.println("Gracias por utilizar nuestra biblioteca virtual.");
					continuar=false;
					break;
					
				}
				
			}
		}
		
	}
	
	private static void imprimirMenu(){
		
		System.out.println("=====MENU=====");
		System.out.println();
		System.out.println("1.-Introducir libro");
		System.out.println("2.-Buscar libro");
		System.out.println("3.-Borrar libro");
		System.out.println();
		System.out.println("4.-Salir");
		System.out.println("=================");
	}
	
	private static void  insertarLibro(){
		
		System.out.print("Isbn: ");
		int isbn=teclado.nextInt();
		teclado.nextLine();
		
		System.out.print(" Título: ");
		String titulo=teclado.nextLine();
		
		System.out.print(" Autor: ");
		String autor=teclado.nextLine();
		
		
		System.out.print(" Páginas: ");
		int paginas=teclado.nextInt();
		teclado.nextLine();
		
		Libro p=new Libro(isbn, titulo, autor, paginas);
		
		DAOLibro dao=new DAOLibro();
		if(!dao.create(p)){//si no ha podido hacer la orden
			System.out.println("Fallo en la insercion. ¿El libro ya está insertada?");
		}
	}
	
	private static void buscarLibro(){
		
		System.out.print("Título: ");
		String titulo=teclado.nextLine();
		
		DAOLibro dao=new DAOLibro();
		Libro p=dao.read(titulo);
		if(p!=null){
			System.out.println(p);
		}
		else {
			System.out.println("El titulo introducido no está en la base de datos");
		}
	}
	
	
	public static void borrarLibro(){
		System.out.print("Isbn: ");
		int isbn=teclado.nextInt();
		
		DAOLibro dao=new DAOLibro();
		Libro p=new Libro(isbn,"","",0);
		if(!dao.delete(p)){
			System.out.println("Fallo al borrar el libro");
		}
		
	}
		

}


