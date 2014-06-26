import java.io.BufferedReader;
import java.io.FileReader;



public class ClassRosterServiceImpl implements ClassRosterService {

	public ClassRoster getClassRoster(String classID) {
		ClassRoster roster = new ClassRoster();
		try {
			String rosterFileName = constructFileName(classID);
			BufferedReader br = new BufferedReader(new FileReader(rosterFileName));
			String str = br.readLine();
			String[] tokens = str.split(",");
			Student[] students = new Student[tokens.length];
			for(int i = 0; i < tokens.length; i++) {
				Student student = new Student();
				student.setID("stdnt"+((i > 98) ? "00" : ((i > 8) ? "000" : "0000"))+(i+1));
				student.setName(tokens[i].trim());
				students[i] = student;
			}
			roster.setClassID(classID);
			roster.setStudents(students);
		} catch(Exception e) {
			System.out.println("ClassRosterService: Encountered Error. Please Try Again Later."+e.getMessage());
		}
		return roster;
	}

	private String constructFileName(String classID) {
		return "ClassRoster-"+classID+".csv";
	}

}
