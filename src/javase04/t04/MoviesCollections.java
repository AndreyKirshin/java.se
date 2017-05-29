package javase04.t04;

import java.io.*;
import java.util.*;

/**
 * This is cmd application which stores name's of movies and main actors.
 * The app allows to add movies and actors who played in it.
 * Also the app allows to remove movies.
 * Data is stored in the file "Movies.out".
 * After working objects are serialized automatically.
 */
public class MoviesCollections {

    public static void main(String[] args) {
        System.out.println(new MoviesCollections().runUsersInterface());
    }

    public List<Movie> runUsersInterface() {
        System.out.println("Hi! Welcome to movie's collection!");
        List<Movie> movies = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream("Movies.out")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (fileInputStream.available() > 0) {
                movies.add((Movie) objectInputStream.readObject());
            }
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        printMovies(movies);
        List<String> actors = getActors(movies);
        while (true) {
            System.out.println("What do you want? \n"
                    + "1 - add Movie\n"
                    + "2 - remove Movie\n"
                    + "3 - look all movies\n"
                    + "4 - look all actors\n"
                    + "5 - exit\n");
            Scanner s = new Scanner(System.in);
            String command = s.nextLine();
            if (command.equals("1")) addMovieToCollection(movies, actors);
            else if (command.equals("2")) removeMovie(movies);
            else if (command.equals("3")) printMovies(movies);
            else if (command.equals("3")) printMovies(movies);
            else if (command.equals("4")) actors.forEach(a -> System.out.println(a));
            else if (command.equals("5")) {
                System.out.println("Good bye!");
                break;
            }
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream("Movies.out")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            movies.forEach(m -> {
                try {
                    objectOutputStream.writeObject(m);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }

    private void printMovies(List<Movie> movies) {
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(i + " " + movies.get(i));
        }
    }

    private List<String> getActors(List<Movie> movies) {
        List<String> actors = new ArrayList<>();
        for (Movie m : movies) {
            actors.addAll(m.getActors());
        }
        return actors;
    }

    private void removeMovie(List<Movie> movies) {
        System.out.println("Select number the movie to remove: ");
        Scanner s = new Scanner(System.in);
        movies.remove(s.nextInt());
    }

    private void addMovieToCollection(List<Movie> movies, List<String> actors) {
        System.out.println("Add movie's name");
        Scanner s = new Scanner(System.in);
        Movie movie = new Movie(s.nextLine());

        while (true) {
            System.out.println("Select actor - 1 / add actor - 2");
            s = new Scanner(System.in);
            if (s.nextLine().equals("1")) {
                for (int i = 0; i < actors.size(); i++) {
                    System.out.println(i + " " + actors.get(i));
                }
                System.out.println("Select actor's number");
                s = new Scanner(System.in);
                movie.addActor(actors.get(s.nextInt()));
            } else {
                System.out.println("Enter actor's name");
                s = new Scanner(System.in);
                movie.addActor(s.nextLine());
            }
            movies.add(movie);
            System.out.println("Add another actor? 2 - yes/1 - no");
            s = new Scanner(System.in);
            if (s.nextLine().equals("1")) break;
        }
    }
}

class Movie implements Serializable {
    private String name;
    private List<String> actors = new ArrayList<>();

    public Movie(String name) {
        this.name = name;
    }

    public Movie(String name, List<String> actors) {
        this.name = name;
        this.actors = actors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public List<String> getActors() {
        return actors;
    }

    public void addActor(String actor) {
        actors.add(actor);
    }

    @Override
    public String toString() {
        return "Movie: '" + name + '\'' +
                ", Actors: " + actors;
    }
}