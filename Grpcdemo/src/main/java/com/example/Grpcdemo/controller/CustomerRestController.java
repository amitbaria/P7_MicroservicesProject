package com.example.Grpcdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.http.converter.protobuf.ProtobufJsonFormatHttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Grpcdemo.service.CustomerService;

import grpc.customerProto.CustomerProtos;
import grpc.customerProto.CustomerProtos.Customer;
import grpc.customerProto.CustomerProtos.Customers;

@RestController
class CustomerRestController {

@Autowired
private CustomerService customerRepository;

@Bean
//@Primary
ProtobufHttpMessageConverter protobufHttpMessageConverter() {
    return new ProtobufHttpMessageConverter();
}

//@RequestMapping("/customers/{id}")
//CustomerProtos.Customer customer(@PathVariable Integer id) {
//    return this.customerRepository.findById(id);
//}

   @RequestMapping(value="/customers/{id}",produces = "application/x-protobuf")
  public  CustomerProtos.Customer customer(@PathVariable Integer id) {
	   
	 
    return this.customerRepository.findById(id);
    
   }
@RequestMapping(value="/allCustomers/",produces = "application/x-protobuf")
public  Customers getAllCustomer() {
     //return  this.customerRepository.findAll().get(19);
    // return  this.customerRepository.findAll(); 
    return Customers.newBuilder().addAllCustomer(this.customerRepository.findAll()).build();
    
}

}
