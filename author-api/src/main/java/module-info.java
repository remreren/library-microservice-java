module online.library.author {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.data.commons;
    requires spring.data.jpa;
    requires spring.context;
    requires spring.web;
    requires com.fasterxml.jackson.annotation;
    requires lombok;
    requires java.persistence;
    exports online.library.author;
    exports online.library.author.api;
    exports online.library.author.model;
}