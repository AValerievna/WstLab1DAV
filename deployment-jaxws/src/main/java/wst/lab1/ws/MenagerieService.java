package wst.lab1.ws;

import lombok.SneakyThrows;
import wst.lab1.dao.MenagerieDAO;
import wst.lab1.db.Menagerie;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

@WebService
public class MenagerieService {
    @Resource(lookup = "jdbc/menagerie")
    private DataSource dataSource;

    @WebMethod
    @SneakyThrows
    public List<Menagerie> findAll() {
        return new MenagerieDAO(dataSource).findAllValues();
    }

    @WebMethod
    @SneakyThrows
    public List<Menagerie> filter(@WebParam(name = "id") Long id, @WebParam(name = "animal") String animal,
                                  @WebParam(name = "name") String name, @WebParam(name = "breed") String breed,
                                  @WebParam(name = "health") String health, @WebParam(name = "arrival") Date arrival) {
        return new MenagerieDAO(dataSource).filterValues(id, animal, name, breed, health, arrival);
    }

    public MenagerieService() {
    }
}
