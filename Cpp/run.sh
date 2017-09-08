#!/bin/bash
INPUT_FILE="stdin.txt"
BINARY_FILE="a.out"

if [ "$#" -eq 1 ] ; then
	INPUT_FILE=$1
fi

if [ -f "$BINARY_FILE" ] ; then
	echo "Removing old $BINARY_FILE file"
	rm a.out
fi

g++ --stdlib=libc++ Solution.cpp
if [ "$?" -eq 0 ] ; then 
	cat $INPUT_FILE | ./$BINARY_FILE
fi
