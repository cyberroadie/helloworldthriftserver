namespace java com.robotmotel.hello

struct HelloRequest {
    1: required string name;
}

struct HelloResponse {
    1: required i64 mostUUID;
    2: required i64 leastUUID;
    3: required string greeting;
}

service HelloWorld {
    void ping();
    HelloResponse getHello(1:HelloRequest helloRequest);
}
