

public class AttendanceSystemRequestController {

	public Object[][] getAttendanceRecord(String classID, String date) {
		ClassRosterService rosterService = ServiceFactory.getClassRosterService();
		AttendanceRecordService recordService = ServiceFactory.getAttendanceRecordService();
		
		ClassRoster roster = rosterService.getClassRoster(classID);
		AttendanceRecord record = recordService.getAttendanceRecord(classID, date);
		
		Object[][] data = new Object[roster.students.length][2];
		for(int i = 0; i < data.length; i++) {
			String name = roster.getStudents()[i].getName();
			String attnStatus = " ";
			for(int j = 0; j < record.missingStudents.length; j++) {
				if(name.equals(record.getMissingStudents()[j].getName())) {
					attnStatus = "X";
				}
			}
			data[i][0] = name;
			data[i][1] = attnStatus;
		}
		return data;
	}
}
