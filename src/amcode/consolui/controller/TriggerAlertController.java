package amcode.consolui.controller;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.TimeInputField;
import amcode.domain.model.Alert;
import amcode.domain.model.Interval;
import amcode.domain.services.interval.notification.IntervalNotification;
import amcode.domain.services.interval.notification.NotificationTimeCreatorA;

import java.time.LocalTime;
import java.util.HashMap;

public class TriggerAlertController implements Controller<Alert> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, Alert model) {
        FormView formView;
        Display display;

        // calculate notification time
        Alert chosenAlert = (Alert) inputField.get("chosenTriggerAlert").getValue();
        Interval interval = chosenAlert.getInterval();
        IntervalNotification intervalNotification = new IntervalNotification();
        LocalTime notificationTime = intervalNotification.calcNextNotificationTime(
                new NotificationTimeCreatorA(), interval);
        inputField.put("notificationTime", new TimeInputField(notificationTime));

        formView = ViewFactory.getView(inputField, View.NOTIFICATION_VIEW);
        display = Display.MAIN;

        return new DisplayScreen(formView, display);
    }
}