package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dao.DAOProducto;
import listeners.ServletContext;
import modelos.Producto;

/**
 * Application Lifecycle Listener implementation class ListenerAplicacion
 *
 */
@WebListener
public class ListenerAplicacion implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerAplicacion() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	 ServletContext contexto=sce.getServletContext();
         DAOAnuncio dao=new DAOAnuncio();
         Anuncio oferta=dao.getProducto(1);
         contexto.setAttribute("oferta",oferta);
    }
	
}
