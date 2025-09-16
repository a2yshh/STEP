// File: HierarchicalInheritanceDemo.java
import java.util.Date;
import java.text.SimpleDateFormat;

// ==================== Base Class ====================
class Employee {
    // Protected fields
    protected String employeeId;
    protected String name;
    protected double baseSalary;
    protected String department;
    protected Date joiningDate;

    // Constructor
    public Employee(String employeeId, String name, double baseSalary, String department, Date joiningDate) {
        if (employeeId == null || name == null || baseSalary < 0) {
            throw new IllegalArgumentException("Invalid employee data");
        }
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
        this.department = department;
        this.joiningDate = joiningDate;
        System.out.println("Employee " + name + " created in " + department);
    }

    // Methods to be overridden
    public double calculateSalary() {
        return baseSalary;
    }

    public String getJobDescription() {
        return "General Employee";
    }

    public void performWork() {
        System.out.println("Employee is working");
    }

    public void attendMeeting() {
        System.out.println("Employee attending meeting");
    }

    // Final methods
    public final String getEmployeeId() {
        return employeeId;
    }

    public final void printEmployeeDetails() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Dept: " + department +
                ", Salary: " + calculateSalary() + ", Joined: " + sdf.format(joiningDate));
    }

    // Default behavior
    public void takeBreak() {
        System.out.println(name + " is taking a short break");
    }

    public void clockIn() {
        System.out.println(name + " clocked in");
    }

    public void clockOut() {
        System.out.println(name + " clocked out");
    }
}

// ==================== Developer Class ====================
class Developer extends Employee {
    private String[] programmingLanguages;
    private String experienceLevel; // Junior/Mid/Senior
    private int projectsCompleted;

    public Developer(String employeeId, String name, double baseSalary, String department, Date joiningDate,
                     String[] programmingLanguages, String experienceLevel, int projectsCompleted) {
        super(employeeId, name, baseSalary, department, joiningDate);
        this.programmingLanguages = programmingLanguages;
        this.experienceLevel = experienceLevel;
        this.projectsCompleted = projectsCompleted;
        System.out.println("Developer profile created");
    }

    @Override
    public double calculateSalary() {
        double bonus = 0;
        if (experienceLevel.equalsIgnoreCase("Senior")) bonus += 20000;
        else if (experienceLevel.equalsIgnoreCase("Mid")) bonus += 10000;
        bonus += projectsCompleted * 1000;
        return baseSalary + bonus;
    }

    @Override
    public String getJobDescription() {
        return "Software Developer";
    }

    @Override
    public void performWork() {
        System.out.println("Developer is coding and debugging");
    }

    @Override
    public void attendMeeting() {
        System.out.println("Developer in technical meeting");
    }

    // Developer-specific methods
    public void writeCode() {
        System.out.println("Writing code in " + String.join(", ", programmingLanguages));
    }

    public void reviewCode() {
        System.out.println("Reviewing team's code");
    }

    public void deployApplication() {
        System.out.println("Deploying application to production");
    }
}

// ==================== Manager Class ====================
class Manager extends Employee {
    private int teamSize;
    private String managementLevel; // Team Lead/Manager/Director
    private double budgetResponsibility;

    public Manager(String employeeId, String name, double baseSalary, String department, Date joiningDate,
                   int teamSize, String managementLevel, double budgetResponsibility) {
        super(employeeId, name, baseSalary, department, joiningDate);
        this.teamSize = teamSize;
        this.managementLevel = managementLevel;
        this.budgetResponsibility = budgetResponsibility;
        System.out.println("Manager profile created");
    }

    @Override
    public double calculateSalary() {
        double bonus = teamSize * 500;
        if (managementLevel.equalsIgnoreCase("Director")) bonus += 30000;
        else if (managementLevel.equalsIgnoreCase("Manager")) bonus += 15000;
        else if (managementLevel.equalsIgnoreCase("Team Lead")) bonus += 5000;
        return baseSalary + bonus;
    }

    @Override
    public String getJobDescription() {
        return "Team Manager";
    }

    @Override
    public void performWork() {
        System.out.println("Manager is coordinating team activities");
    }

    @Override
    public void attendMeeting() {
        System.out.println("Manager leading strategic meeting");
    }

    // Manager-specific methods
    public void conductPerformanceReview() {
        System.out.println("Conducting team performance review");
    }

    public void assignTasks() {
        System.out.println("Assigning tasks to team members");
    }

    public void manageBudget() {
        System.out.println("Managing department budget");
    }
}

// ==================== Intern Class ====================
class Intern extends Employee {
    private String university;
    private int internshipDuration; // weeks
    private String mentor;
    private boolean isFullTime;

    public Intern(String employeeId, String name, double stipend, String department, Date joiningDate,
                  String university, int internshipDuration, String mentor, boolean isFullTime) {
        super(employeeId, name, stipend, department, joiningDate);
        this.university = university;
        this.internshipDuration = internshipDuration;
        this.mentor = mentor;
        this.isFullTime = isFullTime;
        System.out.println("Intern onboarded");
    }

    @Override
    public double calculateSalary() {
        return baseSalary; // stipend
    }

    @Override
    public String getJobDescription() {
        return "Intern";
    }

    @Override
    public void performWork() {
        System.out.println("Intern is learning and assisting");
    }

    // Intern-specific methods
    public void attendTraining() {
        System.out.println("Intern attending training session");
    }

    public void submitReport() {
        System.out.println("Submitting weekly progress report");
    }

    public void seekMentorship() {
        System.out.println("Getting guidance from mentor " + mentor);
    }
}

// ==================== Utility Class ====================
class EmployeeManager {
    public static double calculateTotalPayroll(Employee[] employees) {
        double total = 0;
        for (Employee e : employees) {
            total += e.calculateSalary();
        }
        return total;
    }

    public static void generateReport(Employee[] employees) {
        System.out.println("\n=== Employee Report ===");
        for (Employee e : employees) {
            e.printEmployeeDetails();
            System.out.println("Job: " + e.getJobDescription());
        }
    }
}

// ==================== Demo Class ====================
public class HierarchicalInheritanceDemo {
    public static void main(String[] args) {
        Date today = new Date();

        // Create array of employees
        Employee[] employees = new Employee[3];
        employees[0] = new Developer("D001", "Alice", 60000, "IT", today,
                                     new String[]{"Java", "Python"}, "Senior", 12);
        employees[1] = new Manager("M001", "Bob", 80000, "Management", today,
                                   10, "Manager", 500000);
        employees[2] = new Intern("I001", "Charlie", 15000, "IT", today,
                                  "Tech University", 12, "D001", false);

        // Polymorphic method calls
        System.out.println("\n=== Polymorphism Demo ===");
        for (Employee e : employees) {
            e.performWork();
            e.attendMeeting();
            System.out.println("Salary: " + e.calculateSalary());
        }

        // Type checking
        System.out.println("\n=== Type Checking ===");
        for (Employee e : employees) {
            if (e instanceof Developer) {
                ((Developer) e).writeCode();
            } else if (e instanceof Manager) {
                ((Manager) e).assignTasks();
            } else if (e instanceof Intern) {
                ((Intern) e).attendTraining();
            }
        }

        // Payroll and report
        System.out.println("\nTotal Payroll: " + EmployeeManager.calculateTotalPayroll(employees));
        EmployeeManager.generateReport(employees);
    }
}
