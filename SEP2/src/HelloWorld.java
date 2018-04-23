import Model.Date;
import Model.Employee;

public class HelloWorld {
	public static void main(String[] args)
	{
		Date date = new Date(30,30,2010);
		Employee emp = new Employee("M15","LukasS", "STRONL", "GAIDZIU10", "1234567891011", "lukasass@gmail.com", "+458488484", "LOl", date);
		String sql = "insert into Employee values('" + emp.getMemberID() + "'," + "'" + emp.getFirstName() + "'," + "'" + emp.getLastName() + "'," + "'" + emp.getAdress() + "'," + "'" + emp.getCPRnumber() + "'," + "'" + emp.getEmail() + "'," + "'" + emp.getPhoneNr() + "'," + "'" + emp.getDefoultTaxCard() + "'," + "'" + emp.getDOB() + ");"; 
		System.out.println(sql);
	}
}
