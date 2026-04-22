
package so;

import db.impl.DBBroker;
import db.DBRepository;


public abstract class OpstaSO<T> {

    protected final DBRepository dbr;

    public OpstaSO() {
        this.dbr = new DBBroker();
    }

    public T execute(Object param) throws Exception {
        try {
            precondition(param);
            startTransaction();
            T result = executeOperation(param);
            commitTransaction();
            System.out.println("Uspesno izvrsena operacija!!!");
            return result;
        } catch (Exception ex) {
            System.out.println("Operacija nije uspjesno izvrsena");
            rollbackTransaction();
            throw ex;
        }
    }

    public abstract void precondition(Object param) throws Exception;

    private void startTransaction() throws Exception {
        dbr.connect();
    }

    
    protected abstract T executeOperation(Object param) throws Exception;

   
    protected void commitTransaction() throws Exception {
        dbr.commit();
    }

   
    protected void rollbackTransaction() throws Exception {
        dbr.rollback();
    }


}



