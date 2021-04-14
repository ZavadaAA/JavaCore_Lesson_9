package Lesson_9;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Courses course = new Courses("История Европы ХХ века");
        Courses course1 = new Courses("Сопромат");
        Courses course2 = new Courses("Технология питания");
        Courses course3 = new Courses("Инженерная графика");
        Courses course4 = new Courses("Экономика");
        Courses course5 = new Courses("Анатомия");
        Courses course6 = new Courses("Фехтование");


        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Иванович Петр", Arrays.asList(course1, course4)),
                new Student("Сидоров Евстафий", Arrays.asList(course3, course5, course6)),
                new Student("Андреев Григорий", Arrays.asList(course, course1, course2)),
                new Student("Гребешкова Вероника", Arrays.asList(course, course2, course4, course3, course5))
        ));

        System.out.println("В нашем соревновании участвуют:");
        System.out.println(students.stream()
                .map(Student::getName)
                .collect(Collectors.toSet()));

        System.out.println("------------------------------------------");
        System.out.println("Список уникальных курсов наших студентов:");
        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(c -> c.stream())
                .collect(Collectors.toSet()));

        System.out.println("------------------------------------------");
        System.out.println("Ниже представлены 3 наших самых любознательных студента:");
        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));

        System.out.println("------------------------------------------");
        Courses course_desired = new Courses("Экономика");

        System.out.println("А это студенты, которые посещают " + course_desired + ":");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course_desired))
                .collect(Collectors.toList()));

    }
}