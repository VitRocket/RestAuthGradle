package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vitalii on 20.08.18.
 */
@RestController
public class DemoController {

	@RequestMapping(value = "hello")
	public String hello() {
		return "Spring boot Gradle Example";
	}
}