package test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class Annotation {
	
	@TestAnnotation
	private String s;

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface TestAnnotation{}
