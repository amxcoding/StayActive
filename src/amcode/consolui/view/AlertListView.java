package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.consolui.view.factory.ViewFactory;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.model.Alert;
import amcode.domain.model.User;

import java.util.HashMap;
import java.util.List;

public class AlertListView extends FormView<User> {

    public AlertListView(HashMap<String, InputField> inputFields, Controller<User> controller) {
        super(inputFields, controller);
    }

    @Override
    public void display(Display display) {
        switch (display) {
            case MAIN:
                displayAlerts();
                displayInfo();
                int choice = getScanner().nextInt();
                // TODO validate input
                FormView formView;

                switch (choice) {
                    case 1:
                        formView = ViewFactory.getView(getInputFields(), View.NEW_ALERT_VIEW);
                        formView.display(Display.MAIN);
                        break;
                    case 2:
                        // TODO: Modify Alert
//                        formView = ViewFactory.getView(getInputFields(), ViewEnum.MODIFY_ALERT_VIEW);
//                        formView.display(DisplayEnum.MAIN);
                        break;
                    case 3:
                        formView = ViewFactory.getView(getInputFields(), View.MAIN_VIEW);
                        formView.display(Display.MAIN);
                        break;
                    case 4:
                        // Quit
                        break;
                    default:
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

    @Override
    protected void displayInfo() {
        System.out.println(
                "Choose an option: +\n" +
                        "\t1. Add new alert.\n" +
                        "\t2. Modify alert.\n" +
                        "\t3. Back.\n" +
                        "\t4. Quit."
        );
    }

    private void displayAlerts() {
        User loggedInUser = (User) getInputFields().get("logged_in_user").getValue();
        List<Alert> alertList = loggedInUser.getAlertList();

        System.out.println("Current alerts: ");
        for (Alert alert: alertList) {
            System.out.println("\t" + alert);
        }
    }
}