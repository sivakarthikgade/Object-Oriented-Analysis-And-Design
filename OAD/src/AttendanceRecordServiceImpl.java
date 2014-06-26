import java.io.BufferedReader;
import java.io.FileReader;


public class AttendanceRecordServiceImpl implements AttendanceRecordService {

	public AttendanceRecord getAttendanceRecord(String classID, String date) {
		AttendanceRecord record = new AttendanceRecord();
		try {
			String recordFileName = constructFileName(classID, date);
			BufferedReader br = new BufferedReader(new FileReader(recordFileName));
			String str = br.readLine();
			String[] tokens = str.split(",");
			Student[] missingStudents = new Student[tokens.length - 2];
			for(int i = 2; i < tokens.length; i++) {
				Student student = new Student();
				student.setName(tokens[i].trim());
				missingStudents[i-2] = student;
			}
			record.setClassID(classID);
			record.setDate(date);
			record.setMissingStudents(missingStudents);
		} catch(Exception e) {
			System.out.println("AttendanceRecordService: Encountered Error. Please Try Again Later."+e.getMessage());
		}
		return record;
	}
	
	private String constructFileName(String classID, String date) {
		return "attendRec"+classID+"-"+date+".csv";
	}

}
