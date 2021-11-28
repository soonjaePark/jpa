package mid_test.com.jpa_test.Entities;

import javax.persistence.Entity;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mid_test.com.jpa_test.Model.JpaModel;

@Entity
@Table(name = "Student_Info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;
    private String user_name;
    private String department;
    private String level;
    private int age;

    public static JpaModel CovertToDto(JpaEntity j) {
        return new JpaModel(j.getSeq(), j.getUser_name(), j.getDepartment(), j.getLevel(), j.getAge());
    }
}
