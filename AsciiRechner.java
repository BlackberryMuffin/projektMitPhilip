public class AsciiRechner{
    /**
     * Die Implementierung von Wurzeln oder hoch's ist momentan nicht geplant
     * Klammern, division und multiplikation kommen noch, da hatte ich aber noch keine Lust drauf
     */
    public double berechne(String term){
        double finale=Math.PI;
        if((term.charAt(0)>48&&term.charAt(0)<57||term.charAt(0)==40)&&(term.charAt(term.length()-1)>48&&term.charAt(term.length()-1)<57||term.charAt(term.length()-1)==41)){
            double numbers[]=new double[term.length()/2+1];char operators[]=new char[term.length()-1];int numn=0;int numo=0;int length=0;int b1=0;int b2=0;boolean comma=false;int comm=-1;char x=0;char x1=0;
            for(int i=0;i<term.length();i++){
                x=term.charAt(i);if(i<term.length()-1)x1=term.charAt(i+1);
                if(term.charAt(i)>48&&term.charAt(i)<57){
                    while(term.charAt(i)>48&&term.charAt(i)<57||(term.charAt(i)==44||term.charAt(i)==46)&&(term.charAt(i+1)>48&&term.charAt(i+1)<57)){
                        if((term.charAt(i)==44||term.charAt(i)==46)&&!comma){
                            comma=true;comm=i;}
                        else if(term.charAt(i)==44||term.charAt(i)==46)return Math.PI;
                        length++;
                        if(i<term.length()-1)
                            i++;
                        else break;
                    }
                    if(i+1<term.length()||term.charAt(i)==41)
                        i--;System.out.println(comm+"\t"+i);
                    for(int j=0;j<length;j++){
                        System.out.print("j="+j+";\ti-j="+i+-j+"\t");
                        if(i-j==comm){System.out.print(0+"\t"+term.charAt(i-j));}
                        else if(comma&&i-j>comm)  {System.out.print(1+"\t"+term.charAt(i-j));  numbers[numn]+=(term.charAt(i-j)-48)*Math.pow(10,j-comm-1);}
                        else if(comma&&i-j<comm)  {System.out.print(1+"\t"+term.charAt(i-j));  numbers[numn]+=(term.charAt(i-j)-48)*Math.pow(10,j-comm-2);}
                        else if(!comma) {System.out.print(1+"\t"+term.charAt(i-j)); numbers[numn]+=(term.charAt(i-j)-48)*Math.pow(10,j);}
                        System.out.println("\t"+numbers[numn]);
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
            for(int i=0;i<numo;i++){
            if(operators1[i]==43)
            finale+=numbers1[i+1];
            if(operators1[i]==45)
            finale-=numbers1[i+1];
            }
            System.out.println(finale+"\n");
            
            return finale;
        }
        else return finale;
    }
}
