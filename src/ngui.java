import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ngui {
    private JPanel panel1;
    private JTable table1;

    ngui(){
        try {
            // Connect to database
            Connection connection = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + DATABASE_NAME, USERNAME, PASSWORD);

            // Execute query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE);

            int i = 0;
            // Iterate through the result set
            while (resultSet.next()) {
                Spiel[i] = resultSet.getString("Spiel");
                Entwickler[i] = resultSet.getString("Entwickler");
                Genre[i] = resultSet.getString("Genre");
                JDV[i] = resultSet.getString("JDV");
                i++;
            }

            gameInfo.add(Spiel);
            gameInfo.add(Entwickler);
            gameInfo.add(Genre);
            gameInfo.add(JDV);

            // Close connection
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        for (int i = 0; i < gameInfo.size(); i++){
            String[] info = gameInfo.get(i);
            for (int j = 0; j < info.length; j++){
                if (info[j] != null) {
                    System.out.println(info[j] + " ");
                }
            }
            System.out.println();
        }
    }
}