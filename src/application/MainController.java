package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import com.jfoenix.controls.JFXTimePicker;

import Supreme.Buyer;
import Supreme.Buying;
import Supreme.Google;
import Supreme.SupremeWebsite;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

	@FXML
	private TextField name;
	@FXML
	private TextField email;
	@FXML
	private TextField phone;
	@FXML
	private TextField address;
	@FXML
	private TextField unit;
	@FXML
	private TextField zip;
	@FXML
	private TextField city;
	@FXML
	private TextField state;
	@FXML
	private TextField country;
	@FXML
	private TextField cc;
	@FXML
	private TextField month;
	@FXML
	private TextField year;
	@FXML
	private TextField cvv;
	@FXML
	private TextField keyword;
	@FXML
	private TextField category;
	@FXML
	private TextField color;
	@FXML
	private TextField size;
	@FXML
	private TextField delay;
	
	@FXML
	private Button save;
	@FXML
	private Button start;
	
	@FXML
	private Button useprofile;
	
	@FXML
	private Button google;
	
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	
	public Buying item;
	public Buyer buyer;
	
	public WebDriver w;
	
	public void saveData(ActionEvent event) throws IOException {
		buyer = new Buyer(name.getText(),email.getText(),phone.getText(),address.getText(),unit.getText(),zip.getText(),city.getText(), state.getText(), cc.getText(),month.getText(),year.getText(),cvv.getText(), country.getText().toUpperCase(), username.getText(), password.getText());
		item = new Buying(keyword.getText(),category.getText(),color.getText(),Long.parseLong("1000"), size.getText());
		
		String path = System.getProperty("user.dir");
		path = path.replace("\\", "\\\\");
		
		File file = new File(path+"\\profile.txt");
		FileWriter f = new FileWriter(file);
		f.write(buyer.toString());
		f.close();
		
	}
	
	public void run(ActionEvent event) throws InterruptedException {
		item = new Buying(keyword.getText(),category.getText(),color.getText(),Long.parseLong("1000"), size.getText());
		SupremeWebsite task = new SupremeWebsite();
		task.main(buyer, item,w);
	}
	
	public void googleLogin(ActionEvent event) {
		Google g = new Google();
		w = g.login(username.getText(),password.getText());
	}
	
	public void useProfile(ActionEvent event) throws FileNotFoundException {
		String path = System.getProperty("user.dir");
		path = path.replace("\\", "\\\\");
		
		File file = new File(path+"\\profile.txt");
		
		String content = new Scanner(file).useDelimiter("\\Z").next();
		String [] arr = content.split("~");
		
		buyer = new Buyer(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8],arr[9],arr[10],arr[11],arr[12],arr[13],arr[14]);
		
		name.setText(arr[0]);
		email.setText(arr[1]);
		phone.setText(arr[2]);
		address.setText(arr[3]);
		unit.setText(arr[4]);
		zip.setText(arr[5]);
		city.setText(arr[6]);
		state.setText(arr[7]);
		cc.setText(arr[8]);
		month.setText(arr[9]);
		year.setText(arr[10]);
		cvv.setText(arr[11]);
		country.setText(arr[12]);
		username.setText(arr[13]);
		password.setText(arr[14]);
	}
}
