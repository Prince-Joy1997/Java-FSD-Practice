package in.stackroute.service;

import in.stackroute.dto.Item;

import java.util.List;

public interface ItemService {

    List<Item> getItemsByIds(List<String> codes);
}
