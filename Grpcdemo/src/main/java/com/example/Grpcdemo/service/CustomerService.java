package com.example.Grpcdemo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import grpc.customerProto.CustomerProtos;
import grpc.customerProto.CustomerProtos.Customer;


interface CustomerRepository
{
	CustomerProtos.Customer findById(int id);
    List<CustomerProtos.Customer>  findAll();
}


@Service
public class CustomerService implements CustomerRepository {
	
	 static Map<Integer, CustomerProtos.Customer> customers;
	 static List<CustomerProtos.Customer> customerValue;
	 
	 static {
	
	 customers = new ConcurrentHashMap<>();
	 
	 customerValue=new ArrayList<>();
    
    for(int i=1;i<=20;i++)
    {
 	   CustomerProtos.Customer cObject	  = customer(i, "Chris", "Richardson","11222222","12.10.1988",
 			                                         "Shri","Shmt","Graduate","Mohali","London",
 			                                         "ShopKeeper","HouseMaker",30,200333,
 			   
 			   Arrays.asList("crichardson@email.com","Angad@gmai.com"));  
 	           customerValue.add(cObject);
 	   
    }
           
    customerValue.forEach(k -> customers.put(k.getId(), k));
}

	@Override
	public CustomerProtos.Customer findById(int id) {
		return customers.get(id);
	}

	@Override
	public List<Customer> findAll() {
            
	List<CustomerProtos.Customer>	cust= customers.entrySet().stream()
		                    .map(Map.Entry::getValue)
		                    .collect(Collectors.toList());
		System.out.println(".............................."+cust.size()+" ");
		
		CustomerProtos.Customer  cust1=cust.get(5);
		System.out.println(".............................."+cust.size()+" "+cust1.getDob()+ " "+cust1.getFirstName());
		  return cust;
		
	}
	 
	 private static CustomerProtos.Customer customer(int id, String f, String l,String ph,String dob, 
             String fatherName, String motherName, String qualification, String presenentAddress, String permanentAddress,
             String fatherocupation, String motherOccupataion,int quantity,int totalBil3,
             Collection<String> emails) 
        {



				Collection<CustomerProtos.Customer.EmailAddress> emailAddresses =
				emails.stream().map(e -> CustomerProtos.Customer.EmailAddress.newBuilder()
				.setType(CustomerProtos.Customer.EmailType.PROFESSIONAL)
				.setEmail(e).build())
				.collect(Collectors.toList());
				
				
				
				
				return CustomerProtos.Customer.newBuilder()
				.setFirstName(f)
				.setLastName(l)
				.setId(id)
				.setPhoneNumber(ph)
				.setDob(dob)
				.setFatherName(fatherName)
				.setMotherName(motherName)
				.setQualification(qualification)
				.setPresentAddress(presenentAddress)
				.setPermanentAddress(permanentAddress)
				.setFatherOccupation(fatherocupation)
				.setMotherOccupation(motherOccupataion)
				.setQuantityPurchased(quantity)
				.setTotalBill(totalBil3)
				.addAllEmail(emailAddresses)
				.build();





} 
	 
	 

	
	
	
}
