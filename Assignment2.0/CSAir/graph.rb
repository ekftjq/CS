require '../CSAir/vertex'
require '../CSAir/edge'
require 'json'
require 'Launchy'

class Graph

  # this method takes map_data.json and initializes into a graph
  def initialize(data = "map_data.json")
    @data = JSON.parse File.read(data)

    @vertex = Hash.new
    @data["metros"].each do |city|
      @vertex[city["code"]] = Vertex.new(city)
    end

    @edge = Hash.new
    @data["routes"].each do |route|
      @edge[route["ports"]] = Edge.new(route)
    end
  end

  # gets a list of all the cities that CSAir travels to
  def getAllCities
    result = []
    @vertex.each_value do |city|
      result << city.name
    end
    return result
  end

  # get specific information about a specific city in the CSAir network
  def getCityInfo(city)
    result = @vertex.find{ |key, hash| (key == city || hash.name == city)}

    if result.nil?
      puts "There is no such city,"
      puts ""
      puts "Please input 1 for list of all the cities CS Air travels to"
      puts "Please input 2 for specific information about a city in the CS Air network"
      puts "Please input 3 for the other statistics"
      puts "Please input 4 to exit"
    else
      result[1].printVertex
      puts ""
      connectedCities(result[1].code)
      puts ""
      puts "Please input 1 for list of all the cities CS Air travels to"
      puts "Please input 2 for specific information about a city in the CS Air network"
      puts "Please input 3 for the other statistics"
      puts "Please input 4 to exit"
    end
  end

  # check connected Cities and distance and print them with given city
  def connectedCities(code)
    puts "Connected Cities are"
    results = connectedRoutes(code)
    results.sort{ |x,y| x[1].distance <=> y[1].distance}.each do |route|
      city = @vertex[route[1].ports.join.gsub(code,'')]
      puts "#{city.name} (#{city.code}) : #{route[1].distance}"
    end
  end

  # check what routes are connected to a certain city
  def connectedRoutes(city)
    results = @edge.select{ |key, hash| key.include?(city)}
  end

  def getFlightData(value)
    flight = @edge.values.sort{ |x, y| x.distance <=> y.distance}
    longest = flight.last
    shortest = flight.first
    total = 0
    flight.each do |route|
      total = total + route.distance
    end
    average = total/flight.size

    if(value == 1)
      print "The Longest single flight in the network is "
      puts "#{longest.printEdge}"
    end
    if(value == 2)
      print "The Shortest single flight in the network is "
      puts "#{shortest.printEdge}"
    end
    if(value == 3)
      puts "The average distance of all the flights in the network is: #{average}"
    end

  end

  def getCityData(value)
    city = @vertex.values.sort{ |x,y| x.population <=> y.population}
    largest = city.last
    smallest = city.first
    total = 0
    city.each do |city|
      total = total + city.population
    end
    average = total/city.size

    if(value == 4)
      print "The Biggest city in the network is "
      puts "#{largest.name} (#{largest.code}) with #{largest.population} people"
    end
    if(value == 5)
      print "The Smallest city in the network is "
      puts "#{smallest.name} (#{smallest.code}) with #{smallest.population} people"
    end
    if(value == 6)
      puts "The average population of all the cities in the network is: #{average}"
    end
  end

  def getContinent
    na = []
    sa = []
    eu = []
    asia = []
    africa = []
    au = []

    @vertex.each_value do |city|
      if(city.continent == "North America")
        na << city.name
      end
      if(city.continent == "South America")
        sa << city.name
      end
      if(city.continent == "Europe")
        eu << city.name
      end
      if(city.continent == "Asia")
        asia << city.name
      end
      if(city.continent == "Africa")
        africa << city.name
      end
      if(city.continent == "Australia")
        au << city.name
      end
    end

    puts "Cities in North America are #{na}"
    puts "Cities in South America are #{sa}"
    puts "Cities in Asia are #{asia}"
    puts "Cities in Africa are #{africa}"
    puts "Cities in Australia are #{au}"
    puts "Cities in Europe are #{eu}"

  end

  def getHubCity
    cities = @vertex.values
    hubCity = cities.first
    cities.each do |city|
      if connectedRoutes(hubCity.code).size < connectedRoutes(city.code).size
        hubCity = city
      end
    end
    puts "The city with the most direct connects is: #{hubCity.name} (#{hubCity.code})"
  end

  def visualize
    routes = []
    @edge.each do |key, route|
      routes << route.ports.join("-")
    end
    addurl = routes.join(",")
    Launchy.open("http://www.gcmap.com/mapui?P="+addurl)
  end

end