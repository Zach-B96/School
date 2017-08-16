/**
 * A grocery list tracking food items needed to be purchased, their
 * nutritional facts, and price of the items
 *
 * Zachary Bessette
 *
 */
class Food {}

public interface GroceryList
{
    /**
     * Adds a food item to my grocery list that will be purchased and later
     * consumed.
     */
    public void add(Food f);


    /**
     * Returns the price of any given food item on the list
     */
    public int getPrice();

    /**
     * Returns the price to purchase all of the grocery items on the list.
     * You need to know how much money to bring!
     */
    public int getTotalPrice();

    /**
     *Returns the amount of calories of any item on the list
     */
    public int getCalories();

}
