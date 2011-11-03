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
    Para mejorar la limpieza de la gestion de eventos de persistencia en el contralador:
    - Se ha declarado una nueva interfaz 'Persistencia' que define las funcionalidades requeridas para gestioar la persistencia
    - La clase 'SistemaPlanetario' implementa la interfaz 'Persistencia'. Para ello:
        - El código de gestión de persistencia que antes estaba en el procesador de eventos
        - ahora pasa a los métodos en la clase 'SistemaPlanetario' como parte de la implementación de 'Persistencia'

