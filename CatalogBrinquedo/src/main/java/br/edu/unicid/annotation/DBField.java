package br.edu.unicid.annotation;
import java.lang.annotation.*;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface DBField {
  String colummn() default "";
}