package service.spec.impl;

import dto.ItemDTO;
import entity.Item;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import repository.RepoFactory;
import repository.repo.ItemRepo;
import service.spec.ItemService;

import java.lang.reflect.Type;
import java.util.List;

public class ItemServiceimpl  implements ItemService {

    private ItemRepo itemRepo;
    private ModelMapper modelMapper;

    public ItemServiceimpl() {
        this.itemRepo=new RepoFactory().getRepo(RepoFactory.RepoTypes.ITEM);
        this.modelMapper=new ModelMapper();
    }

    @Override
    public boolean add(ItemDTO itemDTO) {
        try {
            Item item = modelMapper.map(itemDTO, Item.class);
            return itemRepo.add(item);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean update(ItemDTO itemDTO) {
        try {
            Item item = modelMapper.map(itemDTO, Item.class);
            return itemRepo.update(item);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean delete(Integer integer) {
        try {
            return (boolean) itemRepo.delete(integer, integer);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

//    public boolean delete(Item s) {
//        try {
//            return (boolean) itemRepo.delete(s);
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException(e.getMessage());
//        }
//    }

    @Override
    public ItemDTO search(Integer s) {
        try {
            Item item = (Item) itemRepo.search(s);
            if(item!=null){
                return modelMapper.map(item,ItemDTO.class);
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<ItemDTO> getAll() {
        try {
            List<Item> all = itemRepo.getAll();
            Type listType= new TypeToken<List<ItemDTO>>(){}.getType();
            return modelMapper.map(all,listType);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
