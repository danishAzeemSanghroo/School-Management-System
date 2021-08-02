/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManager;


import BeanClasses.ClassBean;
import BeanClasses.MonthBean;
import BeanClasses.SectionBean;
import BeanClasses.SemesterBean;
import BeanClasses.SessionBean;
import BeanClasses.StudentBean;
import BeanClasses.StudentPromotionBean;
import BeanClasses.SubjectsBean;
import BeanClasses.WingBean;

import EnDeCoder.Decoder;

import java.awt.FileDialog;
import java.io.FileOutputStream;
import java.io.PrintStream;
//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.year;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author Danish
 */
public class DatabaseManager {
   

    
    //usindh connection starts
	private static Connection con;
  
	static{
		try{
			init();
		}catch(Exception e){
		}
	}
	private static void init()throws Exception{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:school");
                System.out.println("Connection succesfull");
	}
     // usindh connection ends
//================================WING STARTS HERE======================================================================================        
	public static int addWing(String wingName,String remarks)throws Exception{
		String query="INSERT into wing (wing_name,remarks) values ('"+wingName+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int deleteWing(String wingId)throws Exception{
		String query="DELETE from wing where wing_id="+wingId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}    
	public static int updateWing(String wingId,String wingName,String remarks)throws Exception{
		String query="UPDATE wing set wing_name='"+wingName+"' , remarks='"+remarks+"' where wing_id="+wingId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}        
	public static Vector getWing()throws Exception{
		String query="select * from wing";
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
			while(result.next()){
				WingBean bean=new WingBean();	
				bean.setWingId( result.getInt("wing_id") );
				bean.setWingName( result.getString("wing_name") );
				bean.setRemarks( result.getString("remarks") );			
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}       
     public static WingBean getWingById(String wingId){
        
            WingBean bean = null;
            ResultSet result = null;
            try{
                
                String query = "select * from wing where wing_id = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, wingId);
                
                result = pstmt.executeQuery();
                System.out.println(query);
                if(result.next()){
                
                    bean = new WingBean();
                    bean.setWingId(result.getInt("wing_id"));
                    bean.setWingName(result.getString("wing_name"));
                    bean.setRemarks(result.getString("remarks"));
                }
                
                
            }catch(Exception e){
            
                e.printStackTrace();
                
            }
         return bean;   
 }                  
        
//=====================================WING ENDS HERE====================================================================================        

//================================CLASS STARTS HERE======================================================================================        
	public static int addClass(int wingId,String className,String fees,String remarks)throws Exception{
		String query="INSERT into class (wing_id,class_name,fees,remarks) values ("+wingId+",'"+className+"','"+fees+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int deleteClass(String classId)throws Exception{
		String query="DELETE from class where class_id="+classId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}    
	public static int updateClass(String classId,String className,String fees,String remarks)throws Exception{
		String query="UPDATE class set class_name='"+className+"' , fees='"+fees+"' , remarks='"+remarks+"' where class_id="+classId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}        
	public static Vector getClasss(int wingId)throws Exception{
		String query="select * from class where wing_id="+wingId;
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
			while(result.next()){
				ClassBean bean=new ClassBean();
                                bean.setWingId(result.getInt("wing_id"));
				bean.setClassId( result.getInt("class_id") );
				bean.setClassName( result.getString("class_name") );
                                bean.setFees(result.getString("fees"));
				bean.setRemarks( result.getString("remarks") );			
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}       
     public static ClassBean getClassById(String classId){
        
            ClassBean bean = null;
            ResultSet result = null;
            try{
                
                String query = "select * from class where class_id = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, classId);
                
                result = pstmt.executeQuery();
                System.out.println(query);
                if(result.next()){
                
                    bean = new ClassBean();
                    bean.setClassId(result.getInt("class_id"));
                    bean.setClassName(result.getString("class_name"));
                    bean.setFees(result.getString("fees"));
                    bean.setRemarks(result.getString("remarks"));
                }
                
                
            }catch(Exception e){
            
                e.printStackTrace();
                
            }
         return bean;   
 }                  
        
//=====================================CLASS ENDS HERE====================================================================================         
     
//================================SECTION STARTS HERE======================================================================================        
	public static int addSection(int classId,String sectionName,String remarks)throws Exception{
		String query="INSERT into section (class_id,section_name,remarks) values ("+classId+",'"+sectionName+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int deleteSection(String sectionId)throws Exception{
		String query="DELETE from section where section_id="+sectionId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}    
	public static int updateSection(String sectionId,String sectionName,String remarks)throws Exception{
		String query="UPDATE section set section_name='"+sectionName+"' , remarks='"+remarks+"' where section_id="+sectionId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}        
	public static Vector getSection(int classId)throws Exception{
		String query="select * from section where class_id="+classId;
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
			while(result.next()){
				SectionBean bean=new SectionBean();
                              //  bean.setWingId(result.getInt("wing_id"));
				bean.setClassId( result.getInt("class_id") );
                                bean.setSectionId(result.getInt("section_id"));
				bean.setSectionName( result.getString("section_name") );
				bean.setRemarks( result.getString("remarks") );			
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}       
     public static SectionBean getSectionById(String sectionId){
        
            SectionBean bean = null;
            ResultSet result = null;
            try{
                
                String query = "select * from section where section_id = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, sectionId);
                
                result = pstmt.executeQuery();
                
                if(result.next()){
                
                    bean = new SectionBean();
                    bean.setSectionId(result.getInt("section_id"));
                    bean.setSectionName(result.getString("section_name"));
                    bean.setRemarks(result.getString("remarks"));
                }
                
                
            }catch(Exception e){
            
                e.printStackTrace();
                
            }
         return bean;   
 }                  
        
//=====================================SECTION ENDS HERE====================================================================================         

//================================MONTH STARTS HERE======================================================================================        
	public static int addMonth(int classId,String monthName,String remarks)throws Exception{
		String query="INSERT into months (class_id,months,remarks) values ("+classId+",'"+monthName+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int deleteMonth(String monthId)throws Exception{
		String query="DELETE from months where month_id="+monthId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}    
	public static int updateMonth(String monthId,String monthName,String remarks)throws Exception{
		String query="UPDATE months set months='"+monthName+"' , remarks='"+remarks+"' where month_id="+monthId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}        
	public static Vector getMonth(int classId)throws Exception{
		String query="select * from months where class_id="+classId;
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
			while(result.next()){
				MonthBean bean=new MonthBean();
                                //bean.setWingId(result.getInt("wing_id"));
				bean.setClassId( result.getInt("class_id") );
                                bean.setMonthId(result.getInt("month_id"));
				bean.setMonthName( result.getString("months") );
				bean.setRemarks( result.getString("remarks") );			
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}       
     public static MonthBean getMonthById(String monthId){
        
            MonthBean bean = null;
            ResultSet result = null;
            try{
                
                String query = "select * from months where month_id = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, monthId);
                
                result = pstmt.executeQuery();
                
                if(result.next()){
                
                    bean = new MonthBean();
                    bean.setMonthId(result.getInt("month_id"));
                    bean.setMonthName(result.getString("months"));
                    bean.setRemarks(result.getString("remarks"));
                }
                
                
            }catch(Exception e){
            
                e.printStackTrace();
                
            }
         return bean;   
 }                  
        
//=====================================MONTH ENDS HERE====================================================================================         
          
//================================SUBJECTS STARTS HERE======================================================================================        
	public static int addSubjects(int classId,String subjectsName,String remarks)throws Exception{
		String query="INSERT into subjects (class_id,subjects,remarks) values ("+classId+",'"+subjectsName+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int deleteSubjects(String subjectsId)throws Exception{
		String query="DELETE from subjects where subject_id="+subjectsId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}    
	public static int updateSubjects(String subjectsId,String subjectsName,String remarks)throws Exception{
		String query="UPDATE subjects set subjects='"+subjectsName+"' , remarks='"+remarks+"' where subject_id="+subjectsId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}        
	public static Vector getSubjects(int classId)throws Exception{
		String query="select * from subjects where class_id="+classId;
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
			while(result.next()){
				SubjectsBean bean=new SubjectsBean();
                                
				bean.setClassId( result.getInt("class_id") );
                                bean.setSubjectId(result.getInt("subject_id"));
				bean.setSubjects( result.getString("subjects") );
				bean.setRemarks( result.getString("remarks") );			
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}       
     public static SubjectsBean getSubjectsById(String subjectsId){
        
            SubjectsBean bean = null;
            ResultSet result = null;
            try{
                
                String query = "select * from subjects where subject_id = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, subjectsId);
                
                result = pstmt.executeQuery();
                
                if(result.next()){
                
                    bean = new SubjectsBean();
                    bean.setSubjectId(result.getInt("subject_id"));
                    bean.setSubjects(result.getString("subjects"));
                    bean.setRemarks(result.getString("remarks"));
                }
                
                
            }catch(Exception e){
            
                e.printStackTrace();
                
            }
         return bean;   
 }                  
        
//=====================================SUBJECTS ENDS HERE====================================================================================         

//================================SEMESTER STARTS HERE======================================================================================        
	public static int addSemester(int classId,String semesterName,String semesterDate,String remarks)throws Exception{
            if(semesterDate!=null)
                    semesterDate="#"+semesterDate+"#";
            else 
                semesterDate=null;            
		String query="INSERT into semester (class_id,semester,semester_date,remarks) values ("+classId+",'"+semesterName+"',"+semesterDate+",'"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int deleteSemester(String semesterId)throws Exception{
		String query="DELETE from semester where semester_id="+semesterId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}    
	public static int updateSemester(String semesterId,String semesterName,String semesterDate,String remarks)throws Exception{
            if(semesterDate!=null)
                    semesterDate="#"+semesterDate+"#";
            else 
                semesterDate=null;
		String query="UPDATE semester set semester='"+semesterName+"', semester_date="+semesterDate+", remarks='"+remarks+"' where semester_id="+semesterId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}        
	public static Vector getSemester(int classId)throws Exception{
		String query="select * from semester where class_id="+classId;
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
			while(result.next()){
				SemesterBean bean=new SemesterBean();
                                
				bean.setClassId( result.getInt("class_id") );
                                bean.setSemesterId(result.getInt("semester_id"));
				bean.setSemester( result.getString("semester") );
                                bean.setSemesterDate(result.getDate("semester_date"));
				bean.setRemarks( result.getString("remarks") );			
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}       
     public static SemesterBean getSemesterById(String semesterId){
        
            SemesterBean bean = null;
            ResultSet result = null;
            try{
                
                String query = "select * from semester where semester_id = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, semesterId);
                
                result = pstmt.executeQuery();
                
                if(result.next()){
                
                    bean = new SemesterBean();
                    bean.setSemesterId(result.getInt("semester_id"));
                    bean.setSemester(result.getString("semester"));
                    bean.setSemesterDate(result.getDate("semester_date"));
                    bean.setRemarks(result.getString("remarks"));
                }
                
                
            }catch(Exception e){
            
                e.printStackTrace();
                
            }
         return bean;   
 }                  
        
//=====================================SEMESTER ENDS HERE====================================================================================         
     
     
//=====================================STUDENT STARTS HERE====================================================================================  
public static int addStudent(int sectionId,String name,String surname,String dob,String stdCnic,String presentAddress,String parmanentAddress,String gender,String religion,String stdMobile,String dateOfAddmission,String lastAttendClass,String passingYear,String lastAttendedSchoolName,String lastSchoolLeavingReason,String remarks,String fName,String fCnic,String fMobile,String fQualification,String fOccupation,String mName,String mCnic,String mMobile,String mQualification,String mOccupation,String gName,String gCnic,String gMobile,String gQualification,String gOccupation,String gRelationship)throws Exception{
            if(dob.trim().equals(""))
                     dob=null;
            else
                dob="#"+dob+"#";
            if(dateOfAddmission.trim().equals(""))
                     dateOfAddmission=null;
            else
                dateOfAddmission="#"+dateOfAddmission+"#";
            
		String query="INSERT INTO student (section_id,name,surname,date_of_birth,std_cnic,present_address,permanent_address,gender,religion,std_mobile,date_of_addmission,last_attended_class,passing_year,last_attended_school_name,last_school_leaving_reason,remarks,f_name,f_cnic,f_mobile,f_qualification,f_occupation,m_name,m_cnic,m_mobile,m_qualification,m_occupation,g_name,g_cnic,g_mobile,g_qualification,g_occupation,g_relationship) values ("+sectionId+",'"+name+"','"+surname+"',"+dob+",'"+stdCnic+"','"+presentAddress+"','"+parmanentAddress+"','"+gender+"','"+religion+"','"+stdMobile+"',"+dateOfAddmission+",'"+lastAttendClass+"','"+passingYear+"','"+lastAttendedSchoolName+"','"+lastSchoolLeavingReason+"','"+remarks+"','"+fName+"','"+fCnic+"','"+fMobile+"','"+fQualification+"','"+fOccupation+"','"+mName+"','"+mCnic+"','"+mMobile+"','"+mQualification+"','"+mOccupation+"','"+gName+"','"+gCnic+"','"+gMobile+"','"+gQualification+"','"+gOccupation+"','"+gRelationship+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int deleteStudent(String stdId)throws Exception{
		String query="DELETE from student where std_id="+stdId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}   
	public static int updateStudent(String stdId,String name,String surname,String dob,String stdCnic,String presentAddress,String parmanentAddress,String gender,String religion,String stdMobile,String dateOfAddmission,String lastAttendClass,String passingYear,String lastAttendedSchoolName,String lastSchoolLeavingReason,String remarks,String fName,String fCnic,String fMobile,String fQualification,String fOccupation,String mName,String mCnic,String mMobile,String mQualification,String mOccupation,String gName,String gCnic,String gMobile,String gQualification,String gOccupation,String gRelationship)throws Exception{
            if(dob.trim().equals(""))
                     dob=null;
            else
                dob="#"+dob+"#";
            if(dateOfAddmission.trim().equals(""))
                     dateOfAddmission=null;
            else
                dateOfAddmission="#"+dateOfAddmission+"#";
            
            String query="UPDATE student set name='"+name+"' , surname='"+surname+"' , date_of_birth="+dob+" , std_cnic='"+stdCnic+"' , present_address='"+presentAddress+"' , permanent_address='"+parmanentAddress+"' ,  gender='"+gender+"' , religion='"+religion+"' , std_mobile='"+stdMobile+"' , date_of_addmission="+dateOfAddmission+" ,  last_attended_class='"+lastAttendClass+"' , passing_year='"+passingYear+"' , last_attended_school_name='"+lastAttendedSchoolName+"' , last_school_leaving_reason='"+lastSchoolLeavingReason+"' ,  remarks='"+remarks+"' , f_name='"+fName+"' , f_cnic='"+fCnic+"' , f_mobile='"+fMobile+"' , f_qualification='"+fQualification+"' , f_occupation='"+fOccupation+"' , m_name='"+mName+"' , m_cnic='"+mCnic+"' , m_mobile='"+mMobile+"' , m_qualification='"+mQualification+"' , m_occupation='"+mOccupation+"' , g_name='"+gName+"' , g_cnic='"+gCnic+"' , g_mobile='"+gMobile+"' , g_qualification='"+gQualification+"' , g_occupation='"+gOccupation+"' , g_relationship='"+gRelationship+"'  where std_id="+stdId;
		System.out.println(query);
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}        
        
     public static Vector getStudent(int sectionId)throws Exception{
		String query="select * from student where section_id= "+sectionId;
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
			while(result.next()){
				StudentBean bean=new StudentBean();	
                                 bean.setStdId( result.getInt("std_id") );
				bean.setName( result.getString("name") );
                                bean.setSurname( result.getString("surname") );
                                bean.setDateOfBirth(result.getDate("date_of_birth"));
                                bean.setStdCnic( result.getString("std_cnic") );
                                bean.setPresentAddress(result.getString("present_address"));
                                bean.setParmanentAddress(result.getString("permanent_address"));
                                bean.setGender(result.getString("gender"));
                                bean.setReligion(result.getString("religion"));
                                bean.setStdMobile(result.getString("std_mobile"));
                                bean.setDateOfAddmission(result.getDate("date_of_addmission"));
                                bean.setLastAttendClass( result.getString("last_attended_class") );
                                bean.setPassingYear( result.getString("passing_year") );
                                bean.setLastAttendedSchoolName( result.getString("last_attended_school_name") );
                                bean.setLastSchoolLeavingReason( result.getString("last_school_leaving_reason") );
                                bean.setRemarks( result.getString("remarks") );
				//bean.setfName( result.getString("fname") );
				
                                bean.setfName(result.getString("f_name"));
                                bean.setfCnic(result.getString("f_cnic"));
                                bean.setfMobile(result.getString("f_mobile"));
                                bean.setfQualification(result.getString("f_qualification"));
                                bean.setfOccupation(result.getString("f_occupation"));
                                
                                bean.setmName(result.getString("m_name"));
                                bean.setmCnic(result.getString("m_cnic"));
                                bean.setmMobile(result.getString("m_mobile"));
                                bean.setmQualification(result.getString("m_qualification"));
                                bean.setmOccupation(result.getString("m_occupation"));
                                
                                bean.setgName(result.getString("g_name"));
                                bean.setgCnic(result.getString("g_cnic"));
                                bean.setgMobile(result.getString("g_mobile"));
                                bean.setgQualification(result.getString("g_qualification"));
                                bean.setgOccupation(result.getString("g_occupation"));
                                bean.setgRelationship(result.getString("g_relationship"));		
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}      
     public static StudentBean getStudentById(String stdId){
        
            StudentBean bean = null;
            ResultSet result = null;
            try{
                
                String query = "select * from student where std_id = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, stdId);
                
                result = pstmt.executeQuery();
                
                if(result.next()){
                
                    bean = new StudentBean();
                                bean.setStdId( result.getInt("std_id") );
				bean.setName( result.getString("name") );
                                bean.setSurname( result.getString("surname") );
                                bean.setDateOfBirth(result.getDate("date_of_birth"));
                                bean.setStdCnic( result.getString("std_cnic") );
                                bean.setPresentAddress(result.getString("present_address"));
                                bean.setParmanentAddress(result.getString("permanent_address"));
                                bean.setGender(result.getString("gender"));
                                bean.setReligion(result.getString("religion"));
                                bean.setStdMobile(result.getString("std_mobile"));
                                bean.setDateOfAddmission(result.getDate("date_of_addmission"));
                                bean.setLastAttendClass( result.getString("last_attended_class") );
                                bean.setPassingYear( result.getString("passing_year") );
                                bean.setLastAttendedSchoolName( result.getString("last_attended_school_name") );
                                bean.setLastSchoolLeavingReason( result.getString("last_school_leaving_reason") );
                                bean.setRemarks( result.getString("remarks") );
				//bean.setfName( result.getString("fname") );
				
                                bean.setfName(result.getString("f_name"));
                                bean.setfCnic(result.getString("f_cnic"));
                                bean.setfMobile(result.getString("f_mobile"));
                                bean.setfQualification(result.getString("f_qualification"));
                                bean.setfOccupation(result.getString("f_occupation"));
                                
                                bean.setmName(result.getString("m_name"));
                                bean.setmCnic(result.getString("m_cnic"));
                                bean.setmMobile(result.getString("m_mobile"));
                                bean.setmQualification(result.getString("m_qualification"));
                                bean.setmOccupation(result.getString("m_occupation"));
                                
                                bean.setgName(result.getString("g_name"));
                                bean.setgCnic(result.getString("g_cnic"));
                                bean.setgMobile(result.getString("g_mobile"));
                                bean.setgQualification(result.getString("g_qualification"));
                                bean.setgOccupation(result.getString("g_occupation"));
                                bean.setgRelationship(result.getString("g_relationship"));
             }
                
                
            }catch(Exception e){
            
                e.printStackTrace();
                
            }
         return bean;   
 }      
        
//=====================================STUDENT ENDS HERE====================================================================================      
     
//================================SESSION STARTS HERE======================================================================================        
	public static int addSession(String sessionYear,String remarks)throws Exception{
		String query="INSERT into session (session_year,remarks) values ('"+sessionYear+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int deleteSession(String sessionId)throws Exception{
		String query="DELETE from session where session_id="+sessionId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}    
	public static int updateSession(String sessionId,String sessionYear,String remarks)throws Exception{
		String query="UPDATE session set session_year='"+sessionYear+"' , remarks='"+remarks+"' where session_id="+sessionId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}        
	public static Vector getSession()throws Exception{
		String query="select * from session";
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
			while(result.next()){
				SessionBean bean=new SessionBean();	
				bean.setSessionId( result.getInt("session_id") );
				bean.setSessionYear( result.getString("session_year") );
				bean.setRemarks( result.getString("remarks") );			
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}       
     public static SessionBean getSessionById(String sessionId){
        
            SessionBean bean = null;
            ResultSet result = null;
            try{
                
                String query = "select * from session where session_id = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, sessionId);
                
                result = pstmt.executeQuery();
                System.out.println(query);
                if(result.next()){
                
                    bean = new SessionBean();
                    bean.setSessionId(result.getInt("session_id"));
                    bean.setSessionYear(result.getString("session_year"));
                    bean.setRemarks(result.getString("remarks"));
                }
                
                
            }catch(Exception e){
            
                e.printStackTrace();
                
            }
         return bean;   
 }                  
        
//=====================================SESSION ENDS HERE====================================================================================        
//=====================================STUDENT PROMOTION STARTS HERE====================================================================================  

     public static int addStudentPromotion(int classId,int stdId,int sessionId,String description,String promotionDate,String remarks)throws Exception{
            if(promotionDate.trim().equals(""))
                     promotionDate=null;
            else
               promotionDate="#"+promotionDate+"#";
            
            
		String query="INSERT INTO promotion_class (class_id,std_id,session_id,description,promotion_date,remarks) values ("+classId+","+stdId+","+sessionId+",'"+description+"',"+promotionDate+",'"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
     
	public static int deleteStudentPromotion(String proClassId)throws Exception{
		String query="DELETE from promotion_class where pro_class_id="+proClassId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}   
	public static int updateStudentPromotion(int classId,int stdId,int sessionId,String proClassId,String description,String promotionDate,String remarks)throws Exception{
            if(promotionDate.trim().equals(""))
                     promotionDate=null;
            else
                promotionDate="#"+promotionDate+"#";
           
            
            String query="UPDATE promotion_class set class_id="+classId+", std_id="+stdId+", session_id="+sessionId+", description='"+description+"' , promotion_date="+promotionDate+" , remarks='"+remarks+"'  where pro_class_id="+proClassId;
		System.out.println(query);
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}        
        
     public static Vector getStudentPromotion(int classId,int stdId,int sessionId)throws Exception{
		String query="select * from promotion_class where class_id= "+classId+" and std_id="+stdId+" and session_id="+sessionId;
		System.out.println(query);
		Statement st=null;
		ResultSet result=null;
		try{
			st=con.createStatement();
			result=st.executeQuery(query);
			Vector v=new Vector();
			while(result.next()){
				StudentPromotionBean bean=new StudentPromotionBean();	
                                bean.setClassId( result.getInt("class_id") );
                                bean.setStdId( result.getInt("std_id") );
                                bean.setSessionId( result.getInt("session_id") );
                                bean.setProClassId( result.getInt("pro_class_id") );
                                bean.setDescription( result.getString("description") );
                                bean.setPromotionDate(result.getDate("promotion_date"));
                                bean.setRemarks( result.getString("remarks") );
                                
                                
//                                 bean.setStdId( result.getInt("std_id") );
//				bean.setName( result.getString("name") );
//                                bean.setSurname( result.getString("surname") );
//                                bean.setDateOfBirth(result.getDate("date_of_birth"));
//                                bean.setStdCnic( result.getString("std_cnic") );
//                                bean.setPresentAddress(result.getString("present_address"));
//                                bean.setParmanentAddress(result.getString("permanent_address"));
//                                bean.setGender(result.getString("gender"));
//                                bean.setReligion(result.getString("religion"));
//                                bean.setStdMobile(result.getString("std_mobile"));
//                                bean.setDateOfAddmission(result.getDate("date_of_addmission"));
//                                bean.setLastAttendClass( result.getString("last_attended_class") );
//                                bean.setPassingYear( result.getString("passing_year") );
//                                bean.setLastAttendedSchoolName( result.getString("last_attended_school_name") );
//                                bean.setLastSchoolLeavingReason( result.getString("last_school_leaving_reason") );
//                                bean.setRemarks( result.getString("remarks") );
//				//bean.setfName( result.getString("fname") );
//				
//                                bean.setfName(result.getString("f_name"));
//                                bean.setfCnic(result.getString("f_cnic"));
//                                bean.setfMobile(result.getString("f_mobile"));
//                                bean.setfQualification(result.getString("f_qualification"));
//                                bean.setfOccupation(result.getString("f_occupation"));
//                                
//                                bean.setmName(result.getString("m_name"));
//                                bean.setmCnic(result.getString("m_cnic"));
//                                bean.setmMobile(result.getString("m_mobile"));
//                                bean.setmQualification(result.getString("m_qualification"));
//                                bean.setmOccupation(result.getString("m_occupation"));
//                                
//                                bean.setgName(result.getString("g_name"));
//                                bean.setgCnic(result.getString("g_cnic"));
//                                bean.setgMobile(result.getString("g_mobile"));
//                                bean.setgQualification(result.getString("g_qualification"));
//                                bean.setgOccupation(result.getString("g_occupation"));
//                                bean.setgRelationship(result.getString("g_relationship"));		
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}     
     public static StudentPromotionBean getClassPromotionById(String proClassId){
        
            StudentPromotionBean bean = null;
            ResultSet result = null;
            try{
                
                String query = "Select * from promotion_class pc, student s  where s.std_id=pc.std_id and pro_class_id = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, proClassId);
                
                result = pstmt.executeQuery();
                
                if(result.next()){
                
                    bean = new StudentPromotionBean();
                                bean.setProClassId( result.getInt("pro_class_id") );
                                bean.setDescription( result.getString("description") );
                                bean.setPromotionDate(result.getDate("promotion_date"));
                               // bean.setRemarks( result.getString("remarks") ); 
                                bean.setStdId( result.getInt("std_id") );
				bean.setName( result.getString("name") );
                               
                                bean.setStdCnic( result.getString("std_cnic") );
                           
                                bean.setStdMobile(result.getString("std_mobile"));
                                bean.setDateOfAddmission(result.getDate("date_of_addmission"));
                               
                                bean.setPassingYear( result.getString("passing_year") );
                               
                                bean.setRemarks( result.getString("remarks") );
				//bean.setfName( result.getString("fname") );
				
                                bean.setfName(result.getString("f_name"));
                                bean.setfCnic(result.getString("f_cnic"));
                                bean.setfMobile(result.getString("f_mobile"));
                                bean.setfQualification(result.getString("f_qualification"));
                                bean.setfOccupation(result.getString("f_occupation"));
                                
                                bean.setmName(result.getString("m_name"));
                                bean.setmCnic(result.getString("m_cnic"));
                                bean.setmMobile(result.getString("m_mobile"));
                                bean.setmQualification(result.getString("m_qualification"));
                                bean.setmOccupation(result.getString("m_occupation"));
                                
                                bean.setgName(result.getString("g_name"));
                                bean.setgCnic(result.getString("g_cnic"));
                                bean.setgMobile(result.getString("g_mobile"));
                                bean.setgQualification(result.getString("g_qualification"));
                                bean.setgOccupation(result.getString("g_occupation"));
                                bean.setgRelationship(result.getString("g_relationship"));
             }
                
                
            }catch(Exception e){
            
                e.printStackTrace();
                
            }
         return bean;   
 }      
        
//=====================================STUDENT PROMOTION ENDS HERE==================================================================================== 
     
     
     
     
     
     
     
     
     public static int addDepartment(int facId,String deptName,String remarks)throws Exception{
		String query="INSERT into department (fac_id,dept_name,remarks) values ("+facId+",'"+deptName+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int addProgram(int deptId,String progName,int semDuration,String remarks)throws Exception{
		String query="INSERT into program (dept_id,prog_name,duration_in_sem,remarks) values ('"+deptId+"','"+progName+"',"+semDuration+",'"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int addBatch(int progId,int batchYear,String shift,String groupDesc,String remarks)throws Exception{
		String query="INSERT into batch (prog_id,batch_year,shift,group_desc,remarks) values ("+progId+","+batchYear+",'"+shift+"','"+groupDesc+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
//	public static int addStudent(int batchId,String stdName,String fName,String surname,String rollNo,String gender,String remarks)throws Exception{
//		String query="INSERT into student (batch_id,std_name,fname,surname,roll_no,gender,remarks) values ("+batchId+",'"+stdName+"','"+fName+"','"+surname+"','"+rollNo+"','"+gender+"','"+remarks+"')";
//		System.out.println(query);
//		
//		Statement st=null;
//		try{
//			st=con.createStatement();
//			int rows=st.executeUpdate(query);
//			return rows;
//		}finally{
//			if (st!=null)
//			st.close();
//		}
//	}

	public static int addPart(int batchId,int part,int partYear,String remarks)throws Exception{
		String query="INSERT into part (batch_id,part,part_year,remarks) values ("+batchId+","+part+","+partYear+",'"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	} 
 	public static int addStudentPart(int batchId,int part,String rollNo,String status,String remarks)throws Exception{
		String query="INSERT into student_part (batch_id,part,roll_no,status,remarks) values ("+batchId+","+part+",'"+rollNo+"','"+status+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}       
 	public static int addSeatList(int batchId,int part,int year,String type,String prepDate,String remarks)throws Exception{
		String query="INSERT into seat_list (batch_id,part,year,type,prep_date,remarks) values ("+batchId+","+part+","+year+",'"+type+"','"+prepDate+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}         
        
 	public static int addSeatListDetail(int batchId,int part,int slId,String examType,String rollNo,String status,String remarks)throws Exception{
		String query="INSERT into seat_list_detail (sl_id,exam_type,roll_no,batch_id,part,status,remarks) values ("+slId+",'"+examType+"','"+rollNo+"',"+batchId+","+part+",'"+status+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}     

 	public static int addScheme(int progId,int year,int minMarks,String groupDesc,String remarks)throws Exception{
		String query="INSERT into scheme (prog_id,year,min_marks,group_desc,remarks) values ("+progId+","+year+","+minMarks+",'"+groupDesc+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}     
        
 	public static int addSchemePart(int schemeId,int schemePart,String remarks)throws Exception{
		String query="INSERT into scheme_part (scheme_id,scheme_part,remarks) values ("+schemeId+","+schemePart+",'"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	} 
        
 	public static int addSchemeSemester(int schemeId,int schemePart,int semester,String remarks)throws Exception{
		String query="INSERT into scheme_semester (scheme_id,scheme_part,semester,remarks) values ("+schemeId+","+schemePart+","+semester+",'"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}         
        
 	public static int addSchemeDetail(int schemeId,int schemePart,int semester,String courseNo,String courseTitle,int crHours,int maxMarks,String subjType,String isCreditable,String remarks)throws Exception{
		String query="INSERT into scheme_detail (scheme_id,scheme_part,semester,course_no,course_title,cr_hrs,max_marks,subj_type,is_creditable,remarks) values ("+schemeId+","+schemePart+","+semester+",'"+courseNo+"','"+courseTitle+"',"+crHours+","+maxMarks+",'"+subjType+"','"+isCreditable+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}      
 	public static int addLedgerDetails(int schemeId,int schemePart,int semester,String courseNo,int slId,String rollNo,int minMarks,int qp,String grade,String remarks)throws Exception{
		String query="INSERT into ledger_details (scheme_id,scheme_part,semester,course_no,sl_id,roll_no,min_marks,qp,grade,remarks) values ("+schemeId+","+schemePart+","+semester+",'"+courseNo+"',"+slId+",'"+rollNo+"',"+minMarks+","+qp+",'"+grade+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}          
        public static int addBook(int deptId,String bookTitle,String author,String publisher,String edition,int yearOfPublishing,int quantity,String isbn,String accessNo,int price,String dateOfPurchase,String purchaseFrom,String remarks)throws Exception{
            String query="INSERT into book (dept_id,book_title,author,publisher,edition_volume,year_of_publishing,quantity,isbn,access_no,price,date_of_purchase,purchase_from,remarks) values ("+deptId+",'"+bookTitle+"','"+author+"','"+publisher+"','"+edition+"',"+yearOfPublishing+","+quantity+",'"+isbn+"','"+accessNo+"',"+price+",'"+dateOfPurchase+"','"+purchaseFrom+"','"+remarks+"')";
            System.out.println(query);
            
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)
                    st.close();
            }
        }
        public static int addBookIssue(int bookId,int stdId,String dateOfIssue,String dateOfReturn,int fine,String remarks)throws Exception{
            dateOfIssue="#"+dateOfIssue+"#";
if(dateOfReturn.trim().equals(""))
    dateOfReturn=null;
else
    dateOfReturn="#"+dateOfReturn+"#";
    
            String query="INSERT into book_issue (book_id,std_id,date_of_issue,date_of_return,fine,remarks) values ("+bookId+","+stdId+","+dateOfIssue+","+dateOfReturn+","+fine+",'"+remarks+"')";
            System.out.println(query);
            
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)
                    st.close();
            }
        }     
    public static int addFacultyMembers(int deptId,String firstName, String lastName, String surname, String nic, String dateOfAppointment, String email, String pass, String designation, String remarks)throws Exception{
            
            if(dateOfAppointment.trim().equals(""))
            dateOfAppointment=null;
            else
            dateOfAppointment="#"+dateOfAppointment+"#";
    
            String query="INSERT into faculty_members (dept_id,first_name,last_name,surname,nic,date_of_appointment,email,pass,designation,remarks) values ("+deptId+",'"+firstName+"','"+lastName+"','"+surname+"','"+nic+"',"+dateOfAppointment+",'"+email+"','"+pass+"','"+designation+"','"+remarks+"')";
            System.out.println(query);
            
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)
                    st.close();
            }
        }      
	public static int addCourseDistribution(int schemeId,int schemePart,int semester,String courseNo,int memberId,int cdYearId,String cdDate,String remarks)throws Exception{
	if(cdDate.trim().equals(""))
            cdDate=null;
        else
            cdDate="#"+cdDate+"#";	
            String query="INSERT into course_distribution (scheme_id,scheme_part,scheme_semester,course_no,member_id,cd_year_id,distribution_date,remarks) values ("+schemeId+","+schemePart+","+semester+",'"+courseNo+"',"+memberId+","+cdYearId+","+cdDate+",'"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}  
    public static int addAttendance(String rollNo,int batchId,int part,int cdId,String attendanceDate,String attendanceStatus,String remarks)throws Exception{
            
            if(attendanceDate.trim().equals(""))
            attendanceDate=null;
            else
            attendanceDate="#"+attendanceDate+"#";
    
            String query="INSERT into attendance (roll_no,batch_id,part,cd_id,attendance_date,status,remarks) values ('"+rollNo+"',"+batchId+","+part+","+cdId+","+attendanceDate+",'"+attendanceStatus+"','"+remarks+"')";
            
            System.out.println(query);
            
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)
                    st.close();
            }
        } 
	public static int addCourseDistributionYear(int cdYear,String remarks)throws Exception{
		String query="INSERT into course_distribution_year (cd_year,remarks) values ("+cdYear+",'"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}    
        

	public static int deleteDepartment(int deptId)throws Exception{
		String query="DELETE from department where dept_id="+deptId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int deleteProgram(int progId)throws Exception{
		String query="DELETE from program where prog_id="+progId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int deleteBatch(int batchId)throws Exception{
		String query="DELETE from batch where batch_id="+batchId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
//	public static int deleteStudent(int StdId)throws Exception{
//		String query="DELETE from student where std_id="+StdId;
//		System.out.println(query);
//		
//		Statement st=null;
//		try{
//			st=con.createStatement();
//			int rows=st.executeUpdate(query);
//			return rows;
//		}finally{
//			if (st!=null)
//			st.close();
//		}
//	}
	public static int deletePart(int batchId,int part)throws Exception{
		String query="DELETE from part where batch_id="+batchId+" and part="+part;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int deleteStudentPart(int batchId,int part,String rollNo)throws Exception{
		String query="DELETE from student_part where roll_no='"+rollNo+"' and part = "+part+" and batch_id="+batchId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}  
	public static int deleteSeatList(int slId)throws Exception{
		String query="DELETE from seat_list where sl_id="+slId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	} 	
        public static int deleteSeatListDetail(int batchId,int part,int slId,String rollNo)throws Exception{
		String query="DELETE from seat_list_detail where batch_id="+batchId+" and part="+part+" and sl_id="+slId+" and Roll_no='"+rollNo+"'";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}  
        
	public static int deleteScheme(int schemeId)throws Exception{
		String query="DELETE from scheme where scheme_id="+schemeId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
        
	public static int deleteSchemePart(int schemeId,int schemePart)throws Exception{
		String query="DELETE from scheme_part where scheme_id="+schemeId+" and scheme_part="+schemePart;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}        
        
	public static int deleteSchemeSemester(int schemeId,int schemePart,int semester)throws Exception{
		String query="DELETE from scheme_semester where scheme_id="+schemeId+" and scheme_part="+schemePart+" and semester="+semester;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}      
        
	public static int deleteSchemeDetail(int schemeId,int schemePart,int semester,String courseNo)throws Exception{
		String query="DELETE from scheme_detail where course_no='"+courseNo+"' and semester="+semester+" and scheme_part="+schemePart+" and scheme_id="+schemeId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}  
	public static int deleteLedgerDetails(int schemeId,int schemePart,int semester,String courseNo,int slId,String rollNo)throws Exception{
		String query="DELETE from ledger_details where scheme_id="+schemeId+" and scheme_part="+schemePart+" and semester="+semester+" and course_no='"+courseNo+"' and sl_id="+slId+" and roll_no='"+rollNo+"'" ;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}     
	public static int deleteBook(int bookId)throws Exception{
		String query="DELETE from book where prog_id="+bookId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}   
	public static int deleteBookIssue(int IssueId)throws Exception{
		String query="DELETE from book_issue where issue_id="+IssueId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}        
	public static int deleteFacultyMembers(int membersId)throws Exception{
		String query="DELETE from faculty_members where member_id="+membersId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	} 
	public static int deleteCourseDistribution(int cdId)throws Exception{
		String query="DELETE from course_distribution where cd_id="+cdId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}  
	public static int deleteAttendance(int attendanceId)throws Exception{
		String query="DELETE from attendance where attendance_id="+attendanceId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}        
	public static int deleteCourseDistributionYear(int cdYearId)throws Exception{
		String query="DELETE from course_distribution_year where cd_year_id="+cdYearId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}        
        

	public static int updateDepartment(int deptId,String deptName,String remarks)throws Exception{
		String query="UPDATE department set dept_name='"+deptName+"' , remarks='"+remarks+"' where dept_id="+deptId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int updateProgram(int progId,String progName,int semDuration,String remarks)throws Exception{
		String query="UPDATE program set prog_name='"+progName+"' , duration_in_sem="+semDuration+" , remarks='"+remarks+"' where prog_id="+progId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	public static int updateBatch(int batchId,int batchYear,String shift,String groupDesc,String remarks)throws Exception{
		String query="UPDATE batch set batch_year='"+batchYear+"' ,shift='"+shift+"' ,group_desc='"+groupDesc+"' , remarks='"+remarks+"' where batch_id="+batchId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
//	public static int updateStudent(int stdId,String stdName,String fName,String surname,String rollNo,String remarks)throws Exception{
//		String query="UPDATE student set std_name='"+stdName+"' ,fname='"+fName+"' ,surname='"+surname+"' ,roll_no='"+rollNo+"' , remarks='"+remarks+"' where std_id="+stdId;
//		System.out.println(query);
//		
//		Statement st=null;
//		try{
//			st=con.createStatement();
//			int rows=st.executeUpdate(query);
//			return rows;
//		}finally{
//			if (st!=null)
//			st.close();
//		}
//	}
	public static int updatePart(int part,int partYear,String remarks)throws Exception{
    String query="UPDATE part set  part_year="+partYear+" , remarks='"+remarks+"' where part ="+part;		
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
    public static int updateStudentPart(int batchId,int part,String rollNo,String status,String remarks)throws Exception{
    String query="UPDATE student_part set status='"+status+"' , remarks='"+remarks+"' where roll_no='"+rollNo+"' and batch_id="+batchId+" and part = "+part;		
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}   
    public static int updateSeatList(int slId,int year,String type,String prepDate,String remarks)throws Exception{
    String query="UPDATE seat_list set year="+year+", type='"+type+"', prep_date='"+prepDate+"' , remarks='"+remarks+"' where sl_id="+slId;		
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}      
 
   public static int updateSeatListDetail(int batchId,int part,int slId,String examType,String rollNo,String status,String remarks)throws Exception{
    String query="UPDATE seat_list_detail set exam_type='"+examType+"' ,  status='"+status+"', remarks='"+remarks+"' where batch_id="+batchId+" and part="+part+" and sl_id="+slId+" and roll_no='"+rollNo+"'";		
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	} 
   
   public static int updateScheme(int schemeId,int year,int minMarks,String groupDesc,String remarks)throws Exception{
    String query="UPDATE scheme set year="+year+" , min_marks="+minMarks+"  , group_desc='"+groupDesc+"', remarks='"+remarks+"' where scheme_Id="+schemeId;		
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}      
    
   public static int updateSchemePart(int schemeId,int schemePart,int schemePartOriginal,String remarks)throws Exception{
    String query="UPDATE scheme_part set scheme_part="+schemePart+" , remarks='"+remarks+"'  where scheme_part="+schemePartOriginal+" and scheme_id="+schemeId;		
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}    
   //UpdateSchemePartOverloaded
     public static int updateSchemePart(int schemeId,int schemePartOriginal,String remarks)throws Exception{
    String query="UPDATE scheme_part set remarks='"+remarks+"'  where scheme_part="+schemePartOriginal+" and scheme_id="+schemeId;		
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}    
   
 //UpdateSchemePartOverloaded end  
   
   
   public static int updateSchemeSemester(int schemeId,int schemePart,int semesterOriginal,int semester,String remarks)throws Exception{
    String query="UPDATE scheme_semester set semester= "+semester+" , remarks='"+remarks+"' where scheme_id="+schemeId+" and scheme_part= "+schemePart+" and semester="+semesterOriginal;		
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}   
   
   //UpdateSchemeSemester
      public static int updateSchemeSemester(int schemeId,int schemePart,int semester,String remarks)throws Exception{
        String query="UPDATE scheme_semester set  remarks='"+remarks+"' where scheme_id="+schemeId+" and scheme_part= "+schemePart+" and semester="+semester;		
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
   //UpdateSchemeSemester end

   public static int updateSchemeDetail(int schemeId,int schemePart,int semester,String courseNoOriginal,String courseNo,String courseTitle,int crHours,int maxMarks,String subjType,String isCreditable,String remarks)throws Exception{
		String query="UPDATE scheme_detail set course_no ='"+courseNo+"' , course_title='"+courseTitle+"' , cr_hrs="+crHours+" , max_marks="+maxMarks+" , subj_type='"+subjType+"' , is_creditable = '"+isCreditable+"' , remarks= '"+remarks+"' where scheme_id="+schemeId+" and scheme_part= "+schemePart+" and course_no='"+courseNoOriginal+"' and semester="+semester  ;
                System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}     
   public static int updateLedgerDetails(int schemeId,int schemePart,int semester,String courseNo,int slId,String rollNo,int obtainMarks,int minMarks,int qp,String grade,String remarks)throws Exception{
		String query="UPDATE ledger_details set obtain_marks ="+obtainMarks+" , min_marks="+minMarks+" , qp="+qp+" ,  grade='"+grade+"' , remarks= '"+remarks+"' where scheme_id="+schemeId+" and scheme_part= "+schemePart+" and course_no='"+courseNo+"' and semester="+semester+" and sl_id="+slId+" and roll_no='"+rollNo+"'"; ;
                System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}    
  public static int updateBook(int bookId,String bookTitle,String author,String publisher,String edition,int yearOfPublishing,int quantity,String isbn,String accessNo,int price,String dateOfPurchase,String purchaseFrom,String remarks)throws Exception{
                String query="Update book set book_title='"+bookTitle+"' , author = '"+author+"' , publisher = '"+publisher+"' , edition_volume = '"+edition+"' , year_of_publishing = "+yearOfPublishing+" , quantity = "+quantity+" , isbn = '"+isbn+"' , access_no = '"+accessNo+"' , price = "+price+" , date_of_purchase = '"+dateOfPurchase+"' , purchase_from = '"+purchaseFrom+"' , remarks = '"+remarks+"' where book_id = "+bookId; 
                System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
  } 
    public static int updateBookIssue(int bookId,int stdId,int issueId,String dateOfIssue,String dateOfReturn,int fine,String remarks)throws Exception{
                String query="Update book_issue set date_of_issue='"+dateOfIssue+"' , date_of_return = '"+dateOfReturn+"' , fine = "+fine+" , remarks = '"+remarks+"' where book_id = "+bookId+" and std_id="+stdId+" and issue_id="+issueId; 
                System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
  } 
  public static int updateFacultyMembers(int memberId,int deptId,String firstName, String lastName, String surname, String nic, String dateOfAppointment, String email, String pass, String designation, String remarks)throws Exception{
            if(dateOfAppointment.trim().equals(""))
            dateOfAppointment=null;
            else
            dateOfAppointment="#"+dateOfAppointment+"#";               
      String query="Update faculty_members set first_name = '"+firstName+"' , last_name = '"+lastName+"' , surname = '"+surname+"', nic='"+nic+"' , date_of_appointment = "+dateOfAppointment+" , email = '"+email+"' , pass = '"+pass+"' , designation = '"+designation+"' , remarks = '"+remarks+"' where member_id = "+memberId+" and dept_id="+deptId; 
                System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
  }    
   public static int updateCourseDistribution(int cdId,int schemeId,int schemePart,int semester,String courseNo,int memberId,String remarks)throws Exception{
		String query="UPDATE course_distribution set scheme_id ="+schemeId+" , scheme_part="+schemePart+" , scheme_semester="+semester+" ,  course_no='"+courseNo+"' , member_id="+memberId+" , remarks= '"+remarks+"' where cd_id="+cdId;//+" and scheme_part= "+schemePart+" and course_no='"+courseNo+"' and semester="+semester+" and sl_id="+slId+" and roll_no='"+rollNo+"'"; ;
                System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}   
   public static int updateAttendance(String rollNo,int batchId,int part,int cdId,int attendanceId,String attendanceDate,String attendanceStatus,String remarks)throws Exception{
            if(attendanceDate.trim().equals(""))
            attendanceDate=null;
            else
            attendanceDate="#"+attendanceDate+"#";
       String query="UPDATE attendance set roll_no='"+rollNo+"', batch_id="+batchId+", part="+part+" , cd_id="+cdId+" , attendance_date="+attendanceDate+",   status='"+attendanceStatus+"', remarks='"+remarks+"' where  attendance_id="+attendanceId;		
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}    
	public static int updateCourseDistributionYear(int cdYearId,int cdYear,String remarks)throws Exception{
		String query="UPDATE course_distribution_year set cd_year="+cdYear+" , remarks='"+remarks+"' where cd_year_id="+cdYearId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}   
//	public static Vector getStudent(int batchId)throws Exception{
//		String query="select * from student where batch_id= "+batchId;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				StudentBean bean=new StudentBean();	
//				bean.setStdId( result.getInt("std_id") );
//				//bean.setBatchId( result.getInt("batch_id") );
//				bean.setName( result.getString("std_name") );
//				bean.setFname( result.getString("fname") );
//				bean.setSurname( result.getString("surname") );
//				bean.setRollNo( result.getString("roll_no") );
//                                bean.setGender(result.getString("gender"));
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}         
//        
}//databaseManager class end


   //subint.karbi@outlook.com 1111
//

//	public static Vector getDepartment(int facId)throws Exception{
//		String query="select * from department where fac_id= "+facId ;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				DepartmentBean bean=new DepartmentBean();	
//				bean.setDeptId( result.getInt("dept_id") );
//				bean.setFacId( result.getInt("fac_id") );
//				bean.setDeptName( result.getString("dept_name") );
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}
//	public static Vector getDepartment()throws Exception{
//		String query="select * from department";
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				DepartmentBean bean=new DepartmentBean();	
//				bean.setDeptId( result.getInt("dept_id") );
//				bean.setFacId( result.getInt("fac_id") );
//				bean.setDeptName( result.getString("dept_name") );
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}
//        
//        public static Vector getProgram(int deptId)throws Exception{
//		String query="select * from program where dept_id="+deptId;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				ProgramBean bean=new ProgramBean();	
//				bean.setProgId( result.getInt("prog_id") );
//				bean.setDeptId( result.getInt("dept_id") );
//				bean.setProgName( result.getString("prog_name") );
//				bean.setSemDuration( result.getInt("duration_in_sem"));
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}
//	public static Vector getBatch(int progId)throws Exception{
//		String query="select * from batch where prog_id="+progId;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				BatchBean bean=new BatchBean();	
//				bean.setBatchId( result.getInt("batch_id") );
//				bean.setProgId( result.getInt("prog_id") );
//				bean.setBatchYear( result.getInt("batch_year") );
//				bean.setShift( result.getString("shift") );
//				bean.setGroupDesc( result.getString("group_desc") );
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}
//        	public static Vector getBatch()throws Exception{
//		String query="select * from batch ";
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				BatchBean bean=new BatchBean();	
//				bean.setBatchId( result.getInt("batch_id") );
//				bean.setProgId( result.getInt("prog_id") );
//				bean.setBatchYear( result.getInt("batch_year") );
//				bean.setShift( result.getString("shift") );
//				bean.setGroupDesc( result.getString("group_desc") );
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}
//	public static Vector getStudent(int batchId)throws Exception{
//		String query="select * from student where batch_id= "+batchId;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				StudentBean bean=new StudentBean();	
//				bean.setStdId( result.getInt("std_id") );
//				bean.setBatchId( result.getInt("batch_id") );
//				bean.setName( result.getString("std_name") );
//				bean.setFname( result.getString("fname") );
//				bean.setSurname( result.getString("surname") );
//				bean.setRollNo( result.getString("roll_no") );
//                                bean.setGender(result.getString("gender"));
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}    
//  public static Vector getStudent()throws Exception{
//		String query="select * from student ";
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//                        int sno=0;
//			while(result.next()){
//                            sno++;
//				StudentBean bean=new StudentBean();	
//				bean.setSerialNum(sno);
//                                
//                                bean.setStdId( result.getInt("std_id") );
//				bean.setBatchId( result.getInt("batch_id") );
//				bean.setName( result.getString("std_name") );
//				bean.setFname( result.getString("fname") );
//				bean.setSurname( result.getString("surname") );
//				bean.setRollNo( result.getString("roll_no") );
//                                bean.setGender(result.getString("gender"));
//				bean.setRemarks( result.getString("remarks") );	
//                                //bean.setSerialNum(result.getInt("serial_num"));
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}
//  public static StudentBean getStudent1()throws Exception{
//		String query="select * from student ";
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			//Vector v=new Vector();
//                        StudentBean bean=null;
//                        int sno=0;
//			while(result.next()){
//                            sno++;
//				bean=new StudentBean();	
//				bean.setSerialNum(sno);
//                                
//                                bean.setStdId( result.getInt("std_id") );
//				bean.setBatchId( result.getInt("batch_id") );
//				bean.setName( result.getString("std_name") );
//				bean.setFname( result.getString("fname") );
//				bean.setSurname( result.getString("surname") );
//				bean.setRollNo( result.getString("roll_no") );
//                                bean.setGender(result.getString("gender"));
//				bean.setRemarks( result.getString("remarks") );	
//                                //bean.setSerialNum(result.getInt("serial_num"));
//				//addElement(bean);
//                             // return bean;  
//			}
//			return bean;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}   
//	public static Vector getGender(String rollNo)throws Exception{
//		String query="select * from student where roll_no= "+rollNo;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				StudentBean bean=new StudentBean();	
//				bean.setStdId( result.getInt("std_id") );
//				bean.setBatchId( result.getInt("batch_id") );
//				bean.setName( result.getString("std_name") );
//				bean.setFname( result.getString("fname") );
//				bean.setSurname( result.getString("surname") );
//				bean.setRollNo( result.getString("roll_no") );
//                                bean.setGender(result.getString("gender"));
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}   
//  	/*public static Vector getRollNo(int batchId,int part,int examYear)throws Exception{
//		String query="select * from seat_list where batch_id= "+batchId+" and part="+part+" and year="+examear;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				SeatListBean bean=new SeatListBean();
//                                bean.setSlId(result.getInt("sl_id"));
//                                bean.setBatchId( result.getInt("batch_id") );
//				bean.setPart( result.getInt("part") );
//                                bean.setYear(result.getInt("year"));
//                                bean.setType( result.getString("type") );
//                                bean.setPrepDate( result.getDate("prep_date") );
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}        
//       */
//	public static Vector getScheme(int progId)throws Exception{
//		String query="select * from scheme where prog_id="+progId;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				SchemeBean bean=new SchemeBean();	
//				bean.setSchemeId( result.getInt("scheme_id") );
//				bean.setProgId( result.getInt("prog_id") );
//				bean.setYear( result.getInt("year") );
//                                bean.setMinMarks( result.getInt("min_marks") );
//				bean.setGroupDesc( result.getString("group_desc") );
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}
//	public static Vector getSchemePart(int schemeId)throws Exception{
//		String query="select * from scheme_part where scheme_id="+schemeId;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				SchemePartBean bean=new SchemePartBean();	
//				bean.setSchemeId( result.getInt("scheme_id") );
//				bean.setSchemePart( result.getInt("scheme_part") );
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}     
//	public static Vector getSchemeSemester(int schemeId,int schemePart)throws Exception{
//		String query="select * from scheme_semester where scheme_id="+schemeId+" and scheme_part="+schemePart ;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				SchemeSemesterBean bean=new SchemeSemesterBean();	
//				bean.setSchemeId( result.getInt("scheme_id") );
//				bean.setSchemePart( result.getInt("scheme_part") );
//                                bean.setSemester( result.getInt("semester") );
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}          
//	public static Vector getSchemeDetail(int schemeId,int schemePart,int semester)throws Exception{
//		String query="select * from scheme_detail where scheme_id="+schemeId+" and scheme_part="+schemePart+" and semester="+semester;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				SchemeDetailBean bean=new SchemeDetailBean();	
//				bean.setSchemeId( result.getInt("scheme_id") );
//				bean.setSchemePart( result.getInt("scheme_part") );
//                                bean.setSemester( result.getInt("semester") );
//                                bean.setCourseNo( result.getString("course_no") );
//                                bean.setCourseTitle( result.getString("course_title") );
//                                bean.setCrHours( result.getInt("cr_hrs") );
//                                bean.setMaxMarks( result.getInt("max_marks") );
//                                bean.setSubjType( result.getString("subj_type") );	
//                                bean.setIsCreditable( result.getString("is_creditable") );	
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}         
//        
//        
//        
//	public static SchemeDetailBean getSchemeDetail(int schemeId,int schemePart,int semester,String courseNo)throws Exception{
//		String query="select * from scheme_detail where scheme_id="+schemeId+" and scheme_part="+schemePart+" and semester="+semester+" and course_no like '"+courseNo+"'";
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//                        
//                        SchemeDetailBean bean=null;	
//			
//			//Vector v=new Vector();
//			if(result.next()){
//				bean=new SchemeDetailBean();	
//				bean.setSchemeId( result.getInt("scheme_id") );
//				bean.setSchemePart( result.getInt("scheme_part") );
//                                bean.setSemester( result.getInt("semester") );
//                                bean.setCourseNo( result.getString("course_no") );
//                                bean.setCourseTitle( result.getString("course_title") );
//                                bean.setCrHours( result.getInt("cr_hrs") );
//                                bean.setMaxMarks( result.getInt("max_marks") );
//                                bean.setSubjType( result.getString("subj_type") );	
//                                bean.setIsCreditable( result.getString("is_creditable") );	
//				bean.setRemarks( result.getString("remarks") );			
//				//v.addElement(bean);
//			}
//			return bean;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}         
//        
//        
//	public static Vector getPart(int batchId)throws Exception{
//		String query="select * from part where batch_id= "+batchId;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				PartBean bean=new PartBean();	
//				bean.setPart( result.getInt("part") );
//                                bean.setPartYear( result.getInt("part_year") );
//				bean.setBatchId( result.getInt("batch_id") );
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	} 
//	public static Vector getStudentPart(int batchId,int part)throws Exception{
//		String query="select * from student_part where batch_id="+batchId+" and part="+part ;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				StudentPartBean bean=new StudentPartBean();
//                                bean.setRollNo( result.getString("roll_no") );
//                                bean.setBatchId( result.getInt("batch_id") );
//				bean.setPart( result.getInt("part") );
//                                bean.setStatus( result.getString("status") );	
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	} 
//	public static Vector getSeatList(int batchId,int part)throws Exception{
//		String query="select * from seat_list where batch_id="+batchId+" and part= "+part;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				SeatListBean bean=new SeatListBean();
//                                bean.setSlId(result.getInt("sl_id"));
//                                bean.setBatchId( result.getInt("batch_id") );
//				bean.setPart( result.getInt("part") );
//                                bean.setYear(result.getInt("year"));
//                                bean.setType( result.getString("type") );
//                                bean.setPrepDate( result.getDate("prep_date") );
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}        
//	public static Vector getSeatListDetail(int slId)throws Exception{
//		String query="select * from seat_list_detail where  sl_id="+slId;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				SeatListDetailBean bean=new SeatListDetailBean();
//                                bean.setSlId(result.getInt("sl_id"));
//                                bean.setRollNo( result.getString("roll_no") );
//                                bean.setExamType(result.getString("exam_type"));
//                                bean.setBatchId( result.getInt("batch_id") );
//				bean.setPart( result.getInt("part") );
//                                bean.setStatus( result.getString("status") );
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}
//	public static Vector getLedgerDetails(int schemeId,int schemePart,int semester,String courseNo,int slId)throws Exception{
//		String query="select * from ledger_details where scheme_id="+schemeId+" and scheme_part="+schemePart+" and semester="+semester+" and course_no='"+courseNo+"'  and sl_id="+slId+" ";
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				LedgerDetailsBean bean=new LedgerDetailsBean();	
//				bean.setSchemeId( result.getInt("scheme_id") );
//				bean.setSchemePart( result.getInt("scheme_part") );
//                                bean.setSemester( result.getInt("semester") );
//                                bean.setCourseNo( result.getString("course_no") );
//                                bean.setSlId(result.getInt("sl_id"));
//                                bean.setRollNo( result.getString("roll_no") );
//                                bean.setObtainMarks( result.getInt("obtain_marks") );
//                                bean.setMinMarks( result.getInt("min_marks") );
//                                bean.setQp( result.getString("qp") );	
//                                bean.setGrade( result.getString("grade") );	
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}        
//      public static Vector getBook(int deptId)throws Exception{
//      String query="select * from book where dept_id="+deptId;
//      System.out.println(query);
//      Statement st=null;
//      ResultSet result=null;
//      try{
//          	st=con.createStatement();
//		result=st.executeQuery(query);
//		Vector v=new Vector();
//                while(result.next()){
//                    BookBean  bean = new BookBean (); 
//                    bean.setBookId(result.getInt("book_id"));
//                    bean.setBookTitle(result.getString("book_title"));
//                    bean.setAuthor(result.getString("author"));
//                    bean.setPublisher(result.getString("publisher"));
//                    bean.setEdition(result.getString("edition_volume"));
//                    bean.setYearOfPublishing(result.getInt("year_of_publishing"));
//                    bean.setQuantity(result.getInt("quantity"));
//                    bean.setIsbn(result.getString("isbn"));
//                    bean.setAccessNo(result.getString("access_no"));
//                    bean.setPrice(result.getInt("price"));
//                    bean.setDateOfPurchase(result.getDate("date_of_purchase"));
//                    bean.setPurchaseFrom(result.getString("purchase_from"));
//                    bean.setRemarks(result.getString("remarks"));
//                    v.addElement(bean);
//                }
//          return v;
//      }finally{
//              if(result!=null)result.close();;
//              if(st!=null)st.close();;}
//      }  
//
//      public static Vector getBookIssue(int bookId)throws Exception{
//      String query="select bi.book_id,bi.std_id,bi.issue_id,bi.date_of_issue,bi.date_of_return,bi.fine,bi.remarks,std_name,fname,surname,roll_no,gender from book_issue bi,student std where bi.std_id=std.std_id and book_id="+bookId;
//      System.out.println(query);
//     
//      Statement st=null;
//      ResultSet result=null;
//      try{
//          	st=con.createStatement();
//		result=st.executeQuery(query);
//		Vector v=new Vector();
//                while(result.next()){
//                    BookIssueBean  bean = new BookIssueBean ();
//                    bean.setBookId(result.getInt("book_id"));
//                    bean.setStdId(result.getInt("std_id"));
//                    bean.setIssueId(result.getInt("issue_id"));
//                    bean.setDateOfIssue(result.getDate("date_of_issue"));
//                    bean.setDateOfReturn(result.getDate("date_of_return"));
//                    bean.setFine(result.getInt("fine"));
//                    bean.setRemarks(result.getString("remarks"));
//                    
//                    bean.setName(result.getString("std_name"));
//                    bean.setFname(result.getString("fname"));
//                    bean.setSurname(result.getString("surname"));
//                    bean.setRollNo(result.getString("roll_no"));
//                    bean.setGender(result.getString("gender"));
//                         
//                    v.addElement(bean);
//                }
//          return v;
//      }finally{
//              if(result!=null)result.close();;
//              if(st!=null)st.close();;}
//      }  
//     public static Vector getDefaulterList(String dateOfIssue1,String dateOfIssue2)throws Exception{
//            if(dateOfIssue1.trim().equals(""))
//                     dateOfIssue1=null;
//            else
//                dateOfIssue1="#"+dateOfIssue1+"#";
//            if(dateOfIssue2.trim().equals(""))
//                     dateOfIssue2=null;
//            else
//                dateOfIssue2="#"+dateOfIssue2+"#";    
//            
//      String query="select roll_no,std_name,fname,surname,b.book_title,b.author,b.publisher,b.price from book_issue bi,book b,student std where bi.std_id=std.std_id and bi.book_id=b.book_id and date_of_issue>"+dateOfIssue1+" and date_of_issue<"+dateOfIssue2+" ";
//      System.out.println(query);
//   
//      Statement st=null;
//      ResultSet result=null;
//      try{
//          	st=con.createStatement();
//	        result=st.executeQuery(query);
//		Vector v=new Vector();
//                BookIssueBean  bean =  null;
//                while(result.next()){
//                    bean = new BookIssueBean ();
//                  // Vector vector=new Vector();
//                    bean.setRollNo(result.getString("roll_no"));
//                    bean.setName(result.getString("std_name"));
//                    bean.setFname(result.getString("fname"));
//                    bean.setSurname(result.getString("surname"));
//                    bean.setBookTitle(result.getString("book_title"));
//                    bean.setAuthor(result.getString("author"));
//                    bean.setPublisher(result.getString("publisher"));
//                    bean.setPrice(result.getInt("price"));
//                    v.addElement(bean);
//         //==================================================================                  
////                    obj={result.getString("roll_no"),
////                                  result.getString("std_name"), 
////                                  result.getString("fname"),
////                                  result.getString("surname"),
////                                  result.getString("book_title"),
////                                  result.getString("author"),
////                                  result.getString("publisher"),
////                                  result.getInt("price")
////                                 };
//        //=================================================================            
//                   // System.out.println(obj + " " + result);
//                    
////                    bean.setRollNo(result.getString("roll_no"));
////                    bean.setName(result.getString("std_name"));
////                    bean.setFname(result.getString("fname"));
////                    bean.setSurname(result.getString("surname"));
////                    bean.setBookTitle(result.getString("book_title"));
////                    bean.setAuthor(result.getString("author"));
////                    bean.setPublisher(result.getString("publisher"));
////                    bean.setPrice(result.getInt("price"));
//                    
//      //=====================================================================                 
//                    
//               
//                }
//          return v;
//      }
//      finally{
//              if(result!=null)result.close();;
//              if(st!=null)st.close();;
//      }
//            
//}      
//
//	public static Vector getFacultyMembers(int deptId)throws Exception{
//		String query="select * from faculty_members where dept_id="+deptId;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				FacultyMembersBean bean=new FacultyMembersBean();	
//				bean.setMemberId( result.getInt("member_id") );
//				bean.setDeptId( result.getInt("dept_id") );
//				bean.setFirstName( result.getString("first_name") );
//                                bean.setLastName( result.getString("last_name") );
//                                bean.setSurname( result.getString("surname") );
//                                bean.setNic( result.getString("nic") );
//                                bean.setDateOfAppointment( result.getDate("date_of_appointment") );
//				bean.setEmail( result.getString("email") );
//                                bean.setPass( result.getString("pass") );
//                                bean.setDesignation(result.getString("designation"));
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}
//        
//        
//	public static FacultyMembersBean getFacultyMembers(String memberId)throws Exception{
//		String query="select * from faculty_members where member_id="+memberId;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			//Vector v=new Vector();
//                        
//                        FacultyMembersBean bean=null;
//                        
//			if(result.next()){
//				bean=new FacultyMembersBean();	
//				bean.setMemberId( result.getInt("member_id") );
//				bean.setDeptId( result.getInt("dept_id") );
//				bean.setFirstName( result.getString("first_name") );
//                                bean.setLastName( result.getString("last_name") );
//                                bean.setSurname( result.getString("surname") );
//                                bean.setNic( result.getString("nic") );
//                                bean.setDateOfAppointment( result.getDate("date_of_appointment") );
//				bean.setEmail( result.getString("email") );
//                                bean.setPass( result.getString("pass") );
//                                bean.setDesignation(result.getString("designation"));
//				bean.setRemarks( result.getString("remarks") );			
//				//v.addElement(bean);
//			}
//			return bean;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}
//        
//        
//	public static Vector getCourseDistribution(int cdYearId,int memberId,int schemeId,int schemePart,int schemeSemester,String courseNo,String search)throws Exception{
//			
//            
//        String query="select * from course_distribution where scheme_id="+schemeId+" and scheme_part="+schemePart+" and scheme_semester="+schemeSemester+" and cd_year_id="+cdYearId+" and member_id="+memberId;
//	
//        if(search.toUpperCase().startsWith("COURSE"))
//            query="select * from course_distribution where scheme_id="+schemeId+" and scheme_part="+schemePart+" and scheme_semester="+schemeSemester+" and cd_year_id="+cdYearId+" and COURSE_NO like '"+courseNo+"'";
//        
//                System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				CourseDistributionBean bean=new CourseDistributionBean();	
//				bean.setMemberId( result.getInt("member_id") );
//				bean.setSchemeId( result.getInt("scheme_id") );
//                                bean.setSchemePart( result.getInt("scheme_part") );
//                                bean.setSemester( result.getInt("scheme_semester") );
//				bean.setCourseNo( result.getString("course_no") );
//                                bean.setCdId(result.getInt("cd_id"));
//                                bean.setDistributionDate(result.getDate("distribution_date"));
//                                bean.setRemarks( result.getString("remarks") );
//                                
////                                bean.setFirstName( result.getString("first_name") );
////                                bean.setLastName( result.getString("last_name") );
////                                bean.setSurname( result.getString("surname") );
////                                bean.setNic( result.getString("nic") );
////                                bean.setDateOfAppointment( result.getDate("date_of_appointment") );
////				bean.setEmail( result.getString("email") );
////                                bean.setPass( result.getString("pass") );
////                                bean.setDesignation(result.getString("designation"));
//				bean.setSearch(search);
//                                
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}        
//		public static Vector getCourseDistribution(int memberId,int cdYearId)throws Exception{
//		String query="select * from course_distribution where member_id="+memberId+" and cd_year_id="+cdYearId;
//                System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				CourseDistributionBean bean=new CourseDistributionBean();	
//				bean.setMemberId( result.getInt("member_id") );
//				bean.setSchemeId( result.getInt("scheme_id") );
//                                bean.setSchemePart( result.getInt("scheme_part") );
//                                bean.setSemester( result.getInt("scheme_semester") );
//				bean.setCourseNo( result.getString("course_no") );
//                                bean.setCdId(result.getInt("cd_id"));
//                                bean.setDistributionDate(result.getDate("distribution_date"));
//                                bean.setRemarks( result.getString("remarks") );							
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}        
//
//                
//          public static Vector getCourseDistribution()throws Exception{
//		String query="select cd.cd_id,cd.member_id,cd.scheme_id,cd.scheme_part,cd.scheme_semester,cd.course_no,cd.distribution_date,cd.remarks,first_name,last_name,surname,nic,date_of_appointment,email,pass,designation from course_distribution cd,faculty_members fm where cd.member_id=fm.member_id";
//		System.out.println(query);//int schemeId,int schemePart,int semester,String courseNo,
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				CourseDistributionBean bean=new CourseDistributionBean();	
//				bean.setMemberId( result.getInt("member_id") );
//				bean.setSchemeId( result.getInt("scheme_id") );
//                                bean.setSchemePart( result.getInt("scheme_part") );
//                                bean.setSemester( result.getInt("scheme_semester") );
//				bean.setCourseNo( result.getString("course_no") );
//                                bean.setCdId(result.getInt("cd_id"));
//                                bean.setDistributionDate(result.getDate("distribution_date"));
//                                bean.setRemarks( result.getString("remarks") );
//                                
//                                bean.setFirstName( result.getString("first_name") );
//                                bean.setLastName( result.getString("last_name") );
//                                bean.setSurname( result.getString("surname") );
//                                bean.setNic( result.getString("nic") );
//                                bean.setDateOfAppointment( result.getDate("date_of_appointment") );
//				bean.setEmail( result.getString("email") );
//                                bean.setPass( result.getString("pass") );
//                                bean.setDesignation(result.getString("designation"));
//							
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}     
//      
//	public static Vector getAttendance(int batchId,int part,int cdId,String dateOfAttendace)throws Exception{
//            String query="Select * from attendance where batch_id="+batchId+" and part="+part+" and cd_id="+cdId+" and attendance_date=#"+dateOfAttendace+"#";
////String query="SELECT a.attendance_id,a.attendance_date, a.remarks, first_name, last_name, surname, nic, date_of_appointment, email, pass, designation FROM attendance a, faculty_members AS fm WHERE a.member_id=fm.member_id and batch_id="+batchId+" and scheme_part="+part+" and cd_id="+cdId;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				AttendanceBean bean=new AttendanceBean();	
//				bean.setRollNo(result.getString("roll_no") );
//				bean.setBatchId(result.getInt("batch_id") );
//				bean.setPart(result.getInt("part") );
//				
//                                bean.setCdId(result.getInt("cd_id"));
//                                bean.setAttendanceId(result.getInt("attendance_id") );
//                                bean.setAttendanceDate(result.getDate("attendance_date") );
//                                bean.setStatus(result.getString("status"));
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	} 
//     public static Vector getDateOfAttendance(int batchId,int part,int cdId )throws Exception{
//            String query="Select distinct attendance_date from attendance where batch_id="+batchId+" and part="+part+" and cd_id="+cdId;
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//                            
//                            String date=Decoder.getDateFormat(result.getDate("attendance_date"));
//                                
////                              			
//				v.addElement(date);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//}       
//	public static Vector getCourseDistributionYear()throws Exception{
//		String query="select * from course_distribution_year";
//		System.out.println(query);
//		Statement st=null;
//		ResultSet result=null;
//		try{
//			st=con.createStatement();
//			result=st.executeQuery(query);
//			Vector v=new Vector();
//			while(result.next()){
//				CourseDistributionYearBean bean=new CourseDistributionYearBean();	
//				bean.setCdYearId( result.getInt("cd_year_id") );
//				bean.setCdYear( result.getInt("cd_year") );
//				bean.setRemarks( result.getString("remarks") );			
//				v.addElement(bean);
//			}
//			return v;
//		}finally{
//			if(result!=null)result.close();
//			if(st!=null)st.close();
//		}
//	}
