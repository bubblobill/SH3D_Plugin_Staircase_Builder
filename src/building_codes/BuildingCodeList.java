package building_codes;

public enum BuildingCodeList {
	BuildingCode_AU("Australia", "AU"),
	BuildingCode_NoLimits("Sensible restrictions removed", "NoLimits"),
	BuildingCode_Default("Default", "Default");
	
	// declaring private variable for getting values 
    private String descriptor;
    private String codeAbbreviation;
    
	// enum constructor - cannot be public or protected 
    private BuildingCodeList(String descriptor, String codeAbbreviation)     { 
        this.descriptor = descriptor;
        this.codeAbbreviation = codeAbbreviation;
    }	
    
	int BuildingCodeOrdinal=0;
	BuildingCodeList(int ordinal) {
		this.BuildingCodeOrdinal = ordinal;
	}
	public static BuildingCodeList byOrdinal(int ord) {
        for (BuildingCodeList bc : BuildingCodeList.values()) {
            if (bc.BuildingCodeOrdinal == ord) {
                return bc;
            }
        }
        return null;
    }
	public static BuildingCodeList index(int index) {
		return BuildingCodeList.values()[index];
	}
	
	public static int count() {
		int i =0;
		for (@SuppressWarnings("unused") BuildingCodeList bc : BuildingCodeList.values()) {i++;}
		return i;
	}
  
    // getter method 
    public String getDescriptor() {return this.descriptor;}
    public String getCodeAbbreviation() {return this.codeAbbreviation;}
   
}