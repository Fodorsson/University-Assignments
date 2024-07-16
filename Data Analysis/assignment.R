#Import excel file
install.packages("readxl")
library("readxl")

deaths <- read_excel("maledeaths2019.xls")
deaths
View(deaths)

#get the structure
str(deaths)

#convert every cell to integer, instead of num
deaths[] <- lapply(deaths, as.integer)

#declare a new vector of 46 length, 
#since there are 46 columns excluding the Age column
#this vector is going to be the average age of dying per each year
avgPerYear = vector(mode="numeric", length = 46 )
avgPerYear

#

#do a for loop
#x will store the indexes of all the columns we need to go through
#in the for loop (2 to 47, so excluding the Age column at the start
#and the Product column at the end, which we are about to add)
x = seq(from = 2, to = 47, by = 1)

for (i in x) {
  
  #create the product column for the i. column
  deaths$Product = deaths$Age * deaths[, c(i)]
  
  #create the total for the i. column
  totalLastCol = sum(deaths[, c(i)])
  totalLastCol
  
  #create the total for the product column
  totalProd = sum(deaths$Product)
  totalProd
  
  #calculate the average age at which people died that year
  avgAge = totalProd / totalLastCol
  avgAge
  
  #add average age of the i. column 
  #to the corresponding element of the avg vector
  avgPerYear[i - 1] = avgAge
  
}

#check the average vector, which should now be populated
avgPerYear

#store the years in a vector
years = seq(from = 1974, to = 2019, by = 1)
years

#Plot the average age of dying across the years
plot(years, avgPerYear, xlab="Years", ylab="Average age of death per year")

#i dont really know what im doing
#See if the two vectors correlate
cor(years, avgPerYear)

#test the significance of the correlation
cor.test(years, avgPerYear, method="pearson")

#i dont know what im doing
# build linear regression
linearMod <- lm(avgPerYear ~ years, data=deaths) 
print(linearMod)

#summary of our model
summary(linearMod)