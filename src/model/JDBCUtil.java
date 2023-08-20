package model;

import java.sql.*;

public class JDBCUtil {
    public static String FAIL_SAME_ACC = "已存在相同账号";
    Connection connection = null;
    Statement statement = null;
    Player player = null;
    GameLevel gameLevel = null;
    public Player login(String acc, String pwd){
        try {
            loadDataBase();
            String loginSQL = "select * from player where acc = " + acc + " and pwd = " + pwd + " ";//编写SQL语句
            ResultSet resultSet = statement.executeQuery(loginSQL);//执行SQL语句
            //System.out.println("loading");
            while (resultSet.next()) {//处理结果集
                player = new Player(resultSet.getString("acc"), resultSet.getInt("maxLevel"), resultSet.getString("playerName"));
                //System.out.println(player.getPlayerName());
            }
            statement.close();//释放执行者对象
            connection.close();//释放连接
            //System.out.println(player);
            System.out.println("welcome " + "\"" + player.getPlayerName() + "\"");
            return player;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean signUp(String acc, String pwd, String playerName) {
        try {
            int judge = 0;
            boolean result = false;
            loadDataBase();
            String signUpSQL = "select * from player where acc = " + acc + "";//查找是否数据库存在相同账号
            ResultSet resultSet = statement.executeQuery(signUpSQL);
            System.out.println("judging");
            while (resultSet.next()) {
                //System.out.println("has next");
                judge = 1;
            }
            playerName = "'" + playerName + "'";
            if (judge != 1) {
                signUpSQL = "insert into thunderplane.player(acc, pwd, playerName, maxlevel, totalscore) values (" + acc + ", " + pwd + ", " + playerName + ", 1, 0)";//编写SQL语句
                statement.executeUpdate(signUpSQL);//执行SQL语句
                System.out.println("sign_up_succeed");
                result = true;
            } else {
                System.out.println("fail_to_signup");
            }
            statement.close();
            connection.close();
            return result;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public GameLevel loadLevel(int levelID){
        try {
            loadDataBase();
            String levelSQL = "select * from level where levelID = " + levelID + "";
            ResultSet resultSet = statement.executeQuery(levelSQL);
            int levelSpeed, commonNum, promoteNum, bossLife, commonLife, promoteLife;
            String levelName, background;
            resultSet.next();
            levelSpeed = resultSet.getInt("levelSpeed");
            background = resultSet.getString("background");
            levelName = resultSet.getString("levelName");
            commonNum = resultSet.getInt("commonNum");
            promoteNum = resultSet.getInt("promoteNum");
            bossLife = resultSet.getInt("bossLife");
            gameLevel = new GameLevel(background, levelName, levelSpeed, commonNum, promoteNum, bossLife, levelID);
            return gameLevel;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }







    private void loadDataBase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");//导入jar包，加载驱动
        String url = "jdbc:mysql://localhost:3306/thunderPlane?characterEncoding=utf-8";
        String user = "root";
        String password = "root";
        connection = DriverManager.getConnection(url, user, password);//创建连接
        statement = connection.createStatement();//创建执行者对象
    }
}
