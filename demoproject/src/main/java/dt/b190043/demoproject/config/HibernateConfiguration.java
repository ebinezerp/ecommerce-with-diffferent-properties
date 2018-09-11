package dt.b190043.demoproject.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("dt.b190043.demoproject")
@EnableTransactionManagement
public class HibernateConfiguration
{
	
	   @Bean
	   public DataSource getDataSource()
	   {
		    BasicDataSource dataSource=new BasicDataSource();
		    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		    dataSource.setUrl("jdbc:mysql://localhost:3306/demoproject");
		    dataSource.setUsername("root");
		    dataSource.setPassword("root");
		    
		    return dataSource;
	   }
	   
	   
	   private Properties getProperties()
	   {
		   Properties properties=new Properties();
		   properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		   properties.setProperty("hibernate.hbm2ddl.auto", "update");
		   properties.setProperty("hibernate.show_sql", "true");
		   
		   return properties;
	   }
	   
	   @Bean("sessionFactory")
	   public SessionFactory getSessionFactory(DataSource dataSource)
	   {
		   LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(dataSource);
		   localSessionFactoryBuilder.addProperties(getProperties());
		   localSessionFactoryBuilder.scanPackages("dt.b190043.demoproject.model");
		   return localSessionFactoryBuilder.buildSessionFactory();
	   }
	   
	
	   
	   
	   @Bean
	   public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	   {
		   return new HibernateTransactionManager(sessionFactory);
	   }
}