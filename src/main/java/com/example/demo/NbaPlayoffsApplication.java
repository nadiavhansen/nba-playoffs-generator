package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.PlayoffsService;
import com.example.demo.service.PlayoffsServiceImpl;

import controller.PlayoffsController;

@SpringBootApplication
public class NbaPlayoffsApplication {

	public static void main(String[] args) {
		PlayoffsService service = new PlayoffsServiceImpl();
		PlayoffsController controller = new PlayoffsController(service);
		controller.startPlayoffs();

		SpringApplication.run(NbaPlayoffsApplication.class, args);
	}

}
