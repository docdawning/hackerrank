#!/bin/bash
INPUT_FILE="stdin.txt"

if [ "$#" -eq 1 ] ; then
	INPUT_FILE=$1
fi

gcc Solution.cpp
if [ "$?" -eq 0 ] ; then 
	cat $INPUT_FILE | ./a.out
fi
