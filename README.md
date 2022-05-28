*Problem 1: SALES TAXES
Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical
products that are exempt. Import duty is an additional sales tax
applicable on all imported goods at a rate of 5%, with no exemptions. When I purchase items
I receive a receipt which lists the name of all the items and their price (including tax),
finishing with the total cost of the items,
and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax
rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of
sales tax.
Write an application that prints out the receipt details for these shopping baskets…

### INPUT:
Input 1:
> 1 book at 12.49
> 1 music CD at 14.99
> 1 chocolate bar at 0.85

Input 2:
> 1 imported box of chocolates at 10.00
> 1 imported bottle of perfume at 47.50

Input 3:
> 1 imported bottle of perfume at 27.99
> 1 bottle of perfume at 18.99
> 1 packet of headache pills at 9.75
> 1 box of imported chocolates at 11.25

### OUTPUT
Output 1:
> 1 book: 12.49
> 1 music CD: 16.49
> 1 chocolate bar: 0.85
> Sales Taxes: 1.50
> Total: 29.83

Output 2:
> 1 imported box of chocolates: 10.50
> 1 imported bottle of perfume: 54.65
> Sales Taxes: 7.65
> Total: 65.15

Output 3:
> 1 imported bottle of perfume: 32.19
> 1 bottle of perfume: 20.89
> 1 packet of headache pills: 9.75
> 1 imported box of chocolates: 11.85
> Sales Taxes: 6.70
> Total: 74.68

How to Run:
The code is written in Java language useing JavaFx Platform. To run the project, 
can be by downloading .java files into your IDE or compile the project into a jar. 
INPUT FILES must be clone with the project or in the root of project directory.

Input Files are :Input 1.txt
                 Input 2.txt
                 Input 3.txt


Program Flow:

The Main method extend Application class to use JavaFx functionality and run the user GUI.
receiptController Class will handel the communication between the GUI and backend code, 
and it will create Product objects based on the information that provided by the input files.
Moreover, calculating the receipt by neither multiplying by 10% or 5%.





