package com.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vitalii on 20.08.18.
 */
@RestController
public class DemoController {

	@GetMapping("info")
	public String hello() {
		return "Spring boot Gradle Example";
	}

}