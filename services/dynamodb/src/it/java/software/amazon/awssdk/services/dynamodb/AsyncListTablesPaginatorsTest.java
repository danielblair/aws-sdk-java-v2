package software.amazon.awssdk.services.dynamodb;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import software.amazon.awssdk.services.dynamodb.model.ListTablesRequest;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;
import software.amazon.awssdk.services.dynamodb.paginators.ListTablesPublisher;

public class AsyncListTablesPaginatorsTest {

    @Test
    public void listTables() throws InterruptedException, ExecutionException {
        DynamoDBAsyncClient client = DynamoDBAsyncClient.create();

        ListTablesRequest request = ListTablesRequest.builder().limit(2).build();
        ListTablesPublisher listTablesPublisher = client.listTablesPublisher(request);


        // Simple forEach usage
        CompletableFuture<Void> future = listTablesPublisher.forEach(listTablesResponse -> {
            System.out.println(listTablesResponse.tableNames().size());
            listTablesResponse.tableNames().forEach(System.out::println);
        });
        future.get();


        // forEach on Items
        CompletableFuture<Void> future2 = listTablesPublisher.tableNames().forEach(System.out::println);
        future2.get();


        // Use a subscriber to subscribe to listTablesPublisher
        listTablesPublisher.subscribe(new Subscriber<ListTablesResponse>() {

            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                subscription.request(1);
                subscription.request(2);
            }

            @Override
            public void onNext(ListTablesResponse listTablesResponse) {
                listTablesResponse.tableNames().forEach(System.out::println);
                subscription.request(1);
                subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onComplete() {
                subscription = null;
            }
        });

        Thread.sleep(3_000);
    }
}
