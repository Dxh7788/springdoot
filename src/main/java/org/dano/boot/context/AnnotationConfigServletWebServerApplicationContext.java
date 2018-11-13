package org.dano.boot.context;

import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author dongxiaohong on 2018/11/12 18:56
 */
public class AnnotationConfigServletWebServerApplicationContext extends GenericApplicationContext implements AnnotationConfigRegistry {


    private final Set<Class<?>> annotatedClasses = new LinkedHashSet<>();

    @Override
    public void register(Class<?>... annotatedClasses) {
        this.annotatedClasses.addAll(Arrays.asList(annotatedClasses));
    }

    @Override
    public void scan(String... basePackages) {

    }

    private AnnotatedBeanDefinitionReader reader;
    private ClassPathBeanDefinitionScanner scanner;

    public AnnotationConfigServletWebServerApplicationContext() {
        this.reader = new AnnotatedBeanDefinitionReader(this);
        this.scanner = new ClassPathBeanDefinitionScanner(this);
    }
}
