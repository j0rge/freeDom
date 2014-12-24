#!/bin/env ruby
require 'Open3'
puts "Param: #{$*.join(' ')}"
o = %x{java -jar target/freeDomParser-1.0.0-jar-with-dependencies.jar #{$*.join(' ')}}
p o
