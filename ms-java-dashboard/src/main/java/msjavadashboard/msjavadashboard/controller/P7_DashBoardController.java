package msjavadashboard.msjavadashboard.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import msjavadashboard.msjavadashboard.service.*;
import msjavadashboard.msjavadashboard.entity.*;
@RestController
@RequestMapping("/api")
public class P7_DashBoardController {
	
	 @Autowired
	 private P7_DashBoardServiceImp  P7_DashBoardServiceImp;
	 
	 private final org.jboss.logging.Logger LOGGER = LoggerFactory.logger(this.getClass());
	
	 
	 
	 
	 
	 
     @GetMapping("/dashboard")
	 public  ResponseEntity   getAllDashboardData()	{
	
	  Map<String,P7_DashBoardPojo> dashboardRecords =P7_DashBoardServiceImp.showAllDashBoardRecords();
	  if(dashboardRecords.size()>0)
	  {
		LOGGER.info("Show all records");
		return  new ResponseEntity(P7_DashBoardServiceImp.showAllDashBoardRecords(), HttpStatus.OK);
	      
	  }
		else
	  {
		return   new ResponseEntity("Record not Found", HttpStatus.OK); 
	  }
	}
     
     
     @PostMapping(value="/dashboard", consumes="application/json")
     public  ResponseEntity<P7_DashBoardPojo>   addSingleRecordInDashBoard(@RequestBody P7_DashBoardPojo p7_DashBoardPojo)
     { 	
    	 
    	 LOGGER.info(p7_DashBoardPojo.getIs_deleted()); 
    	 LOGGER.info(p7_DashBoardPojo.getIs_primary()); 
    	
    	 p7_DashBoardPojo.setCreated_on(new Date());
    	 p7_DashBoardPojo.setModified_on(new Date());
    	 
    	 LOGGER.info("Default value====="+p7_DashBoardPojo.getIs_default()); 
    	 
    	 
    	 if(p7_DashBoardPojo.getIs_default()==null ||p7_DashBoardPojo.getIs_default()=="".trim())
    		   p7_DashBoardPojo.setIs_default("0");
    	   else
	           p7_DashBoardPojo.setIs_default(p7_DashBoardPojo.getIs_default());
    	 int generatedNewPrimaryKey =  P7_DashBoardServiceImp.addOneRecord(p7_DashBoardPojo);
    	 
    	
    	  if(generatedNewPrimaryKey!=0)
    	  {
    		  
    		  return   new ResponseEntity(generatedNewPrimaryKey  + "   Saved  Successfully", HttpStatus.OK); 
    	  }
    	  else
    	  {
    		  return   new ResponseEntity("Record not  Saved", HttpStatus.OK); 
    	  }
    	 
     }
     
     //  Fetch Single DashBoard Record
     @GetMapping(value="/dashboard/{dashboardId}")
     public  ResponseEntity  getDashBoardById(@PathVariable("dashboardId") int dashboardId)
     {
    	 
        Optional< P7_DashBoardPojo>	record= P7_DashBoardServiceImp.showSingleRecordById(dashboardId);
    
        LOGGER.info("Record Available......"+record.isPresent()); 
    	  if(record.isPresent())
    	  {
    		     
    		 Map<String,P7_DashBoardPojo> map=new HashMap();
    		 map.put("data",record.get());
    		  LOGGER.info("Record Available...yes......."); 
    		 
    		 return new ResponseEntity(map,HttpStatus.OK);
    	     }
    	  else
    	    return  new ResponseEntity<Object>("DashBoard Not Found",HttpStatus.OK);
     }
     
     
     //  Edit DashBoard Record
     @PutMapping(value="/dashboard/{dashboardId}", consumes="application/json")
     public  ResponseEntity<P7_DashBoardPojo>   editDashBoardById(@PathVariable("dashboardId") int dashboardId,
    		                                                      @RequestBody P7_DashBoardPojo  p7_DashBoardPojo
    		                                                       )
     	{
    	      LOGGER.info("Record Available...yes......."+dashboardId); 
    	      LOGGER.info("Record Available...from request......"+p7_DashBoardPojo.getName());
		      int pk	= P7_DashBoardServiceImp.editDashBoardById(dashboardId, p7_DashBoardPojo);
		      if(pk!=0)
		    	  return new ResponseEntity(pk  +  "    Updated Successfully",HttpStatus.OK);
		      else
		    	  return new ResponseEntity("DashBoard Not found",HttpStatus.OK);
			   	     
		   	    
    	 
        }
     
     
     @DeleteMapping(value="/dashboard/{dashboardId}")
     public  ResponseEntity<P7_DashBoardPojo>   deleteDashBoardById(@PathVariable("dashboardId") int dashboardId)
    		 {
    	                if(P7_DashBoardServiceImp.deleteDashBoardById(dashboardId)!=0)
    	               	   return new ResponseEntity(dashboardId  +  "    Deleted Successfully",HttpStatus.OK);
    	                else
  	       		    	   return new ResponseEntity("DashBoard Id Not found",HttpStatus.OK);
  	       			   	     
  	                	
    	 
    		 }
     
                     
     
}
