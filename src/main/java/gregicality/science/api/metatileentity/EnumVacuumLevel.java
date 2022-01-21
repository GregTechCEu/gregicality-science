package gregicality.science.api.metatileentity;

public enum EnumVacuumLevel {
    NONE("gcys.vacuum_level.none"),
    LOW_VACUUM("gcys.vacuum_level.low"),
    MEDIUM_VACUUM("gcys.vacuum_level.medium"),
    HIGH_VACUUM("gcys.vacuum_level.high"),
    ULTRA_HIGH_VACUUM("gcys.vacuum_level.ultra_high"),
    EXTREMELY_HIGH_VACUUM("gcys.vacuum_level.extremely_high"),
    PERFECT_VACUUM("gcys.vacuum_level.perfect");

    private final String name;

    EnumVacuumLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
