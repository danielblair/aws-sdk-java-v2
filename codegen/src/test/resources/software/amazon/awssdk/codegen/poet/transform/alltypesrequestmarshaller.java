package software.amazon.awssdk.services.jsonprotocoltests.transform;

import javax.annotation.Generated;
import software.amazon.awssdk.annotations.SdkInternalApi;
import software.amazon.awssdk.core.Request;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.http.HttpMethodName;
import software.amazon.awssdk.core.protocol.OperationInfo;
import software.amazon.awssdk.core.protocol.Protocol;
import software.amazon.awssdk.core.protocol.ProtocolRequestMarshaller;
import software.amazon.awssdk.core.protocol.json.SdkJsonProtocolFactory;
import software.amazon.awssdk.core.runtime.transform.Marshaller;
import software.amazon.awssdk.services.jsonprotocoltests.model.AllTypesRequest;
import software.amazon.awssdk.utils.Validate;

/**
 * {@link AllTypesRequest} Marshaller
 */
@Generated("software.amazon.awssdk:codegen")
@SdkInternalApi
public class AllTypesRequestMarshaller implements Marshaller<Request<AllTypesRequest>, AllTypesRequest> {
    private static final OperationInfo SDK_OPERATION_BINDING = OperationInfo.builder().protocol(Protocol.REST_JSON)
                                                                            .requestUri("/").httpMethodName(HttpMethodName.POST).hasExplicitPayloadMember(false).hasPayloadMembers(true).build();

    private final SdkJsonProtocolFactory protocolFactory;

    public AllTypesRequestMarshaller(SdkJsonProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    @Override
    public Request<AllTypesRequest> marshall(AllTypesRequest allTypesRequest) {
        Validate.paramNotNull(allTypesRequest, "allTypesRequest");
        try {
            ProtocolRequestMarshaller<AllTypesRequest> protocolMarshaller = protocolFactory.createProtocolMarshaller(
                SDK_OPERATION_BINDING, allTypesRequest);
            protocolMarshaller.startMarshalling();
            AllTypesRequestModelMarshaller.getInstance().marshall(allTypesRequest, protocolMarshaller);
            return protocolMarshaller.finishMarshalling();
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }
}
