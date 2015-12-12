#first class
class Customer
	def initialize(firstName, lastName)
		@firstName = firstName
		@lastName = lastName
	end
	def getFullName()
		return  @firstName + " " + @lastName
	end
end

class Sale
	def initialize(customer, amount)
		@customer = customer
		@amount = amount
	end
	def getInfo()
		return @customer.getFullName + " spent " + @amount.to_s 
	end
	def getCustomer()
		return @customer
	end
	def getValue()
		return @amount
	end
end

class Shop
	$sales = []
	
	def register_sale(sale)
		$sales.push(sale)
	end
	
	def getAllSales()
		return $sales
	end
	
	def getSalesPerCustomer(customer)
		@sum = 0
		@customerName = customer.getFullName
		$sales.each do |item|
			if item.getCustomer == customer
				@sum += item.getValue
			
			end
		end
		return "Customer " + @customerName + " spent " + @sum.to_s + "."
	end

	def getCustomers()
		@customers = []
	
	end
end	

customer1 = Customer.new("Eunice", "Agyei")
saleF1 = Sale.new(customer1, 400)
saleF2 = Sale.new(customer1, 200)
saleF3 = Sale.new(customer1, 100)

customer2 = Customer.new("Christy", "Agyei")
saleS1 = Sale.new(customer2, 150)
saleS2 = Sale.new(customer2, 450)

customer3 = Customer.new("Andy", "Ruby")
saleT1 = Sale.new(customer3, 150000)
saleT2 = Sale.new(customer3, 359090)
saleT3 = Sale.new(customer3, 6909098)

customer4 = Customer.new("Sarfo", "Ruby")
saleE1 = Sale.new(customer3, 150000)
saleE2 = Sale.new(customer3, 359090)
saleE3 = Sale.new(customer3, 6909098)

shop = Shop.new
shop.register_sale(saleF3)
shop.register_sale(saleF2)
shop.register_sale(saleF1)
shop.register_sale(saleS2)
shop.register_sale(saleS1)
shop.register_sale(saleT1)
shop.register_sale(saleT2)
shop.register_sale(saleT3)
shop.register_sale(saleE1)
shop.register_sale(saleE2)
shop.register_sale(saleE3)

array  = shop.getAllSales

puts
puts "********List of SALES*****************"
puts "									"
array.each do |item|
	puts item.getInfo
end
puts
puts "*****Summary per customer********"
puts "									"
puts shop.getSalesPerCustomer(customer1)
puts shop.getSalesPerCustomer(customer2)
puts shop.getSalesPerCustomer(customer3)
puts shop.getSalesPerCustomer(customer4)
