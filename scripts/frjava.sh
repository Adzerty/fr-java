#!/bin/bash
function frjavac() {
    java frjava.Parser $1;
    name=$(echo "$1" | cut -f 1 -d '.');
    echo $name;
    javac $name.java
    rm -f $name.java
}   