package msjavadashboard.msjavadashboard.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import msjavadashboard.msjavadashboard.entity.P7_DashBoardPojo;
import msjavadashboard.msjavadashboard.p7_serviceMethods.P7_DashBoardService;
import msjavadashboard.msjavadashboard.repository.p7_DashBoardRepository;

@Service
public class P7_DashBoardServiceImp  implements P7_DashBoardService {

	
	@Autowired 
	private  p7_DashBoardRepository    p7_DashBoardRepository;
	
	 private final org.jboss.logging.Logger LOGGER = LoggerFactory.logger(this.getClass());
	 
	@Override
	public Map<String,P7_DashBoardPojo> showAllDashBoardRecords() {
		
		//show all records from p7 dashboard table......
		
	    Map p=	new HashMap();
	    p.put("data", p7_DashBoardRepository.findAll());
	    return p;
	}


	@Override
	public int addOneRecord(P7_DashBoardPojo record) {
		P7_DashBoardPojo p7_DashBoardPojo =p7_DashBoardRepository.save(record);
		int primarykey= (p7_DashBoardPojo!=null)?p7_DashBoardPojo.getId():0 ;
		return primarykey;
		 
	}


	@Override
	public void setMultipleRecord(List<P7_DashBoardPojo> records) {
		// TODO Auto-generated method stub
		
		
	}


	@Override
	public Optional<P7_DashBoardPojo> showSingleRecordById(int id) {
		  
		return  p7_DashBoardRepository.findById(id);
		 
		   
		}


	

	@Override
	public int deleteDashBoardById(int id) {
		
		Optional<P7_DashBoardPojo>  existingEntity=	showSingleRecordById(id);
		if(existingEntity.isPresent())
		{
		
		      p7_DashBoardRepository.deleteById(id);
		      return 1;
		}
		else
		return 0;
		
		
	}


	@Override
	public int editDashBoardById(int id, P7_DashBoardPojo p7_DashBoardPojo) {
		
		Optional<P7_DashBoardPojo>  existingEntity=	showSingleRecordById(id);
		if(existingEntity.isPresent())
		{
			
			P7_DashBoardPojo	existingEntityNeedsToUpdate=existingEntity.get();
			existingEntityNeedsToUpdate.setName(p7_DashBoardPojo.getName());
			existingEntityNeedsToUpdate.setCode(p7_DashBoardPojo.getCode());
			existingEntityNeedsToUpdate.setIs_primary(p7_DashBoardPojo.getIs_primary());  
			existingEntityNeedsToUpdate.setIs_default(p7_DashBoardPojo.getIs_default());
			existingEntityNeedsToUpdate.setIs_deleted(p7_DashBoardPojo.getIs_deleted());  
			existingEntityNeedsToUpdate.setModified_on(new Date());
            LOGGER.info("Data set properly.........");
            existingEntityNeedsToUpdate = p7_DashBoardRepository.save(existingEntityNeedsToUpdate);
			
            return   existingEntityNeedsToUpdate.getId();
             
			
			
			
		}
		
		
		return 0;
	}
		    
		
		
	}
	
	

