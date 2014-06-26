
public class ServiceFactory {

	private static ClassRosterService classRosterService;
	private static AttendanceRecordService attendanceRecordService;
	
	public static ClassRosterService getClassRosterService() {
		if(classRosterService == null) {
			classRosterService = new ClassRosterServiceImpl();
		}
		
		return classRosterService;
	}
	
	public static AttendanceRecordService getAttendanceRecordService() {
		if(attendanceRecordService == null) {
			attendanceRecordService = new AttendanceRecordServiceImpl();
		}
		
		return attendanceRecordService;
	}
	
}
