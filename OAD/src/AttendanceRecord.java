import java.util.Date;


public class AttendanceRecord {

	Student[] missingStudents;
	String classID;
	String date;
	
	public Student[] getMissingStudents() {
		return missingStudents;
	}
	public void setMissingStudents(Student[] missingStudents) {
		this.missingStudents = missingStudents;
	}
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
