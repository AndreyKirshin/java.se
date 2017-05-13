package javase02.t07;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;


@Documented
@Inherited
@Target(ElementType.TYPE)
public @interface AnnotationForSubmarineClass {
}
