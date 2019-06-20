package repository;

import dbcp.OrderRepoIMPL;
import repository.repo.repoImpl.CustomerRepoIMPL;
import repository.repo.repoImpl.ItemRepoIMPL;
import repository.repo.repoImpl.OrderDetailRepoIMPL;

public class RepoFactory {
    public enum RepoTypes{
        CUSTOMER,ITEM,ORDERS,ORDER_DETAIL
    }

    public <T>T getRepo(RepoTypes repoTypes){
        switch (repoTypes){
            case CUSTOMER:
                return (T) new CustomerRepoIMPL();
            case ORDERS:
                return (T) new OrderRepoIMPL();
            case ITEM:
                return (T) new ItemRepoIMPL();
            case ORDER_DETAIL:
                return (T) new OrderDetailRepoIMPL();
            default:
                return null;
        }
    }
}
