import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/*
 * Requires the MongoDB Java Driver.
 * https://mongodb.github.io/mongo-java-driver
 */
public class Mongo {
    final static String Host = "localhost";
    private final static int PORT = 27017;

    public static void main(String[] args) {
        try {
            MongoClient mongoClient = new MongoClient(Host, PORT);
            MongoDatabase db = mongoClient.getDatabase("personne"); //la base de donnes
            System.out.println("je me suis connécté a la base de b=donnes");
            MongoCollection<Document> coll = db.getCollection("persone"); //le document qui prends la collection
            //Document doc = new Document("name", "Lorena").append("age", 39).append("email", "poplorenamaria@gmail.com");
           insertSimple(coll);
            //insertMultiple(coll);
          //  insertMultiplest(coll);
           lecture(coll);
            Scanner sc=new Scanner(System.in);
           // System.out.println("Vous chercher qui : ");
         //   String nom=sc.next();
           // filtrer(nom,coll);
           // System.out.println("Entre la marge d'age: ");
          ///  int age1=sc.nextInt();
        //    int age2=sc.nextInt();
         //   filtrersupp(age1,age2,coll);
           // System.out.println("Vous voulez changer de nom (1), age(2) , mail(3), ou preference chat(4): ");
         //   int opt=sc.next();
          //  System.out.println("Vous changer le mail de qui: ");
          //  String nume=sc.next();
          //  System.out.println("Nouveau mail");
           // String nouveau=sc.next();
            //misajour(nume,nouveau,coll);
            System.out.println("Oui voulez vous effacer, on cherche par raport a qoui nom, age, email : ");
            String filds=sc.next();
            System.out.println("Ouelle valeur: ");
            String valeur=sc.next();
            delete(filds,valeur,coll);
            
        } catch (Exception c) {
            System.err.println((c.getClass().getName() + ":" + c.getMessage()));

        }
    }

    public static void lecture(MongoCollection<Document> coll) {
        MongoCursor<Document> cursor = coll.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                System.out.println(document.toJson());
            }
        } finally {
            cursor.close();
        }
    }

    public static void insertSimple(MongoCollection<Document> coll) {

        Document doc = new Document("name", "Lorena").append("age", 39).append("email", "poplorenamaria@gmail.com");
        coll.insertOne(doc);
    }

    public static void insertMultiple(MongoCollection<Document> coll) {
        List<Document> documents = new ArrayList<Document>(10);
        for (int i = 0; i < 10; i++) {
            documents.add(new Document("key", UUID.randomUUID().toString()));
        }
        coll.insertMany(documents);
    }
    public static void insertMultiplest(MongoCollection<Document> coll) {
        List<Document> documents = new ArrayList<Document>(10);

        documents.stream().map(d -> d.append("name", "Zhora").append("age", 39).append("email", "poplorenamaria@gmail.com"));

    }
    public static void filtrer(String nom,MongoCollection <Document> coll)
    {
        MongoCursor <Document> cursor= coll.find(Filters.eq("name",nom)).iterator();
        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                System.out.println(document.toJson());
            }
        } finally {
            cursor.close();
        }
    }
    public static void filtrersupp(int age1,int age2,MongoCollection <Document> coll)
    {
        MongoCursor<Document> cursor = coll.find(Filters.and(Filters.gt("age", age1),Filters.lte("age", age2))).iterator();
        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                System.out.println(document.toJson());
            }
        } finally {
            cursor.close();
        }
    }
    public static void misajour(String nume, String nouveau , MongoCollection <Document> coll)
    {

        coll.updateOne(Filters.eq("name", nume),new Document("$set", new Document("mail", nouveau)));
        MongoCursor<Document> cursor=coll.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                System.out.println(document.toJson());
            }
        } finally {
            cursor.close();
        }
    }
    public static void misajourmany(String nume, String nouveau , MongoCollection <Document> coll)
    {

        coll.updateMany(Filters.eq("name", nume),new Document("$set", new Document("mail", nouveau)));
        MongoCursor<Document> cursor=coll.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                System.out.println(document.toJson());
            }
        } finally {
            cursor.close();
        }
    }
    public static void delete (String field,String valoare ,MongoCollection <Document> coll)
    {

        if (field=="age")
        {
            int varsta=Integer.parseInt(valoare);
            coll.deleteOne(Filters.eq("age", varsta));
        }
        else
        {
            coll.deleteOne(Filters.eq(field, valoare));
        }
        MongoCursor<Document> cursor=coll.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                System.out.println(document.toJson());
            }
        } finally {
            cursor.close();
        }
    }
    public static void deletemany (String nume,  MongoCollection <Document> coll)
    {

        coll.updateMany(Filters.eq("name", nume),new Document("$set", new Document("mail", nouveau)));
        MongoCursor<Document> cursor=coll.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                System.out.println(document.toJson());
            }
        } finally {
            cursor.close();
        }
    }
}


