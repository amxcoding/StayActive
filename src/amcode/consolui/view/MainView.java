package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.consolui.view.factory.ViewFactory;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.model.User;

import java.util.HashMap;

public class MainView extends FormView<User> {

    public MainView(HashMap<String, InputField> inputFields, Controller<User> controller) {
        super(inputFields, controller);
    }

    @Override
    public void display(Display display) {
        switch (display) {
            case MAIN:
                displayInfo();
                int choice = getScanner().nextInt();
                // TODO validate input
                FormView formView;

                switch (choice) {
                    case 1:
                        // TODO: view profile
//                        formView = ViewFactory.getView(getInputFields(), ViewEnum.PROFILE_VIEW);
//                        formView.display(DisplayEnum.MAIN);
                        break;
                    case 2:
                        formView = ViewFactory.getView(getInputFields(), View.ALERT_LIST_VIEW);
                        formView.display(Display.MAIN);
                        break;
                    case 3:
                        // TODO: view exercise history
//                        formView = ViewFactory.getView(getInputFields(), ViewEnum.EXERCISE_HISTORY_VIEW);
//                        formView.display(DisplayEnum.MAIN);
                        break;
                    case 4:
                        // Quit
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        break;
                }
                break;
            default:
                break;
        }

    }

    @Override
    public void submit(HashMap<String, InputField> inputFields, Controller<User> controller) {
    }
}