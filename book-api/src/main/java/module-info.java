module online.library.book {
    requires com.fasterxml.jackson.annotation;
    requires online.library.author;
    requires spring.cloud.openfeign.core;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires lombok;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.data.commons;
    requires java.persistence;
    requires spring.web;
    exports online.library.book;
}