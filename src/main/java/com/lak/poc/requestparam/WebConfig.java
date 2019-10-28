package com.lak.poc.requestparam;

import com.lak.poc.requestparam.anot.ParamName;
import com.lak.poc.requestparam.anot.ParamNameProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig {

    /**
     * Processor for annotation {@link ParamName}.
     *
     * @return ParamNameProcessor
     */
    @Bean
    protected ParamNameProcessor paramNameProcessor() {
        return new ParamNameProcessor();
    }

    /**
     * Custom {@link org.springframework.beans.factory.config.BeanPostProcessor} for adding {@link ParamNameProcessor} into the first of
     * {@link RequestMappingHandlerAdapter#}.
     *
     * @return BeanPostProcessor
     */
    @Bean
    public BeanPostProcessor beanPostProcessor() {
        return new BeanPostProcessor() {

            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof RequestMappingHandlerAdapter) {
                    RequestMappingHandlerAdapter adapter = (RequestMappingHandlerAdapter) bean;
                    List<HandlerMethodArgumentResolver> argumentResolvers = new ArrayList<>(adapter.getArgumentResolvers());
                    argumentResolvers.add(0, paramNameProcessor());
                    adapter.setArgumentResolvers(argumentResolvers);
                }
                return bean;
            }
        };
    }
}
