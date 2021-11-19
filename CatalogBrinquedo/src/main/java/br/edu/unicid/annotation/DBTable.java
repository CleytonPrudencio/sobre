package br.edu.unicid.annotation;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited

public @interface DBTable {
  public String table();
}

