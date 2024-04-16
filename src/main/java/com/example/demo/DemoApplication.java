package com.example.demo;

import com.example.demo.utils.logic_python.PythonExecuter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.script.*;
import java.io.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException, ScriptException {
		/*
		PythonExecuter exec = new PythonExecuter();
		exec.executeScript();
		*/
		SpringApplication.run(DemoApplication.class, args);
	}

}
