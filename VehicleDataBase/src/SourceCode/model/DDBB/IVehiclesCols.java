package SourceCode.model.DDBB;

public interface IVehiclesCols {

    String[] ALL_COLS_NAMES = {"Type", "ChasNumber", "Brand", "Power", "OwID", "RegDate", "Próximo ITV", "License Plate", "Places", "Service/Possibility", "Doors"};
    int ALL_COL_NUMBER = 0;

    //Tabla vehiculos
    String[] VEHICLE_COLS_NAMES = {"License Plate", "Owner Id", "Chassis Number", "Brand", "Power", "Registration date"};

    String VEHICLE_TABLE_NAME = "vehiculos";
    String VEHICLE_LICENSE_PLATE = "matricula";
    String VEHICLE_CHASSIS_NUMBER = "numero_chasis";
    String VEHICLE_BRAND = "marca";
    String VEHICLE_POWER = "potencia";
    String VEHICLE_OWNER_ID = "dni_propietario";
    String VEHICLE_REGISTRATION_DATE = "fecha_matriculacion";
    String VEHICLE_ITV = "proximo_itv";
    int VEHICLE_COL_NUMBER = 7;

    //Tabla motos
    String[] MOTORCYCLE_COLS_NAMES = {"License Plate", "Chassis Number", "Brand", "Power", "Owner ID", "Registration Date", "Próximo ITV"};
    String[] ONLY_MOTORCYCLE_COLS = {};

    String MOTORCYCLE_TABLE_NAME = "motos";
    String MOTORCYCLE_LICENSE_PLATE = "matricula_moto";
    int MOTORCYCLE_COL_NUMBER = 7;

    //Tabla turismos
    String[] CAR_COLS_NAMES = {"Doors", "Possibility", "Places", "License Plate", "Chassis Number", "Brand", "Power", "Owner ID", "Registration Date", "Próximo ITV"};
    String[] ONLY_CARS_COLS = {"Number of places", "Number of doors", "Possibility"};

    String CAR_TABLE_NAME = "turismos";
    String CAR_LICENSE_PLATE = "matricula_turismos";
    String CAR_NUMBER_OF_PLACES = "numero_plazas";
    String CAR_NUMBER_OF_DOORS = "numero_puertas";
    String CAR_POSSIBILITY = "posibilidad";

    String[] CAR_POSSIBILITIES_SELECTOR = {"REMOLQUE", "CARGA"};

    int CAR_COL_NUMBER = 10;

    //Tabla guaguas
    String[] BUS_COLS_NAMES = {"Places", "Service", "License Plate", "Chassis Number", "Brand", "Power", "Owner ID", "Registration Date", "Próximo ITV"};
    String[] ONLY_BUS_COLS = {"Number of places", "Type of service"};

    String BUS_TABLE_NAME = "guaguas";
    String BUS_LICENSE_PLATE = "matricula_guaguas";
    String BUS_NUMBER_OF_PLACES = "numero_plazas";
    String BUS_TYPE_OF_SERVICE = "tipo_servicio";

    String[] BUS_SERVICES_SELECTOR = {"PUBLICO", "ESCOLAR", "DISCRECIONAL"};

    int BUS_COL_NUMBER = 9;
}
