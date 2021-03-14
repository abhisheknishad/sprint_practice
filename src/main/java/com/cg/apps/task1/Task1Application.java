package com.cg.apps.task1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.apps.task1.customerms.ui.CustomerUI;
//import com.cg.apps.task1.item.ui.ItemUI;

@SpringBootApplication
public class Task1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Task1Application.class, args);
		CustomerUI customerUI = context.getBean(CustomerUI.class);
		customerUI.start();
		
		/*ItemUI itemUI = context.getBean(ItemUI.class);
		itemUI.start();*/
	}
	}

