package controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String absolutePath = sce.getServletContext().getRealPath("/4413Database.db");
        DatabaseUtils.setDbUrl("jdbc:sqlite:" + absolutePath);

        // Optional: Enable foreign keys
        try (Connection conn = DatabaseUtils.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("PRAGMA foreign_keys = ON;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
