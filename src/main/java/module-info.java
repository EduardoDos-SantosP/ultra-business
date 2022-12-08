module com.ultra {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    requires org.postgresql.jdbc;

    opens com.ultra.view to javafx.fxml;
    exports com.ultra.model;
    exports com.ultra.view;
    exports com.ultra.controler;
    exports com.ultra.model.enderecos;
    exports com.ultra.view.enderecos;
    exports com.ultra.view.pessoas;
    opens com.ultra.view.enderecos to javafx.fxml;
    exports com.ultra.model.pessoas;
}
