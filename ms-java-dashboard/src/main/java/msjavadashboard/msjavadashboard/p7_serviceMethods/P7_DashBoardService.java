package msjavadashboard.msjavadashboard.p7_serviceMethods;

import java.util.List;

import msjavadashboard.msjavadashboard.entity.P7_DashBoardPojo;

public interface P7_DashBoardService {
	
	 List<P7_DashBoardPojo>  showAllDashBoardRecords();
	 public int addOneRecord(P7_DashBoardPojo   record);
	 public void setMultipleRecord(List<P7_DashBoardPojo>  records);
}