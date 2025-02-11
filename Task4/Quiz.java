import java.util.*;
public class Quiz{
    static class Question{
        String question;
        String[] options;
        String correctAnswer;
        public Question(String question,String[] options,String correctAnswer){
            this.question=question;
            this.options=options;
            this.correctAnswer=correctAnswer;
        }
        public String getQuestion(){
            return question;
        }
        public String[] getOptions(){
            return options;
        }
        public String getCorrectAnswer(){
            return correctAnswer;
        }
    }
    public static void main(String[] args){
        List<Question> question=new ArrayList<>();
        question.add(new Question("what is the capital of india?", new String[]{"mumbai","delhi","kolkata","maharashtra"},"delhi"));
        question.add(new Question("who is the prime minister of india?",new String[]{"modi","nehru","gandhi","indira gandhi"},"modi"));

        Scanner sc=new Scanner(System.in);
        int score=0;
        int totalQuestions=question.size();
        int timeLimit=10;
        for(int i=0;i<totalQuestions;i++){
            Question currentQuestion=question.get(i);

            long startTime=System.currentTimeMillis();
            System.out.println("Question"+(i+1)+":"+currentQuestion.getQuestion());

            String[] options=currentQuestion.getOptions();
            for(int j=0;j<options.length;j++){
                System.out.println((j+1)+"."+options[j]);
            }
            String userAnswer=getAnswerWithTimer(sc,timeLimit,startTime);
            if(userAnswer!=null && userAnswer.equals(currentQuestion.getCorrectAnswer())){
                score++;
            }
        }
        showResult(totalQuestions,score);
    }
    public static String getAnswerWithTimer(Scanner sc,int timeLimit,long startTime){
        System.out.println("You have"+timeLimit+"seconds to answer..");
        String userAnswer=null;
        while (System.currentTimeMillis()-startTime<timeLimit*1000){
           if(sc.hasNextLine()){
                userAnswer=sc.nextLine();
                break;
           } 
        }
        if(userAnswer==null){
            System.out.println("\n Time's up!No answer provided.");
            return null;
        }
        return userAnswer;
    }
    public static void showResult(int totalQuestions,int score){
        System.out.println("Your final score is:"+score+"/"+totalQuestions);
        System.out.println(score==totalQuestions ? "Congrats,you got all answers":"Better luck next time");
    }
}