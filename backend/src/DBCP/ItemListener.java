package DBCP;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ItemListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/thogakade");
        bds.setUsername("root");
        bds.setPassword("1234");

        bds.setInitialSize(2);
        bds.setMaxTotal(2);

        sce.getServletContext().setAttribute("servlet.Item",bds);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
