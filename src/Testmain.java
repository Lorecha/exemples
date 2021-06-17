import java.util.Date;

class TestMain
{
    public static void main(String[] args)
    {
        //exemple classe inuable
       /* ClassInuable im = ClassInuable.createNewInstance(100,"test", new Date());
        System.out.println(im);
        tryModification(im.getImmutableField1(),im.getImmutableField2(),im.getMutableField());
        System.out.println(im);*/
       //exemple java-pass -par value ou java-pass -par -reference
        /*Foo f = new Foo("f");
        changeReference(f); // It won't change the reference!
        modifyReference(f); // It will change the object that the reference variable "f" refers to!*/

    }
  /*  public static void changeReference(Foo a) {
        Foo b = new Foo("b");
        a = b;
    }
    public static void modifyReference(Foo c) {
        c.setAttribute("c");
    }

   */
    /*private static void tryModification(Integer immutableField1, String immutableField2, Date mutableField)
    {
        immutableField1 = 10000;
        immutableField2 = "test changed";
        mutableField.setDate(10);
    }*/
}