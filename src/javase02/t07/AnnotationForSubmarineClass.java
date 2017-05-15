package javase02.t07;

import java.lang.annotation.*;


@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface AnnotationForSubmarineClass {
    String author();
    String version();
    String date();
}
