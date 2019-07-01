// class to manage UI
package com.eteks.test;
/*
public class StaircaseDesignUI {
    // Layout coordinates spinners and transparency slider in a panel with labels
    this.staircasePanel = new JPanel(new GridBagLayout());
    this.staircasePanel.add(new JLabel(String.format(resource.getString("pointsPanel.comment"), preferences.getLengthUnit().getName())),
        new GridBagConstraints(0, 0, 8, 1, 0, 0, GridBagConstraints.LINE_START, 
            GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
    this.staircasePanel.add(new JLabel(new ImageIcon(ShapeGeneratorPlugin.class.getResource("shapeLabel.png"))),
        new GridBagConstraints(0, 1, 1, 11, 0, 0, GridBagConstraints.NORTH, 
            GridBagConstraints.NONE, new Insets(0, 0, 5, 10), 0, 0));
    for (int i = 0; i < this.coordinatesSpinnerModels.length; i++) {
      this.staircasePanel.add(new JLabel(String.format(resource.getString("pointsPanel.pointLabel.text"), i + 1)),
          new GridBagConstraints(1, i + 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 
              GridBagConstraints.NONE, new Insets(0, 0, 5, 5), 0, 0));
      this.staircasePanel.add(new JLabel(resource.getString("pointsPanel.xLabel.text")),
          new GridBagConstraints(2, i + 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 
              GridBagConstraints.NONE, new Insets(0, 0, 5, 5), 0, 0));
      this.staircasePanel.add(new NullableSpinner(this.coordinatesSpinnerModels [i][0]),
          new GridBagConstraints(3, i + 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 
              GridBagConstraints.NONE, new Insets(0, 0, 5, 5), 0, 0));
      this.staircasePanel.add(new JLabel(resource.getString("pointsPanel.yLabel.text")),
          new GridBagConstraints(4, i + 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 
              GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
      this.staircasePanel.add(new NullableSpinner(this.coordinatesSpinnerModels [i][1]),
          new GridBagConstraints(5, i + 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 
              GridBagConstraints.NONE, new Insets(0, 0, 5, 5), 0, 0));
      this.staircasePanel.add(new JLabel(resource.getString("pointsPanel.zLabel.text")),
          new GridBagConstraints(6, i + 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 
              GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
      this.staircasePanel.add(new NullableSpinner(this.coordinatesSpinnerModels [i][2]),
          new GridBagConstraints(7, i + 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 
              GridBagConstraints.NONE, new Insets(0, 0, 5, 5), 0, 0));
    }
    this.staircasePanel.add(new JLabel(resource.getString("transparencyLabel.text")), new GridBagConstraints(
        1, 10, 1, 1, 0, 0, GridBagConstraints.LINE_START, 
        GridBagConstraints.NONE, new Insets(5, 0, 0, 5), 0, 0));
    this.staircasePanel.add(this.transparencySlider, new GridBagConstraints(
        2, 10, 4, 1, 0, 0, GridBagConstraints.LINE_START, 
        GridBagConstraints.HORIZONTAL, new Insets(5, 0, 0, 0), 0, 0));
    this.staircasePanel.add(resetButton, new GridBagConstraints(
        6, 10, 2, 1, 0, 0, GridBagConstraints.EAST, 
        GridBagConstraints.NONE, new Insets(5, 10, 0, 0), 0, 0));
    JPanel transparencyLabelsPanel = new JPanel(new BorderLayout(20, 0));
    transparencyLabelsPanel.setOpaque(false);
    transparencyLabelsPanel.add(new JLabel(resource.getString("opaqueLabel.text")), BorderLayout.WEST);
    transparencyLabelsPanel.add(new JLabel(resource.getString("invisibleLabel.text")), BorderLayout.EAST);
    this.staircasePanel.add(transparencyLabelsPanel, new GridBagConstraints(
        2, 11, 4, 1, 0, 0, GridBagConstraints.NORTH, 
        GridBagConstraints.HORIZONTAL, new Insets(OperatingSystem.isWindows() ? 0 : -3, 0, 0, 0), 0, 0));
  }
}
*/
import javafx.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

 
public class StaircaseDesignUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Staircase Constructor");
        

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        
        Text scenetitle = new Text("Build your staircase");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        primaryStage.show();

        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");
            }
        });
        }
        public static void main(String[] args) {
                launch(args);
    }
}