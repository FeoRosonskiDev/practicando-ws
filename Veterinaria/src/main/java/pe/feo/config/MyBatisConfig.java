package pe.feo.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
//TODO: cambiar por su paquete
@MapperScan(basePackages = "pe.feo.persistence.repository")
public class MyBatisConfig {
	
	@Value("#{ environment['persistence.db.driverClass'] }")
	private String driverClass;

	@Value("#{ environment['persistence.db.url'] }")
	private String url;

	@Value("#{ environment['persistence.db.username'] }")
	private String username;

	@Value("#{ environment['persistence.db.password'] }")
	private String password;

	@Value("#{ environment['persistence.db.domain'] }")
	private String domain;

	@Bean
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(this.driverClass);
		dataSource.setJdbcUrl(this.url);
		dataSource.setUsername(this.username);
		dataSource.setPassword(this.password);
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(this.dataSource());
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(this.dataSource());
		sessionFactory.setTypeAliasesPackage(this.domain);
		return sessionFactory;
	}

}
