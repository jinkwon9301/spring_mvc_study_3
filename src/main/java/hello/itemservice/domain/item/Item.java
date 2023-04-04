package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data // 핵심 도메인 모델에 사용하기 위험할 수 있다.
//@Getter @Setter // 그래서 보통 게터, 세터를 사용한다.
public class Item  {

  private Long id;
  private String itemName;
  private Integer price;
  private Integer quantity;

  public Item() {

  }

  public Item(String itemName, Integer price, Integer quantity) {
    this.itemName = itemName;
    this.price = price;
    this.quantity = quantity;
  }

}
