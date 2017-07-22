#!/bin/bash
javac Solution.java
if [ "$?" -eq 0 ] ; then 
	cat stdin.txt | java Solution
fi
