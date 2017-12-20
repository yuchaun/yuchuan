package com.jltour.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Created by xuzhaolin on 2017/5/19.
 */
@Component
public class MessageUtils {

    @Autowired
    private MessageSource messageSource;

    public  String getMessageByCode(String code){
        MessageSourceAccessor sourceAccessor = new MessageSourceAccessor(messageSource);
        return sourceAccessor.getMessage(code);
    }

    public String getFullMessages(List<ObjectError> errorList){
        final StringBuffer sb = new StringBuffer();
        errorList.forEach(error->{
            sb.append(getMessageByCode(error.getCode())).append(";");
        });
        return sb.toString();
    }
    public String getDefultMessages(BindingResult result){
        return result.getFieldError().getDefaultMessage();
    }

}
