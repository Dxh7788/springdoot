package org.dano.boot.main;

import org.dano.boot.model.Processor;
import org.junit.Test;
import org.springframework.core.annotation.SynthesizedAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author dongxiaohong
 * @date 2018/12/6 14:23
 */
public class AnnotationCheckUtilsTest {

    /**
     * 注解的反射应当使用annotationType而不是getClass,否则获取方法时会获取到无用的方法,而且注解的方法都是不带参数的.
     * 可直接调用moethod.invoke(annotation)来执行获取到结果
     * */
    @Test
    public void annotationArrayTest() throws Exception{
        Class cls = new Processor().getClass();
        Field field = cls.getDeclaredField("name");
        Annotation[] localAnnotations = field.getDeclaredAnnotations();
        for (Annotation ann : localAnnotations){

            System.out.println(ann.annotationType().getName());
            Method[] annMethods = ann.annotationType().getDeclaredMethods();
            for (Method md : annMethods){
                //执行以下找到值
                Object attributeValue = md.invoke(ann);

                if (attributeValue instanceof Annotation[]){
                    Annotation[] value = (Annotation[])attributeValue;
                    Annotation[] annotations = (Annotation[])Array.newInstance(attributeValue.getClass().getComponentType(), value.length);
                    for (int i=0;i<value.length;i++){
                        annotations[i] = synthesizeAnnotation(value[i]);
                    }
                    for (Annotation anno:annotations){
                        Method[] methods = anno.annotationType().getDeclaredMethods();
                        for(Method mtd:methods){
                            Object o = mtd.invoke(anno);
                            System.out.println("值为:"+o.toString());
                        }
                    }
                    System.out.println("我可算找到你了");
                }
            }
        }
    }

    private Annotation synthesizeAnnotation(Annotation annotation) {
        Class annotationType = annotation.annotationType();
        if (annotation instanceof SynthesizedAnnotation){
            return annotation;
        }
        return annotation;
    }
}
