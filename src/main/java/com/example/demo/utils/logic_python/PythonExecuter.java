package com.example.demo.utils.logic_python;

import org.python.util.PythonInterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonExecuter {

    public void executeScript() throws IOException {
        String[] callAndArgs = {"Python", "C:\\Users\\guilherme.bluhm\\Documents\\GitHub\\PoC-UECE\\src\\main\\java\\com\\example\\demo\\utils\\logic_python\\script.py"};
        Process p = Runtime.getRuntime().exec(callAndArgs);

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

        String s;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
    }

}
