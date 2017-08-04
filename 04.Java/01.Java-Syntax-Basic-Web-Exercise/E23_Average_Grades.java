package Java_Basics_Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E23_Average_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        int studentsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < studentsCount; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String studentName = input[0];
            Double[] studentGrades = Arrays
                    .stream(input)
                    .skip(1)
                    .map(Double::parseDouble)
                    .toArray(Double[]::new);

            Student currentStudent = new Student() {{
                setName(studentName);
                setGrades(Arrays.asList(studentGrades));
            }};

            students.add(currentStudent);
        }

        Student[] filteredStudents = students
                .stream()
                .filter(s -> s.getAverageGrade() >= 5.00)
                .sorted((a, b) -> {
                    int comparissonResult = a.getName().compareTo(b.getName());

                    if (comparissonResult == 0) {   // if it returns 0, a equals b (we need to do
                                                    // the other sort - descending by avgGrade)
                        comparissonResult = b.getAverageGrade().compareTo(a.getAverageGrade());
                    }

                    return comparissonResult;
                })
                .toArray(Student[]::new);

        for (Student student : filteredStudents) {
            System.out.printf("%s -> %.2f%n", student.getName(), student.getAverageGrade());
        }
    }
}

class Student {
    private String name;

    private List<Double> grades;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public Double getAverageGrade() {
        double averageGrade = this.grades.stream().mapToDouble(a -> a).average().getAsDouble();
        return averageGrade;
    }
}