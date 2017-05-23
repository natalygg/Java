package modelo;

public class Libro {


		private int isbn;
		private String titulo;
		private String autor;
		private int paginas;
		
		public Libro(int isbn, String titulo, String autor, int paginas){
			this.isbn=isbn;
			this.titulo=titulo;
			this.autor=autor;
			this.paginas=paginas;
			
		}

		
		
		public int getIsbn() {
			return isbn;
		}



		public void setIsbn(int isbn) {
			this.isbn = isbn;
		}



		public String getTitulo() {
			return titulo;
		}



		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}



		public String getAutor() {
			return autor;
		}



		public void setAutor(String autor) {
			this.autor = autor;
		}



		public int getPaginas() {
			return paginas;
		}



		public void setPaginas(int paginas) {
			this.paginas = paginas;
		}



		@Override
		public String toString(){
			return " ISBN: "+isbn+"\n"+" Titulo: "+titulo+"\n"+" Autor: "+autor+"\n"+" P�ginas: "+paginas;
		}
	}

