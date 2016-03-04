class Edge
  attr_accessor :ports, :distance

  # initializes the edge of the graph,
  # it reads the various routes from the given data
  def initialize(data = {})
    @ports = data["ports"]
    @distance = data["distance"]
  end

  def printEdge
    print "from #{@ports[0]} to #{@ports[1]} with #{@distance} miles apart"
  end
end