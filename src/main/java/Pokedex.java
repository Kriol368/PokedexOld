import java.sql.SQLException;
import java.util.Scanner;

public class Pokedex {
    public static void main(String[] args) throws SQLException {
        int opcion;
        printBanner();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            printMenu();
            opcion = selectedOption();
            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    PostController.printAllPosts();
                    break;
                case 2:
                    if (UserController.login()) currentScreen = 1;
                    break;
                case 3:
                    UserController.addUser();
                    break;
                   /* case 4:
                        UserController.deleteUser();
                        break;
                    case 5:
                        UserController.findByName();*/
            }
        }
    }


    public static void printMenu() {
        //System.out.println("0 Exit | " + "1 Print | " + "2 Add | " + "3 Update | " + "4 Delete | " + "5 Search");
        System.out.println(AnsiColor.BLUE.getCode());
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("0 Exit | 1 All Posts | 2 Login | 3 Register");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(AnsiColor.RESET.getCode());
    }

    private static void printBanner() {
        System.out.println(AnsiColor.RED.getCode());
        System.out.println("""
                ██████╗  ██████╗ ██╗  ██╗███████╗██████╗ ███████╗██╗  ██╗
                ██╔══██╗██╔═══██╗██║ ██╔╝██╔════╝██╔══██╗██╔════╝╚██╗██╔╝
                ██████╔╝██║   ██║█████╔╝ █████╗  ██║  ██║█████╗   ╚███╔╝\s
                ██╔═══╝ ██║   ██║██╔═██╗ ██╔══╝  ██║  ██║██╔══╝   ██╔██╗\s
                ██║     ╚██████╔╝██║  ██╗███████╗██████╔╝███████╗██╔╝ ██╗
                ╚═╝      ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═════╝ ╚══════╝╚═╝  ╚═╝
                                                                        \s
                """);
        System.out.println(AnsiColor.RESET.getCode());
    }
}
