package com.tatamotors.dealers;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tatamotors.dealers.dto.StockDto;

@FeignClient(name = "INVENTORY-MGMT-SERVICE")
public interface StockApiService {

	@GetMapping(value="/stock/{stockName}/available",produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<StockDto> getStocks(@PathVariable ("stockName") String stockName);
	
	@GetMapping(value="/stock/transport", produces= {MediaType.APPLICATION_JSON_VALUE})
	public String getTransportInfo();
	
}
