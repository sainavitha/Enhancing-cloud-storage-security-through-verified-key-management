/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FileDownload;

import DatabaseConnectivity.Dbconn;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class download {
   public static void updator(String fileName, String userName) throws Exception{
        try {
            Connection conn = new Dbconn().getConnection();
            Statement smt = conn.createStatement();
            smt.executeUpdate("insert into f_download (file_name, file_owner)values('"+fileName+"','"+userName+"')");
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }

