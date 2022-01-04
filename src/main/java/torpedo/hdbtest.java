package torpedo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class h2dbtest {

    public static void main(String[] args) {
        create();
        insert("p1", 12);
        insert("p1", 10);
        insert("p1", 11);
        insert("p2", 13);
        insert("p2", 12);
        printHighScore();
        printMatchesWonByPlayer();
    }

    public static void create() {
        try {
            Class.forName ("org.h2.Driver");
            Connection conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");
            Statement st = conn.createStatement();
            st.executeUpdate("drop table if exists scores");
            st.executeUpdate("CREATE TABLE scores(playername VARCHAR(255), score int, ts timestamp(9))");
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void insert(String playername, int score) {
        try {
            Class.forName ("org.h2.Driver");
            Connection conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");
            Statement st = conn.createStatement();
            st.executeUpdate("insert into scores (playername, score, ts) values('"+playername+"',"+score+", CURRENT_TIMESTAMP())");
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void printHighScore() {
        try {
            Class.forName ("org.h2.Driver");
            Connection conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select playername, score, ts from scores order by score desc");
            System.out.println("High Score");
            System.out.println("Name\tScore\tWhen");
            while(rs.next()) {
                String name  = rs.getString("playername");
                int score = rs.getInt("score");
                System.out.println(name+"\t"+score+"\t"+rs.getTimestamp("ts"));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void printMatchesWonByPlayer() {
        try {
            Class.forName ("org.h2.Driver");
            Connection conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select playername, count(1) as cnt from scores group by playername");
            System.out.println("Players Won Number");
            System.out.println("Name\t#Won");
            while(rs.next()) {
                String name  = rs.getString("playername");
                int score = rs.getInt("cnt");
                System.out.println(name+"\t"+score);
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}