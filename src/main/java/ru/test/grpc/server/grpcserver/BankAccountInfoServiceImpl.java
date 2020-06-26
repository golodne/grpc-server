package ru.test.grpc.server.grpcserver;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import ru.grpc.model.*;

@GrpcService
public class BankAccountInfoServiceImpl extends BankAccountInfoServiceGrpc.BankAccountInfoServiceImplBase {
    @Override
    public void sendAccount(BankAccountInfoRequest request, StreamObserver<BankAccountInfoResponse> responseObserver) {

        Address address1 = Address.newBuilder()
                .setCity("sezam")
                .setState("Razbityih_fonarey")
                .build();

        BankAccountInfo bankAccountInfo = BankAccountInfo.newBuilder()
                .setAddress(address1)
                .build();

        BankAccountInfoResponse response = BankAccountInfoResponse.newBuilder()
                .setBankAccountInfo(bankAccountInfo)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
