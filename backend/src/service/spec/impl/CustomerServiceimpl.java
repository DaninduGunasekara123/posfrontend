package service.spec.impl;



//import dto.CustomerDTO;
//import entity.Customer;
//
//import repository.RepoFactory;
//import repository.repo.CustomerRepo;
//import service.spec.CustomerService;
//
//import java.lang.reflect.Type;
//import java.sql.SQLException;
//import java.util.List;
//
//public class CustomerServiceimpl implements CustomerService {
//    private RepoFactory repoFactory;
//    private CustomerRepo customerRepo;
//    private ModelMapper modelMapper;
//
//    public CustomerServiceimpl() {
//        this.repoFactory=new RepoFactory();
//        this.customerRepo=repoFactory.getRepo(RepoFactory.RepoTypes.CUSTOMER);
//        this.modelMapper=new ModelMapper();
//    }
//
//    @Override
//    public boolean add(CustomerDTO customerDTO) {
//        Customer customer = modelMapper.map(customerDTO, Customer.class);
//        try {
//            return customerRepo.add(customer);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//
//    @Override
//    public boolean update(CustomerDTO customerDTO) {
//        Customer customer = modelMapper.map(customerDTO, Customer.class);
//        try {
//            return customerRepo.update(customer);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//
//    @Override
//    public boolean delete(Integer cid) {
//        try {
//            return customerRepo.delete(cid, cid);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//
//    @Override
//    public CustomerDTO search(Integer cid) {
//
//        try {
//            Customer customer = customerRepo.search(cid);
//            if(customer==null){
//                return null;
//            }
//            return modelMapper.map(customer, CustomerDTO.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//
//    @Override
//    public List<CustomerDTO> getAll() {
//        try {
//            List<Customer> all = customerRepo.getAll();
//            Type listType= new TypeToken<List<CustomerDTO>>(){}.getType();
//            return modelMapper.map(all,listType);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//}
