package com.tatamotors.dealers;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.tatamotors.dealers.dto.StockDto;

@EnableFeignClients
@SpringBootApplication
public class AutomobileDealerFeignApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(AutomobileDealerFeignApplication.class, args);
		StockApiService stockApiService = context.getBean(StockApiService.class);
		
	
		for (int i = 0; i < 10; i++) {
			List<StockDto> stocks = stockApiService.getStocks("break pad");
			stocks.stream().forEach(System.out::println);
		}
	}

}
