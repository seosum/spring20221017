package lecture.p01lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data // 아래 5개의 어노테이션을 한번에 적용함
//@ToString
//@EqualsAndHashCode
//@Getter
//@Setter
//@requiredArgsConstructor
public class JavaBean5 {
	private String name;
	private int age;
}
