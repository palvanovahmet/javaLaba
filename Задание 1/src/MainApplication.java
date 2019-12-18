
public class MainApplication {
	public static void main(String[] args) throws Exception {
		Food[] breakfast = new Food[20];							
		
		int item = 0;
		for (String arg: args) 
		{		
			
			String[] parts = arg.split("/");		
			
			
				
			
					if ( parts[0].equals("Tea"))
					{
						breakfast[item] = new Tea(parts[1]);
					}
					else
						if ( parts[0].equals("Cake"))
						{
							breakfast[item] = new Cake(parts[1]);
						}
						else
						
						
						if ( parts[0].equals("Coffee"))
						{
							breakfast[item] = new Coffee(parts[1]);
						}else
							
							if ( parts[0].equals("Apple"))
							{
								breakfast[item] = new Apple(parts[1]);
							}
				
			item++;
		}
		
		
		int TheNumbersApple = 0;
		int TheNumbersTea = 0;
		int TheNumbersCoffee = 0;
		int TheNumbersCake = 0;
		
		Tea overalTea = new Tea("Чай");
		Coffee overalCoffee = new Coffee("Кофе");
		Apple overalApple = new Apple("Яблоко");
		Cake overalCake = new Cake ("Пирог");
		
		for(Food temp:breakfast){
			if(temp!=null)
				temp.consume();
		}
		for (Food fast:breakfast)
		{
			
			if (fast!=null)												
			{
				
				
				if ( fast.equals(overalTea))
				{
					TheNumbersTea++;
				
				}
				if ( fast.equals(overalCoffee))
				{
					TheNumbersCoffee++;
				
				}
				if ( fast.equals(overalApple))
				{
					TheNumbersApple++;
				}
				if ( fast.equals(overalCake))
				{
					TheNumbersCake++;
				
				}
			
			}
		}
		
		System.out.println("Общее количество употреблённых чайов: ");
		System.out.println(TheNumbersTea);
		System.out.println("Общее количество употреблённых кофе: ");
		System.out.println(TheNumbersCoffee);
		System.out.println("Общее количество употреблённых яблок: ");
		System.out.println(TheNumbersApple);      
		System.out.println("Общее количество употреблённых пирoгов: ");
		System.out.println(TheNumbersCake);
		System.out.println("Всего хорошего!");     
	}
}

