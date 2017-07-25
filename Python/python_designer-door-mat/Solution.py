#Refs: https://www.hackerrank.com/challenges/designer-door-mat

#This is a snippet, so it's not intended to be run directly

N, M = map(int,raw_input().split()) # More than 6 lines of code will result in 0 score. Blank lines are not counted.
for i in xrange(1,N,2): 
    print "-"*(M-((3*i)+9)) + ".|" + "..|"*(i-1) + "." + "-"*((M/2)-(3**(i-1)))
print ((M-15)/2)*"-"+"----WELCOME----"+((M-15)/2)*"-"
for i in xrange(N-2,-1,-2): 
    print "2 - "+i.__str__()

