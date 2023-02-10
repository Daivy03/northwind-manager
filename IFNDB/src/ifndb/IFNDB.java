/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ifndb;
import java.awt.Dimension;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;


/**
 *
 * @author Reale
 */
public class IFNDB {

    /**
     * @param args the command line arguments
     */
    
    /*
    public static void cercaCliente(String st) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "davide", "davide");
        
        Statement stmt = con.createStatement();

      // Esegue la query per selezionare i dati dalla tabella clienti
//      ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
      ResultSet rs = stmt.executeQuery("SELECT * from orders\n" +
"INNER JOIN customers on customers.CustomerID = orders.CustomerID\n" +
"WHERE customers.CustomerID LIKE\""+st+"\"");
      
      


      
      
      
      
      // Create a table model
            DefaultTableModel tableModel = new DefaultTableModel();
            int columnCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(rs.getMetaData().getColumnName(i));
            }
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(row);
            }

            // Create a JTable and wrap it in a JScrollPane
            JTable table = new JTable(tableModel);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(900, 300));

            // Show the table in a JOptionPane
            JOptionPane.showMessageDialog(
                    new JFrame(), 
                    scrollPane, 
                    "R", 
                    JOptionPane.PLAIN_MESSAGE);
      
      // Chiude la connessione al database
      con.close();
    }
    
    
    */
    public static void cercaCliente(String st) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "davide", "davide");
        
        Statement stmt = con.createStatement();

      // Esegue la query per selezionare i dati dalla tabella clienti
     //  ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
      ResultSet rs = stmt.executeQuery("SELECT * from orders\n" +
        "INNER JOIN customers on customers.CustomerID = orders.CustomerID\n" +
        "WHERE customers.CustomerID LIKE\""+st+"\"");

      // Crea un modello di tabella
        DefaultTableModel tableModel = new DefaultTableModel();
        int columnCount = rs.getMetaData().getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            tableModel.addColumn(rs.getMetaData().getColumnName(i));
        }
        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = rs.getObject(i);
            }
            tableModel.addRow(row);
        }

        JTable table = new JTable(tableModel);
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(100);
        }

        table.setEnabled(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800, 200));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JFrame frame = new JFrame("Risultati");
        frame.setContentPane(scrollPane);
        frame.pack();
        frame.setVisible(true);

      // Chiude la connessione al database
      con.close();
    }

    
    public static ArrayList<String> recoverClienti() throws Exception{
        ArrayList<String> clienti = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "davide", "davide");
        Statement stmt = con.createStatement();
        String query = "SELECT CustomerID from customers";
        ResultSet rs = stmt.executeQuery(query);
         while (rs.next()) {
                String name = rs.getString("CustomerId");
                clienti.add(name);
            }
    return clienti;
    }
    
    public static void main(String[] args) {
               
    }
    
    
    
}
