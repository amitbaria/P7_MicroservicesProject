package msjavadashboard.msjavadashboard.p7_serviceMethods;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import msjavadashboard.msjavadashboard.entity.P7_DashBoardPojo;

public interface P7_DashBoardService {
	
	public Map<String,P7_DashBoardPojo>  showAllDashBoardRecords();
	 public int addOneRecord(P7_DashBoardPojo   record);
	 public void setMultipleRecord(List<P7_DashBoardPojo>  records);
	 public Optional<P7_DashBoardPojo> showSingleRecordById(int id);
	 public int editDashBoardById(int id,P7_DashBoardPojo p7_DashBoardPojo);
	 public int deleteDashBoardById(int id);
	 
}