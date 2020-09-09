package gr.uniwa.apice.Enums;

public enum Courses {
    C("Προγραμματισμός Υπολογιστών","1ο","Βασικός Κύκλος Σπουδών"),
    CPP("Αντικειμενοστρεφής Προγραμματισμός","2ο","Βασικός Κύκλος Σπουδών"),
    LOGICDESIGN("Ψηφιακή Σχεδίαση","2ο","Βασικός Κύκλος Σπουδών"),
    CIRCUITTHEORY("Θεωρία Κυκλωμάτων","2ο","Βασικός Κύκλος Σπουδών"),
    ELECTRONICS(""),
    DATASTRUCTURES(""),
    NETWORKS1(""),
    OPERATIONALSYS1(""),
    PCARCHITECTURE(""),
    DB1(""),
    NETWORKS2(""),
    OPERATIONALSYS2(""),
    JAVA(""),
    DIGITALCIRCUITDESIGN(""),
    SIGNALSANDSYSTEMS(""),
    DB2(""),
    NETWORKPROGRAMMING(""),
    ANALYSISANDDESIGNOFSYSTEMS(""),
    AI(""),
    DIGITALSIGNALPROCESSING(""),
    INTROTOPARALLELPROGRAMMING(""),
    SOFTWAREENGINEERING(""),
    SAFETYONINFORMATICS(""),
    COMPILERS(""),
    MICROELECTRONICS(""),
    DISTRIBUTEDSYSTEMS(""),
    DIGITALCOMMUNICATIONS(""),
    HISTORYOFTECHNOLOGY(""),
    INFORMATICSANDSOCIETY(""),
    DESIGNANDDEVELOPMENTOFOS(""),
    INFORMATIONRETRIEVAL(""),
    PATTERNRECOGNITIONMACHINELEARNING(""),
    SPECIALSOFTWAREENGINEERING(""),
    IMGPROCESSING(""),
    OPERATIONALRESEARCH(""),
    MODELINGANDPROGRAMMINGRESTRICTIONS(""),
    MANAGEMENTINFOSYS(""),
    HEALTHINFORMATICS(""),
    SOFTWAREQUALITY(""),
    SYSTEMSOFDECISION(""),
    PERSONANDPC(""),
    GRAPHICS(""),
    NATURALLANGUAGEPROCESSING(""),
    CLEVERSYSTEMS(""),
    ESTUDY(""),
    ESHOPS(""),
    THEORYOFGRAPHS(""),
    NEURALNETWORKS(""),
    COMPUTERVISION(""),
    MICROCOMPUTERS(""),
    DESIGNSYSTEMWITHCOMPUTER(""),
    BIOMECHANICSINFORMATICS(""),
    EMBEDDEDSYSTEMS(""),
    INTEGRATEDCIRCUITS(""),
    PARALLELSYSTEMS(""),
    ROBOTICS(""),
    DESIGNVLSI(""),
    HIGHRELIABILITYSYS(""),
    AUTOSYSCONTROL(""),
    ADVANCEDCOMPUTERARCHITECTURE(""),
    SAFETYANDRELIABILITYOFHARDWARE(""),
    MECHANOTRONICS(""),
    ADVANCECIRCUITDESIGN(""),
    DIGITALCONTROLOFSYSTEMS(""),
    NETWORKSAFETY(""),
    ADVANCEDNETWORKTECHS(""),
    IOT(""),
    TELECOMS(""),
    MOBILENETWORKS(""),
    CLOUDCOMPUTING(""),
    WIRELESSSYSTEMS(""),
    NETWORKINGDEFINEBYSOFTWARE(""),
    MULTIMEDIAS(""),
    TECHNOLOGYANDDESIGNOFMOBILES("")
    ;

    private String fullname;
    private String semester;
    private String direction;

    Courses(String fullname, String direction) {
        this.fullname = fullname;
        this.direction = direction;
    }

    Courses(String fullname, String semester, String direction) {
        this.fullname = fullname;
        this.semester = semester;
        this.direction = direction;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
