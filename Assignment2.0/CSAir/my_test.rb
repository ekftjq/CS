require 'test/unit'
require_relative '../CSAir/graph'

class MyTest < Test::Unit::TestCase

  def test_graph_hubCity
    graph = Graph.new
    assert_equal("Istanbul", graph.getHubCity)
  end

  #def test_graph_continent
  #  graph = Graph.new
  #  assert_equal("Mexico City", graph.getContinent)
  #end

  def test_graph_populationavg
    graph = Graph.new
    assert_equal(11796143, graph.getCityData(6))
  end

  def test_graph_smallestpol
    graph = Graph.new
    assert_equal(589900, graph.getCityData(5))
  end

  def test_graph_largeestpol
    graph = Graph.new
    assert_equal(34000000, graph.getCityData(4))
  end

  def test_graph_longest
    graph = Graph.new
    assert_equal(12051, graph.getFlightData(1))
  end

  def test_graph_shortest
    graph = Graph.new
    assert_equal(334, graph.getFlightData(2))
  end

  def test_graph_distavg
    graph = Graph.new
    assert_equal(2300, graph.getFlightData(3))
  end

end