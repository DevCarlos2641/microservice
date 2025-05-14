package http.response;

import lombok.Data;

import java.util.List;

@Data
public class StudentByCourseResponse {

    private String course_name;
    private String teacher;
    private List<?> students;

}
