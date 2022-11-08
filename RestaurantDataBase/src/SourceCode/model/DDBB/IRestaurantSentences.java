package SourceCode.model.DDBB;

public interface IRestaurantSentences {

    //Tabla productos
    String PRODUCT_SQL_QUERY = "SELECT `codigo_producto`,`nombre_producto`,`tipo_categoria`,`precio_producto`,`ingredientes_producto` FROM `productos` INNER JOIN `categorias` ON `productos`.`codigo_categoria_producto` LIKE `categorias`.`codigo_categoria`";
    String PRODUCT_SEARCH_BAR = "SELECT `codigo_producto` FROM `productos`";
    String PRODUCT_SEARCH_BY_ID = PRODUCT_SQL_QUERY+" AND `productos`.`codigo_producto` LIKE (SELECT `codigo_producto` FROM `productos` WHERE `codigo_producto` LIKE ";

    String[] PRODUCT_COLS_NAMES = {"ID","Name","Category","Price","Ingredients"};

    int PRODUCT_COL_NUMBER = 5;

    //Tabla clientes (tickets no pagados)
    String CUSTOMER_SQL_QUERY = "SELECT `codigo_ticket`, `mesa_cliente`, `precio_total` FROM `tickets`,`clientes`,`pagos` WHERE `tickets`.`pagado` LIKE '0' AND `clientes`.`codigoQR_cliente` LIKE `tickets`.`codigoQR_cliente_ticket` GROUP BY `tickets`.`codigo_ticket`";

    String CUSTOMER_SEARCH_BAR = "SELECT `codigo_ticket` FROM `tickets`,`clientes`,`pagos` WHERE `tickets`.`pagado` LIKE '0' GROUP BY `tickets`.`codigo_ticket`";
    String CUSTOMER_SEARCH_BY_ID = "SELECT `codigo_ticket`, `mesa_cliente`, `precio_total` FROM `tickets`,`clientes`,`pagos` WHERE `tickets`.`pagado` LIKE '0' AND `clientes`.`codigoQR_cliente` LIKE `tickets`.`codigoQR_cliente_ticket` AND `tickets`.`codigo_ticket` LIKE (SELECT `codigo_ticket` FROM `tickets` WHERE `codigo_ticket` LIKE ";
    String CUSTOMER_EXTRA_QUERY = "GROUP BY `tickets`.`codigo_ticket`";

    String[] CUSTOMER_COLS_NAMES = {"Ticket code","Table number","Total price"};

    String NEW_CUSTOMER_SEARCH_BAR = "SELECT `nombre_producto` FROM `productos` ORDER BY `productos`.`codigo_categoria_producto`";
    String PRODUCT_ID_BY_NAME = "SELECT `codigo_producto` FROM `productos` WHERE `productos`.`nombre_producto` LIKE '";
    String PRODUCT_PRICE_BY_NAME = "SELECT `precio_producto` FROM `productos` WHERE `productos`.`nombre_producto` LIKE '";

    int CUSTOMER_COL_NUMBER = 3;

    //Tabla tickets(pagados)
    String TICKETS_SQL_QUERY = "SELECT `codigo_ticket`, `mesa_cliente`, `precio_total`,`fecha_ticket`,`tipo_pago`,`cantidad_pagada` FROM `tickets`,`clientes`,`pagos` WHERE `pagos`.`codigo_ticket_pago` LIKE `tickets`.`codigo_ticket` AND `tickets`.`pagado` LIKE '1' AND `clientes`.`codigoQR_cliente` LIKE `tickets`.`codigoQR_cliente_ticket` GROUP BY `tickets`.`codigo_ticket`";

    String TICKETS_SEARCH_BAR = "SELECT `codigo_ticket` FROM `tickets`,`clientes`,`pagos` WHERE `tickets`.`pagado` LIKE '1' GROUP BY `tickets`.`codigo_ticket`";
    String TICKETS_SEARCH_BY_ID = "SELECT `codigo_ticket`, `mesa_cliente`, `precio_total`,`fecha_ticket`,`tipo_pago`,`cantidad_pagada` FROM `tickets`,`clientes`,`pagos` WHERE `pagos`.`codigo_ticket_pago` LIKE `tickets`.`codigo_ticket` AND `tickets`.`pagado` LIKE '1' AND `clientes`.`codigoQR_cliente` LIKE `tickets`.`codigoQR_cliente_ticket` AND `tickets`.`codigo_ticket` LIKE (SELECT `codigo_ticket` FROM `tickets` WHERE `codigo_ticket` LIKE ";
    String TICKETS_EXTRA_QUERY = "GROUP BY `tickets`.`codigo_ticket`";

    String[] TICKET_COLS_NAMES = {"Ticket code","Table number","Total price","Date","Payment type","Amount paid"};

    int TICKETS_COL_NUMBER = 6;

    //Tabla pagos(pagar tickets)
    String PAYMENTS_SEARCH_BAR = "SELECT `codigo_ticket` FROM `tickets`,`clientes`,`pagos` WHERE `tickets`.`pagado` LIKE '0' AND `clientes`.`codigoQR_cliente` LIKE `tickets`.`codigoQR_cliente_ticket` GROUP BY `tickets`.`codigo_ticket`";

    String PAYMENTS_SEARCH_BY_ID = "SELECT `codigo_ticket`,`mesa_cliente`, `precio_total`,`fecha_ticket` FROM `tickets`,`clientes`,`pagos` WHERE `tickets`.`pagado` LIKE '0' AND `clientes`.`codigoQR_cliente` LIKE `tickets`.`codigoQR_cliente_ticket` AND `tickets`.`codigo_ticket` LIKE (SELECT `codigo_ticket` FROM `tickets` WHERE `tickets`.`codigo_ticket` LIKE ";
    String PAYMENTS_EXTRA_QUERY = "GROUP BY `tickets`.`codigo_ticket`";

    String[] PAYMENTS_COLS_NAMES = {"Ticket code","Table number","Total price","Date"};


    String PAYMENTS_FOOD_VIEW = "SELECT `cantidad_detallada`,`nombre_producto`,`precio_producto`*`cantidad_detallada` FROM `productos`, `detalles_ticket`, `tickets` WHERE `tickets`.`codigo_ticket` LIKE `detalles_ticket`.`codigo_ticket_detalle` AND `productos`.`codigo_producto` LIKE `detalles_ticket`.`codigo_producto_detalle` AND `tickets`.`codigo_ticket` LIKE (";
    String PAYMENTS_FOOD_VIEW_EXTRA = " GROUP BY `productos`.`nombre_producto`";

    String PAYMENTS_GET_TOTAL_BY_TICKET = "SELECT `precio_total` FROM `tickets` WHERE `tickets`.`codigo_ticket` LIKE ";

    String[] PAYMENTS_FOOD_VIEW_NAMES = {"Quantity","Product Name","Price"};

    int PAYMENTS_COL_NUMBER = 4;

    String GET_CLIENTID_BY_TICKET = "SELECT `codigoQR_cliente_ticket` FROM `tickets` WHERE `tickets`.`codigo_ticket` LIKE ";


    String[] CATEGORY_OPTIONS = {"Bebida","PlatoPrincipal","Entrante","Postre"};
}
