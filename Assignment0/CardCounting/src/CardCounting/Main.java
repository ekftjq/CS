package CardCounting;

import java.util.*;

public class Main {

    public static String[] AssignCards() //assigns each of the 52 cards into an array of Strings from 0 to 51
    {
        String[] cards = new String[52];
        Integer[] aces = {0, 13, 26, 39};
        Integer[] jacks = {10, 23, 36, 49};
        Integer[] queens = {11, 24, 37, 50};
        Integer[] kings = {12, 25, 38, 51};

        for (int i=0; i< cards.length; i++)
        {
            if(i<=12)
            {
                if(Arrays.asList(aces).contains(i))
                {
                    cards[i] = "Spade A";
                    //System.out.println(cards[i]);
                }
                else if (Arrays.asList(jacks).contains(i))
                {
                    cards[i] = "Spade Jack";
                    //System.out.println(cards[i]);
                }
                else if (Arrays.asList(queens).contains(i))
                {
                    cards[i] = "Spade Queen";
                    //System.out.println(cards[i]);
                }
                else if (Arrays.asList(kings).contains(i))
                {
                    cards[i] = "Spade King";
                    //System.out.println(cards[i]);
                }
                else
                {
                    cards[i]="Spade "+(i+1);
                    //System.out.println(cards[i]);
                }

            }
            else if(i<=25)
            {
                if(Arrays.asList(aces).contains(i))
                {
                    cards[i] = "Diamond A";
                }
                else if (Arrays.asList(jacks).contains(i))
                {
                    cards[i] = "Diamond Jack";
                }
                else if (Arrays.asList(queens).contains(i))
                {
                    cards[i] = "Diamond Queen";
                }
                else if (Arrays.asList(kings).contains(i))
                {
                    cards[i] = "Diamond King";
                }
                else
                {
                    cards[i]="Diamond "+(i%13+1);
                }
            }

            else if(i<=38)
            {
                if(Arrays.asList(aces).contains(i))
                {
                    cards[i] = "Heart A";
                }
                else if (Arrays.asList(jacks).contains(i))
                {
                    cards[i] = "Heart Jack";
                }
                else if (Arrays.asList(queens).contains(i))
                {
                    cards[i] = "Heart Queen";
                }
                else if (Arrays.asList(kings).contains(i))
                {
                    cards[i] = "Heart King";
                }
                else
                {
                    cards[i]="Heart "+(i%13+1);
                }
            }

            else if(i<=51)
            {
                if(Arrays.asList(aces).contains(i))
                {
                    cards[i] = "Clover A";
                }
                else if (Arrays.asList(jacks).contains(i))
                {
                    cards[i] = "Clover Jack";
                }
                else if (Arrays.asList(queens).contains(i))
                {
                    cards[i] = "Clover Queen";
                }
                else if (Arrays.asList(kings).contains(i))
                {
                    cards[i] = "Clover King";
                }
                else
                {
                    cards[i]="Clover "+(i%13+1);
                }
            }
            //System.out.println(cards[i]);
        }
        return cards;
    }

    private static String[] CRShuffle() //Completely Random shuffle function. Uses the already implemented function
    {
        String[] cards = AssignCards();
        Collections.shuffle(Arrays.asList(cards));
        //System.out.println(cards[12]);
        return cards;
    }

    private static String[] RiffleShuffle() //Riffle Shuffle function: this shuffle divides the card in half and each deck puts a card on the deck one by one starting from the bottom of the halves.
    {
        String[] cards = AssignCards();
        String[] temp = new String[52];
        System.out.println("Enter a number between 1 to 51 or 0 for random to divide the cards into 2 decks");
        Scanner input_number = new Scanner(System.in);
        int half = input_number.nextInt();
        if(half==0)
        {
            half = RandomNumber();
            System.out.println("The random number is " +half);
        }
        while(half>52 | half < 1)
        {
            System.out.println("Please enter a value between 1 and 51 or 0 for random");
            half = input_number.nextInt();
            if(half==0)
            {
                half = RandomNumber();
                System.out.println("The random number is " +half);
            }
        }
        int j = 0;
        int z = half;

        if (half>=26)
        {
            for (int i = 0; i<cards.length-half;i++)
            {
                temp[2*i] = cards[j];
                j++;

            }
            for (int i = 0; i<cards.length-half;i++)
            {
                temp[1+(2*i)] = cards[z];
                z++;
                //System.out.println(temp[i]);
            }
            for (int i = (cards.length-half)*2; i<cards.length; i++)
            {
                temp[i] = cards[i-(cards.length-half)];
                //System.out.println(temp[i]);
            }
        }
        if (half<26)
        {
            for (int i = 0; i<half; i++)
            {
                temp[2*i] = cards[j];
                j++;
            }
            for (int i = 0; i<half;i++)
            {
                temp[1+(i*2)] = cards[z];
                z++;
            }
            for (int i = half*2; i<cards.length; i++)
            {
                temp[i] = cards[i];
            }
        }
        for(int i =0; i<cards.length;i++)
        {
            //System.out.println(temp[i]);
        }
        return temp;
    }

    private static int RandomNumber() {
        Random random = new Random();
        int Low = 1;
        int High = 51;
        return random.nextInt(High-Low) + Low;
    }

    private static String[] OverhandShuffle() //stilly buggy
    {
        String[] cards = AssignCards();
        System.out.println("Select the part of the deck to cut and place above deck.");
        System.out.println("Input two numbers from 1 to 51. The first number must be bigger than the second number.");
        Scanner firstcut = new Scanner(System.in);
        Scanner secondcut = new Scanner(System.in);
        System.out.print("First Number : ");
        int fcut = firstcut.nextInt();
        System.out.print("Second Number : ");
        int scut = secondcut.nextInt();

        while(fcut<=scut)
        {
            System.out.println("Input two numbers from 1 to 51 again. The first number must be bigger than the second number.");
            System.out.print("First Number : ");
            fcut = firstcut.nextInt();
            System.out.print("Second Number : ");
            scut = secondcut.nextInt();
        }
        String[] temp = new String[52];
        for(int i = 0; i<scut; i++)
        {
            temp[i] = cards[i];
            //System.out.println(temp[i]);
        }
        for(int i = scut; i<fcut+1; i++)
        {
            temp[i] = cards[i+(fcut-scut)];
            //System.out.println(temp[i]);
        }
        for(int i = fcut+1; i<cards.length; i++)
        {
            temp[i] = cards[i-(fcut-scut)];
            //System.out.println(temp[i]);
        }
        for(int i =0; i<cards.length;i++)
        {
            System.out.println(temp[i]);
        }
        System.out.println("Perform Overhand Shuffle again? Y/N?");
        Scanner user_input = new Scanner(System.in);

        while(true)
        {
            String input = user_input.next();
            if (input.equals("Y")) {
                OverhandShuffle();
            } else if (input.equals("N")) {
                return temp;
            } else {
                System.out.println("Please enter Y or N");
            }
        }
    }



    private static String DrawCard(String[] cards, int count) //Draws a card from the top of the deck
    {
        String top = cards[cards.length-count-1];
        return top;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the CardCounter.");
        System.out.println("We are assuming there are 52 cards in the deck.");
        System.out.println("Please enter the wanted shuffle type.");
        String shuffle = "Overhand";
        System.out.println("Type in " + shuffle +" for "+ shuffle+ " shuffle.");
        shuffle = "Riffle";
        System.out.println("Type in " + shuffle +" for "+ shuffle+ " shuffle.");
        shuffle = "Completely Random";
        System.out.println("Type in CR for "+ shuffle+ " shuffle.");
        System.out.print("Shuffle Type: ");
        Scanner user_input = new Scanner(System.in);
        String input = user_input.next();
        String[] cards;

        while(true)
        {
            if(input.equals("Overhand"))
            {
                cards = OverhandShuffle();
                System.out.println("You have chosen Overhand Shuffle");
                break;
            }
            else if(input.equals("Riffle"))
            {
                cards = RiffleShuffle();
                System.out.println("You have chosen Riffle Shuffle");
                break;
            }
            else if(input.equals("CR"))
            {
                cards = CRShuffle();
                System.out.println("You have chosen Completely Random");
                break;
            }
            else
            {
                System.out.println("Please enter a valid type");
                System.out.print("Shuffle Type: ");
                input = user_input.next();
            }
        }

        System.out.println("Please guess the next card");
        Pointchecker(cards);
        System.out.println("Would you like to draw again? Enter Y/N");
        while(true)
        {
            input = user_input.next();
            if(input.equals("Y"))
            {
                DrawCounter.Drawcount++;
                if(DrawCounter.Drawcount==52) //Only 52 cards are in the deck
                {
                    System.out.println("You have drawn all the cards in the deck.");
                    break;
                }
                System.out.println("Please guess the next card");
                Pointchecker(cards);
                System.out.println("Would you like to draw again? Enter Y/N");
            }
            else if (input.equals("N"))
            {
                System.out.println("You have Drawn " + (DrawCounter.Drawcount+1)+ " Cards");
                System.out.println("You have earned " + Points.points+ " points");
                DrawCounter.Drawcount = 0;
                Points.points = 0;
                break;
            }
            else
            {
                System.out.println("Please enter Y or N");
            }
        }

    }

    private static void Pointchecker(String[] cards)
    {
        Scanner user_inputVal = new Scanner(System.in);
        String inputVal = user_inputVal.nextLine();
        String draw = DrawCard(cards, DrawCounter.Drawcount);
        System.out.println("You have drawn " + draw);
        //System.out.println(inputVal);
        if(inputVal.compareTo(draw)==0)
        {
            Points.points++;
            System.out.println("Correct! You have earned a point!");
            System.out.println("You currently have "+ Points.points + " points");
        }
        else
        {
            System.out.println("Incorrect! No points rewarded!");
            System.out.println("You currently have "+ Points.points + " points");
        }
    }




/*  create strings for names for each card symbols and numbers.
create a data structure to assign the symbols and numbers to each data.

create a function to shuffle the cards. (maybe different types of shuffle: complete random, one by one, batch)
create a function to draw and display the name of the cards.
loop to redraw cards until user stops. also, display how many cards they drew + show the cards drawn already + cards remaining.
within the loop, create function to guess card, and check if it is correct
*/

}
