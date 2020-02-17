package msjavadashboard.msjavadashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



import msjavadashboard.msjavadashboard.service.*;
import msjavadashboard.msjavadashboard.entity.*;
@Controller
@RequestMapping("/api")
public class P7_DashBoardController {
	
	 @Autowired
	 private P7_DashBoardServiceImp  P7_DashBoardServiceImp;
	 
	
	
     @GetMapping("/dashboard")
	 public  ResponseEntity   getAllDashboardData()	{
	
	 List<P7_DashBoardPojo> dashboardRecords =P7_DashBoardServiceImp.showAllDashBoardRecords();
	  if(dashboardRecords.size()>0)
		return  new ResponseEntity(P7_DashBoardServiceImp.showAllDashBoardRecords(), HttpStatus.OK);
	  else
	  {
		return   new ResponseEntity("Record not Found", HttpStatus.OK); 
	  }
	}
     
     @PostMapping(value="/addDashBoardRecord" ,  consumes="application/json")
     public  ResponseEntity<P7_DashBoardPojo>   addSingleRecordInDashBoard(@RequestBody P7_DashBoardPojo p7_DashBoardPojo)
     {
    	 int generatedNewPrimaryKey =  P7_DashBoardServiceImp.addOneRecord(p7_DashBoardPojo);
    	 
    	System.out.println( p7_DashBoardPojo.getCode());
    	
    	System.out.println( p7_DashBoardPojo.getCode());
    	System.out.println( p7_DashBoardPojo.getIs_deleted());
    	System.out.println( p7_DashBoardPojo.getUser_id());
    
    	  if(generatedNewPrimaryKey!=0)
    	  {
    		  
    		  return   new ResponseEntity(generatedNewPrimaryKey+ "Saved", HttpStatus.OK); 
    	  }
    	  else
    	  {
    		  return   new ResponseEntity("Record not  Saved", HttpStatus.OK); 
    		  
    		  
    	  }
    	 
     }
     
}
