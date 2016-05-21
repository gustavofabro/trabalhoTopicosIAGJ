package view;

import bean.Produto;
import bean.Cliente;
import java.util.Vector;

/**
 *
 * @author juanvmr
 */
public class TesteObjetos {
    private static Cliente cliente;
    private static Produto produto;
    
    public static Vector clientes;
    public static Vector produtos;
    
    public TesteObjetos(){
	for (int i = 0; i < 10; i++) {
	    clientes.add(cliente);
	    produtos.add(produto);
	}
    }
}
