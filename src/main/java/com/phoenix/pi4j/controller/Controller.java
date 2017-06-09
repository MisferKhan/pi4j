package com.phoenix.pi4j.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

@RestController
public class Controller {
	
	private static GpioPinDigitalOutput pin1;
	private static GpioPinDigitalOutput pin2;
	private static GpioPinDigitalOutput pin3;
	private static GpioController gpio = GpioFactory.getInstance();
	@RequestMapping("/")
	public String Greeting(){
		return "V-Sam is up";
	}
	
	@RequestMapping("/light1")
	public String light(){
		
		if(pin1 == null){
			pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);
		}
		pin1.toggle();
		return "OK!";
		}
	@RequestMapping("/light2")
	public String light2(){

		if(pin2 == null){
			pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);
		}
		pin2.toggle();
		return "OK!";
		}
	@RequestMapping("/light3")
	public String light3(){

		if(pin3 == null){
			pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);
		}
		pin3.toggle();
		return "OK!";
		}
	}
