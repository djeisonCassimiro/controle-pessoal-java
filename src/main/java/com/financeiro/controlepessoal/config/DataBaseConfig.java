package com.financeiro.controlepessoal.config;

import java.io.FileNotFoundException;

import javax.sql.DataSource;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.financeiro.controlepessoal.entidade.ConexaoBanco;
import com.financeiro.controlepessoal.service.ConexaoService;
import com.google.gson.JsonSyntaxException;

@Configuration
@EnableJpaRepositories(basePackages = { "com.financeiro.controlepessoal.repository" })
@EnableTransactionManagement
@PropertySource(value = "classpath:application.properties")
public class DataBaseConfig {

	@Autowired
	private ConexaoService conexaoService;

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory factory) {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(factory);
		manager.setJpaDialect(new HibernateJpaDialect());
		return manager;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(adapter);
		factory.setPackagesToScan("com.financeiro.controlepessoal.entidade");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		ConexaoBanco conexaoDados = new ConexaoBanco();
		try {
			conexaoDados = conexaoService.montarObjeto("c:/multi/", "configDb.json", "D");
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		dataSource.setUsername(conexaoDados.getUsuario());
		dataSource.setPassword(conexaoDados.getSenha());
		dataSource.setDriverClassName(conexaoDados.getDriver());
		dataSource.setUrl(conexaoDados.getUrl());
		return (DataSource) dataSource;
	}
}
