package sample;

public class Game {
    public static int computerChoice;
        public static int rock(){
           String computerInput = Game.computerChoice();
            if(computerInput.equals("sten")){
                return 0; //Draw
            }else if(computerInput.equals("påse")){
                return 2; // Loose
            }else{
                return 1; //WIN!
            }
        }

        public static int paper(){
            String computerInput = Game.computerChoice();
            if(computerInput.equals("påse")){
                return 0; //Draw
            }else if(computerInput.equals("sax")){
                return 2; // Loose
            }else{
                return 1; //WIN!
            }
        }

        public static int scissor(){
            String computerInput = Game.computerChoice();
            if(computerInput.equals("sax")){
                return 0; // Tie
            }else if(computerInput.equals("sten")){
                return 2; //Loose
            }else{
                return 1; //WIN!
            }
        }

        public static String computerChoice(){
            String[] correctInputs = {"sten", "sax", "påse"};
            String computerInput; // Vilken sträng som datorn har valt

            computerChoice = (int) (Math.random()*correctInputs.length);
            computerInput = correctInputs[computerChoice];
            return computerInput;
        }
}
