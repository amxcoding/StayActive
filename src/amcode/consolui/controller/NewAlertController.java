package amcode.consolui.controller;

import amcode.application.common.interfaces.Controller;
import amcode.application.common.interfaces.Displayable;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.model.User;

import java.util.HashMap;

public class NewAlertController implements Controller<User> {
    @Override
    public Displayable execute(HashMap<String, InputField> inputField, User model) {


        return null;
    }
}