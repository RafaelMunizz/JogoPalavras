/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rafae
 */
public class Table_palavras {
 
    private final ConnectionSQLite conexaoSQLite;

    public Table_palavras(ConnectionSQLite conexaoSQLite) {
        this.conexaoSQLite = conexaoSQLite;
    }
    
    public void createTable(){
        
        String sql = "CREATE TABLE IF NOT EXISTS tbl_palavras"
                    + "("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "palavra TEXT NOT NULL"
                    + ");";
        
        //executando o sql de criar tabelas
        boolean conectou = false;

        try {
            conectou = this.conexaoSQLite.conectar();
            
            Statement stmt = this.conexaoSQLite.criarStatement();
            
            stmt.execute(sql);
            
            System.out.println("Tabela de palavras criada!");

        } catch (SQLException e) {
            //mensagem de erro na criação da tabela
            System.out.println("Tabela não criada. Erro: " + e);
        } finally {
            if(conectou){
                this.conexaoSQLite.desconectar();
            }
        }
    }
    
    // Método pra inserir as palavras no banco
    public void insertPalavras(String palavra) {

        conexaoSQLite.conectar();

        String sqlInsert = " INSERT INTO tbl_palavras (palavra) VALUES(?);";

        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);

        try {

            preparedStatement.setString(1, palavra);

            int resultado = preparedStatement.executeUpdate();

            if (resultado == 1) {
                System.out.println("Palavra inserida!");
                
            } else {
                System.out.println("Palavra não inserida!");
            }

        } catch (SQLException e) {
            System.out.println("Palavra não inserida! Erro: " + e);
            
        } finally{
            
            if(preparedStatement != null){
                
                try {
                    preparedStatement.close();
                    
                } catch (SQLException ex) {
                    System.out.println("Erro ao fechar preparedStatement: " + ex);
                }
            }
            conexaoSQLite.desconectar();
        }
    }
    
    // Método pra inserir as palavras no banco
    public void clearPalavras() {

        conexaoSQLite.conectar();

        String sqlInsert = "DELETE FROM tbl_palavras;";

        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);
        
        try {

            int resultado = preparedStatement.executeUpdate();

            if (resultado == 1) {
                System.out.println("Tabela tbl_palavras limpa!");
            } else {
                System.out.println("Tabela tbl_palavras não limpa!");
            }

        } catch (SQLException e) {
            System.out.println("Tabela tbl_palavras não limpa!. Erro: " + e);
            
        } finally{
            
            if(preparedStatement != null){
                
                try {
                    preparedStatement.close();
                    
                } catch (SQLException ex) {
                    System.out.println("Erro ao fechar preparedStatement: " + ex);
                }
            }
            conexaoSQLite.desconectar();
        }
    }
    
    public boolean checarPalavraNoBanco(String palavra){

        conexaoSQLite.conectar();
        
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        String sql = "SELECT palavraSemAcento FROM tbl_palavras WHERE palavraSemAcento = ?;";

        try{
            
            preparedStatement = conexaoSQLite.criarPreparedStatement(sql);
            preparedStatement.setString(1, palavra);
            
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.getString("palavraSemAcento").equals(palavra)){
                resultSet.close();
                preparedStatement.close();
                conexaoSQLite.desconectar();
                return true;
            }
            
        }catch(SQLException e){
            System.out.println("Erro ao checar palavra: " + e);
           
        }finally{
            
            try{
                resultSet.close();
                preparedStatement.close();
                conexaoSQLite.desconectar();
                
            }catch(SQLException ex){
                System.out.println("Erro ao fechar: " + ex);

            }
        }
        return false;
    }
}
