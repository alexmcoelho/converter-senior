package converter;
import model.EstadoType;

public class ConverterEstadoType{ 

public static Integer converter(EstadoType type) { 
    if (type == null) return null; 
    switch (type) { 
        case ORCAMENTO:
            return 1; 
        case APROVADO:
            return 2; 
        case FINALIZADO:
            return 3; 
        case FALTA_PECA:
            return 4; 
        case NAO_APROVADO:
            return 5; 
        case SEM_CONSERTO:
            return 6; 
        default: 
            return null; 
} 
} 
public static EstadoType converter(Integer type) {if (type == null) return null;switch (type) {        case 1:
return EstadoType.ORCAMENTO; 
        case 2:
return EstadoType.APROVADO; 
        case 3:
return EstadoType.FINALIZADO; 
        case 4:
return EstadoType.FALTA_PECA; 
        case 5:
return EstadoType.NAO_APROVADO; 
        case 6:
return EstadoType.SEM_CONSERTO; 
default: 
return null; 
} 
} 
} 
