package mid_test.com.jpa_test.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JpaModel {

    private long seq;
    private String user_name;
    private String department;
    private String level;
    private Integer age;

}
