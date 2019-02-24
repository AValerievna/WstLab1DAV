package wst.lab1.ws;

import lombok.SneakyThrows;
import wst.lab1.dao.MenagerieDAO;
import wst.lab1.db.Menagerie;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService
public class MenagerieService {
    private MenagerieDAO menagerieDAO;

    @WebMethod
    @SneakyThrows
    public List<Menagerie> findAll() {
        return menagerieDAO.findAllValues();
    }

    @WebMethod
    @SneakyThrows
    public List<Menagerie> filter(@WebParam(name = "id") Long id, @WebParam(name = "animal") String animal,
                                  @WebParam(name = "name") String name, @WebParam(name = "breed") String breed,
                                  @WebParam(name = "health") String health, @WebParam(name = "arrival") Date arrival) {
        return menagerieDAO.filterValues(id, animal, name, breed, health, arrival);
    }

    public MenagerieService(MenagerieDAO menagerieDAO) {
        this.menagerieDAO = menagerieDAO;
    }

    public MenagerieService() {
    }
}
