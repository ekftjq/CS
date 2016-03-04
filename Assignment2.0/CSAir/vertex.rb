class Vertex
  attr_accessor :code, :name, :country, :continent, :timezone, :coordinates, :population, :region

  # initializes the vertex of the graph
  # it reads the various metros given from the given data
  def initialize(data = {})
    @code = data["code"]
    @name = data["name"]
    @country = data["country"]
    @continent = data["continent"]
    @timezone = data["timezone"]
    @coordinates = data["coordinates"]
    @population = data["population"]
    @region  =data["region"]
  end

  def printVertex
    puts "code: #{code}"
    puts "name: #{name}"
    puts "country: #{country}"
    puts "continent: #{continent}"
    puts "timezone: #{timezone}"
    puts "coordinates: #{coordinates}"
    puts "population: #{population}"
    puts "region: #{region}"
  end

end
