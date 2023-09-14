package code;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Connections{
	 
	private static Connection con = null ;
	public static String connessione () {

	  try {
			  //caricamento e registrazione driver
		  	   String s=" ";
			   Class.forName("com.mysql.cj.jdbc.Driver"); //Carica il Driver
			   String url ="jdbc:mysql://localhost:3306/ecommerce?useSSL=false&serverTimezone=UTC";
		       String username = "root";
			   String pwd = "123456";  
			   con = DriverManager.getConnection(url,username,pwd);
			   s="Connessione riuscita!!";
			   return s;
	  }
	  catch(Exception e)
	  {
		  return "Connessione fallita";  
	  }
	}
	
	public static String uscita() {
		
		try {
			con.close();
			return "Connessione chiusa correttamente\n";
		} catch (SQLException e) {
			return "Chiusura connessione fallita\n";
		}
	}
	
	public static void query1(int idCliente,String nome,String cognome,String username,String password)  {
   	
    try {
   			String sql="INSERT INTO cliente VALUES(?,?,?,?,?)";
	        PreparedStatement query = con.prepareStatement(sql);
	        query.setInt(1, idCliente);
	        query.setString(2, nome);
	        query.setString(3, cognome);
	        query.setString(4,username);
	        query.setString(5, password);
	        query.executeUpdate();
            query.close();
            
         }
    catch (SQLException e)
    {
       System.out.println(e);
       JPanel pane= new JPanel();
       JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
    }
}
	
	public static void query2(int idProdotto,String nome,String descrizione,int prezzo,float peso,int idCategoria)  {
	   	
	    try {
	   			String sql="INSERT INTO prodotto VALUES(?,?,?,?,?,?)";
		        PreparedStatement query = con.prepareStatement(sql);
		        query.setInt(1, idProdotto);
		        query.setString(2, nome);
		        query.setString(3, descrizione);
		        query.setInt(4,prezzo);
		        query.setFloat(5, peso);
		        query.setInt(6,idCategoria);
		        query.executeUpdate();
	            query.close();
	            
	         }
	    catch (SQLException e)
	    {
	       System.out.println(e);
	       JPanel pane= new JPanel();
	       JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public static String query3() {

		String r="";
		try {
	        
	        Statement query = con.createStatement();
	        ResultSet result = query.executeQuery("SELECT * FROM prodotto;");
	    
            while (result.next())
            {
               int idProdotto = result.getInt("idProdotto");
               String nome = result.getString("nome");
               String descrizione = result.getString("descrizione");
               int prezzo = result.getInt("prezzo");
               float peso= result.getFloat("peso");
               int idCategoria = result.getInt("idCategoria");
               r+="idProdotto:"+idProdotto+"\nnome:"+nome+"\ndescrizione:"+descrizione+"\nprezzo:"+prezzo+"\npeso:"+peso+"\nidCategoria:"+idCategoria+"\n\n";
          
            } 
            result.close();
            query.close();
            return r;
           
       }
    catch (SQLException e)
    {
        System.out.println(e);
        JPanel pane= new JPanel();
        JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
        return null;
    }
	}
	
	public static String query4() {

		String r="";
		try {
	        
	        Statement query = con.createStatement();
	        ResultSet result = query.executeQuery("SELECT p.idProdotto, p.nome AS nomeProdotto, SUM(c.quantità) AS\r\n"
	        		+ "quantità_venduta\r\n"
	        		+ " FROM Prodotto as p\r\n"
	        		+ " JOIN Contiene as c ON p.idProdotto = c.idProdotto\r\n"
	        		+ " JOIN Ordine as o ON c.idOrdine = o.idOrdine\r\n"
	        		+ " WHERE o.data BETWEEN '2021-04-21' AND '2023-09-01'\r\n"
	        		+ " GROUP BY p.idProdotto, p.nome\r\n"
	        		+ " ORDER BY quantità_venduta DESC");
	    
            while (result.next())
            {
               int idProdotto = result.getInt("idProdotto");
               String nomeProdotto = result.getString("nomeProdotto");
               int quantità_venduta = result.getInt("quantità_venduta");
              
               r+="idProdotto:"+idProdotto+"\nnome:"+nomeProdotto+"\nquantità_venduta:"+quantità_venduta+"\n\n";
          
            } 
            result.close();
            query.close();
            return r;
           
       }
    catch (SQLException e)
    {
        System.out.println(e);
        JPanel pane= new JPanel();
        JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
        return null;
    }
	}

	public static String query5() {

		String r="";
		try {
	        
	        Statement query = con.createStatement();
	        ResultSet result = query.executeQuery("SELECT p.idProdotto, p.nome AS nomeProdotto, COALESCE(SUM(c.quantità), 0) AS quantità_venduta\r\n"
	        		+ "FROM Prodotto as p \r\n"
	        		+ "LEFT JOIN Contiene as c ON p.idProdotto = c.idProdotto \r\n"
	        		+ "LEFT JOIN Ordine as o ON c.idOrdine = o.idOrdine AND o.data BETWEEN '2021-04-21' AND '2023-09-01'\r\n"
	        		+ "GROUP BY p.idProdotto, p.nome \r\n"
	        		+ "ORDER BY quantità_venduta ASC;\r\n");
	    
            while (result.next())
            {
               int idProdotto = result.getInt("idProdotto");
               String nomeProdotto = result.getString("nomeProdotto");
               int quantità_venduta= result.getInt("quantità_venduta");
               
           
               r+="idProdotto:"+idProdotto+"\nnomeProdotto:"+nomeProdotto+"\nquantità_venduta:"+quantità_venduta+"\n\n";
          
            } 
            result.close();
            query.close();
            return r;
           
       }
    catch (SQLException e)
    {
        System.out.println(e);
        JPanel pane= new JPanel();
        JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
        return null;
    }
	}
	
	public static String query6() {

		String r="";
		try {
	        
	        Statement query = con.createStatement();
	        ResultSet result = query.executeQuery("SELECT idProdotto, nome, prezzo\r\n"
	        		+ "FROM Prodotto\r\n"
	        		+ "ORDER BY prezzo DESC\r\n"
	        		+ "LIMIT 1;");
	    
            while (result.next())
            {
               int idProdotto = result.getInt("idProdotto");
               String nome = result.getString("nome");
               int prezzo = result.getInt("prezzo");
            
               r+="idProdotto:"+idProdotto+"\nnome:"+nome+"\nprezzo:"+prezzo+"\n\n";
          
            } 
            result.close();
            query.close();
            return r;
           
       }
    catch (SQLException e)
    {
        System.out.println(e);
        JPanel pane= new JPanel();
        JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
        return null;
    }
	}
	
	
	
	
	public static String query7() {

		String r="";
		try {
	        
	        Statement query = con.createStatement();
	        ResultSet result = query.executeQuery("SELECT c.idCliente, c.nome\r\n"
	        		+ "FROM Cliente c\r\n"
	        		+ "JOIN Ordine o ON c.idCliente = o.idCliente\r\n"
	        		+ "GROUP BY c.idCliente, c.nome\r\n"
	        		+ "HAVING COUNT(o.idOrdine) > 1;");
	    
            while (result.next())
            {
               int idCliente= result.getInt("idCliente");
               String nome = result.getString("nome");
               
               r+="idCliente:"+idCliente+"\nnome:"+nome+"\n\n";
          
            } 
            result.close();
            query.close();
            return r;
           
       }
    catch (SQLException e)
    {
        System.out.println(e);
        JPanel pane= new JPanel();
        JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
        return null;
    }
	}
	
	public static String query8() {

		String r="";
		try {
	        
	        Statement query = con.createStatement();
	        ResultSet result = query.executeQuery("SELECT idProdotto, nome, prezzo\r\n"
	        		+ "FROM Prodotto\r\n"
	        		+ "ORDER BY prezzo ASC;");
	    
            while (result.next())
            {
               int idProdotto = result.getInt("idProdotto");
               String nome = result.getString("nome");
               int prezzo = result.getInt("prezzo");
               
               r+="idProdotto:"+idProdotto+"\nnome:"+nome+"\nprezzo:"+prezzo+"\n\n";
          
            } 
            result.close();
            query.close();
            return r;
           
       }
    catch (SQLException e)
    {
        System.out.println(e);
        JPanel pane= new JPanel();
        JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
        return null;
    }
	}
	
	
	public static String query9(int idCliente) {

		String r="";
		try {
	        
	        String sql = "SELECT c.nome, c.cognome, COALESCE(SUM(p.importo), 0) AS importo_totale\r\n"
	        		+ "FROM Cliente c\r\n"
	        		+ "JOIN Ordine o ON c.idCliente = o.idCliente\r\n"
	        		+ "JOIN Pagamento p ON o.idOrdine = p.idOrdine\r\n"
	        		+ "WHERE c.idCliente = ?\r\n"
	        		+ "GROUP BY c.nome, c.cognome;\r\n";
	        
	       PreparedStatement query = con.prepareStatement(sql);
	       query.setInt(1, idCliente);
	       ResultSet result= query.executeQuery();
	       
	       if (!result.isBeforeFirst()) {
	            r = "Nessuna informazione trovata per il cliente con ID " + idCliente;
	        } else {
            while (result.next())
            {  
            String nome= result.getString("nome");
            String cognome= result.getString("cognome");
            int importo_totale= result.getInt("importo_totale");
               r+="nome:"+nome+"\ncognome:"+cognome+"\nimporto_totale:"+importo_totale+"\n\n";
          
            } }
            result.close();
            query.close();
            return r;
           
       }
    catch (SQLException e)
    {
        System.out.println(e);
        JPanel pane= new JPanel();
        JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
        return null;
    }
		
	}
	
	public static String query10() {

		String r="";
		try {
	        
	        Statement query = con.createStatement();
	        ResultSet result = query.executeQuery("SELECT idProdotto, nome, prezzo\r\n"
	        		+ "FROM Prodotto\r\n"
	        		+ "WHERE prezzo > 50");
	    
            while (result.next())
            {
               int idProdotto = result.getInt("idProdotto");
               String nome = result.getString("nome");
               int prezzo = result.getInt("prezzo");
               
               r+="idProdotto:"+idProdotto+"\nnome:"+nome+"\nprezzo:"+prezzo+"\n\n";
          
            } 
            result.close();
            query.close();
            return r;
           
       }
    catch (SQLException e)
    {
        System.out.println(e);
        JPanel pane= new JPanel();
        JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
        return null;
    }
	}
	
	
	public static String query11() {

		String r="";
		try {
	        
	        Statement query = con.createStatement();
	        ResultSet result = query.executeQuery("SELECT p.idProdotto, p.nome\r\n"
	        		+ " FROM Prodotto p\r\n"
	        		+ "LEFT JOIN Contiene c ON p.idProdotto = c.idProdotto\r\n"
	        		+ "WHERE c.idProdotto IS NULL;\r\n");
	    
            while (result.next())
            {
               int idProdotto = result.getInt("idProdotto");
               String nome = result.getString("nome");
              
               r+="idProdotto:"+idProdotto+"\nnome:"+nome+"\n\n";
          
            } 
            result.close();
            query.close();
            return r;
           
       }
    catch (SQLException e)
    {
        System.out.println(e);
        JPanel pane= new JPanel();
        JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
        return null;
    }
	}
	
	public static String query12() {

		String r="";
		try {
	        
	        Statement query = con.createStatement();
	        ResultSet result = query.executeQuery("SELECT c.nome, MAX(o.data) AS ultima_data_ordine\r\n"
	        		+ "FROM Cliente c\r\n"
	        		+ "JOIN Ordine o ON c.idCliente = o.idCliente\r\n"
	        		+ "GROUP BY c.nome;");
	    
            while (result.next())
            {
               
               String nome = result.getString("nome");
               Date ultima_data_ordine = result.getDate("ultima_data_ordine");
               
               r+="nome:"+nome+"\nultima_data_ordine:"+ultima_data_ordine+"\n\n";
          
            } 
            result.close();
            query.close();
            return r;
           
       }
    catch (SQLException e)
    {
        System.out.println(e);
        JPanel pane= new JPanel();
        JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
        return null;
    }
	}
	
	public static String query13() {

		String r="";
		try {
	        
	        Statement query = con.createStatement();
	        ResultSet result = query.executeQuery("SELECT cat.idCategoria, cat.nome, COUNT(DISTINCT p.idProdotto) AS\r\n"
	        		+ "varietà_prodotti\r\n"
	        		+ "FROM Categoria cat\r\n"
	        		+ "JOIN Prodotto p ON cat.idCategoria = p.idCategoria\r\n"
	        		+ "GROUP BY cat.idCategoria, cat.nome\r\n"
	        		+ "ORDER BY varietà_prodotti DESC;");
	    
            while (result.next())
            {
            	int idCategoria = result.getInt("idCategoria");
               String nome = result.getString("nome");
               int varietà_prodotti = result.getInt("varietà_prodotti");
              
               
               r+="idCategoria:"+idCategoria+"\nnome:"+nome+"\nvarietà_prodotti:"+varietà_prodotti+"\n\n";
          
            } 
            result.close();
            query.close();
            return r;
           
       }
    catch (SQLException e)
    {
        System.out.println(e);
        JPanel pane= new JPanel();
        JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
        return null;
    }
	}
	public static String query14() {

		String r="";
		try {
	        
	        Statement query = con.createStatement();
	        ResultSet result = query.executeQuery("SELECT o.idOrdine, o.data\r\n"
	        		+ "FROM Ordine o\r\n"
	        		+ "JOIN Pagamento p ON o.idOrdine = p.idOrdine\r\n"
	        		+ "JOIN MetodoPagamento mp ON p.idMetodoPagamento =\r\n"
	        		+ "mp.idMetodoPagamento\r\n"
	        		+ "WHERE mp.tipo = 'Carta di credito';");
	    
            while (result.next())
            {
               int idOrdine = result.getInt("idOrdine");
               Date data = result.getDate("data");
              
               r+="idOrdine:"+idOrdine+"\ndata:"+data+"\n\n";
          
            } 
            result.close();
            query.close();
            return r;
           
       }
    catch (SQLException e)
    {
        System.out.println(e);
        JPanel pane= new JPanel();
        JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
        return null;
    }
	}
	
	public static String query15(int anno) {

		String r="";
		try {
	        
	        String sql = "SELECT idOrdine, data\r\n"
	        		+ " FROM Ordine\r\n"
	        		+ " WHERE YEAR(data) = ?;\r\n";
	        
	       PreparedStatement query = con.prepareStatement(sql);
	       query.setInt(1, anno);
	       ResultSet result= query.executeQuery();
	       
	       if (!result.isBeforeFirst()) {
	            r = "Nessun ordine trovato per l'anno " + anno;
	        } else {
            while (result.next())
            {  
            int idOrdine= result.getInt("idOrdine");
            Date data= result.getDate("data");
            
               r+="idOrdine:"+idOrdine+"\ndata:"+data+"\n\n";
            }
            } 
            result.close();
            query.close();
            return r;
           
       }
    catch (SQLException e)
    {
        System.out.println(e);
        JPanel pane= new JPanel();
        JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
        return null;
    }
		
	}
	
	public static String query16() {

		String r="";
		try {
	        
	        Statement query = con.createStatement();
	        ResultSet result = query.executeQuery("SELECT rn.nomeNegozio, c.idCliente, c.nome, c.cognome, COUNT(*) AS\r\n"
	        		+ "NumeroRitiri\r\n"
	        		+ "FROM RitiroNegozio rn\r\n"
	        		+ "JOIN Ordine o ON rn.idOrdine = o.idOrdine\r\n"
	        		+ "JOIN Cliente c ON o.idCliente = c.idCliente\r\n"
	        		+ "GROUP BY rn.nomeNegozio, c.idCliente, c.nome, c.cognome\r\n"
	        		+ "ORDER BY NumeroRitiri DESC\r\n"
	        		+ "LIMIT 1;\r\n");
	    
            while (result.next())
            {
            	String nomeNegozio = result.getString("nomeNegozio");
               int idCliente = result.getInt("idCliente");
               String nome = result.getString("nome");
               String cognome = result.getString("cognome");
               int NumeroRitiri = result.getInt("NumeroRitiri");
               
               r+="nomeNegozio:"+nomeNegozio+"\nidCliente:"+idCliente+"\nnome:"+nome+"\ncognome:"+cognome+"\nNumeroRitiri:"+NumeroRitiri+"\n\n";
          
            } 
            result.close();
            query.close();
            return r;
           
       }
    catch (SQLException e)
    {
        System.out.println(e);
        JPanel pane= new JPanel();
        JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
        return null;
    }
	}
	
}