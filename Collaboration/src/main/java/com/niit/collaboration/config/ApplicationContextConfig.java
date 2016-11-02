package com.niit.collaboration.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaboration.dao.BlogDAOImpl;
import com.niit.collaboration.dao.ForumDAOImpl;
import com.niit.collaboration.dao.FriendDAOImpl;
import com.niit.collaboration.dao.JobDAOImpl;
import com.niit.collaboration.dao.NewsfeedDAOImpl;
import com.niit.collaboration.dao.UserDAOImpl;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.Forum;
import com.niit.collaboration.model.Friend;
import com.niit.collaboration.model.Job;
import com.niit.collaboration.model.Newsfeed;
import com.niit.collaboration.model.User;

@Configuration
@ComponentScan("com.niit.collaboration")
@EnableTransactionManagement
public class ApplicationContextConfig {	

	@Bean(name = "dataSource")
	public DataSource getOracleDataSource() {
		DriverManagerDataSource  dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
 		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/xe");

	/*	Properties connProperties = new Properties();
		connProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		connProperties.setProperty("hibernate.show_sql", "true");
		connProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		connProperties.setProperty("hibernate.format_sql", "true");
		connProperties.setProperty("hibernate.jdbc.use_get_generated_keys", "true");*/

		dataSource.setUsername("coldb");
		dataSource.setPassword("coldb");

		return dataSource;
	}

	@Autowired
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");	
		properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactroy(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(Forum.class);
		sessionBuilder.addAnnotatedClass(Job.class);
		sessionBuilder.addAnnotatedClass(Newsfeed.class);
		sessionBuilder.addAnnotatedClass(Friend.class);

		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Autowired
	@Bean(name = "userDAO")
	public UserDAOImpl getUserDAO(SessionFactory sessionFactory) {
		return new UserDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "blogDAO")
	public BlogDAOImpl getBlogDAO(SessionFactory sessionFactory) {
		return new BlogDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "forumDAO")
	public ForumDAOImpl getForumDAO(SessionFactory sessionFactory) {
		return new ForumDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "jobDAO")
	public JobDAOImpl getJobDAO(SessionFactory sessionFactory) {
		return new JobDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "newsfeedDAO")
	public NewsfeedDAOImpl getNewsfeedDAO(SessionFactory sessionFactory) {
		return new NewsfeedDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "friendDAO")
	public FriendDAOImpl getFriendDAO(SessionFactory sessionFactory) {
		return new FriendDAOImpl(sessionFactory);
	}
}