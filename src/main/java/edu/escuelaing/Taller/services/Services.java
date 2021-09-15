package edu.escuelaing.Taller.services;

import edu.escuelaing.Taller.nextspring.RequestMapping;

public class Services {

    @RequestMapping("/square")
    public static Double square(String n){
        Double number = Double.parseDouble(n);
        return Math.pow(number, 2);
    }

    @RequestMapping("/squareRoot")
    public static Double squareRoot(String n){
        Double number= Double.parseDouble(n);
        return Math.sqrt(number);
    }

    @RequestMapping("/status")
    public static String status(String param){
        return "Running";
    }
}
