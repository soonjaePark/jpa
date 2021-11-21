package mid_test.com.jpa_test.Entities;

import javax.persistence.Entity;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Student_Info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JpaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;
    private String user_name;
    private String department;
    private String level;
    private int age;


}
