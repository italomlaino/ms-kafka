package com.italomlaino.ms.order.logic;

import com.italomlaino.ms.order.customer.Customer;
import com.italomlaino.ms.order.item.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
class SpringRestDataConfig implements RepositoryRestConfigurer {

	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {

		return new RepositoryRestConfigurer() {
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				config.exposeIdsFor(Order.class, Item.class, Customer.class);
			}
		};
	}

}
