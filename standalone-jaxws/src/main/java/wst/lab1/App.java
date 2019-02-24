package wst.lab1;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import wst.lab1.dao.MenagerieDAO;
import wst.lab1.util.Configuration;
import wst.lab1.ws.MenagerieService;

import javax.sql.DataSource;
import javax.xml.ws.Endpoint;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class App {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration("config.properties");
        String scheme = conf.get("scheme", "http:");
        String host = conf.get("host", "localhost");
        String port = conf.get("port", "9090");
        String baseUrl = scheme + "//" + host + ":" + port;

        String menagerieServiceName = conf.get("menagerie.service.name");

        String menagerieUrl = baseUrl + "/" + menagerieServiceName;

        DataSource dataSource = initDataSource();

        log.info("Start application");
        Endpoint.publish(menagerieUrl, new MenagerieService(new MenagerieDAO(dataSource)));
        log.info("Application was successfully started");
    }

    @SneakyThrows
    private static DataSource initDataSource() {
        InputStream dsPropsStream = App.class.getClassLoader().getResourceAsStream("datasource.properties");
        Properties dsProps = new Properties();
        dsProps.load(dsPropsStream);
        HikariConfig hikariConfig = new HikariConfig(dsProps);
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }
}
