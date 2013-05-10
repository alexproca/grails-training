class List
  constructor: (@array = []) ->
  
  remove: (element) -> @array[t..t] = [] if (t = @array.indexOf(element)) > -1 if element
  
  add: (element) -> @array.push element
  
  values: -> return @array

test = new List()

test.add(1)
test.add(2)

test2 = new List()

test2.add(3)
test2.add(4)

console.log(test.values())

console.log(test2.values())

test2.add(5)

console.log(test2.values())

test2.remove(3)

console.log(test2.values())
