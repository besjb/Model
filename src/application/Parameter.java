package application;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Parameter {

    String category();

    String displayName();

    String scope();

    /**
     * 
     * for slider
     * @return
     */
    double min() default Double.NaN;

    /**
     * 
     * for slider
     * @return
     */
    double max() default Double.NaN;

    /**
     * 
     * 
     * @return which slider this is min bound of
     */
    String sliderMinOf() default "";

    /**
     * 
     * 
     * @return which slider this is max bound of
     */
    String sliderMaxOf() default "";

}
