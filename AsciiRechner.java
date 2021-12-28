import java.util.List;
import java.util.ArrayList;

public class AsciiRechner{
    
    /**
     * Let's start with the simple situation, where there are only integer numbers and no parentheses
     * Calculation just blindly from left to right
     */
    public double berechne2(String term){
        //split term according to operators
        char[] ops = new char[]{'+','-','*','/'};
        List<String> numbers = new ArrayList<>();
        List<Character> operations = new ArrayList<>();
        
        String num = "";
        for (int i =0;i<term.length();i++){
            char c = term.charAt(i);
            boolean isOperator = false;
            for (char op:ops){
                if (c==op){
                    operations.add(c); //save operation
                    numbers.add(num); //save number
                    num =""; //reset number
                    isOperator = true;
                    break;
                }
            }
            if (!isOperator){
                num+=c;
            }
        }
        numbers.add(num);
        
        
        //calculation
        int n = 0;
        double result = Double.parseDouble(numbers.get(n++));
        for (Character op: operations){
            switch(op){
                case '+':
                    result+=Double.parseDouble(numbers.get(n++));
                    break;
                case '-':
                    result-=Double.parseDouble(numbers.get(n++));
                    break;
                case '*':
                    result*=Double.parseDouble(numbers.get(n++));
                    break;
                case '/':
                    result/=Double.parseDouble(numbers.get(n++));
                    break;
            }
        }

        //for debugging
        output(numbers,operations,result);
        
        return result;
    }
    
    private void output(List<String> numbers, List<Character> operations,double result){
        
        int count = 0;
        for (String number:numbers){
            System.out.print(number);
            if (count<operations.size())
                System.out.print(operations.get(count++));
        }
        System.out.println("="+result);
        
    }
    
    
    /**
     * Die Implementierung von Wurzeln oder hoch's ist momentan nicht geplant
     * Klammern, division und multiplikation kommen noch, da hatte ich aber noch keine Lust drauf
     */
    public double berechne(String term){
        double finale=Math.PI;
        if(
        (term.charAt(0)>47&&term.charAt(0)<58||term.charAt(0)==40)&& //digits or opening parenthesis
        (term.charAt(term.length()-1)>47&&term.charAt(term.length()-1)<58||term.charAt(term.length()-1)==41))//digits or closing parenthesis
        {
            double numbers[]=new double[term.length()/2+1]; //create array for a bunch of numbers
            char operators[]=new char[term.length()-1]; //chreate array for a bunch of operator chars
            int numn=0;
            int numo=0;
            int length=0;
            int b1=0;
            int b2=0;
            boolean comma=false;
            int comm=-1;
            char x=0;
            char x1=0;
            for(int i=0;i<term.length();i++){
                x=term.charAt(i); //ith symbol
                if(i<term.length()-1)
                    x1=term.charAt(i+1); //(i+1)th symbol
                if(term.charAt(i)>47&&term.charAt(i)<58){ //digit
                    while(term.charAt(i)>47&&term.charAt(i)<58||(term.charAt(i)==44||term.charAt(i)==46)&&(term.charAt(i+1)>47&&term.charAt(i+1)<58)){
                        if((term.charAt(i)==44||term.charAt(i)==46)&&!comma){
                            comma=true;comm=i;} //save the position of the decimal point
                        else if(term.charAt(i)==44||term.charAt(i)==46)
                            return Math.PI; //complain stupid input
                        length++; //keep track of the length of the number
                        if(i<term.length()-1)
                            i++;
                        else break;
                    }
                    if(i+1<term.length()||term.charAt(i)==41) //detect closing parenthesis
                        i--;
                    System.out.println(comm+"\t"+i); //some output for debugging
                    for(int j=0;j<length;j++){ //at this point I give up, it is too complicated. Let's start simpler!!!
                        System.out.print("j="+j+";\ti-j="+i+-j+"\t");
                        if(i-j==comm){System.out.print(0+"\t"+term.charAt(i-j));}
                        else if(comma&&i-j>comm)  {System.out.print(1+"\t"+term.charAt(i-j));  numbers[numn]+=(term.charAt(i-j)-48)*Math.pow(10,j-comm-2);}
                        else if(comma&&i-j<comm)  {System.out.print(2+"\t"+term.charAt(i-j));  numbers[numn]+=(term.charAt(i-j)-48)*Math.pow(10,j-comm-3);}
                        else if(!comma) {System.out.print(3+"\t"+term.charAt(i-j)); numbers[numn]+=(term.charAt(i-j)-48)*Math.pow(10,j);}
                        System.out.println("\t"+numbers[numn]+"\t"+(term.charAt(i-j)-48)*Math.pow(10,j));
                    }
                    numn++;length=0;comm=-1;comma=false;
                }
                else if(/**x==40||x==41||x==42||*/x==43||x==45/**||x==47||x==59*/){
                    if(x==40)b1++;if(x==41)b2++;if(b1<b2){System.out.println("Error:weird brackets");return Math.PI;}if(i==term.length()-1&&b1!=b2){System.out.println("Error:weird brackets");return Math.PI;}
                    if((/**x==42||*/x==43||x==45/**||x==47||x==59*/)&&(/**x1==42||*/x1==43||x1==45/**||x1==47||x1==59*/)){System.out.println("Error:\"Thats not how operators work, sorry\"");return Math.PI;}
                    operators[numo]+=x;numo++;
                }
            }
            double numbers1[]=new double[numn];char operators1[]=new char[numo];finale=numbers[0];
            for(int i=0;i<numn;i++){
                numbers1[i]=numbers[i];}
            for(int i=0;i<numo;i++){
                operators1[i]=operators[i];}
            System.out.print(numbers[0]);
            for(int i=0;i<numo;i++){
                System.out.print(operators[i]+""+numbers1[i+1]);
                if(operators1[i]==43)
                    finale+=numbers1[i+1];
                if(operators1[i]==45)
                    finale-=numbers1[i+1];
            }
            System.out.println("="+finale+"\n");

            return finale;
        }
        else{System.out.println("hi"); return finale;}
    }

    public void print(String hi){System.out.println(hi);}
}
