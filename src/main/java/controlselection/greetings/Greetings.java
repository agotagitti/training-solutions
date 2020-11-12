package controlselection.greetings;

public class Greetings {

   public String sayGreeting(int hour, int minute) {
        //a konzultáción együtt csináltuk meg ezt a Classt + testClasst

       String greeting = "";

       if (hour < 5) {
           greeting = "Good Night";
       } else if (hour < 9) {
           greeting = "Good Morning";
       } else if (hour <= 17 || (hour == 18 && minute <=30)) {
            greeting ="Good Afternoon";
       } else if (hour < 20) {
           greeting = "Good Evening";
       } else {
           greeting = "Good Night";
       }
       return greeting;
   }
}
