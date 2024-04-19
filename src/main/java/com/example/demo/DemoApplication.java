package com.example.demo;

import com.example.demo.utils.misc.ReadFileXLSX;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.script.ScriptException;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException, ScriptException {
		/*
		PythonExecuter exec = new PythonExecuter();
		exec.executeScript();
		*/
		SpringApplication.run(DemoApplication.class, args);

		//ReadFileXLSX excel = new ReadFileXLSX();
		//excel.getData();

	}

}
