package presentation;

import java.awt.Color;
import java.awt.Paint;
import java.io.IOException;

import com.itextpdf.text.DocumentException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Path;
import logic.PdfExporter;

public class FrontPageTopLeftInsetter {
	TextField horizontalAngle;
	TextField verticalAngle;
	TextField areal;
	WeightHBox weightHBox;
	ComboBox<String> weightUnit;
	TriangleDrawer td = new TriangleDrawer();
	TriangleField trianglePane;

	public GridPane insetLeft() {
		Canvas startCanvas = new Canvas(300, 300);
		Canvas triangleCanvas = td.createTriangle(startCanvas, 40);
		GridPane beregnerGrid = new GridPane();
		beregnerGrid.setAlignment(Pos.TOP_LEFT);
		
		trianglePane = new TriangleField();
		trianglePane.setCanvas(triangleCanvas);
		trianglePane.getChildren().setAll(new NeedMoreInputTriangle());
		trianglePane.setPadding(new Insets(10,10,10,10));
		trianglePane.setPrefWidth(320);
		trianglePane.setPrefHeight(320);
		
		horizontalAngle = new HorizontalAngleTextField();
		horizontalAngle.setAlignment(Pos.CENTER_RIGHT);
		Label vandretEnhedLabel = new Label("°");
		HBox vandretHBox = new HBox();
		vandretHBox.getChildren().addAll(horizontalAngle, vandretEnhedLabel);
		Label vandretLabel = new Label("Lodret vinkel:");
		VBox vandretVBox = new VBox();
		vandretVBox.getChildren().addAll(vandretLabel,vandretHBox);
		
		verticalAngle = new VerticalAngleTextField();
		verticalAngle.setAlignment(Pos.CENTER_RIGHT);
		Label lodretEnhedLabel = new Label("°");
		HBox lodretHBox = new HBox();
		lodretHBox.getChildren().addAll(verticalAngle, lodretEnhedLabel);
		Label lodretLabel = new Label("Vandret vinkel:");
		VBox lodretVBox = new VBox();
		lodretVBox.getChildren().addAll(lodretLabel,lodretHBox);
		
		weightHBox = new WeightHBox();		
		Label weightLabel = new Label("Vægt:");
		VBox weightVBox = new VBox();
		weightVBox.getChildren().addAll(weightLabel,weightHBox);		

//		if(Double.parseDouble(HorizontalAngleTextField.getText()))
		
		// for at få verticalAngle textFeltet på linje med trekanten
		GridPane verticalGrid = new GridPane();
		verticalGrid.add(lodretVBox, 0, 1);
		verticalGrid.setHgap(5);

		beregnerGrid.add(vandretVBox, 0, 0);
		beregnerGrid.add(weightVBox, 1, 0);
		beregnerGrid.add(trianglePane, 0, 1, 1, 2);
		beregnerGrid.add(verticalGrid, 1, 2);
		beregnerGrid.setHgap(5);
		verticalGrid.setAlignment(Pos.BOTTOM_LEFT);
		
		return beregnerGrid;

	}

	public TextField getHorizontalAngle() {
		return horizontalAngle;
	}

	public void setHorizontalAngle(TextField horizontalAngle) {
		this.horizontalAngle = horizontalAngle;
	}

	public TextField getVerticalAngle() {
		return verticalAngle;
	}

	public void setVerticalAngle(TextField verticalAngle) {
		this.verticalAngle = verticalAngle;
	}

	public TextField getAreal() {
		return areal;
	}

	public void setAreal(TextField areal) {
		this.areal = areal;
	}

	public WeightHBox getWeightValueHBox() {
		return weightHBox;
	}

	public void setWeightValue(WeightHBox weightValue) {
		this.weightHBox = weightValue;
	}

	public TriangleField getTriangle() {
		return trianglePane;
	}

	public void setTriangle(Canvas triangle) {
		trianglePane.setCanvas(triangle);
		trianglePane.getChildren().setAll(triangle);
	}

}
