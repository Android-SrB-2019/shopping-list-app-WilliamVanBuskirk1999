package ca.nbcc.shoppinglist;

import java.util.ArrayList;
import java.util.List;

public class ListOfItems {
    public class Item{
        public String ingredient;
        public int count;

        public int getCount(){
            return count;
        }

        public String getIngredient(){
            return ingredient;
        }
        public Item(String ingredient){
            this.ingredient = ingredient;
            this.count = 1;
        }
    }

    private List<Item> items = new ArrayList();

    /**
     * Returns a list of grocery items
     * @return
     */
    public List<Item> returnItems(){
        return items;
    }

    /**
     * Adds an item to a cart. If the item is already there, up it's count by 1
     * @param name
     */
    public void addToCart(String name){
        boolean inCart = false;
        for(Item item : items){
            if(item.name == name){
                inCart = true;
                item.count++;
                break;
            }
        }

        if(!inCart){
            items.add(new Item(name));
        }
    }


}
