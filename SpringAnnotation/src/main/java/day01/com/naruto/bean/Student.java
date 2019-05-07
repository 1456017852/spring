package day01.com.naruto.bean;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
@Component
public class Student {

    private String id;
    private String stuNo;
    private String name;

}
