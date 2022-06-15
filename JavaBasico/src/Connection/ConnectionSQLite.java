/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

// SITE PARA BAIXAR O DRIVER MAIS ATUAL: 
// https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc/3.36.0

public class ConnectionSQLite {
  
    private Connection conexao;

   // Conecta a um banco de dados ou cria o banco se ele não existir
    public boolean conectar() {

        try {
            
            // Passar localização do banco. Exemplo:
            // C:\\Users\\...\\JogoPalavras\\JavaBasico\\database\\SQLite_db.db
            String url = "jdbc:sqlite:SQLite_db.db";

            this.conexao = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }

        //System.out.println("conectou!!!");
        
        return true;
    }
    
    // Desconecta o banco
    public boolean desconectar() {

        try {
            if (this.conexao.isClosed() == false) {
                this.conexao.close();
            }

        } catch (SQLException e) {

            System.err.println(e.getMessage());
            return false;
        }
        
        //System.out.println("desconectou!!!");
        return true;

    }
    
    // Método para criar statements que executarão as consultas
    public Statement criarStatement(){
        
        try{
            return this.conexao.createStatement();
        } catch (SQLException e){
            return null;
        }
    }
    
    // Criar SQL's com valores pré-prontos
    public PreparedStatement criarPreparedStatement(String sql) {
        try {
            return this.conexao.prepareStatement(sql);
        } catch (SQLException e) {
            return null;
        }
    }
    
    // Retornar a conexão do banco 
    public Connection getConexao(){
        return this.conexao;
    }
}