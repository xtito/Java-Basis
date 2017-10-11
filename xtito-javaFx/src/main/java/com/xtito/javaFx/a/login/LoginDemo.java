package com.xtito.javaFx.a.login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by [Zy]
 * 2017/10/10 17:26
 */
public class LoginDemo extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("JavaFX Welcome");
        GridPane grid = new GridPane();
        // alignment属性将grid的默认位置从靠左上角对齐改为居中显示
        grid.setAlignment(Pos.CENTER);
        // gap属性管理行列之间的间隔
        grid.setHgap(10);
        grid.setVgap(10);
        // padding管理grid 面板边缘周围的间隔。 insets分别指定了上、右、下、左四边的间隔
        grid.setPadding(new Insets(25, 25, 25, 25));


        // 增加文本(Text)、标签(Lable)和文本域(Text Field)
        // 创建不可编辑的Text对象
        Text sceneTitle = new Text("Welcome");
        sceneTitle.setId("welcome_text");
        // 设置文字字体，是否加粗，字体大小
//        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        // add 参数 对象、第0列、第0行、列跨度为2、行跨度为1
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        // 添加 label 到第0列 第1行
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        // 添加 用户名输入框 到第1列 第1行
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        // 添加 label 到第0列 第2行
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        // 添加 用户名输入框 到第1列 第2行
        grid.add(pwBox, 1, 2);


        // 创建了一个名为btn的按钮，并带有”Sign in”标签
        Button btn = new Button("Sign in");
        // 创建了一个名为hbBtn的HBox 布局面板，它的spacing被设置为10像素
        HBox hbBtn = new HBox(10);
        // HBox面板为按钮设置了与grid面板中其它控件不同的对齐方式。alignment属性值为Pos.BOTTOM_RIGHT，表示将对应的节点设置为靠右下对齐
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        // 按钮被添加为HBox面板的子节点，
        hbBtn.getChildren().add(btn);
        // 而HBox面板被添加到grid中的第1列，第4行
        grid.add(hbBtn, 1, 4);

        // 增加用于显示信息的文本
        final Text actionTarget = new Text();
        // 添加到第0列，第6行
        grid.add(actionTarget, 0, 6);
        // 设置合并单元格
        GridPane.setColumnSpan(actionTarget, 2);
        // 设置文字右对齐
        GridPane.setHalignment(actionTarget, HPos.RIGHT);
        actionTarget.setId("action_target");

        // 注册事件handler
        btn.setOnAction(new EventHandler<ActionEvent>() {

            // 当用户点击按钮时会将actiontarget对象的文本设置为”Sign in button pressed”，颜色设置为砖红色
            @Override
            public void handle(ActionEvent e) {
                // 将文字颜色变成 firebrick red
                actionTarget.setFill(Color.FIREBRICK);
                // 文字描述
                actionTarget.setText("Sign in button pressed");
            }
        });

        /**
         * scene被创建并使用grid pane作为root节点，这在使用layout容器构建界面时是一种常见用法。
         * 因此当窗口的大小改变时，在gird pane中的节点也将随之根据布局的约束而改变。
         * 在本例中无论你怎样对窗体进行缩放操作，grid 面板将始终居中显示。
         * padding属性将确保在窗口被缩小时gird 面板周围仍能留有间隔
         *
         * 将scene的大小设置为了300*275。 默认情况下scene将使用能将其内部组件全部显示的最小大小
         */
        Scene scene = new Scene(grid, 300, 275);
        stage.setScene(scene);
        // 添加css样式
        scene.getStylesheets().add(getClass().getResource("css/Login.css").toExternalForm());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
