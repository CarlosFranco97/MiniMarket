package minimarket;

import java.util.Scanner;

public class MiniMarket {
    static Scanner sc = new Scanner(System.in);

    /* Administrator */
    static String[] userAdmin = new String[4];
    static int idAdmin;
    static String nameAdmin;
    static String emailAdmin;
    static String passwordAdmin;
    static boolean statusConnectionAdmin = false;

    /* Client */
    static String[][] usersClients = new String[3][5];
    static int idClient;
    static String nameClient;
    static String emailClient;
    static String passwordClient;
    static boolean statusConnectionClient = false;
    static boolean  aConnectedClient = false;

    /* Products */
    static String[][] productsMiniMarket = new String[3][4];
    static int idProduct;
    static String nameProduct;
    static float priceProduct;
    static int quantityProduct;

    public static void main(String[] args){
        int i = 1;
        while(i != 0) {
            System.out.println("¿Qué deseas realizar?" + "\n" +
        "1.-Registrar administrador o cliente " + "\n" +
                    "2.-Listar Administrador " + "\n" +
                    "3.-Listar clientes " + "\n" +
                    "4.-Iniciar sesión como administrador " + "\n" +
                    "5.-Iniciar sesión como cliente " + "\n" +
                    "6.-Agregar productos " + "\n" +
                    "7.-Listar Productos " + "\n" +
                    "8.-Comprar producto" + "\n" +
                    "9.- salir");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                registerAdminOrClient();
                break;
                case 2:
                    if(userAdmin[0] == null) {
                        System.out.println("No hay administrador registrado");
                        break;
                    } else {
                        listAdmin();
                        break;
                    }
                case 3:
                    if(usersClients[0][0] == null) {
                        System.out.println("No hay clientes registrados");
                        break;
                    } else {
                        listUsersClients();
                        break;
                    }
                case 4:
                    System.out.println("Iniciar sesión como administrador");
                    if(statusConnectionAdmin) {
                    System.out.println("Ya se ha iniciado sesión");
                    } else {
                        loginAdmin();
                        break;
                    }
                case 5:
                    System.out.println("Iniciar sesión como cliente");
                    if(aConnectedClient) {
                        System.out.println("Ya se ha iniciado sesión");
                        break;
                    } else {
                        loginClients();
                        break;
                    }
                case 6:
                    if(statusConnectionAdmin) {
                     System.out.println("Agregar Producto");
                      agregateToProducts();
                     break;
                    } else {
                        System.out.println("Debes ingresar como administrador para poder tener permisos");
                        break;
                    }

                case 7:
                    if(productsMiniMarket[0][0] == null) {
                        System.out.println("No hay productos disponibles");
                        break;
                    } else {
                        System.out.println("Listado de productos");
                        listProducts();
                        break;

                    }
                case 8:
                    if(aConnectedClient && productsMiniMarket[0][0] != null) {
                        System.out.println("Comprar producto");
                        purchaseOfProducts();
                        break;
                    } else {
                        System.out.println("Verifique si inicio sesión o si no hay productos registrados");
                        break;
                    }

                    case 9:
                    i = 0;
                    break;

                default:
                    System.out.println("Ingrese una opción valida");
            }
        }
    }

    /* function register admin or client */
     public static void registerAdminOrClient() {
            int i = 1;
            while(i != 0) {
                System.out.println("1.- Registrar Administrador 2.- Registrar clientes 3.- salir");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        registerAdmin();
                        break;
                        case 2:
                            agregateToUsersClients();
                            break;
                    case 3:
                    i = 0;
                    break;
                    default:
                        System.out.println("Ingrese una opción valida");
                }
            }

    }

    /* administrator register function */

    public static void registerAdmin() {
        System.out.println("Crear Administrador");
        System.out.println("Ingresa tu número de cedula");
        idAdmin = sc.nextInt();
        sc.nextLine();
        userAdmin[0] = idAdmin + "";

        System.out.println("Ingresa nombre de usuario");
        nameAdmin = sc.nextLine();
        userAdmin[1] = nameAdmin;

        System.out.println("Ingresa el email");
        emailAdmin = sc.nextLine();
        userAdmin[2] = emailAdmin;

        System.out.println("Ingresa contraseña");
        passwordAdmin = sc.nextLine();
        userAdmin[3] = passwordAdmin;

    }
    /* list Admin user */
    public static void listAdmin() {
        for(int i = 0; i < userAdmin.length - 1; i++) {
            System.out.println(userAdmin[i] + " ");
        }
    }

    /* client register */

    public static String[] registerClient() {
         String[] userClient = new String[5];
         System.out.println("Crear cliente");
        System.out.println("Ingrese número de cedula");
        idClient = sc.nextInt();
        userClient[0] = idClient + "";
        sc.nextLine();

        System.out.println("Ingrese el nombre de usuario");
        nameClient = sc.nextLine();
        userClient[1] = nameClient;

        System.out.println("Ingrese el correo");
        emailClient = sc.nextLine();
        userClient[2] = emailClient;

        System.out.println("Ingrese contraseña");
        passwordClient = sc.nextLine();
        userClient[3] = passwordClient;

        userClient[4] = statusConnectionClient + "";

        return userClient;
    }

    /* function for agregateToUsersClients */
    public static void agregateToUsersClients(){
        for(int i = 0; i < usersClients.length; i++){
                usersClients[i] = registerClient();
        }

    }

    /* function list clients */
    public static void listUsersClients () {
        for (int i = 0; i < usersClients.length; i++) {
            for(int j = 0; j < usersClients[i].length - 1; j++) {
                System.out.print(usersClients[i][j] + " ");
            }
                System.out.print("\n");
        }
    }

    /* login */

    /* login admin */

    public static void loginAdmin() {
        String inputNameOrEmailAdmin;
        String inputPasswordAdmin;
        String nameAdmin = userAdmin[1];
        String emailAdmin = userAdmin[2];
        String passwordAdmin = userAdmin[3];


        System.out.println("Ingrese nombre de usuario o correo");
        sc.nextLine();
        inputNameOrEmailAdmin = sc.nextLine();

        System.out.println("Igrese contraseña");
        inputPasswordAdmin = sc.nextLine();

        if(inputNameOrEmailAdmin.equals(nameAdmin) || inputNameOrEmailAdmin.equals(emailAdmin) && inputPasswordAdmin.equals(passwordAdmin)) {
            System.out.println("Bienvenido " + nameAdmin);
            statusConnectionAdmin = true;
        } else {
            System.out.println("Valide credenciales");
        }
    }

    /* login clients */
    public static void loginClients() {
        String inputNameOrEmailClient;
        String inputPasswordClient;
        /* userClients[0][2] user 1, nombre...
        userClients[0][3] user 1, correo... userClients[0][4] user 1,
        password... userClients[0][5] statusConnection
        un for empezando desde dos... para evaluar.
        */


        System.out.println("Ingrese el nombre o el Email");
        sc.nextLine();
        inputNameOrEmailClient = sc.nextLine();

        System.out.println("Ingrese la contraseña");
        inputPasswordClient = sc.nextLine();

        boolean dataIsFound = false;
        for(int i = 0; i < usersClients.length; i++) {
                if(inputNameOrEmailClient.equals(usersClients[i][1])
                        || inputNameOrEmailClient.equals(usersClients[i][2])
                            && inputPasswordClient.equals(usersClients[i][3])
                ) {
                    dataIsFound = true;

                    System.out.println("Bienvenido apreciado cliente " + usersClients[i][1]);
                    usersClients[i][4] = true + "";
                    aConnectedClient = true;
                    break;
                }

        }

        if(!dataIsFound) {
            System.out.println("Valide credenciales");
        }

    }


    /* register product */
    public static String[] registerProduct(){
        String[] products = new String[4];
        System.out.println("Registrar producto");
        System.out.println("Ingresa el código del producto");
        idProduct = sc.nextInt();
        products[0] = idProduct + "";

        System.out.println("Ingresa el nombre del producto");
        sc.nextLine();
        nameProduct = sc.nextLine();
        products[1] = nameProduct;

        System.out.println("Ingresa el precio unitario del producto");
        priceProduct = sc.nextFloat();
        products[2] = priceProduct + "";

        System.out.println("Ingresa la cantidad del producto");
        quantityProduct = sc.nextInt();
        products[3] = quantityProduct + "";

        return products;

    }

    /* agregate products to productsMiniMarket */

    public static void agregateToProducts() {
        int i = 0;
        while(i < productsMiniMarket.length) {
            productsMiniMarket[i] = registerProduct();
            i++;
        }
    }

    public static void listProducts() {
        for(int i = 0; i < productsMiniMarket.length; i++) {
            for(int j = 0; j < productsMiniMarket[i].length; j++) {
                System.out.print(productsMiniMarket[i][j] + " ");
            }
            System.out.println("\n");
        }
    }


        /* purchase to products */
    public static void purchaseOfProducts() {
        int quantityToPurcharse;
        String nameProductToPurchase;
        /* float purcharsePrice; */

        System.out.println("¿Qué productos deseas comprar?");
        for(int i = 0; i < productsMiniMarket.length; i++) {
            System.out.println("producto # " + (i + 1));
            for(int j = 1; j < productsMiniMarket[i].length; j++){
                System.out.print(productsMiniMarket[i][j] + " ");
            }
            System.out.println("\n");
        }

        System.out.println("Ingrese el nombre del producto que desea comprar");
        sc.nextLine();
        nameProductToPurchase = sc.nextLine();


        boolean productIsFound = false;
        for(int i = 0; i < productsMiniMarket.length; i++) {

            String nameProductMiniMarket = productsMiniMarket[i][1];
            int quantityProductMiniMarket = Integer.parseInt(productsMiniMarket[i][3]);
            System.out.println("\n");

            if(nameProductToPurchase.equals(nameProductMiniMarket)) {
                /* productsMiniMarket[i][1]; nombre producto */
                /*  productsMiniMarket[i][3] ; quantity producto */

                productIsFound = true;
                System.out.println("Ingrese la cantidad a comprar del producto");
                quantityToPurcharse = sc.nextInt();

                quantityProductMiniMarket -= quantityToPurcharse;

                productsMiniMarket[i][3] = quantityProductMiniMarket + "";


                break;
            }

        }

        if(!productIsFound) {
            System.out.println("No se pudo encontrar el producto");
        }




    }

}

