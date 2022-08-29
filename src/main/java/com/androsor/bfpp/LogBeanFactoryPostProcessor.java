package com.androsor.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

import java.util.List;

/**
 * The {@code LogBeanFactoryPostProcessor}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 29.08.2022 22:09
 */
public class LogBeanFactoryPostProcessor implements BeanFactoryPostProcessor, PriorityOrdered {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println();
//        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
//            var beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
//            var genericArgumentValues = beanDefinition.getConstructorArgumentValues().getGenericArgumentValues();
//            for(ConstructorArgumentValues.ValueHolder genericArgumentValue : genericArgumentValues) {
//                // TODO: 29.08.2022 set get
//            }
//        }
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
