package com.library.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.service.ItemService;
import com.library.service.ItemTypeService;

@Component
public class InventoryUtil {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemTypeService itemTypeService;
	
	public static final List<String> inventoryLines;
	
	 static  {
			Path path;
	        Stream<String> lines = null;
	        try {
	            path = Paths.get(Thread.currentThread().
	            		getContextClassLoader().getResource("initial_inventory.csv").toURI());
	            lines = Files.lines(path);
	            inventoryLines= lines.collect(Collectors.toList());
	            lines.close();
	        } catch (URISyntaxException | IOException e) {
	            throw new RuntimeException(e);
	        }
	}
	
	
	public void registerInitialItemTypes() {
		Set<String> uniqueItemTypes =  inventoryLines.stream().map(each -> each.split(",")[0]).collect(Collectors.toSet());
		for(String type: uniqueItemTypes) {
			itemTypeService.addItemType(type);
		}
	}
	
	public void registerInitialItems() {
		for(String items: inventoryLines) {
			String[] splitItems = items.split(",");
			itemService.addItem(splitItems[1], splitItems[0]);
		}
	}
	
	
	
	
}
