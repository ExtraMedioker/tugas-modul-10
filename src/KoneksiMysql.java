import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class KoneksiMysql {
    private Connection connect;
    private String driverName = "com.mysql.jdbc.Driver"; // driver koneksi ke mysql
    private String jdbc = "jdbc:mysql://";
    private String host = "localhost:"; // bisa menggunakan ip anda
    private String port = "3306/"; // port ini port mysql
    private String database = "crud61133239"; // ini database yang akan digunakan
    private String url = jdbc + host + port + database;
    private String username = "root"; // username default mysql
    private String password = "";

    public Connection getKoneksi() throws SQLException{
        if (connect == null) {
            try {
                Class.forName(driverName);
                System.out.println("Class Driver ditemukan");
                try {
                    connect = DriverManager.getConnection(url,username,password);
                    System.out.println("Koneksi database sukses");
                } catch (SQLException se) {
                    System.out.println("Koneksi database gagal : " + se);
                    System.exit(0);
                }
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Class driver tidak ditemukan, Terjadi kesalahan pada : " + cnfe);
                System.exit(0);
            }
        }
        return connect;
    }
}

