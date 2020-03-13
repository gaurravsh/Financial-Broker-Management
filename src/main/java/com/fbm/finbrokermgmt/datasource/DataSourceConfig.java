package com.fbm.finbrokermgmt.datasource;

import java.sql.SQLException;
import java.util.Base64;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:db-connection.properties")
public class DataSourceConfig {

	@Value("${myspring.datasource.encodedpassword}")
	private String encodedPassword;

	@Bean(name = "mysql-aws")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource getDataSource() throws SQLException {
		return DataSourceBuilder.create().password(decodePassword(encodedPassword)).build();
	}

	private String decodePassword(String password) {
		return new String(Base64.getDecoder().decode(password));
	}

}