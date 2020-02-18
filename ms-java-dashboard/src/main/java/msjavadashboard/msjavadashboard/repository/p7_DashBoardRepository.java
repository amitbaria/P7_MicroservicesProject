package msjavadashboard.msjavadashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import msjavadashboard.msjavadashboard.entity.P7_DashBoardPojo;

@Repository
public interface p7_DashBoardRepository  extends JpaRepository<P7_DashBoardPojo,Integer> {
	
	   

}