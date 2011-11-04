- TipoEvento.java:
    - Creación y envio de eventos mediante una enumeracion en lugar de String. Esto mejora la gestión pues:
        - impide la utilización de eventos que no estan definidos
        - permite gestionar los eventos mediante un swtich en lugar de un if-else anidado.

- Cambiar SistemaSolar -> SistemaPlanetario. El nuestro se llama "Sistema Solar"
    - Se añade a Sistema Solar un atributo "nombre" para el propio sistema. Este atributo implica:
    - Cambiar el constructor actual sin parametros para añadirle un campo String para asignar dicho nombre
    - Añadir getNombre. No se permite setNombre
- Se crea un paquete Utils para clases de utilidad diversa:
    - Inicializador: Clase con metodos static para inicializar con datos de prueba
        - public static SistemaPlanetario inicializaSistemaPlanetario()

- Controlador.procesadorEventos()
    - Gestiona los eventos "TipoEvento" mediante un switch
    - Se implementa la gestion de los eventos:
        - MOSTRAR_SISTEMA_PLANETARIO
        - MOSTRAR_OBJETO_ASTRONOMICO_ESFERICO         
        - Se añade el caso "default" para mostrar por System.err eventos no controlados.

- VistaTexto.java: Se ha implementado los siguientes metodos:
    - public void mostrarSistemaPlanetario(SistemaPlanetario sPlanetario): mostra un sistema planetario
    - public void mostrarOAEsferico(ObjetoAstronomicoEsferico oAEsferico): mostrar un oAEsferico
    - public String getValor(String etiqueta): pedir una valor para 'etiqueta'
    - public void mostrarMensaje(String mensaje): mostrar un mensaje

Vistas nuevas:
    - DialogoPedirCampo: Dialogo para pedir un valor para una etiqueta dada.
    - Mensaje: UI para mostrar un mensaje.
    - VistaObjetoAstronomico: UI para mostrar cualquier tipo de objeto Astronomico
    - VistaSistemaPlanetario: UI para mostrar un sistema planetario completo (incluidos todos los OAEsfericos)

Nuevas bibliotecas:
    - commons-lang3-3.0.jar: Liberaria para utilización de WordUtils.capitalize(). Se utiliza para:
        - Al insertar los OAEsfericos en el sistema planetario, todos los nombres se 'capitalizan'
        - se evita así problemas con la busqueda de objetos por diferencias 'case sensitive'. Por ejemplo a la hora de pedir un objeto para buscar

Rev 0.8:
    Para mejorar la limpieza de la gestión de eventos de persistencia en el controlador:
    - Se ha declarado una nueva interfaz 'Persistencia' que define las funcionalidades requeridas para gestionar la persistencia
    - La clase 'SistemaPlanetario' implementa la interfaz 'Persistencia'. Para ello:
        - El código de gestión de persistencia que antes estaba en el procesador de eventos
        - ahora pasa a los métodos en la clase 'SistemaPlanetario' como parte de la implementación de 'Persistencia'

Rev 0.9:
    Mejoras en el menu. Cuando el modelo no tiene datos, todos los items de menu que necesitan datos del modelo aparecen noVisibles
    Para ello se ha implementado el patrón Observer:
    - Observer : menuItems
    - Observable: SistemaPlanetario
    Tambien se ha cambiado el proceso de puesta en marcha del SistemaPlanetario:
    - Ahora la construcción del objeto no implica darle nombre. Eso ahora se lleva a cabo mediante el metodo 'iniciliza(String nombre)'
    - Se ha sobrecargado el método inicializa(SistemaPlanetario) para que inicialize el sistema desde otro objeto SistemaPlanetarioç
    El proceso de 'deserializacion' ahora no devuelve ningún objeto, sino que invoca a 'inicializacion(SistemaPlanetario) para poner cargar el objeto actual desde otro objeto
    - Cambiado la inicializacion de la vistaMenu:
        - Ahora la inicializacion del menu se hace desde Inicializador.inicializaMenu
        - A la Vista se la pasa la VistaMenu ya inicializada.
Rev 1.00
    Implementacion de una nueva funcionalidad para añadir un nuevo SP:
    - Crear un nuevo tipo evento "NUEVO_SP"
    - Añadir esa opcion al menu
    - Gestionar en el controlador el evento
    Implementacion de una nueva funcionalidad para añadir un nuevo OAE:
    - Crear un nuevo tipo evento "NUEVO_OAE"
    - Añadir esa opcion al menu
    - Gestionar en el controlador el evento
    - Crear un nuevo metodo para pedir datos del OAE (getOAE)
