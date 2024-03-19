import java.util.Date;
// Imports for Postgresql connections
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class question1{
    public static Connection connection;

    /**
     * Print all the students in the database along with their
     * attributes. These are:
     * *student_id,
     * *first_name,
     * *last_name,
     * *email,
     * *enrollement_date
    */
    public static void getAllStudents(){
        try{
            // Create, execute, and store result of the select query
            Statement stmt = connection.createStatement();
            String query = "select * from students";
            ResultSet rs = stmt.executeQuery(query);

            // Code used to format output to look nice
            String overhead, output;
            overhead = String.format("%-15s", "Student_id") + "|";
            overhead = overhead + String.format("%-15s", "first_name") + "|";
            overhead = overhead + String.format("%-15s", "last_name") + "|";
            overhead = overhead + String.format("%-30s", "email") + "|";
            overhead = overhead + String.format("%-15s", "enrollement_date");
            System.out.println(String.format("%95s", "").replace(' ', '-'));
            System.out.println(overhead);
            System.out.println(String.format("%95s", "").replace(' ', '-'));

            // Iterate over all rows in the database while
            // printing all the entries in the current row
            while(rs.next()){
                int student_id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String email = rs.getString(4);
                Date enroll_date = rs.getDate(5);

                // Format the output string to make it easier to parse
                output = String.format("%-15s", student_id) + "|";
                output = output + String.format("%-15s", first_name) + "|";
                output = output + String.format("%-15s", last_name) + "|";
                output = output + String.format("%-30s", email) + "|";
                output = output + String.format("%-15s", enroll_date);
                System.out.println(output);
            }

            stmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    /** 
     * Adds a new student to the database with:
     * @param first_name - New student's first name.
     * @param last_name - New student's last name.
     * @param email - New student's email.
     * @param enrollement_date - New student's enrollement date.
     * 
     * !Note: This function makes a permanent update to the database, so
     * !      be sure you don't accidentally make a change you don't want.
    */
    public static void addStudent(String first_name, String last_name, String email, String enrollement_date){
        try{
            // Create, execute, and store result of the insert query
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO students(first_name, last_name, email, enrollment_date) VALUES ("+first_name+", "+last_name+", "+email+", "+enrollement_date+");";
            int rowsInserted = stmt.executeUpdate(query);
            
            // Inform user if new student has been inserted into the database
            if(rowsInserted>0){
                System.out.println("A new student was added successfully!");
            }
            else{
                System.out.println("New student has not been added.");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Change the email of the student with the corresponding ID in the database.
     * 
     * @param student_id - Find student with this ID in the database.
     * @param new_email - Replace the old email with this new one.
     */
    public static void updateStudentEmail(int student_id, String new_email){
        try{
            // Create, execute, and store result of the update query
            Statement stmt = connection.createStatement();
            String query = "UPDATE students SET email="+new_email+" WHERE student_id="+student_id;
            int numStudentsUpdated = stmt.executeUpdate(query);

            if(numStudentsUpdated>0){
                System.out.println("Successfully updated student email.");
            }
            else{
                System.out.println("Student could not be found");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Remove the student from the database with the matching id.
     * Do nothing otherwise.
     * 
     * @param student_id - The student matching this id will be removed.
     */
    public static void deleteStudent(int student_id){
        try{
            // Create, execute, and store result of the delete query
            Statement stmt = connection.createStatement();
            String query = "DELETE FROM students WHERE student_id=" + student_id;
            int numRowsDeleted = stmt.executeUpdate(query);
            
            // Inform user of output
            if(numRowsDeleted > 0){
                System.out.println("Student successfully deleted.");
            }
            else{
                System.out.println("Student not found.");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        try{
            // Details needed to open a connection to the database
            String jdbcUrl = "jdbc:postgresql://localhost:5432/A3Q1";
            String username = "postgres";
            String password = "d@t@SQLbases";
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to Database");

            //* Print all students
            //getAllStudents();
            
            //* Add New Student to the database
            //addStudent("'Jack'", "'Jill'", "'jack@gmail.com'", "'2023-04-17'");
            //getAllStudents();
            
            //* Update a student's email in the database
            //updateStudentEmail(4, "'jack.jill@gmail.com'");
            //getAllStudents();

            //* Remove specified student from the database
            deleteStudent(4);
            getAllStudents();

            connection.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}