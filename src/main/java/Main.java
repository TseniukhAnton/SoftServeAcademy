import model.User;
import repository.SqlUserRepository;

public class Main {
    public static void main(String[] args) {
        SqlUserRepository clients = new SqlUserRepository();
        User first = new User("Daniil", "daniil.dudariev@gmail.com");
        //clients.save(first);
        System.out.println(clients.getById(first.getId()));
    }
}
