package software.amazon.awssdk.services.jsonprotocoltests.model;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("software.amazon.awssdk:codegen")
final class ListOfMapStringToStringCopier {
    static List<Map<String, String>> copy(Collection<Map<String, String>> listOfMapStringToStringParam) {
        if (listOfMapStringToStringParam == null) {
            return null;
        }
        List<Map<String, String>> listOfMapStringToStringParamCopy = listOfMapStringToStringParam.stream()
                                                                                                 .map(MapOfStringToStringCopier::copy).collect(toList());
        return Collections.unmodifiableList(listOfMapStringToStringParamCopy);
    }
}
