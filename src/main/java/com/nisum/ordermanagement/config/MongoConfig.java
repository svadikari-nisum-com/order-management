/**
 * 
 */
package com.nisum.ordermanagement.config;

import javax.sql.DataSource;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.service.common.MongoServiceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author SVadikari
 *
 */
@Configuration
public class MongoConfig {

	@Bean
	public MongoDbFactory mongoDbFactory() {
		MongoDbFactory mongoDb = null;
		try {
			CloudFactory cloudFactory = new CloudFactory();
			Cloud cloud = cloudFactory.getCloud();
			MongoServiceInfo serviceInfo = (MongoServiceInfo) cloud.getServiceInfo("my-mongodb");
			String serviceId = serviceInfo.getId();
			mongoDb = (MongoDbFactory) cloud.getServiceConnector(serviceId, DataSource.class, null);
		} catch (org.springframework.cloud.CloudException ce) {
			return mongoDb;
		}
		return mongoDb;
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoDbFactory());
	}
}
