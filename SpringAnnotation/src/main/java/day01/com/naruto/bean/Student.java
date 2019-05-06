package day01.com.naruto.bean;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
@Component//表示为spring的组件(相同的注解有@Controller,@Service,@Repository,@Component)
public class Student {

    private String id;
    private String stuNo;
    private String name;

}
