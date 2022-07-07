package ia;

import java.io.FileInputStream;
import java.sql.*;
import javax.swing.*;

public class IA {

    private static String url = ""; //URL to connect to Azure hosted SQL database
    private static Connection con;
    public static Base base;

    public static void main(String[] args) {
        getCon();
        base = new Base();
        base.setVisible(true);
    }

    public static ResultSet adminExps(String user, String trip, String type) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("select top 15 * from " + user + "_expenses where trip = '" + trip + "' and expenseType = '" + type + "';");
            return stmt.getResultSet();
        } catch (Exception e) {
            System.out.println("error");
        }
        return null;
    }

    public static ResultSet getSummary(String user, String trip) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("select * from " + user + "_expenses where trip = '" + trip + "';");
            return stmt.getResultSet();
        } catch (Exception e) {
            System.out.println("error");
        }
        return null;
    }

    public static String user(String first, String last) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("select username from users where first_name = '" + first + "' and last_name = '" + last + "';");
            ResultSet rs = stmt.getResultSet();
            rs.next();
            return rs.getString("username");
        } catch (Exception e) {
            System.out.println("error");
        }
        return null;
    }

    public static ResultSet getUsers() {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("select top 15 * from users where admin_check = 0;");
            return stmt.getResultSet();
        } catch (Exception e) {
            System.out.println("error");
        }
        return null;
    }

    public static ResultSet viewImg(Object trip, Object amount, Object type, Object curr, Object date, String user) {
        if (trip instanceof String && amount instanceof String && type instanceof String && curr instanceof String && date instanceof String) {
            try {
                Statement stmt = con.createStatement();
                stmt.execute("select top 1 images from " + user + "_expenses where trip = '" + trip + "' and amount = " + amount + " and expenseType = '" + type + "' and currency = '" + curr + "' and dates = '" + date + "';");
                return stmt.getResultSet();
            } catch (Exception e) {
                System.out.println("error");
            }
        }
        return null;
    }

    public static ResultSet sortTrips(String type, String order) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("select top 15 * from " + base.getUser() + "_trips order by " + type + " " + order + ";");
            return stmt.getResultSet();
        } catch (Exception e) {
            System.out.println("error");
        }
        return null;
    }

    public static ResultSet sortExps(String type, String order) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("select top 15 * from " + base.getUser() + "_expenses order by " + type + " " + order + ";");
            return stmt.getResultSet();
        } catch (Exception e) {
            System.out.println("error");
        }
        return null;
    }

    public static void deleteExp(Object trip, Object amount, Object type, Object curr, Object date) {
        try {
            if (trip instanceof String && amount instanceof String && type instanceof String && curr instanceof String && date instanceof String) {
                Statement stmt = con.createStatement();
                stmt.executeUpdate("delete from " + base.getUser() + "_expenses where trip = '" + trip + "' and amount = " + amount + " and expenseType = '" + type + "' and currency = '" + curr + "' and dates = '" + date + "';");
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static void deleteTrip(Object name, Object sDate, Object eDate) {
        try {
            if (name instanceof String && sDate instanceof String && eDate instanceof String) {
                Statement stmt = con.createStatement();
                stmt.executeUpdate("delete from " + base.getUser() + "_trips where trip_name = '" + name + "' and strt_date = '" + sDate + "' and end_date = '" + eDate + "';");
            }
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public static void updateTrips(Object name, Object sDate, Object eDate, int column) {
        if (name instanceof String && sDate instanceof String && eDate instanceof String) {
            if (column == 0) {
                updateTripName((String) name, (String) sDate, (String) eDate);
            } else if (column == 1) {
                updateTripSDate((String) name, (String) sDate, (String) eDate);
            } else if (column == 2) {
                updateTripEDate((String) name, (String) sDate, (String) eDate);
            }
        }
    }

    public static void updateTripName(String name, String sDate, String eDate) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update " + base.getUser() + "_trips set trip_name = '" + name + "' where strt_date = '" + sDate + "' and end_date = '" + eDate + "';");
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static void updateTripSDate(String name, String sDate, String eDate) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update " + base.getUser() + "_trips set strt_date = '" + sDate + "' where trip_name = '" + name + "' and end_date = '" + eDate + "';");
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static void updateTripEDate(String name, String sDate, String eDate) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update " + base.getUser() + "_trips set end_date = '" + eDate + "' where strt_date = '" + sDate + "' and trip_name = '" + name + "';");
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static ResultSet getTrips(String user) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("select top 15 * from " + user + "_trips order by strt_date desc;");
            return stmt.getResultSet();
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
        return null;
    }

    public static void updateExps(Object trip, Object amount, Object type, Object curr, Object date, int column) {
        if (trip instanceof String && amount instanceof String && type instanceof String && curr instanceof String && date instanceof String) {
            if (column == 0) {
                updateExpsTrip((String) trip, (String) amount, (String) type, (String) curr, (String) date);
            } else if (column == 1) {
                updateExpsAmt((String) trip, (String) amount, (String) type, (String) curr, (String) date);
            } else if (column == 2) {
                updateExpsType((String) trip, (String) amount, (String) type, (String) curr, (String) date);
            } else if (column == 3) {
                updateExpsCurr((String) trip, (String) amount, (String) type, (String) curr, (String) date);
            } else if (column == 4) {
                updateExpsDate((String) trip, (String) amount, (String) type, (String) curr, (String) date);
            }
        }
    }

    public static void updateExpsTrip(String trip, String amount, String type, String curr, String date) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update " + base.getUser() + "_expenses set trip = '" + trip + "' where amount = " + amount + " and expenseType = '" + type + "' and currency = '" + curr + "' and dates = '" + date + "';");
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static void updateExpsAmt(String trip, String amount, String type, String curr, String date) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update " + base.getUser() + "_expenses set amount = " + amount + " where trip = '" + trip + "' and expenseType = '" + type + "' and currency = '" + curr + "' and dates = '" + date + "';");
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static void updateExpsType(String trip, String amount, String type, String curr, String date) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update " + base.getUser() + "_expenses set expenseType = '" + type + "' where amount = " + amount + " and trip = '" + trip + "' and currency = '" + curr + "' and dates = '" + date + "';");
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static void updateExpsCurr(String trip, String amount, String type, String curr, String date) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update " + base.getUser() + "_expenses set currency = '" + curr + "' where amount = " + amount + " and expenseType = '" + type + "' and trip = '" + trip + "' and dates = '" + date + "';");
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static void updateExpsDate(String trip, String amount, String type, String curr, String date) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update " + base.getUser() + "_expenses set dates = '" + date + "' where amount = " + amount + " and expenseType = '" + type + "' and currency = '" + curr + "' and trip = '" + trip + "';");
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static boolean addExpense(Object trip, Object type, Object curr, String amt, String date, FileInputStream fis, int len) {
        for (int i = 0; i < amt.length(); i++) {
            if (!((amt.charAt(i) > 47 && amt.charAt(i) < 58) || amt.charAt(i) == 46)) {
                JDialog invalid = new InvalidInput(base, true);
                invalid.setVisible(true);
                return false;
            }
        }
        if ((trip instanceof String && type instanceof String && curr instanceof String)) {
            try {
                if (fis == null) {
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate("insert into " + base.getUser() + "_expenses(trip, amount, expenseType, currency, dates, images) values('" + trip + "', " + amt + ", '" + type + "', '" + curr + "', '" + date + "', null);");
                    return true;
                } else {
                    PreparedStatement pstmt = con.prepareStatement("insert into " + base.getUser() + "_expenses(trip, amount, expenseType, currency, dates, images) values('" + trip + "', " + amt + ", '" + type + "', '" + curr + "', '" + date + "', ?)");
                    pstmt.setBinaryStream(1, fis, len);
                    pstmt.executeUpdate();
                    return true;
                }
            } catch (Exception e) {
                System.out.println("error");
                e.printStackTrace();
            }
        } else {
            JDialog invalid = new InvalidInput(base, true);
            invalid.setVisible(true);
        }
        return false;
    }

    public static ResultSet getExps(String user) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("select top 15 * from " + user + "_expenses order by dates desc;");
            return stmt.getResultSet();
        } catch (Exception e) {
            System.out.println("error");
        }
        return null;
    }

    public static void addUser(String user, String pass, String firstName, String lastName, int admin) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into users(username, pass, first_name, last_name, admin_check) values ('" + user + "', '" + pass + "', '" + firstName + "', '" + lastName + "', " + admin + ");");
            if (admin == 0) {
                stmt.executeUpdate("create table " + user + "_expenses (trip varchar(30), amount decimal(18, 2), expenseType varchar(30), currency varchar(5), dates date, images varbinary(MAX));");
                stmt.executeUpdate("create table " + user + "_trips (trip_name varchar(30), strt_date date, end_date date);");
            }
            base.showPanel(2);
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
            JDialog fail = new FaildedUser(base, true);
            fail.setVisible(true);
        }
    }

    public static void addTrip(String trip, String sDate, String eDate) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into " + base.getUser() + "_trips(trip_name, strt_date, end_date) values ('" + trip + "', '" + sDate + "', '" + eDate + "');");
            JDialog created = new TripCreated(base, true);
            created.setVisible(true);
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public static ResultSet top4Trips(String user) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("select top 4 * from " + user + "_trips order by strt_date desc;");
            return stmt.getResultSet();
        } catch (Exception e) {
            System.out.println("error");
        }
        //System.out.println("select top 4 * from " + user + "_trips order by strt_date desc;");
        return null;
    }

    public static void getCon() {
        try {
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public static String getPass(String user) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("select pass from users where username = '" + user + "';");
            ResultSet rs = stmt.getResultSet();
            rs.next();
            return rs.getString("pass");
        } catch (Exception e) {
            System.out.println("error");
            //e.printStackTrace();
        }
        return "";
    }

    public static boolean checkAdmin(String user) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("select admin_check from users where username = '" + user + "';");
            ResultSet rs = stmt.getResultSet();
            rs.next();
            if (rs.getInt("admin_check") == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        return false;
    }

    public static boolean checkUser(String user, String pass) {
        if (getPass(user).equals(pass)) {
            return true;
        }
        return false;
    }
}
