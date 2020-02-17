package msjavadashboard.msjavadashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import msjavadashboard.msjavadashboard.entity.P7_DashBoardPojo;
import msjavadashboard.msjavadashboard.p7_serviceMethods.P7_DashBoardService;
import msjavadashboard.msjavadashboard.repository.p7_DashBoardRepository;

@Service
public class P7_DashBoardServiceImp  implements P7_DashBoardService {

	
	@Autowired 
	private  p7_DashBoardRepository    p7_DashBoardRepository;
	
	
	@Override
	public List<P7_DashBoardPojo> showAllDashBoardRecords() {
		
		
		//show all records from p7 dashboard table......
		
	  return    p7_DashBoardRepository.findAll();
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
	
	

	
	 
	

	

}
