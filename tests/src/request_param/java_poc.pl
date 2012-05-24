#!/usr/bin/perl

use strict;
use warnings;
use LWP;

# tomcat6
#my $url='http://localhost:8080/examples/servlets/servlet/RequestParamExample';
#tomcat5
#my $url='http://localhost:8080/servlets-examples/servlet/RequestParamExample';
#my $url='http://djorm-rhel61-ews.cloud.lab.eng.bne.redhat.com:8080/examples/servlets/servlet/RequestParamExample'

my $url='http://tyan-gt24-12.rhts.eng.bos.redhat.com:8080/examples/servlets/servlet/RequestParamExample';

my $browser = LWP::UserAgent->new;

open PARMS, "<", "keys_not_mapping_2m" or die $!;
my ($buf, $data, $n);

print "Starting concat loop\n";
while (($n = read PARMS, $data, 2)!= 0) {
    $data =~ s/\r|\n/&/g;
  $buf .= $data;
}

print "Buffer is :" . " " . $buf;

my $response = $browser->post( $url,
# comment and remove as needed
	[ $buf
#        [ "firstname" => "Jim",
#          "lastname" => "Dandy",
   ]
  );

     die "$url error: ", $response->status_line
       unless $response->is_success;

     print "$response->status_line\n";
     print "$response->content\n";
