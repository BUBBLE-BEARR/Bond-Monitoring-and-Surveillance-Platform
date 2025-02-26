package com.project.common.dict.apect;

import java.lang.reflect.Field;

public class DictDefinition {


    private Dict dict;

    private Field field;

    public Dict getDict() {
        return dict;
    }

    public void setDict(Dict dict) {
        this.dict = dict;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
