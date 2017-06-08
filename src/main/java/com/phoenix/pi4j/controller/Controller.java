package com.phoenix.pi4j.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

@RestController
public class Controller {
	
	private static GpioPinDigitalOutput pin;

	@RequestMapping("/")
	public String Greeting(){
		return "V-Sam is up";
	}
	
	@RequestMapping("/light1")
	public String light1(){
		
		if(pin == null){
			GpioController gpio = GpioFactory.getInstance();		
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);						
		}
		pin.toggle();
		return "OK!";
		}
	@RequestMapping("/light2")
		public String light2(){			
			if(pin == null){
				GpioController gpio = GpioFactory.getInstance();		
				pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);						
			}
			pin.toggle();
			return "OK!";
			}
	@RequestMapping("/light3")
	public String light3(){		
		if(pin == null){
			GpioController gpio = GpioFactory.getInstance();		
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03);						
		}
		pin.toggle();
		return "OK!";
		}
	}
