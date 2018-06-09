package com.github.simplesteph.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple;

import java.util.Arrays;

public class ProtoToJSONMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {


        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();

        // simple fields
        builder.setId(42)  // set the id field
                .setIsSimple(true)  // set the is_simple field
                .setName("My Simple Message Name"); // set the name field

        // repeated field
        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(4, 5, 6));


        // Print this as a JSON
        String jsonString = JsonFormat.printer()
                // .includingDefaultValueFields() - options
                .print(builder);
        System.out.println(jsonString);


        // parse JSON into Protobuf
        Simple.SimpleMessage.Builder builder2 = Simple.SimpleMessage.newBuilder();

        JsonFormat.parser()
                .ignoringUnknownFields()
                .merge(jsonString, builder2);

        System.out.println(builder2);

    }
}
