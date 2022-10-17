package lecture.p01lombok;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
public class JavaBean7 {
	private final String name;
	private final int age;
	private String address;

	JavaBean7(String name, int age, String address) {
		this.name = name;
//		this.age = age;
	}
}
