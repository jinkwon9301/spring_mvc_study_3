package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository { // 테스트 짜보기 : cmd + shift + T

  private static final Map<Long, Item> store = new HashMap<>(); // static, (실제는 HashMap 사용하면 안된다 : 멀티쓰레드 환경에서 여러개가 store에 동시에 접근하는 상황이라면 HashMap 사용 X (singleton으로 생성되는 상황). 대신 ConcurrentHashMap<>() 사용해야 한다.)
  private static long sequence = 0L; // static

  public Item save(Item item) {
    item.setId(sequence++);
    store.put(item.getId(), item);
    return item;
  }

  public Item findById(Long id) {
    return store.get(id);
  }

  public List<Item> findAll() {
    return new ArrayList<>(store.values());
  }

  public void updateItem(Long id, Item updateParam) {
    Item item = findById(id);
    item.setItemName(updateParam.getItemName());
    item.setPrice(updateParam.getPrice());
    item.setQuantity(updateParam.getQuantity());
  }

  public void clearStore() {
    store.clear();
  }

}
