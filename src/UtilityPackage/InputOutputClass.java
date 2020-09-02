/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS DEALS WITH THE INPUT OUTPUT FUNCTIONALITY OF OUR PROGRAM
 used classes: Customer, LoginServer
 **/
package UtilityPackage;


import FoodPackage.Beverages;
import MainPackage.Customer;
import MoviePackage.Movie;
import MoviePackage.MovieManager;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.*;
public class InputOutputClass {

    /***FIELD DECLARATIONS**/
    public static HashMap<String, String> login = new HashMap<>();
    public static List<Customer> customers = new ArrayList<>();


    /***READ/WRITE LOGIN DATA**/
    public static void writeLogin(HashMap<String, String> hash) throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            File file = new File("loginDetails.txt");
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(hash);
        } catch (Exception e) {
            System.out.println("An unexpected error occured :(");
        } finally {
            if(fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            if(objectOutputStream != null)
            objectOutputStream.close();


        }
    }



    public static HashMap<String, String> readLogin() throws IOException {
        HashMap<String, String> temporaryHashMap = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("loginDetails.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            temporaryHashMap = (HashMap<String, String>)objectInputStream.readObject();
        }
        catch (Exception e) {
            System.out.println("An unexpected error occured :(");

        }
        finally {
            if(fileInputStream != null)
                fileInputStream.close();
            if(objectInputStream != null)
                objectInputStream.close();
        }
        return  temporaryHashMap;
    }






    /***READ/WRITE USER DATA**/
    public static List<Customer> readUser () throws IOException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        List<Customer> customers = null;
        String file = "customersList.txt";
        if(file.isEmpty() || file == null) {
            return null;
        }
        else if (file != null) {
            try {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                customers = (List<Customer>) objectInputStream.readObject();
            } catch (Exception e) {
                System.out.println("An unexpected error occured :(");
            } finally {
                if (fileInputStream != null) {
                    fileInputStream.close();
                    if(objectInputStream != null)
                    objectInputStream.close();
                }
            }
        }
        return customers;
    }

    public static void writeUser (List<Customer> customers) throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            File file = new File("customersList.txt");
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(customers);

        }
        catch (Exception e) {
            System.out.println("An unexpected error occured :(");

        }
        finally {
            if(fileOutputStream != null)
            fileOutputStream.close();
            if(objectOutputStream != null)
            objectOutputStream.close();
        }
    }




    /***READ/WRITE MOVIE DATA**/

    public static MovieManager readMovies () throws IOException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        MovieManager movies = null;
        String file = "movieData.txt";
        if(file.isEmpty() || file == null) {
            return null;
        }
        else if (file != null) {
            try {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                movies = (MovieManager) objectInputStream.readObject();
            } catch (Exception e) {
                System.out.println("An unexpected error occured :(");
            } finally {
                if (fileInputStream != null) {
                    fileInputStream.close();
                    if(objectInputStream != null)
                        objectInputStream.close();
                }
            }
        }
        return movies;
    }

    public static void writeMovie (MovieManager movieManager) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("movieData.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(movieManager);

        }
        catch (Exception e) {
            System.out.println("Sorry, an error occured while writing movie data :(");
            e.printStackTrace();
        }

    }


    /***READ/WRITE FOOD DATA**/

    public static HashMap<String, Double> readBeverages () throws IOException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        HashMap<String, Double> beverages = null;
        String file = "beverageData.txt";
        if(file.isEmpty() || file == null) {
            return null;
        }
        else if (file != null) {
            try {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                beverages = (HashMap<String, Double>) objectInputStream.readObject();
            } catch (Exception e) {
                System.out.println("An unexpected error occured :(");
            } finally {
                if (fileInputStream != null) {
                    fileInputStream.close();
                    if(objectInputStream != null)
                        objectInputStream.close();
                }
            }
        }
        return beverages;
    }

    public static void writeBeverages (HashMap<String, Double> beverages) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("beverageData.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(beverages);

        }
        catch (Exception e) {
            System.out.println("Sorry, an error occured while writing beverage data :(");
            e.printStackTrace();
        }

    }


    public static HashMap<String, Double> readFastFood () throws IOException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        HashMap<String, Double> fastFood = null;
        String file = "fastFoodData.txt";
        if(file.isEmpty() || file == null) {
            return null;
        }
        else if (file != null) {
            try {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                fastFood = (HashMap<String, Double>) objectInputStream.readObject();
            } catch (Exception e) {
                System.out.println("An unexpected error occured :(");
            } finally {
                if (fileInputStream != null) {
                    fileInputStream.close();
                    if(objectInputStream != null)
                        objectInputStream.close();
                }
            }
        }
        return fastFood;
    }

    public static void writeFastFood (HashMap<String, Double> fastFood) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("fastFoodData.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(fastFood);

        }
        catch (Exception e) {
            System.out.println("Sorry, an error occured while writing beverage data :(");
            e.printStackTrace();
        }

    }


    public static HashMap<String, Double> readSnacks () throws IOException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        HashMap<String, Double> snacks = null;
        String file = "snacksData.txt";
        if(file.isEmpty() || file == null) {
            return null;
        }
        else if (file != null) {
            try {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                snacks = (HashMap<String, Double>) objectInputStream.readObject();
            } catch (Exception e) {
                System.out.println("An unexpected error occured :(");
                e.printStackTrace();
            } finally {
                if (fileInputStream != null) {
                    fileInputStream.close();
                    if(objectInputStream != null)
                        objectInputStream.close();
                }
            }
        }
        return snacks;
    }

    public static void writeSnackData (HashMap<String, Double> snacks) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("snacksData.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(snacks);

        }
        catch (Exception e) {
            System.out.println("Sorry, an error occurred while writing beverage data :(");
            e.printStackTrace();
        }

    }





}
