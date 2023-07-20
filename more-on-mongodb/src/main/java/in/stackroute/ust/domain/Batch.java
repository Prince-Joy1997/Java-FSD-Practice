package in.stackroute.ust.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "batches")
public class Batch {

    @Id
    private String id;

    private String code;

    private String description;

    private Set<Student> students;

    public Batch() {
    }

    public Batch(String code, String description, Set<Student> students) {
        this.code = code;
        this.description = description;
        this.students = students;
    }

    public Batch(String id, String code, String description, Set<Student> students) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.students = students;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", students=" + students +
                '}';
    }
}
