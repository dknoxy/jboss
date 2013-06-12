#!/bin/bash


if [ $# -eq 0 ]; then
  echo >&2 "Usage: jstackSeries <pid> <run_user> [ <count> [ <delay> ] ]"
  echo >&2 "    Defaults: count = 10, delay = 0.5 (seconds)"
  exit 1
fi
pid=$1          # required
user=$2         # required
count=${3:-10}  # defaults to 10 times
delay=${4:-0.5} # defaults to 0.5 seconds
echo >&2 "Using PID $pid with User $2"

while [ $count -gt 0 ]
	do
	   echo >&2 "sudo -u $user jstack -l $pid"
      sudo -u $user jstack -l $pid >jstack.$pid.$(date +%H%M%S.%N)
	   sleep $delay
      let count--
      echo -n "."
done
