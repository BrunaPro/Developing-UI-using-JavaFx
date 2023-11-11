package com.example.brunasilva_comp228lab4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.security.PrivilegedAction;

public class HelloController {

    //fields present on the interface
    @FXML
    private Label welcomeText;

    @FXML
    private ScrollPane ScrollPane_box;
    @FXML
    private TextArea textarea_output;
    @FXML
    private TextField textfield_name;
    @FXML
    private TextField textfield_adress;
    @FXML
    private TextField textfield_province;
    @FXML
    private TextField textfield_city;
    @FXML
    private TextField textfield_postalcode;
    @FXML
    private TextField textfield_phone;
    @FXML
    private TextField textfield_email;
    @FXML
    private CheckBox checkbox_student;
    @FXML
    private CheckBox checkbox_volunteer;
    @FXML
    private RadioButton radio_computersscience;
    @FXML
    private RadioButton radio_business;
    @FXML
    private ComboBox<String> chombobox_course;
    @FXML
    private String[] coursesComputer = {"Java", "C#", "Python"};
    @FXML
    private String[] coursesBusiness = {"Businnes1", "Business2", "Comunication"};
    private ObservableList<String> selectedCoursesList = FXCollections.observableArrayList();

    //second textarea that get the courses from the combo box and display them
    @FXML
    private TextArea textarea_listcourses;

    String selectedCourse;
    StringBuilder coursesText = new StringBuilder();

    //object created to have all the fields and to be display on the textarea
    StringBuilder displayOutPut = new StringBuilder();


    // method with one control the radio button
    //if one is select the other options is of
    @FXML
    protected void onRadioOptions() {
        //radio button for Computer Science
        if (radio_computersscience.isSelected()) {
            chombobox_course.getItems().setAll(coursesComputer);
            radio_business.setSelected(false);
        }
        //radio button for Business
        if (radio_business.isSelected()) {
            chombobox_course.getItems().setAll(coursesBusiness);
            radio_computersscience.setSelected(false);
        }
    }

    //method to ge the values of the combo box put then on the list and display them on the textarea
    @FXML
    protected void onComboBoxSelection() {

        selectedCourse = chombobox_course.getValue();

        if (!selectedCoursesList.contains(selectedCourse)) {
            selectedCoursesList.add(selectedCourse);
        }

        //so the courses won't be repeated in the textarea
        coursesText.setLength(0);

        //display the item of the list on the textarea so the user can see  which course his adding
        for (String courses : selectedCoursesList) {
            coursesText.append(courses).append("\n");
        }
        textarea_listcourses.setText(coursesText.toString());
    }

    //method that display the fields so the values can be display on the textarea
    @FXML
    protected void onDisplayClick() {
        displayOutPut.append(textfield_name.getText()).append(",  ");
        displayOutPut.append(textfield_adress.getText()).append(",  ");
        displayOutPut.append(textfield_province.getText()).append(",  ");
        displayOutPut.append(textfield_city.getText()).append(",  ");
        displayOutPut.append(textfield_postalcode.getText()).append(",  ");
        displayOutPut.append(textfield_phone.getText()).append(",  ");
        displayOutPut.append(textfield_email.getText()).append(",  ");

        // if the student had check council
        if (checkbox_student.isSelected()) {
            displayOutPut.append(checkbox_student.getText()).append(",  ");


        }
        // if the student had check volunteer
        if (checkbox_volunteer.isSelected()) {
            displayOutPut.append(checkbox_volunteer.getText()).append(" ");

        }

        //condition for the user to enter all fields
        if (textfield_name.getText().isEmpty() || textfield_adress.getText().isEmpty() || textfield_province.getText().isEmpty() || textfield_city.getText().isEmpty() ||
        textfield_postalcode.getText().isEmpty() ||  textfield_phone.getText().isEmpty() || textfield_email.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Field");
            alert.setHeaderText(null);
            alert.setContentText("Please, fill up all the values");

            alert.showAndWait();

        }
        // if all the values are completed then the output will be display
        else {

            //display the combo box list
            displayOutPut.append("\n Courses:\n");
            for (String course : selectedCoursesList) {
                displayOutPut.append(course).append("\n");
            }

            //display all the values on the object on the textarea
            textarea_output.setText(displayOutPut.toString());
        }
    }

    //button to restart the process of fill the information up from the beginning
    @FXML
    private void onRestartClick() {
        textfield_name.clear();
        textfield_adress.clear();
        textfield_province.clear();
        textfield_city.clear();
        textfield_postalcode.clear();
        textfield_phone.clear();
        textfield_email.clear();
        textarea_output.clear();
        textarea_listcourses.clear();
        checkbox_student.setSelected(false);
        checkbox_volunteer.setSelected(false);
        radio_business.setSelected(false);
        radio_computersscience.setSelected(false);
        selectedCoursesList.clear();
    }

    //clean the combo box so the user can choose the courses from the beginning
    @FXML
    private void onRemoveClick(){
        selectedCoursesList.clear();
        textarea_listcourses.clear();
        chombobox_course.getItems().clear();
        chombobox_course.setValue("");

        if (radio_computersscience.isSelected()) {
            chombobox_course.getItems().setAll(coursesComputer);
            radio_business.setSelected(false);
        }
        //radio button for Business
        if (radio_business.isSelected()) {
            chombobox_course.getItems().setAll(coursesBusiness);
            radio_computersscience.setSelected(false);
        }

    }
}
