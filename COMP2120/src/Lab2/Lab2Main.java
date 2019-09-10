package Lab2;

/**
 * Lab 2 Assignment.  Reads in 3 Item, stores in ArrayList.
 * Outputs receipt formatted to lab2 specs.
 * @author Harrison Scarfone 104900846
 *
 */
public class Lab2Main {
	
	ItemGetter itemGetter = new ItemGetter();

	public static void main(String[] args) {
		Lab2Main lab2Main = new Lab2Main();
		lab2Main.itemGetter.getItems();
		ReceiptPrinter receiptPrinter = new ReceiptPrinter(lab2Main.itemGetter.items);
		receiptPrinter.printReceipt();				
	}
}
