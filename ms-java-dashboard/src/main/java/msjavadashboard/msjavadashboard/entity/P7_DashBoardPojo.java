package msjavadashboard.msjavadashboard.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;




@Entity
@Table(name="p7_dashboard_new")
public class P7_DashBoardPojo {
	
	

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
  	 private int id; 
     
     
     @Column(name="NAME")
	 private String n;
     @Column(name="CODE")
	 private String 	code;
     @Column(name="IS_PRIMARY")
	 private String 	is_primary;
     @Column(name="USER_ID")
	 private String 	user_id;
     @Column(name="IS_DELETED")
	 private int	is_deleted;
     
     @Column(name="CREATED_ON")
	 private Date 	created_on;
     @Column(name="MODIFIED_ON")
	 private Date	modified_on;
     @Column(name="IS_DEFAULT")
	 private String is_default;
	 
	 public int getId() {
	  return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
		System.out.println(n);
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
		System.out.println(code);
	}
	public String getIs_primary() {
		return is_primary;
	}
	public void setIs_primary(String is_primary) {
		this.is_primary = is_primary;
		System.out.println(is_primary);
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
		System.out.println(user_id);
		
	}
	public int getIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
		System.out.println(is_deleted);
	}
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	public Date getModified_on() {
		return modified_on;
	}
	public void setModified_on(Date modified_on) {
		this.modified_on = modified_on;
	}
	public String getIs_default() {
		return is_default;
	}
	public void setIs_default(String is_default) {
		this.is_default = is_default;
	}
	
}


