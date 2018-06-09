package userinterface;

import java.util.Properties;
import java.util.ResourceBundle;
import common.MessageBundle;
import impresario.IModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.Worker;

public class ModifyWorkerView extends View 
{
	final static ResourceBundle message = new MessageBundle().getBundle();

	//GUI stuff
	private TextField bannerId;
	private PasswordField password;
	private TextField firstName;
	private TextField lastName;
	private TextField contactPhone;
	private TextField email;
	private TextField credentials;
	private TextField dateOfLatestCredentialsStatus;
	private TextField dateOfHire;
	private ComboBox status;
	
	private Button submitButton;
	private Button cancelButton;
	
	//For showing error message
	private MessageView statusLog;
	Worker myWorker;
	
	public ModifyWorkerView(IModel model) 
	{
		super(model, "ModifyWorkerView");
		//create container for showing contents
		
		
		VBox container = new VBox(10);
		
		container.setPadding(new Insets(15, 5, 5, 5));
		
		//Add a title for this panel
		container.getChildren().add(createTitle());
		
		//how do you add white space?
		//container.getChildren().add(new Label("space"));
		
		//create our GUI components, add them to this Container
		container.getChildren().add(createFormContents());
		
		container.getChildren().add(createStatusLog("			"));
		
		getChildren().add(container);
		
		populateFields();
		
		myModel.subscribe("TransactionError", this);
	}

	private Node createTitle() 
	{
		Text titleText = new Text("  "+ message.getString("modifyWorkerTitle")+" ");
		titleText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		titleText.setTextAlignment(TextAlignment.CENTER);
		titleText.setFill(Color.DARKGREEN);
		
	
		return titleText;
	}

	private GridPane createFormContents() 
	{
		GridPane grid = new GridPane();
    	grid.setAlignment(Pos.CENTER);
   		grid.setHgap(10);
    	grid.setVgap(10);
    	grid.setPadding(new Insets(25, 25, 25, 25));

    	// data entry fields
    	Label bannerIdLabel = new Label(message.getString("bannerId") + ": ");
    	Label passwordLabel = new Label(message.getString("password") + ": ");
    	Label firstNameLabel = new Label(message.getString("firstName") + ": ");
    	Label lastNameLabel = new Label(message.getString("lastName") + ": ");
    	Label contactPhoneLabel = new Label(message.getString("phoneNumber") + ": ");
    	Label emailLabel = new Label(message.getString("emailAddress") + ": ");
    	Label credentialsLabel = new Label(message.getString("credentials") + ": ");
    	Label dateOfLtCredsLabel = new Label(message.getString("dateOfCredentialStatus") + ": ");
    	Label dateOfHireLabel = new Label(message.getString("dateOfHire") + ": ");
    	Label statusLabel = new Label(message.getString("status") + ": ");
    	
    	grid.add(bannerIdLabel, 0, 0);
    	grid.add(passwordLabel, 0, 1);
    	grid.add(firstNameLabel, 0, 2);
    	grid.add(lastNameLabel, 0, 3);
    	grid.add(contactPhoneLabel, 0, 4);
    	grid.add(emailLabel, 0, 5);
    	grid.add(credentialsLabel, 0, 6);
    	grid.add(dateOfLtCredsLabel, 0, 7);
    	grid.add(dateOfHireLabel, 0, 8);
    	grid.add(statusLabel, 0, 9);
    	
    	bannerId = new TextField();
    	password = new PasswordField();
    	firstName = new TextField();
    	lastName = new TextField();
    	contactPhone = new TextField();
    	email = new TextField();
    	credentials = new TextField();
    	dateOfLatestCredentialsStatus = new TextField();
    	dateOfHire = new TextField();
    	status = new ComboBox();
    	status.getItems().addAll(
    			message.getString("choice1"),
    			message.getString("choice2")
    			
    			);
    	
    	bannerId.setEditable(false);
 
    	
    	grid.add(bannerId, 1, 0);
    	grid.add(password, 1, 1);
    	grid.add(firstName, 1, 2);
    	grid.add(lastName, 1, 3);
    	grid.add(contactPhone, 1, 4);
    	grid.add(email, 1, 5);
    	grid.add(credentials, 1, 6);
    	grid.add(dateOfLatestCredentialsStatus, 1, 7);
    	grid.add(dateOfHire, 1, 8);
    	grid.add(status, 1, 9);
    	
    	submitButton = new Button(message.getString("login_submit"));
 		submitButton.setOnAction(new EventHandler<ActionEvent>() {

  		     @Override
  		     public void handle(ActionEvent e) {
  		     	clearErrorMessage(); 
  		     	processTransaction();
  		     }

 		});
 		

    	
		grid.add(submitButton, 1, 10);
		
    	return grid;
	}
	
	private void processTransaction()
	{
		Properties props = new Properties();
		props.setProperty("bannerId", bannerId.getText());
		props.setProperty("password", password.getText());
		props.setProperty("firstName", firstName.getText());
		props.setProperty("lastName", lastName.getText());
		props.setProperty("contactPhone", contactPhone.getText());
		props.setProperty("email", email.getText());
		props.setProperty("credentials", credentials.getText());
		props.setProperty("dateOfLatestCredentialsStatus", dateOfLatestCredentialsStatus.getText());
		props.setProperty("dateOfHire", dateOfHire.getText());
		props.setProperty("status", (String)status.getValue());
		
		//clear the fields for the next time around
		bannerId.setText("");
		password.setText("");
		firstName.setText("");
		lastName.setText("");
		contactPhone.setText("");
		email.setText("");
		credentials.setText("");
		dateOfLatestCredentialsStatus.setText("");
		dateOfHire.setText("");
		
		
		myModel.stateChangeRequest("Submit", props);
		
	}

	private Node createStatusLog(String initialMessage)
	{
		statusLog = new MessageView(initialMessage);

		return statusLog;
	}

	private void populateFields() 
	{
		myWorker = (Worker)myModel.getState("GetWorker");
		bannerId.setText((String)myWorker.getState("bannerId"));
		password.setText((String)myWorker.getState("password"));
		firstName.setText((String)myWorker.getState("firstName"));
		lastName.setText((String)myWorker.getState("lastName"));
		contactPhone.setText((String)myWorker.getState("contactPhone"));
		email.setText((String)myWorker.getState("email"));
		credentials.setText((String)myWorker.getState("credentials"));
		dateOfLatestCredentialsStatus.setText((String)myWorker.getState("dateOfLatestCredentialsStatus"));
		dateOfHire.setText((String)myWorker.getState("dateOfHire"));
		
		String choice= (String)myWorker.getState("status");
		String result;
		
		if (choice.equals("1"))
		{
			 result = message.getString("choice1");
		}
		else
		{
			 result = message.getString("choice2");
		}
		status.setValue(result);
	}

	public void updateState(String key, Object value) {


	}
	
	
	public void clearErrorMessage()
	{
		statusLog.clearErrorMessage();
	}
	

}
