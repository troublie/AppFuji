/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.dao.tabelapreco;

/**
 *
 * @author juliano.lopes
 */
final class TabelaPrecoConstantes {

    static public final String URL = "jdbc:derby://localhost:1527/serviceDB";
    static public final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static public final String USER = "admin";
    static public final String PASSWORD = "fuji123";
    static public final String TABELAPRECO_TABLE_NAME = "tabelapreco";
    static public final String TABELAPRECO_ID_SEQUENCE_NAME = "tabelapreco_id_sequence";

    private TabelaPrecoConstantes() {
    }
}
