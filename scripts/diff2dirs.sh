#!/bin/bash

## INSTRUCTIONS
## This script takes two directory trees and creates three output types:
##   1. *.diffed which include the diff results if both dir1 and dir2 contain the file
##   2. lonely.dir1 which includes all the files present in dir1 but not dir2
##   3. lonely.dir2 which includes all the files present in dir2 but not dir1
## It deletes -> recreates a directory /diffed in your run location

echo "Comparing $1 with $2........"

homedir=$(pwd)

## Has to track the current directory
cd $1
all_files=$(find . -name "*.java")
cd $homedir

## Could put some sort of warning here
		if [ -d "diffed" ]; then
	   	rm -r diffed
		fi
		mkdir diffed
		echo "Diffing $1 -> $2"
		for f in $all_files; do
		   ## Have to remove the /'s from $f for naming
         fslashesremoved=$(echo $f | sed 's/\///g')
			fslashesremoved=${fslashesremoved:1}
		   if [ -f $1/$f ]; then
		      if [ -f $2/$f ]; then
		       diff $1/$f $2/$f > /dev/null
		       if [ $? != 0 ]; then
		          diff $1/$f $2/$f > diffed/$fslashesremoved.diffed
		       fi
		     else
		        echo "$f: present in $1, but not in $2" >> diffed/orphaned_$1.diffed
		    fi  
        fi 
	  done
     cd $2
	  extra_files=$(find . -name "*.java")
	  cd $homedir
## Now have to do the reverse for tmp2 to tmp1, but only have to check if they are present or not
		echo "Examining $2 for orphans"
     for f in $extra_files; do
       fslashesremoved=$(echo $f | sed 's/\///g')
	    if [ -f $2/$f ]; then
		    if [ -f $1/$f ]; then
		    ## Have to figure out how not to do something here
		       echo stuff > /dev/null
		    else
		      echo "$f: present in $2, but not in $1" >> diffed/orphaned_$2.diffed
		    fi  
		fi 
	 done
	 echo "Complete. Results are in ./diffed"

## Now we have a diffed directory that has lots of files
## What should we remove from them?
## Should also remove the *.*~ from this
