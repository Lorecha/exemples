import static java.lang.System.currentTimeMillis;


    class ConcatTest{
        public static String concatWithString()    {
            String t = "Java";
            for (int i=0; i<10000; i++){
                t = t + "Tpoint";
            }
            return t;
        }
        public static String concatWithStringBuffer(){
            StringBuffer sb = new StringBuffer("Java");
            for (int i=0; i<10000; i++){
                sb.append("Tpoint");
            }
            return sb.toString();
        }
        public static void main(String[] args){
            long startTime = currentTimeMillis();
            concatWithString();
            System.out.println("Time taken by Concating with String: "+(currentTimeMillis()-startTime)+"ms");
            startTime = currentTimeMillis();
            concatWithStringBuffer();
            System.out.println("Time taken by Concating with  StringBuffer: "+(currentTimeMillis()-startTime)+"ms");
        }
    }

