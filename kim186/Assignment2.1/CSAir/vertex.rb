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

  def latitude
    if @coordinates.has_key?("N")
      "N" + @coordinates["N"].to_s
    else
      "S" + @coordinates["S"].to_s
    end
  end

  def longitude
    if @coordinates.has_key?("W")
      "W" + @coordinates["W"].to_s
    else
      "E" + @coordinates["E"].to_s
    end
  end

  def printVertex
    puts "code: #{code}"
    puts "name: #{name}"
    puts "country: #{country}"
    puts "continent: #{continent}"
    puts "timezone: #{timezone}"
    puts "latitude: #{self.latitude}"
    puts "longitude: #{self.longitude}"
    puts "population: #{population}"
    puts "region: #{region}"
  end

end
