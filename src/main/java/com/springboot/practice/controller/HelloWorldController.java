package com.springboot.practice.controller;

import com.springboot.practice.model.HelloWorldInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @GetMapping
    public ResponseEntity<String> helloWorld(){
        return new ResponseEntity<>("HelloWorld", HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<String> helloWorldWithInput(@RequestParam(required = false,name = "inputname") String name){
        if(name==null){
            return new ResponseEntity<>("HelloWorld testing", HttpStatus.OK);
        }
        return new ResponseEntity<>("HelloWorld "+name, HttpStatus.OK);
    }


    @GetMapping("/name/{nameinput}")
    public ResponseEntity<String> helloWorldWithPathInput(@PathVariable("nameinput") String input){

        return new ResponseEntity<>("HelloWorld "+input, HttpStatus.OK);
    }

    @PostMapping("/name")
    public ResponseEntity<String> helloworldPostReq(@RequestBody HelloWorldInput helloWorldInput){

        if(helloWorldInput.getName()==null || helloWorldInput.getName().isEmpty()){
            return new ResponseEntity<>("HelloWorld", HttpStatus.OK);
        }

        return new ResponseEntity<>("HelloWorld "+helloWorldInput.getName(), HttpStatus.OK);


    }






}
