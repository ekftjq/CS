require '../CSAir/graph'

def main
  graph = Graph.new
  puts "Launching CS Air..."
  puts "Please input 1 for list of all the cities CS Air travels to"
  puts "Please input 2 for specific information about a city in the CS Air network"
  puts "Please input 3 for the other statistics"
  puts "Please input 4 to Visualize CSAir's route map"
  puts "Please input 5 to exit"

  while(1)
    input = gets.to_i
    case input
      when 1
        puts "List of cities are :"
        puts graph.getAllCities
        puts ""
        puts "Please input 1 for list of all the cities CS Air travels to"
        puts "Please input 2 for specific information about a city in the CS Air network"
        puts "Please input 3 for the other statistics"
        puts "Please input 4 to exit"
      when 2
        cityInfo(graph)
      when 3
        stats(graph)
      when 4
        graph.visualize
      when 5
        return 0
    end
  end
end #end of main

def cityInfo(graph)
  puts "Enter the City Code or City Name"
  city = gets.chop
  graph.getCityInfo(city)
end

def stats(graph)
  puts "Please input 1 for the longest single flight in the network"
  puts "Please input 2 for the shortest single flight in the network"
  puts "Please input 3 for the average distance of all the flights in the network"
  puts "Please input 4 for the biggest city (by population) served by CSAir"
  puts "Please input 5 for the smallest city (by population) served by CSAir"
  puts "Please input 6 for the average size (by population) of all the cities served by CSAir"
  puts "Please input 7 for a list of the continents served by CSAir and which cities are in them"
  puts "Please input 8 for CSAir's hub cities"
  puts "Please input 9 to go back to the previous menu"
  while(1)
    value = gets.to_i
    case value
      when 1
        graph.getFlightData(value)
      when 2
        graph.getFlightData(value)
      when 3
        graph.getFlightData(value)
      when 4
        graph.getCityData(value)
      when 5
        graph.getCityData(value)
      when 6
        graph.getCityData(value)
      when 7
        graph.getContinent
      when 8
        graph.getHubCity
      when 9
        puts "Please input 1 for list of all the cities CS Air travels to"
        puts "Please input 2 for specific information about a city in the CS Air network"
        puts "Please input 3 for the other statistics"
        puts "Please input 4 to exit"
        return 0
    end
  end
end

main