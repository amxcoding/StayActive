package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.StringInputField;
import amcode.domain.model.User;

import java.util.HashMap;

public class LoginView extends FormView<User> {

    public LoginView(HashMap<String, InputField> inputFields, Controller<User> controller) {
        super(inputFields, controller);
    }

    @Override
    public void display(Display display) {

        switch (display) {
            case MAIN:
                System.out.println("Enter username: ");
                String username = getScanner().nextLine();
                System.out.println("Enter password: ");
                String password = getScanner().nextLine();

                getInputFields().put("username", new StringInputField(username));
                getInputFields().put("password", new StringInputField(password));

                display(Display.SUCCESS);
                break;
            case FAIL:
                System.out.println("Incorrect password or username.");
                System.out.println("Try again? [Y/N]");

                String choice = getScanner().nextLine();
                displayFail(choice);
                break;
            case SUCCESS:
                submit(getInputFields(), getController());
                break;
            default:
                break;
        }
    }


    @Override
    public void submit(HashMap<String, InputField> inputFields, Controller<User> controller) {
        final String username = (String) getInputFields().get("username").getValue();
        final String password = (String) getInputFields().get("password").getValue();
        User user = new User(username, password);

        controller.execute(getInputFields(), user);
    }

    private void displayFail (String choice) {
        if(choice.equalsIgnoreCase("y")) {
            display(Display.MAIN);
        } else if (choice.equalsIgnoreCase("n")){
            FormView formView = ViewFactory.getView(View.START_VIEW);
            formView.display(Display.MAIN);
        } else {
            System.out.println("Invalid input.");
            display(Display.MAIN);
        }
    }

}
